package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Change_3 {
	static Frame f;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	//�������壨���ͣ�����ֺţ�
//  Font.PLAIN����ͨ��
//  Font.BOLD���Ӵ֣�
	JLabel name1,value1,number1,title;
	JButton end,jb1,jb2;
	final JTextField str2 = new JTextField();
	//final JTextField str3 = new JTextField();
	//final JTextField str4 = new JTextField();
	public Change_3()
	{
		f = new Frame("�۳���Ʒ",600,600);
		f.setSize(600, 300);     //���ô��ڵĴ�С
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
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("�������۳���Ʒ������",JLabel.CENTER);
		//number1 = new JLabel("�۳�����:",JLabel.LEFT);
		title.setFont(fo);
		//number1.setFont(fo2);
		str2.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		//number1.setBounds(200,300,50,50);
		str2.setBounds(250, 100, 150, 50);
		jb1 = new JButton("���ز˵�");
		jb2 = new JButton("ȷ��");
		end.setBounds(450, 200, 100, 50);
		jb1.setBounds(250, 200, 100, 50);
		jb2.setBounds(50, 200, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Customer.f.setVisible(true);
				f.setVisible(false);
				str2.setText("");
			}
		});
		f.add(title);
		//f.add(number1);
		f.add(str2);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		long number;
		if(str2.getText().equals(""))
			return;
		String str;
		str = str2.getText();
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
			{
				JOptionPane.showMessageDialog(null, "��������ȷ��Ϣ", "��Ϣ����",JOptionPane.ERROR_MESSAGE);//�������Ϣ��
				return;
			}
		
		if(!str2.getText().equals(""))
		{
			number = Long.parseLong(str2.getText());
			if(number==0)
				JOptionPane.showMessageDialog(null, "�������������", "��Ϣ����",JOptionPane.ERROR_MESSAGE);//�������Ϣ��
			else {
			if(f.mo.judgenum(Change2.id, number))
			{
			f.mo.update(Change2.id, number,2);
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�","�޸���Ʒ��Ϣ",JOptionPane.PLAIN_MESSAGE);
			Customer.f.setVisible(true);
			f.setVisible(false);
			}
			else
			JOptionPane.showMessageDialog(null, "��治�㣬�޷��޸�", "��Ϣ����",JOptionPane.ERROR_MESSAGE);//�������Ϣ��
			}
		}
		
	}
}
