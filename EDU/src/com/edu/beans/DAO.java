package com.edu.beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO {

	// Data Access Object
	public static Connection connect() {
		Connection conn = null;
		try { // 서버에서 DB를 처리해주는 , 리소스를 관리해주는 객체
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			System.out.println("연결 성공");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
