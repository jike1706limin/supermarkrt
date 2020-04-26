package com.sdut.dao;

import java.sql.SQLException;
import java.sql.Statement;
//对数据库的增删改查
import java.util.ArrayList;
import java.util.List;

import com.sdut.opreation.Book;
import com.sdut.opreation.Sale;
public class MenuOpreation {
	Basedao bd = new Basedao();
	//添加信息
	public int addBook(Book book) throws ClassNotFoundException, SQLException
	{
		String sql = "insert into books values('"+book.getId()+"','"+book.getName()+"','"+book.getNature()+"',"+book.getValue()+","+book.getNum()+");";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		try {
			return bd.st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
	//删除某商品
	public int del(String id) throws ClassNotFoundException, SQLException 
	{
		String sql = "DELETE FROM books WHERE id = '"+id+"' LIMIT 1;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		return bd.st.executeUpdate(sql);
	}
    /*
     * 	查询一条记录
     */
	//按id查询
	public List<Book> Find(String id) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *FROM  books where id = '"+id+"' ORDER BY books.price ASC;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		while(bd.rs.next())
		{
			Book book= new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list;
	}
	//按名字查询
	public List<Book> FindName(String name) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *FROM  books where name = '"+name+"' ORDER BY books.price ASC;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		while(bd.rs.next())
		{
			Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list;
	}
	//按价格查询
	public List<Book> Find(double little,double big) throws ClassNotFoundException, SQLException
	{
		double t;
		t = Math.max(little, big);
		little = Math.min(little, big);
		big = t;
		String sql = "SELECT *FROM  books where price>="+little+"&&price<="+big+"ORDER BY books.price ASC;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		while(bd.rs.next())
		{
			Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list;
	}
	//按名称+价格查询
	public List<Book> Find(String name,double little,double big) throws ClassNotFoundException, SQLException
	{
		double t;
		t = Math.max(little, big);
		little = Math.min(little, big);
		big = t;
		String sql = "SELECT *FROM  books where name = '"+name+"'&&price>="+little+"&&price<="+big+" ORDER BY books.price ASC;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		while(bd.rs.next())
		{
			Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list;
	}
	//查找库存
	public List<Book> Find1(long number) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * FROM  books where num<="+number+";";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		while(bd.rs.next())
		{
		     Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list;
	}
	//查找库存
		public List<Book> Find2(long number) throws ClassNotFoundException, SQLException
		{
			String sql = "SELECT * FROM  books where num>="+number+";";
			bd.getConn();
			bd.st = (Statement) bd.con.createStatement();
			bd.rs=bd.st.executeQuery(sql);
			List<Book> list=new ArrayList<Book>();
			while(bd.rs.next())
			{
			     Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
				list.add(book);
			}
			return list;
		}
	/*
	 * 修改该记录
	 */
	
	//判断id存在
	public boolean judge(String id) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *FROM  books where id = '"+id+"' ORDER BY books.price ASC;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		if(bd.rs.next())
		{
			Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list.size()==0?false:true;
	}
	//修改名称
	public void update(String id,String name) throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE books SET name = '"+name+"' WHERE id = '"+id+"'";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.st.executeUpdate(sql); 
	}
	//修改名称
		public void update1(String id,String nature) throws ClassNotFoundException, SQLException
		{
			String sql = "UPDATE books SET nature = '"+nature+"' WHERE id = '"+id+"'";
			bd.getConn();
			bd.st = (Statement) bd.con.createStatement();
			bd.st.executeUpdate(sql); 
		}
	//修改价格
	public void update(String id,double value) throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE books SET price = "+value+" WHERE id = '"+id+"';";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.st.executeUpdate(sql); 
	}
	//修改库存
	public void update(String id,long number,int i) throws ClassNotFoundException, SQLException
	{
		if(i==1)
		{
		  String sql= "UPDATE books SET num = "+number+" WHERE id = '"+id+"'";
		    bd.getConn();
			bd.st = (Statement) bd.con.createStatement();
			bd.st.executeUpdate(sql); 
		}
		else if(i==2)
		{
			
			String sql = "UPDATE books SET num = num - "+number+" WHERE id = '"+id+"'";
			bd.getConn();
			bd.st = (Statement) bd.con.createStatement();
			bd.st.executeUpdate(sql); 
		}
		else if(i==3)
		{
		   String sql = "UPDATE books SET num = num + "+number+" WHERE id = '"+id+"'";
		   bd.getConn();
		   bd.st = (Statement) bd.con.createStatement();
		   bd.st.executeUpdate(sql); 
		}
	}
	//判断库存
	public boolean judgenum(String id,long number) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *FROM  books where id = '"+id+"'and num >= "+number+" ;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		if(bd.rs.next())
		{
			Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list.size()==0?false:true;
	}
	
	//显示所有记录
	public List<Book> AllBook() throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT *FROM  books ORDER BY books.price ASC";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.rs=bd.st.executeQuery(sql);
		List<Book> list=new ArrayList<Book>();
		while(bd.rs.next())
		{
			Book book = new Book(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getDouble(4),bd.rs.getLong(5));
			list.add(book);
		}
		return list;
	}
        //清除所有记录
        public void Truncate() throws SQLException, ClassNotFoundException
        {
            String sql = "TRUNCATE TABLE books";
            bd.getConn();
            bd.st = (Statement) bd.con.createStatement();
            bd.rs=bd.st.executeQuery(sql);
        }
        /*
                                 * 下面是对销售人员表的操作
         * 
         */
        //添加销售人员信息
        public int addSales(Sale sale) throws ClassNotFoundException, SQLException
    	{
    		String sql = "insert into sales values('"+sale.getId()+"','"+sale.getName()+"','"+sale.getGender()+"','"+sale.getAddress()+"')";
    		bd.getConn();
    		bd.st = (Statement) bd.con.createStatement();
    		try {
    			return bd.st.executeUpdate(sql);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			return 0;
    		}
    	}
      //显示所有销售人员信息
    	public List<Sale> AllSale() throws ClassNotFoundException, SQLException
    	{
    		String sql = "SELECT * FROM  sales";
    		bd.getConn();
    		bd.st = (Statement) bd.con.createStatement();
    		bd.rs=bd.st.executeQuery(sql);
    		List<Sale> list=new ArrayList<Sale>();
    		while(bd.rs.next())
    		{
    			Sale sale= new Sale(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getString(4));
    			list.add(sale);
    		}
    		return list;
    	}
    	//删除销售员信息
    	public int saledel(String id) throws ClassNotFoundException, SQLException 
    	{
    		String sql = "DELETE FROM sales WHERE id = '"+id+"' LIMIT 1;";
    		bd.getConn();
    		bd.st = (Statement) bd.con.createStatement();
    		return bd.st.executeUpdate(sql);
    	}
    	//判断id存在
    	public boolean salejudge(String id) throws ClassNotFoundException, SQLException
    	{
    		String sql = "SELECT *FROM  sales where id = '"+id+"' ;";
    		bd.getConn();
    		bd.st = (Statement) bd.con.createStatement();
    		bd.rs=bd.st.executeQuery(sql);
    		List<Sale> list=new ArrayList<Sale>();
    		if(bd.rs.next())
    		{
    			Sale sale = new Sale(bd.rs.getString(1),bd.rs.getString(2),bd.rs.getString(3),bd.rs.getString(4));
    			list.add(sale);
    		}
    		return list.size()==0?false:true;
    	}
}
