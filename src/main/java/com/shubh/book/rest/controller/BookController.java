package com.shubh.book.rest.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.book.rest.exception.BookException;
import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.services.BookService;
import com.shubh.book.rest.services.impl.BookServiceImpl;

/**
 * @author Shubhangi.Talekar
 *
 */
@RestController
@RequestMapping("/api")
public class BookController {

	BookService bookService = new BookServiceImpl();

	@GetMapping("/book/{id}")
	@ResponseBody
	public ResponseEntity<?> getBookById(@PathVariable(value = "id") int id) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(bookService.getBookById(id));
		} catch (SQLException e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return response;
	}

	@PostMapping("/book")
	@ResponseBody
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		System.out.println(book.getId());
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
		} catch (SQLException e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
		}
		return response;
	}

	@PutMapping("/book")
	@ResponseBody
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(bookService.updateBook(book));
		} catch (SQLException e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
		}
		return response;
	}

	@DeleteMapping("/book/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") int id) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(bookService.deleteBook(id));
		} catch (SQLException e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
		}
		return response;
	}

	@GetMapping("/books")
	public ResponseEntity<?> getBooksOfAuthor(@RequestParam(value = "author") String authorName) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(bookService.getBooksOfAuthor(authorName));
		} catch (SQLException e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return response;
	}

	@GetMapping("/books/in")
	public ResponseEntity<?> getBooksInPriceRange(@RequestParam(value = "min") int min,
			@RequestParam(value = "max") int max) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(bookService.getBooksInPriceRange(min, max));
		} catch (SQLException e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return response;
	}
}
