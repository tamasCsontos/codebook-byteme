package com.codecool.codebook.repository;

import com.codecool.codebook.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


    Student findByEmail(String email);

}