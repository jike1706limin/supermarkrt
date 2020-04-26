package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Find_2 {
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	JLabel name1,value1,value2,title,ps;
	JButton end,jb1,jb2;
	final JTextField str2 = new JTextField();
	final JTextField str3 = new JTextField();
	final JTextField str4 = new JTextField();
	public Find_2()
	{
		f = new Frame("商品查询",600,600);
		f.setSize(600, 500);     //设置窗口的大小
		init();
		f.setVisible(false);
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					deal();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str2.setText("");
				str3.setText("");
				str4.setText("");
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("请输入查询条件",JLabel.CENTER);
		ps = new JLabel("（不需要的请不要填写）",JLabel.RIGHT);
		name1 = new JLabel("名字:",JLabel.RIGHT);
		value1 = new JLabel("最低价格:",JLabel.RIGHT);
		value2 = new JLabel("最高价格:",JLabel.RIGHT);
		title.setFont(fo);
		ps.setFont(fo3);
		name1.setFont(fo2);
		value1.setFont(fo2);
		value2.setFont(fo2);
		str2.setFont(fo2);
		str3.setFont(fo2);
		str4.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		ps.setBounds(100, 50, 400, 50);
		name1.setBounds(200,100,50,50);
		value1.setBounds(100,200,150,50);
		value2.setBounds(100,300,150,50);
		str2.setBounds(250, 100, 150, 50);
		str3.setBounds(250, 200, 150, 50);
		str4.setBounds(250, 300, 150, 50);
		jb1 = new JButton("返回菜单");
		jb2 = new JButton("确认");
		end.setBounds(450, 380, 100, 50);
		jb1.setBounds(250, 380, 100, 50);
		jb2.setBounds(50, 380, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Choice.flag==1)
				{
					First.f.setVisible(true);
					f.setVisible(false);
				}
				else
				{
					Customer.f.setVisible(true);
					f.setVisible(false);
				}
				str2.setText("");
				str3.setText("");
				str4.setText("");
			}
		});
		f.add(title);
		f.add(ps);
		f.add(name1);
		f.add(value1);
		f.add(value2);
		f.add(str2);
		f.add(str3);
		f.add(str4);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		String name = null,str;
		double little = -1,big = -1;
		if(!str2.getText().equals(""))
		{
			name = str2.getText();
		}
		str = str3.getText();
		for(int i=0;i<str.length();i++)
		if(str.charAt(i)<'0'||str.charAt(i)>'9')
		{
			JOptionPane.showMessageDialog(null, "请输入正确的查询信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
			return;
		}
		str = str4.getText();
		for(int i=0;i<str.length();i++)
		if(str.charAt(i)<'0'||str.charAt(i)>'9')
		{
			JOptionPane.showMessageDialog(null, "请输入正确的查询信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
			return;
		}
		if(!str3.getText().equals(""))
		{
			little = Double.parseDouble(str3.getText());
		}
		if(!str4.getText().equals(""))
		{
			big = Long.parseLong(str4.getText());
		}
		if(name==null&&little==-1&&big==-1)
			return;
		if(little!=-1||big!=-1)
		{
			if(little==-1||big==-1)
			{
				JOptionPane.showMessageDialog(null, "请输入正确的查询信息","信息错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(name!=null)
		{
			if(little!=-1&&big!=-1)
			{
				new show(f.mo.Find(name, little, big));
			}
			else
			{
				new show(f.mo.FindName(name));
			}
		}
		else
		{
			if(little!=-1&&big!=-1)
				new show(f.mo.Find(little, big));
		}
	}
}
