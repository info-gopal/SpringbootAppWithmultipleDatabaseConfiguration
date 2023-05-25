package com.junit.practice.testing.repo.libraryrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.practice.testing.entites.library.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}
