package com.codecool.codebook.controller;

import com.codecool.codebook.model.ActualJob;
import com.codecool.codebook.model.Klass;
import com.codecool.codebook.repository.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class KlassController {


    @Autowired
    KlassRepository klassRepository;

    @GetMapping("/klasses")
    public List<Klass> listKlasses(){
        List<Klass> klasses = klassRepository.findAll();
        System.out.println(klasses);
        return klasses;
    }

    @GetMapping("/klasses/{id}")
    public Optional<Klass> showKlass(@PathVariable("id") int id){
        Optional <Klass> klass = klassRepository.findById((long) id);
        return klass;
    }


    @PostMapping(value = "/klasses/create")
    public Klass postJob(@RequestBody Klass klass) {

        return klassRepository.save(new Klass(klass.getName()));
    }



    @PutMapping("/klasses/{id}")
    public ResponseEntity<Klass> updateJob(@PathVariable("id") long id, @RequestBody Klass klass) {
        Optional<Klass> klassData = klassRepository.findById(id);

        if (klassData.isPresent()) {
            Klass _klass = klassData.get();
            _klass.setName(klass.getName());
            return new ResponseEntity<>(klassRepository.save(_klass), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/klasses/{id}")
    public ResponseEntity<String> deleteKlass(@PathVariable("id") long id) {

        klassRepository.deleteById(id);

        return new ResponseEntity<>("Klass has been deleted!", HttpStatus.OK);
    }

    @DeleteMapping("/klasses/delete")
    public ResponseEntity<String> deleteAllKlasses() {

        klassRepository.deleteAll();

        return new ResponseEntity<>("All klasses have been deleted!", HttpStatus.OK);
    }


}
