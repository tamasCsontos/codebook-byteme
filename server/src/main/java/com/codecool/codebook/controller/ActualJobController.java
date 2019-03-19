package com.codecool.codebook.controller;


import com.codecool.codebook.model.ActualJob;
import com.codecool.codebook.model.Workplace;
import com.codecool.codebook.repository.ActualJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ActualJobController {

    @Autowired
    ActualJobRepository actualJobRepository;


    @GetMapping("/jobs")
    public List<ActualJob> listJobs(){
        List<ActualJob> jobs = actualJobRepository.findAll();
        System.out.println(jobs);
//        String email = (String) session.getAttribute("email");
//        model.addAttribute("user", studentRepository.findByEmail(email));
//        model.addAttribute("workplaces", workplaces);
        return jobs;
    }

    @GetMapping("/jobs/{id}")
    public Optional<ActualJob> showJob(@PathVariable("id") int id){
        Optional <ActualJob> job = actualJobRepository.findById((long) id);
//        model.addAttribute(workplace);
//        String email = (String) session.getAttribute("email");
//        model.addAttribute("user", studentRepository.findByEmail(email));
        return job;
    }


    @PostMapping(value = "/jobs/create")
    public ActualJob postJob(@RequestBody ActualJob job) {

        ActualJob _job = actualJobRepository.save(new ActualJob(job.getName(), job.getDescription()));
        return _job;
    }



    @PutMapping("/jobs/{id}")
    public ResponseEntity<ActualJob> updateJob(@PathVariable("id") long id, @RequestBody ActualJob job) {
        Optional<ActualJob> jobData = actualJobRepository.findById(id);

        if (jobData.isPresent()) {
            ActualJob _job = jobData.get();
            _job.setName(job.getName());
            _job.setDescription(job.getDescription());
            return new ResponseEntity<>(actualJobRepository.save(_job), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") long id) {

        actualJobRepository.deleteById(id);

        return new ResponseEntity<>("Job has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/jobs/delete")
    public ResponseEntity<String> deleteAllJobs() {

        actualJobRepository.deleteAll();

        return new ResponseEntity<>("All jobs have been deleted!", HttpStatus.OK);
    }

}
