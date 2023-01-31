package com.company.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.company.home.util.DBconnection;

public class MemberDAO {
	
	//1. 회원 추가
	public static int addMember(MemberDTO memberDTO) throws Exception{
		Connection con = DBconnection.getConnection();
		
		String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberDTO.getMember_id());
		ps.setString(2, memberDTO.getMember_pw());
		ps.setString(3, memberDTO.getMember_name());
		ps.setString(4, memberDTO.getMember_address());
		ps.setString(5, memberDTO.getMember_phone());
		ps.setString(6, memberDTO.getMember_email());

		int result = ps.executeUpdate();
		
		DBconnection.disconnection(con, ps);
		
		return result;
	}
	public static void main(String[] args) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("JAVA_TEST_ID1");
		memberDTO.setMember_pw("JAVA_TEST_PW1");
		memberDTO.setMember_name("JAVA_TEST_NAME1");
		memberDTO.setMember_address("JAVA_TEST_ADDRESS1");
		memberDTO.setMember_phone("JAVA_TEST_PHONE1");
		memberDTO.setMember_email("JAVA_TEST_EMAIL1");
		
		int result;
		try {
			result = MemberDAO.addMember(memberDTO);
			System.out.println(result == 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
