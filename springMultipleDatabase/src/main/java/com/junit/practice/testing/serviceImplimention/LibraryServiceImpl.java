package com.junit.practice.testing.serviceImplimention;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.junit.practice.testing.entites.library.Library;
import com.junit.practice.testing.repo.libraryrepository.LibraryRepository;
import com.junit.practice.testing.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public ResponseEntity<Library> saveLibraryDetails(Library library) {

		Library save = libraryRepository.save(library);
		// TODO Auto-generated method stub
		HttpStatus created = HttpStatus.CREATED;
		return new ResponseEntity<Library>(save, HttpStatus.CREATED);
	}

}
