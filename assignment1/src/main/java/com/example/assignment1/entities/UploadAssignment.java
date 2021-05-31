package com.example.assignment1.entities;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "uploadassignment")
public class UploadAssignment extends AbstractEntity{
		
	    @Column(name = "TOPIC")
		private String topic;
		@Column(name = "STARTDATE")
		private String startDate;
		@Column(name = "ENDDATE")
		private String endDate;
		@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
		@JoinColumn(name="FileUpload_fk")
		private Doc fileUpload;
		
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate2) {
			this.startDate = startDate2;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public Doc getFileUpload() {
			return fileUpload;
		}
		public void setFileUpload(Doc fileUpload) {
			this.fileUpload = fileUpload;
		}
		
		
}
