package com.junit.practice.testing.controllers;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.practice.testing.entites.book.Book;
import com.junit.practice.testing.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping
	public Book saveBookDetails(@RequestBody Book book){
		Book saveBook = bookService.saveBook(book);
			return saveBook;
	}
	@GetMapping
	public List<Book> getAllBooks(){
		List<Book> allBooks = bookService.getAllBooks();
		return allBooks;
			}
	
	@GetMapping(value="test/{bookId}")
	public Book getBookById(@PathVariable(value="bookId") Long bookId) throws FileNotFoundException {
		Book book = bookService.getBook(bookId);
		return book;
		}
	@PutMapping
	public Book upDateBook(@RequestBody @Validated Book book) throws FileNotFoundException {
		Book updateBook = bookService.updateBook(book);
		
		return updateBook;
	}

}
