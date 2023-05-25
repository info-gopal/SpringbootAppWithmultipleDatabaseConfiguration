package com.junit.practice.testing.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.junit.practice.testing.entites.book.Book;

public interface BookService {

	
	public List<Book> getAllBooks();
	public Book getBook(Long bookId) throws FileNotFoundException;
	public Book saveBook(Book book);
	public Book updateBook(Book book) throws FileNotFoundException;
	
	
}
