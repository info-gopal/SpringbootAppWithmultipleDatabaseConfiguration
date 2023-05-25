package com.junit.practice.testing.repo.bookrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.practice.testing.entites.book.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
