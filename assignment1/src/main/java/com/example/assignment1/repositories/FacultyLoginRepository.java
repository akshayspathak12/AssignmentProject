package com.example.assignment1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.assignment1.entities.FacultyLogin;

public interface FacultyLoginRepository extends JpaRepository<FacultyLogin, Long> {

	FacultyLogin findByEmail(String email);



}
