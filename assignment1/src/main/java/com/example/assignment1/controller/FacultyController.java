package com.example.assignment1.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assignment1.entities.Doc;
import com.example.assignment1.entities.FacultyLogin;
import com.example.assignment1.entities.StudentLogin;
import com.example.assignment1.entities.StudentUploadAssignment;
import com.example.assignment1.entities.UploadAssignment;
import com.example.assignment1.repositories.FacultyLoginRepository;
import com.example.assignment1.repositories.StudentLoginRepository;
import com.example.assignment1.repositories.StudentUploadAssignmentRepository;
import com.example.assignment1.repositories.UploadAssignmentRepository;
import com.example.assignment1.services.FacultyServicesImpl;







@Controller
public class FacultyController {
	
	@Autowired
	private FacultyLoginRepository facultyrepo;
	
	@Autowired
	private StudentLoginRepository studentRepo;
	
	@Autowired
	private UploadAssignmentRepository uploadAssignmentRepo;
	
	@Autowired
	private FacultyServicesImpl facultyService;
	
	@Autowired
	private StudentUploadAssignmentRepository studentUploadAssignmentRepo;
	
	
	
	@RequestMapping("/faculty")
	public String studentLoginPage() {
		return "loginfaculty";
	}
	
	@RequestMapping("/FacultyLogin")
	public String verifyLogin(@RequestParam("email") String email , @RequestParam("password") String password , ModelMap modelmap) {
		FacultyLogin faculty = facultyrepo.findByEmail(email);
		if(faculty != null) {
			if(faculty.getEmail().equals(email) && faculty.getFpassword().equals(password) ) {
				return "facultyDashboard";
			}else {
				modelmap.addAttribute("msg", "Invalid E-mail id and Password");
				return "loginfaculty";
			}
		}else {
			modelmap.addAttribute("msg", "Invalid E-mail id and Password");
			return "loginfaculty";
		}
		

	}
	
	@RequestMapping("/AddStudent")
	public String addStudent() {
		return "AddStudent";
	}
	
	@RequestMapping("/studentData")
	public String studentData(@ModelAttribute("student") StudentLogin student , ModelMap model) {
		
		studentRepo.save(student);
		model.addAttribute("msg", "Student Record Save Successfully");
		return "AddStudent";
	}
	
	@RequestMapping("/AssignmentGenerate")
	public String assignmentGenerate() {
		return "AssignmentGenerate";
	}
	
	@RequestMapping("/GenerateAssignment")
	public String generateAssignment( @RequestParam("topic") String topic, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate  , RedirectAttributes ra , 
			@RequestParam("file") MultipartFile file) throws IOException {
		Doc saveFile = facultyService.saveFile(file);
		

		UploadAssignment upload = new UploadAssignment();
		upload.setTopic(topic);
		upload.setStartDate(startDate);
		upload.setEndDate(endDate);
		upload.setFileUpload(saveFile);
		uploadAssignmentRepo.save(upload);
		return "facultyDashboard";
	}
	
	@RequestMapping("/ViewStudent")
	public String viewStudent(ModelMap modelmap) {
		List<StudentUploadAssignment> findAll = studentUploadAssignmentRepo.findAll();
		modelmap.addAttribute("findAll", findAll);
//		for (StudentUploadAssignment find : findAll) {
//			System.out.println(find.getStudent().getRollNo());
//			System.out.println(find.getStudent().getSname());
//		}
		return "ViewStudent";
	}
	
	@RequestMapping("/DownloadAnswerSheet")
	public ResponseEntity<ByteArrayResource> DownloadAnswerSheet(@RequestParam("file") int file) {
		Doc doc = facultyService.getFile(file).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	
}















