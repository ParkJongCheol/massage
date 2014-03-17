package com.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.message.db.DBManager;
import com.message.db.SqlMap;
import com.message.dto.MemberDTO;

public class LoginDAO {
	public MemberDTO Login(String userId, String passWord){
		MemberDTO member = new MemberDTO();
		SqlMapClient sqlmap = SqlMap.getSqlMapInstance();
		
		try{
			Map map = new HashMap<>();
			map.put("USER_ID", "JONGCHAL");
			member = (MemberDTO)sqlmap.queryForObject("login", map);
		}catch(Exception e){
			System.out.println(e.toString());
		}finally{
			//DBManager.dbClose(conn, pstmt);
		}
		
		return member;
	}
}
