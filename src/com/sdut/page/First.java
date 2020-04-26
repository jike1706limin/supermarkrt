package com.sdut.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class First {
	public static Frame f;
	Font fo = new Font("����",Font.PLAIN,16);//�������壨���ͣ�����ֺţ�
//    Font.PLAIN����ͨ��
//    Font.BOLD���Ӵ֣�
//    Font.ITALIC��б�壩
//    Font.BOLD+ Font.ITALIC����б�壩
	public First()
	{
		f = new Frame("���н�����ϵͳ",550,600);
		f.setForeground(Color.PINK);//�������ֵ���ɫ
		init();
		f.setVisible(false);
		
	}
	public JButton setButton(String title)
	{
		JButton a = new JButton(title);
		a.setFont(fo);
		return a;
	}
	public void init()
	{
		JButton add = setButton("�ϼ���Ʒ");
		JButton del = setButton("�¼���Ʒ");
		JButton change = setButton("�޸���Ϣ");
		JButton find = setButton("��Ʒ��ѯ");
		JButton show = setButton("����������Ʒ");
		JButton truncate = setButton("�������");
		JButton controllsale = setButton("����������Ա");
		JButton select = setButton("����ѯ");
		JButton end = f.end();
		add.setBounds(50, 40, 150, 75);//����λ�á���С
		del.setBounds(300, 40, 150, 75);
		change.setBounds(50, 165, 150, 75);
		find.setBounds(300, 165, 150, 75);
		show.setBounds(50, 290, 150, 75);
		truncate.setBounds(300, 290, 150, 75);
		select.setBounds(300, 415, 150, 75);
		controllsale.setBounds(50, 415, 150, 75);
		end.setBounds(170, 500, 150, 75);
		end.setFont(fo);
		//��Ӵ��ڰ�ť�ĵ����¼�
		add.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Add.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//ɾ�����ڰ�ť�ĵ����¼�
		del.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Del.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//�޸Ĵ��ڰ�ť�ĵ����¼�
		change.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Change.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//��ʾ���д��ڰ�ť�ĵ����¼�
		show.addActionListener(new ActionListener()
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
		//��ѯ���ڰ�ť�ĵ����¼�
		find.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//������ݴ��ڰ�ť�ĵ����¼�
		truncate.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ѡ��򣬷���ֵΪ0��1��
				int a = JOptionPane.showConfirmDialog(null, "�ò����޷������Ƿ������", "��ʾ",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					int b = JOptionPane.showConfirmDialog(null, "���ٴ�ȷ��", "��ʾ",JOptionPane.YES_NO_OPTION);
					if(b==0)
					{
						try {
							f.mo.Truncate();
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "������","�������",JOptionPane.PLAIN_MESSAGE);  
					}
				}
			}
			
		});
		controllsale.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Saleopreation.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		select.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find_3.f.setVisible(true);
				f.setVisible(false);
			}
			
		});

		f.add(add);
		f.add(del);
		f.add(change);
		f.add(find);
		f.add(show);
		f.add(truncate);
		f.add(controllsale);
		f.add(select);
		f.add(end);
	}
}
