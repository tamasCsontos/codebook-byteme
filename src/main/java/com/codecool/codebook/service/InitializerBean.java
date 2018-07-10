package com.codecool.codebook.service;

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

    }
}
