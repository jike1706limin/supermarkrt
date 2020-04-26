package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Change2 {
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	JLabel id1,title;
	static String id;
	JButton end,jb1,jb2;
	final JTextField str1 = new JTextField();
	public Change2()
	{
		f = new Frame("售出商品",600,300);
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
				str1.setText("");
			}
		});
		
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("请输入更改的商品编号",JLabel.CENTER);
		id1 = new JLabel("编号:",JLabel.LEFT);
		//双引号中为标签中显示的内容，后面为对齐方式
		title.setFont(fo);
		id1.setFont(fo2);
		str1.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		id1.setBounds(200,100,50,50);
		str1.setBounds(250, 100, 150, 50);
		jb1 = new JButton("返回菜单");
		jb2 = new JButton("确认");
		end.setBounds(450, 180, 100, 50);
		jb1.setBounds(250, 180, 100, 50);
		jb2.setBounds(50, 180, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Customer.f.setVisible(true);
				f.setVisible(false);
				str1.setText("");
			}
		});
		f.add(title);
		f.add(id1);
		f.add(str1);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		id = str1.getText();
		//接收输入的编号
		if(id.equals(""))
			return;
		if(!f.mo.judge(id))
		{
			JOptionPane.showMessageDialog(null, "编号不存在！","修改信息",JOptionPane.PLAIN_MESSAGE);
		}
		else
		{
			Change_3.f.setVisible(true);
			f.setVisible(false);
		}
	}//商品编号的判断
}
