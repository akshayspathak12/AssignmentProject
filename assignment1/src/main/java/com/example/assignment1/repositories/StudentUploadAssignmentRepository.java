package com.example.assignment1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment1.entities.StudentUploadAssignment;

public interface StudentUploadAssignmentRepository extends JpaRepository<StudentUploadAssignment, Long> {

}
