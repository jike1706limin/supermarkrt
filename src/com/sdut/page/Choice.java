package com.sdut.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Choice{
	static Frame f;
	static int flag;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	JLabel title;
	JButton end,jb1,jb2;
	public Choice()
	{
		f = new Frame("��ҳ",300,300);
		init();
		f.setVisible(true);
		
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("��ѡ��ʹ����",JLabel.CENTER);
		title.setFont(fo);
		title.setBounds(0, 20, 300, 50);
		title.setForeground(Color.BLUE);//�������ֵ���ɫ
		jb1 = new JButton("����Ա");
		jb2 = new JButton("����Ա");
		end.setBounds(100, 180, 100, 50);
		jb1.setBounds(160, 80, 100, 50);
		jb2.setBounds(30, 80, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controllogin.f.setVisible(true);
				f.setVisible(false);
				flag= 1;
			}
		});
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Customer.f.setVisible(true);
				f.setVisible(false);
				flag = 2;
			}
		});
		f.add(title);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
}
