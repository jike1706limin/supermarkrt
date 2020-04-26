package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Find{
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	JLabel title;
	JButton end,jb1,jb2,jb3,jb4;
	public Find()
	{
		f = new Frame("查询商品",300,300);
		init();
		f.setVisible(false);
		
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("选择查询方式",JLabel.CENTER);
		title.setFont(fo);
		title.setBounds(0, 20, 300, 50);
		jb1 = new JButton("返回菜单");
		jb2 = new JButton("编号查询");
		jb3 = new JButton("其他方式");
		jb4 = new JButton("库存查询");
		jb4.setBounds(160, 160, 100, 50);
		jb1.setBounds(30, 160, 100, 50);
		jb2.setBounds(30, 80, 100, 50);
		jb3.setBounds(160, 80, 100, 50);
		end.setBounds(100, 220, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb3.setFont(fo3);
		jb4.setFont(fo3);
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
			}
		});
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find_1.f.setVisible(true);
				f.setVisible(false);
			}
		});
		jb3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find_2.f.setVisible(true);
				f.setVisible(false);
			}
		});
		jb4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find_4.f.setVisible(true);
				f.setVisible(false);
			}
		});
		f.add(title);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
		f.add(jb3);
		f.add(jb4);
	}
}
