package com.example.assignment1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="studentlogin")
public class StudentLogin extends AbstractEntity {

		private String sname;
		private String email;
		private String spassword;
		@Column(name = "ROLLNO")
		private int rollNo;
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSpassword() {
			return spassword;
		}
		public void setSpassword(String spassword) {
			this.spassword = spassword;
		}
		public int getRollNo() {
			return rollNo;
		}
		public void setRollNo(int rollNo) {
			this.rollNo = rollNo;
		}
		
		
}
