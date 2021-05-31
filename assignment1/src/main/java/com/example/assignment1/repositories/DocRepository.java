package com.example.assignment1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment1.entities.Doc;



public interface DocRepository extends JpaRepository<Doc, Integer> {
	

}
