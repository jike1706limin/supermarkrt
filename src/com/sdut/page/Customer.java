package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Customer{
	static Frame f;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	JLabel title;
	JButton end,jb1,jb2,jb3,jb4;
	public Customer()
	{
		f = new Frame("��ӭʹ��",400,400);
		init();
		f.setVisible(false);
		
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("��ӭʹ�ó��н�����ϵͳ",JLabel.CENTER);
		title.setFont(fo);
		title.setBounds(0, 20, 400, 50);
		jb1 = new JButton("��Ʒ��ѯ");
		jb2 = new JButton("��ʾ������Ʒ");
		jb3 = new JButton("�۳���Ʒ");
		jb4 = new JButton("��Ʒ�˻�");
		end.setBounds(150, 300, 100, 75);
		jb1.setBounds(30, 80, 150, 75);
		jb2.setBounds(200, 80, 150, 75);
		jb3.setBounds(30, 200, 150, 75);
		jb4.setBounds(200, 200, 150, 75);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb3.setFont(fo3);
		jb4.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find.f.setVisible(true);
				f.setVisible(false);
			}
		});
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new show(f.mo.AllBook());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jb3.addActionListener(new ActionListener()
		{//�۳���Ʒ

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Change2.f.setVisible(true);
				f.setVisible(false);
			}
		});
		jb4.addActionListener(new ActionListener()
		{//�۳���Ʒ

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Change3.f1.setVisible(true);
				f.setVisible(false);
			}
		});
		f.add(title);
		f.add(end);
		f.add(jb4);
		f.add(jb3);
		f.add(jb2);
		f.add(jb1);
	}
}
