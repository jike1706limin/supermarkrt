package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controllogin {
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	JLabel name1,value1,title;
	JButton end,jb1,jb2;
	final JTextField str2 = new JTextField();
	final JTextField str3 = new JTextField();
	public Controllogin()
	{
		f = new Frame("管理员登录",600,600);
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
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("请输入用户名密码",JLabel.CENTER);
		name1 = new JLabel("用户名:",JLabel.RIGHT);
		value1 = new JLabel("密码:",JLabel.RIGHT);
		title.setFont(fo);
		name1.setFont(fo2);
		value1.setFont(fo2);
		str2.setFont(fo2);
		str3.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		name1.setBounds(150,100,100,50);
		value1.setBounds(100,200,150,50);
		str2.setBounds(250, 100, 150, 50);
		str3.setBounds(250, 200, 150, 50);
		jb1 = new JButton("返回主页面");
		jb2 = new JButton("确认");
		end.setBounds(410, 380, 150, 50);
		jb1.setBounds(220, 380, 150, 50);
		jb2.setBounds(40, 380, 150, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
					Choice.f.setVisible(true);
					f.setVisible(false);
				str2.setText("");
				str3.setText("");
			}
		});
		f.add(title);
		f.add(name1);
		f.add(value1);
		f.add(str2);
		f.add(str3);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		if(str2.getText().equals("admin")&&str3.getText().equals("admin"))
		{
			First.f.setVisible(true);
			f.setVisible(false);
		}
		else
			JOptionPane.showMessageDialog(null, "用户名或密码错误！","管理员登录",JOptionPane.PLAIN_MESSAGE);
	}
		
}
