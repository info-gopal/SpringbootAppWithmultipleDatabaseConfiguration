package com.junit.practice.testing.service;

import org.springframework.http.ResponseEntity;

import com.junit.practice.testing.entites.library.Library;

public interface LibraryService {
	
	public ResponseEntity<Library> saveLibraryDetails(Library library);

}
