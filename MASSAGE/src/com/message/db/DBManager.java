package com.message.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBManager {
	
	private static DBManager dbManager = null;

	private DBManager(){}
	
	public static synchronized DBManager getInstance() {
        if( dbManager == null ){
        	dbManager = new DBManager();
        }
        return dbManager; 
   }
	
	public static  Connection dbConn(){
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String id = "msps_test";
		String pw = "1q2w3e$";
		String dbUrl = "jdbc:sqlserver://10.239.166.85:1433;databasename=MSPS_DEV";
		Connection conn = null;
		
		try{
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(dbUrl, id, pw);	
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		return conn;
		
	}
	
	public static void dbClose(Connection conn, PreparedStatement pstmt){
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
