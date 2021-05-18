package com.edu.beans;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.test.stateless.DataSource;

public class BookDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

// 전체리스트, 신규입력, 수정, 삭제 - DBMS를 활용

	// 한건 조회
	public BookBean getBook(String title) {
		String sql = "select * from book where title = ?";
		conn = DAO.connect();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				System.out.println("정상조회.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return book;
	}

	// 전체 리스트 (여러건 조회)
	public List<BookBean> getBookList() {
		List<BookBean> bookList = new ArrayList<BookBean>();
		conn = DAO.connect();
		String sql = "select * from book";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("Publisher"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bookList;
	}

	// 저자별 책 조회 : author -> 책리스트를 반환 (getBookByAuthor)
	public List<BookBean> getBookByAuthor(String author) {
		String sql = "select * from book where author = ?";
		conn = DAO.connect();
		BookBean book = new BookBean();
		List<BookBean> list = new ArrayList<BookBean>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, author);
			rs = psmt.executeQuery();
			if (rs.next()) {
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 한건 입력 : BookBean 타입 -> insertBook (BookBean book)
	public void insertBook(BookBean book) {
		String sql = "insert into book values(?, ?, ?)";
		conn = DAO.connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());
			int n = psmt.executeUpdate();
			if(n != 0 ) {
				System.out.println(n + "건 입력");
			}else {
				System.out.println("실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	// 수정

	// 삭제
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
