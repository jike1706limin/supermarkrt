package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Saleopreation{
	static Frame f;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	JLabel title;
	JButton end,jb1,jb2,jb3,jb4;
	public Saleopreation()
	{
		f = new Frame("����Ա����",400,350);
		init();
		f.setVisible(false);
		
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("��������Ա",JLabel.CENTER);
		title.setFont(fo);
		title.setBounds(0, 20, 300, 50);
		jb1 = new JButton("���ز˵�");
		jb2 = new JButton("�鿴��������Ա");
		jb3 = new JButton("ɾ��������Ա");
		jb4 = new JButton("���������Ա");
		end.setBounds(150, 250, 100, 50);
		jb1.setBounds(30, 160, 150, 75);
		jb2.setBounds(30, 80, 150, 75);
		jb3.setBounds(200, 80, 150, 75);
		jb4.setBounds(200, 160, 150, 75);
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
					First.f.setVisible(true);//�ص�����Ա�˵�
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
				try {
					new show1(f.mo.AllSale());//��ʾ��������Ա
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		jb3.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SaleDel.f.setVisible(true);//��ʾɾ��ҳ��
				f.setVisible(false);//����ʾ��������Աҳ��
			}
			
		});
		jb4.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SaleAdd.f.setVisible(true);//��ʾ������Ϣҳ��
				f.setVisible(false);//����ʾ��������Աҳ��
			}
			
		});
		f.add(title);
		f.add(end);
		f.add(jb4);
		f.add(jb2);
		f.add(jb1);
		f.add(jb3);
	}
}
