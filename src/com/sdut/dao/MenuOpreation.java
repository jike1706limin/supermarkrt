package com.sdut.dao;

import java.sql.SQLException;
import java.sql.Statement;
//�����ݿ����ɾ�Ĳ�
import java.util.ArrayList;
import java.util.List;

import com.sdut.opreation.Book;
import com.sdut.opreation.Sale;
public class MenuOpreation {
	Basedao bd = new Basedao();
	//�����Ϣ
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
	//ɾ��ĳ��Ʒ
	public int del(String id) throws ClassNotFoundException, SQLException 
	{
		String sql = "DELETE FROM books WHERE id = '"+id+"' LIMIT 1;";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		return bd.st.executeUpdate(sql);
	}
    /*
     * 	��ѯһ����¼
     */
	//��id��ѯ
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
	//�����ֲ�ѯ
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
	//���۸��ѯ
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
	//������+�۸��ѯ
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
	//���ҿ��
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
	//���ҿ��
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
	 * �޸ĸü�¼
	 */
	
	//�ж�id����
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
	//�޸�����
	public void update(String id,String name) throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE books SET name = '"+name+"' WHERE id = '"+id+"'";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.st.executeUpdate(sql); 
	}
	//�޸�����
		public void update1(String id,String nature) throws ClassNotFoundException, SQLException
		{
			String sql = "UPDATE books SET nature = '"+nature+"' WHERE id = '"+id+"'";
			bd.getConn();
			bd.st = (Statement) bd.con.createStatement();
			bd.st.executeUpdate(sql); 
		}
	//�޸ļ۸�
	public void update(String id,double value) throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE books SET price = "+value+" WHERE id = '"+id+"';";
		bd.getConn();
		bd.st = (Statement) bd.con.createStatement();
		bd.st.executeUpdate(sql); 
	}
	//�޸Ŀ��
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
	//�жϿ��
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
	
	//��ʾ���м�¼
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
        //������м�¼
        public void Truncate() throws SQLException, ClassNotFoundException
        {
            String sql = "TRUNCATE TABLE books";
            bd.getConn();
            bd.st = (Statement) bd.con.createStatement();
            bd.rs=bd.st.executeQuery(sql);
        }
        /*
                                 * �����Ƕ�������Ա��Ĳ���
         * 
         */
        //���������Ա��Ϣ
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
      //��ʾ����������Ա��Ϣ
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
    	//ɾ������Ա��Ϣ
    	public int saledel(String id) throws ClassNotFoundException, SQLException 
    	{
    		String sql = "DELETE FROM sales WHERE id = '"+id+"' LIMIT 1;";
    		bd.getConn();
    		bd.st = (Statement) bd.con.createStatement();
    		return bd.st.executeUpdate(sql);
    	}
    	//�ж�id����
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
