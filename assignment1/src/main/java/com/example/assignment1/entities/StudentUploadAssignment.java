package com.example.assignment1.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentuploadassignment")
public class StudentUploadAssignment extends AbstractEntity {
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "assignment_id")
	private UploadAssignment assignment;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private StudentLogin student;

	private Date sumbittedDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FileUpload_fk")
	private Doc fileUpload;
	public UploadAssignment getAssignment() {
		return assignment;
	}
	public void setAssignment(UploadAssignment assignment) {
		this.assignment = assignment;
	}
	public StudentLogin getStudent() {
		return student;
	}
	public void setStudent(StudentLogin student) {
		this.student = student;
	}
	public Date getSumbittedDate() {
		return sumbittedDate;
	}
	public void setSumbittedDate(Date sumbittedDate) {
		this.sumbittedDate = sumbittedDate;
	}
	public Doc getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(Doc fileUpload) {
		this.fileUpload = fileUpload;
	}


}
