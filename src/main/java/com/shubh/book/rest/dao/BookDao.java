package com.shubh.book.rest.dao;

import java.sql.SQLException;
import java.util.List;

import com.shubh.book.rest.model.Book;

/**
 * @author Shubhangi.Talekar
 *
 */

public interface BookDao {

	/**
	 * @param id
	 * @return BOOK OBJECT
	 * @throws SQLException
	 */
	Book getBookById(int id) throws SQLException;

	/**
	 * @param authorName
	 * @return LIST OF BOOKS OF AUTHOR authorName
	 * @throws SQLException
	 */
	List<Book> getBooksOfAuthor(String authorName) throws SQLException;

	/**
	 * @param min
	 * @param max
	 * @return LIST OF BOOKS HAVING PRICE RANGE IN min AND max
	 * @throws SQLException
	 */
	List<Book> getBooksInPriceRange(int min, int max) throws SQLException;

	/**
	 * @param book
	 * @return NEWLY CREATED BOOK OBJECT 
	 * @throws SQLException
	 */
	Book createBook(Book book) throws SQLException;

	/**
	 * @param book
	 * @return NO. OF AFFECTED ROWS
	 * @throws SQLException
	 */
	int updateBook(Book book) throws SQLException;
	
	/**
	 * @param id
	 * @return NO. OF AFFECTED ROWS
	 * @throws SQLException
	 */
	int deleteBook(int id) throws SQLException;
}
