package com.massage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.massage.db.DBManager;
import com.massage.dto.MemberDTO;

public class LoginDAO {
	public MemberDTO Login(String userId, String passWord){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String loginSQL = "SELECT USER_ID, NAME FROM TB_COM_USERS WHERE USER_ID=?";
		
		//DBManager db = new DBManager();
		MemberDTO member = new MemberDTO();
		try{
			conn = DBManager.dbConn();
			pstmt = conn.prepareStatement(loginSQL);
			pstmt.setString(1, "JONGCHAL");
			//pstmt.setString(2, passWord);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				member.setId(rs.getString("USER_ID"));
				member.setName(rs.getString("NAME")); //name
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}finally{
			DBManager.dbClose(conn, pstmt);
		}
		
		return member;
	}
}
