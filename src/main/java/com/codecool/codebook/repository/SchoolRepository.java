package com.codecool.codebook.repository;

import com.codecool.codebook.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

}