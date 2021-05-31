package com.example.assignment1.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.example.assignment1.entities.Doc;
import com.example.assignment1.entities.StudentLogin;
import com.example.assignment1.entities.StudentUploadAssignment;
import com.example.assignment1.entities.UploadAssignment;
import com.example.assignment1.repositories.StudentLoginRepository;
import com.example.assignment1.repositories.StudentUploadAssignmentRepository;
import com.example.assignment1.repositories.UploadAssignmentRepository;
import com.example.assignment1.services.FacultyServicesImpl;

@Controller
@SessionAttributes("student")
public class StudentController {
	
	@Autowired
	private UploadAssignmentRepository uploadAssignmentRepo;
	
	@Autowired
	private StudentLoginRepository studentLoginRepo;
	
	@Autowired
	private FacultyServicesImpl facultyService;
	
	@Autowired
	private StudentUploadAssignmentRepository studentUploadAssignmentRepo;
	
	@RequestMapping("/student")
	public String studentLoginPage() {
		return "StudentLogin";
	}
	
	@RequestMapping("/StudentLogin")
	public String StudentLogin(@RequestParam("email") String email , @RequestParam("spassword") String spassword , ModelMap modelmap) {
		
			StudentLogin student = studentLoginRepo.findByEmail(email);
		if(student != null) {
			if(student.getEmail().equals(email) && student.getSpassword().equals(spassword) ) {
			modelmap.put("student", student.getId());	
				
				return "StudentDashboard";
			}else {
				modelmap.addAttribute("msg", "Invalid E-mail id and Password");
				return "StudentLogin";
			}
		}else {
			modelmap.addAttribute("msg", "Invalid E-mail id and Password");
			return "StudentLogin";
		}
		
	}
	
	@RequestMapping("/AllAssignment")
	public String StudentDashboard(ModelMap modelmap) {
	 List<UploadAssignment> findAll = uploadAssignmentRepo.findAll();
	 
	modelmap.addAttribute("find", findAll);
	return "showAllAssignment";
		
	}
	
	@RequestMapping("/dwoloadAssignment")
	public ResponseEntity<ByteArrayResource>  dwoloadAssignment(@RequestParam("fileUploadId") Integer fileUploadId  ) {
		
		
		Doc doc = facultyService.getFile(fileUploadId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
		
		}
	
	@RequestMapping("/UploadStudentAssignment")
	public String UploadStudentAssignment(@RequestParam("find") Integer find , ModelMap modelmap) {
		modelmap.addAttribute("find", find);
		return "UploadStudentAssignment";
	}
	
	@RequestMapping("/UploadAssignment") 
	public String UploadAssignment(@RequestParam("name") String name , 
			@RequestParam("file") MultipartFile file , @RequestParam("find") UploadAssignment find , @RequestParam("student") StudentLogin student , ModelMap modelmap) {
		Doc saveFile = facultyService.saveFile(file);
		
		StudentUploadAssignment upload = new StudentUploadAssignment();
		upload.setAssignment(find);
		upload.setStudent(student);
		upload.setSumbittedDate(new Date());
		upload.setFileUpload(saveFile);
		studentUploadAssignmentRepo.save(upload);
		
		return "StudentDashboard";
	}
	
	
	
	
	
	

}
