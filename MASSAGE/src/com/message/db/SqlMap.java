package com.message.db;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMap {
	private static SqlMapClient sqlMap;
	
	static{
		Reader reader = null;
		try{
			String resource = "com/message/db/sqlMapConfig.xml";
			reader = Resources.getResourceAsReader(resource);
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public static SqlMapClient getSqlMapInstance(){
		return sqlMap;
	}
}
