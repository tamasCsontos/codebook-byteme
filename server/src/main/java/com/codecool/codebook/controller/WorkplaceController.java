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

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WorkplaceController {
    @Autowired
    WorkplaceRepository workplaceRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HttpSession session;

    @GetMapping("/workplaces")
    public List<Workplace> listWorkplaces(){
        List<Workplace> workplaces = workplaceRepository.findAll();
        System.out.println(workplaces);
//        String email = (String) session.getAttribute("email");
//        model.addAttribute("user", studentRepository.findByEmail(email));
//        model.addAttribute("workplaces", workplaces);
        return workplaces;
    }

    @GetMapping("/workplaces/{id}")
    public Optional<Workplace> showWorkplace(@PathVariable("id") int id){
        Optional <Workplace> workplace = workplaceRepository.findById((long) id);
//        model.addAttribute(workplace);
//        String email = (String) session.getAttribute("email");
//        model.addAttribute("user", studentRepository.findByEmail(email));
        return workplace;
    }


    @PostMapping(value = "/workplaces/create")
    public Workplace postWorkplace(@RequestBody Workplace workplace) {

        Workplace _workplace = workplaceRepository.save(new Workplace(workplace.getName(), workplace.getDescription()));
        return _workplace;
    }



    @PutMapping("/workplaces/{id}")
    public ResponseEntity<Workplace> updateWorkplace(@PathVariable("id") long id, @RequestBody Workplace workplace) {
        System.out.println("Update Workplace with ID = " + id + "...");

        Optional<Workplace> workplaceData = workplaceRepository.findById(id);

        if (workplaceData.isPresent()) {
            Workplace _workplace = workplaceData.get();
            _workplace.setName(workplace.getName());
            _workplace.setDescription(workplace.getDescription());
            return new ResponseEntity<>(workplaceRepository.save(_workplace), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/workplaces/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {

        workplaceRepository.deleteById(id);

        return new ResponseEntity<>("Workplace has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/workplaces/delete")
    public ResponseEntity<String> deleteAllCustomers() {

        workplaceRepository.deleteAll();

        return new ResponseEntity<>("All workplaces have been deleted!", HttpStatus.OK);
    }



}