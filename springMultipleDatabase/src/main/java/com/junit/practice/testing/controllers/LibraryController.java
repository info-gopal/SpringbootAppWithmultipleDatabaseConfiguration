package com.junit.practice.testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.practice.testing.entites.library.Library;
import com.junit.practice.testing.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	LibraryService libraryService;
	
	@PostMapping
	public ResponseEntity<Library> addLibraryDetails(@RequestBody Library library){
		
		ResponseEntity<Library> savelibrary=libraryService.saveLibraryDetails(library);
		
		
		return savelibrary;
	
		
		
		
	}
	
	
	
	

}
