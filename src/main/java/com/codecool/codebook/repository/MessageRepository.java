package com.codecool.codebook.repository;

import com.codecool.codebook.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}