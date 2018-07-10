package com.codecool.codebook.service;

import com.codecool.codebook.Location;
import com.codecool.codebook.model.*;
import com.codecool.codebook.repository.*;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(ActualJobRepository actualJobRepository,
                           KlassRepository klassRepository,
                           MessageRepository messageRepository,
                           SchoolRepository schoolRepository,
                           StudentRepository studentRepository,
                           WorkplaceRepository workplaceRepository) {
        Workplace testWorkplace = new Workplace("Tname", "Tdesc");
        Klass testKlass = new Klass("BPtest");
        ActualJob testJob = new ActualJob("Tjob", "Tjobdesc");
        School testSchool = new School(Location.BUDAPEST);
        Message testMessage = new Message("asd");
        Student testStudent = new Student("Testname", "e@mail.hu", "examplepassword");
        testStudent.setKlass(testKlass);
        testStudent.setWorkplace(testWorkplace);

        workplaceRepository.save(testWorkplace);
        schoolRepository.save(testSchool);
        klassRepository.save(testKlass);
        actualJobRepository.save(testJob);
        messageRepository.save(testMessage);
        studentRepository.save(testStudent);
    }
}
