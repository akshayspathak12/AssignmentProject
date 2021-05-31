package com.example.assignment1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.assignment1.entities.Doc;
import com.example.assignment1.repositories.DocRepository;


@Service
public class FacultyServicesImpl {

	
	
	@Autowired
	private DocRepository docRepository;

	public Doc saveFile(MultipartFile file) {
		
		String docname = file.getOriginalFilename();
		try {
			Doc doc = new Doc (docname,file.getContentType(),file.getBytes());
			 return docRepository.save(doc);
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Optional<Doc> getFile(Integer fileId) {
		return docRepository.findById(fileId);
	}
	
	public List<Doc> getFiles(){
		return docRepository.findAll();
	}
}