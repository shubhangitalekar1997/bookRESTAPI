package com.shubh.book.rest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shubh.book.rest.dao.BookDao;
import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.util.db.DBConnect;

/**
 * @author Shubhangi.Talekar
 *
 */
public class BookDaoImpl implements BookDao {

	private static String QUERY_GET_BY_ID = "select * from books where id=";
	private static String QUERY_GET_BY_AUTHOR = "select * from books where author=";
	private static String QUERY_GET_BETWEEN_PRICE = "select * from books where price between ? and ?";
	private static String QUERY_CREATE = "insert into books values(?,?,?,?)";
	private static String QUERY_UPDATE = "update books set title= ? , author= ? ,  price= ? where id = ?";
	private static String QUERY_DELETE = "delete from books where id=?";

	public Book getBookById(int id) throws SQLException {
		Connection connection = DBConnect.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY_GET_BY_ID + id);
		Book responseBook = null;
		if (rs.next()) {
			responseBook = new Book();
			responseBook.setId(rs.getInt("id"));
			responseBook.setName(rs.getString("title"));
			responseBook.setAuthor(rs.getString("author"));
			responseBook.setPrice(rs.getInt("price"));
		}
		return responseBook;
	}

	public List<Book> getBooksOfAuthor(String authorName) throws SQLException {
		List<Book> result = new ArrayList<Book>();
		Book b;

		Connection conn = DBConnect.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(QUERY_GET_BY_AUTHOR + "'" + authorName + "'");
		while (rs.next()) {
			b = new Book();
			b.setId(rs.getInt("id"));
			b.setName(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPrice(rs.getInt("price"));
			result.add(b);
		}
		return result;
	}

	public List<Book> getBooksInPriceRange(int min, int max) throws SQLException {
		List<Book> result = new ArrayList<Book>();
		Book b;
		Connection conn = DBConnect.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_GET_BETWEEN_PRICE);
		stmt.setInt(1, min);
		stmt.setInt(2, max);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			b = new Book();
			b.setId(rs.getInt("id"));
			b.setName(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPrice(rs.getInt("price"));
			result.add(b);
		}
		return result;
	}

	@Override
	public Book createBook(Book book) throws SQLException {
		Connection conn = DBConnect.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_CREATE);
		Book respBook = null;
		stmt.setInt(1, book.getId());
		stmt.setString(2, book.getName());
		stmt.setString(3, book.getAuthor());
		stmt.setInt(4, book.getPrice());
		int rs = stmt.executeUpdate();
		if (rs > 0)
			respBook = getBookById(book.getId());
		return respBook;
	}

	@Override
	public int updateBook(Book book) throws SQLException {
		Connection conn = DBConnect.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_UPDATE);
		stmt.setString(1, book.getName());
		stmt.setString(2, book.getAuthor());
		stmt.setInt(3, book.getPrice());
		stmt.setInt(4, book.getId());
		int rs = stmt.executeUpdate();
		return rs;
	}

	public int deleteBook(int id) throws SQLException {
		Connection conn = DBConnect.getConnection();
		PreparedStatement stmt = conn.prepareStatement(QUERY_DELETE);
		stmt.setInt(1, id);
		int rs = stmt.executeUpdate();
		return rs;
	}

}
