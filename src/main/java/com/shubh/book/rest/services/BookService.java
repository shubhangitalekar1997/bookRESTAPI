package com.shubh.book.rest.services;

import java.sql.SQLException;
import java.util.List;

import com.shubh.book.rest.exception.BookException;
import com.shubh.book.rest.model.Book;

/**
 * @author Shubhangi.Talekar
 *
 */
public interface BookService {
	/**
	 * @param id
	 * @return book OBJECT
	 * @throws SQLException
	 * @throws BookException
	 */
	Book getBookById(int id) throws SQLException,BookException;
	/**
	 * @param authorName
	 * @return LIST OF BOOKS OF AUTHOR authorName
	 * @throws SQLException
	 * @throws BookException
	 */
	List<Book> getBooksOfAuthor(String authorName) throws SQLException, BookException;
	/**
	 * @param min
	 * @param max
	 * @return LIST OF BOOKS HAVING PRICE RANGE IN min AND max
	 * @throws SQLException
	 * @throws BookException
	 */
	List<Book> getBooksInPriceRange(int min, int max) throws SQLException, BookException;
	/**
	 * @param book
	 * @return NEWLY CREATED BOOK OBJECT
	 * @throws SQLException
	 * @throws BookException
	 */
	Book createBook(Book book) throws SQLException, BookException;
	/**
	 * @param book
	 * @return UPDATED book OBJECT
	 * @throws SQLException
	 * @throws BookException
	 */
	Book updateBook(Book book) throws SQLException, BookException;
	/**
	 * @param id
	 * @return SUCCESS / FAILED MASSAGE
	 * @throws SQLException
	 * @throws BookException
	 */
	String deleteBook(int id) throws SQLException, BookException; ;
}

