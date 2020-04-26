package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sdut.opreation.Sale;

public class SaleAdd {
	static Frame f;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	JLabel id1,name1,value1,number1,title;
	JButton end,jb1,jb2;
	final JTextField str1 = new JTextField();
	final JTextField str2 = new JTextField();
	final JTextField str3 = new JTextField();
	final JTextField str4 = new JTextField();
	public SaleAdd()
	{
		f = new Frame("���������Ա",600,600);
		f.setSize(600, 600);     //���ô��ڵĴ�С
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
				str2.setText("");
				str3.setText("");
				str4.setText("");
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("����������Ա��Ϣ",JLabel.CENTER);
		id1 = new JLabel("���:",JLabel.LEFT);
		name1 = new JLabel("����:",JLabel.LEFT);
		value1 = new JLabel("�Ա�:",JLabel.LEFT);
		number1 = new JLabel("סַ:",JLabel.LEFT);
		title.setFont(fo);
		id1.setFont(fo2);
		name1.setFont(fo2);
		value1.setFont(fo2);
		number1.setFont(fo2);
		str1.setFont(fo2);
		str2.setFont(fo2);
		str3.setFont(fo2);
		str4.setFont(fo2);
		title.setBounds(200, 20, 250, 50);
		id1.setBounds(200,100,50,50);
		name1.setBounds(200,200,50,50);
		value1.setBounds(200,300,50,50);
		number1.setBounds(200,400,50,50);
		str1.setBounds(250, 100, 150, 50);
		str2.setBounds(250, 200, 150, 50);
		str3.setBounds(250, 300, 150, 50);
		str4.setBounds(250, 400, 150, 50);
		jb1 = new JButton("���ز˵�");
		jb2 = new JButton("ȷ�����");
		end.setBounds(450, 480, 100, 50);
		jb1.setBounds(250, 480, 100, 50);
		jb2.setBounds(50, 480, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				First.f.setVisible(true);
				f.setVisible(false);
				str1.setText("");
				str2.setText("");
				str3.setText("");
				str4.setText("");
			}
		});
		f.add(title);
		f.add(id1);
		f.add(name1);
		f.add(value1);
		f.add(number1);
		f.add(str1);
		f.add(str2);
		f.add(str3);
		f.add(str4);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		String id,name,gender,address;
		if(str1.getText().equals("")||str2.getText().equals("")||str3.getText().equals("")||str4.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "��������ȷ��Ϣ", "��Ϣ����",JOptionPane.ERROR_MESSAGE);//�������Ϣ��
			return;
		}
		id = str1.getText();
		name = str2.getText();
		gender = str3.getText();
		address = str4.getText();
		if(f.mo.salejudge(id))
		{
			JOptionPane.showMessageDialog(null, "��ȷ�ϱ��Ψһ��", "����ظ�",JOptionPane.ERROR_MESSAGE);//�������Ϣ��
			return;
		}
		Sale sale = new Sale(id,name,gender,address);
		f.mo.addSales(sale);
		JOptionPane.showMessageDialog(null, "��ӳɹ���","�������Ա",JOptionPane.PLAIN_MESSAGE); //��ͨ����Ϣ�� 
		Saleopreation.f.setVisible(true);
		f.setVisible(false);
	}
}
