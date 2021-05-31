package com.example.assignment1.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="facultylogin")
public class FacultyLogin extends AbstractEntity {

	
		private String fname ;
		private String email;
		private String fpassword;
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFpassword() {
			return fpassword;
		}
		public void setFpassword(String fpassword) {
			this.fpassword = fpassword;
		}
		
}
