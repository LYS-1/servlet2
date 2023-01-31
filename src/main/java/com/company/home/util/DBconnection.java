package com.company.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconnection {
	//getConnection
	public static Connection getConnection() throws Exception{
		//1. 연결 정보
		String user = "USER01";
		String pw = "USER01";
		String ip = "192.168.1.114";
		String url = "jdbc:oracle:thin:@192.168.1.175:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver를 메모리에 로딩
		Class.forName(driver);
		
		//3. DB연결
		return DriverManager.getConnection(url, user, pw);
	}
	
	public static void disconnection(Connection con, PreparedStatement ps, ResultSet rs) throws Exception{
		rs.close();
		ps.close();
		con.close();
	}
	
	public static void disconnection(Connection con, PreparedStatement ps) throws Exception{
		ps.close();
		con.close();
	}
	
	public static void main(String[] args) {
		try {
			Connection con = DBconnection.getConnection();
			System.out.println(con == null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
