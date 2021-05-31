package com.example.assignment1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment1.entities.StudentLogin;

public interface StudentLoginRepository extends JpaRepository<StudentLogin , Long> {
    StudentLogin findByEmail(String email);

}
