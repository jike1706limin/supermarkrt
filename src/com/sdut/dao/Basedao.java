package com.sdut.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//数据库基本操作，连接与关闭
public class Basedao {
	Connection con;
	Statement st;
	ResultSet rs;
	public void getConn() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=(Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/supermarket?serverTimezone=GMT%2B8",
			    "root", "123456");

	}
	public void closeAll() throws SQLException
	{
		if(rs!=null)
		{
			rs.close();
		}
		if(st!=null)
		{
			st.close();
		}
		if(con!=null)
		{
			con.close();
		} 
	} 
}
