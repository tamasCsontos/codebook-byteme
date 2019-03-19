package com.codecool.codebook.controller;

import com.codecool.codebook.model.Student;
import com.codecool.codebook.model.Workplace;
import com.codecool.codebook.repository.StudentRepository;
import com.codecool.codebook.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/students")
    public List<Student> listStudents() {
        List<Student> students = studentRepository.findAll();
//
//        model.addAttribute("students", students);
//        String email = (String) session.getAttribute("email");
//        model.addAttribute("user", studentRepository.findByEmail(email));

        return students;
    }

    @GetMapping("/students/{id}")
    public Optional<Student> showStudent(@PathVariable("id") int id){
        Optional<Student> student = studentRepository.findById((long) id);
//        model.addAttribute("student", student);
//        model.addAttribute("sessionId", session.getAttribute("userID"));
//        String email = (String) session.getAttribute("email");
//        model.addAttribute("user", studentRepository.findByEmail(email));
        return student;
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam("id") String id){
        Student student = studentRepository.getOne(Long.valueOf(id));
        List<Workplace> workplaceList = workplaceRepository.findAll();
        String email = (String) session.getAttribute("email");
        model.addAttribute("user", studentRepository.findByEmail(email));
        model.addAttribute("student", student);
        model.addAttribute("workplaces", workplaceList);
        return "edit";
    }

    @PostMapping(value = "/students/create")
    public Student postStudent(@RequestBody Student student) {

        Student _student = studentRepository.save(new Student(student.getName(), student.getEmail(), student.getWorkplaceFeedback()));
        return _student;
    }



    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        System.out.println("Update Student with ID = " + id + "...");

        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            Student _student = studentData.get();
            _student.setName(student.getName());
            _student.setEmail(student.getEmail());
            _student.setPhonenumber(student.getPhonenumber());
            _student.setWorkplaceFeedback(student.getWorkplaceFeedback());
            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/admin")
    public String goToAdmin(@SessionAttribute String email, Model model, HttpServletResponse response) throws IOException {
        if (email.equals("admin@admin.com")) {
            List<Workplace> workplaces = workplaceRepository.findAll();
            model.addAttribute("workplaces", workplaces);
            return "admin";
        }else{
            return "redirect:/";
        }
    }



    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {

        studentRepository.deleteById(id);

        return new ResponseEntity<>("Student has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/students/delete")
    public ResponseEntity<String> deleteAllCustomers() {

        studentRepository.deleteAll();

        return new ResponseEntity<>("All students have been deleted!", HttpStatus.OK);
    }



}