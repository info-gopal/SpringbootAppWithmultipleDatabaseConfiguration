package com.junit.practice.testing.serviceImplimention;

import java.io.FileNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junit.practice.testing.entites.book.Book;
import com.junit.practice.testing.repo.bookrepository.BookRepository;
import com.junit.practice.testing.service.BookService;


@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
	List<Book> allBookList = bookRepository.findAll();
		return allBookList;
	}
	@Override
	public Book getBook(Long bookId) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	 Optional<Book> findBook = bookRepository.findById(bookId);
		
		if(!findBook.isPresent()|| findBook.isEmpty()) {
			throw new FileNotFoundException("book");
				
		}
				
		return findBook.get();
	}
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		Book save = bookRepository.save(book);
		
		return save;
	}
	@Override
	public Book updateBook(Book book) throws FileNotFoundException {
		if(book.getBookId()==null || book==null) {
			throw new FileNotFoundException(" book must not null this Book Id==> "+book.getBookId()+"  null");
		}
	   Optional<Book> findedbook = bookRepository.findById(book.getBookId());
	   if(!findedbook.isPresent()) {
		  throw new FileNotFoundException("this book id ==> "+book.getBookId()+" not exist in data base"); 
	   }
	   Book save = bookRepository.save(book);
		return save;
	}
	

}
