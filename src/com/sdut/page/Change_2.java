package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Change_2 {
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	//定义字体（类型，风格，字号）
//  Font.PLAIN（普通）
//  Font.BOLD（加粗）
	JLabel name1,nature1,value1,number1,title,ps;
	JButton end,jb1,jb2;
	final JTextField str2 = new JTextField();
	final JTextField str3 = new JTextField();
	final JTextField str4 = new JTextField();
	final JTextField str5 = new JTextField();
	public Change_2()
	{
		f = new Frame("修改商品信息",600,600);
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
				str5.setText("");
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("请输入修改商品的信息",JLabel.CENTER);
		ps = new JLabel("（不需要修改的请不要填写）",JLabel.RIGHT);
		name1 = new JLabel("名字:",JLabel.LEFT);
		nature1 = new JLabel("类别:",JLabel.LEFT);
		value1 = new JLabel("价格:",JLabel.LEFT);
		number1 = new JLabel("库存:",JLabel.LEFT);
		title.setFont(fo);
		ps.setFont(fo3);
		name1.setFont(fo2);
		nature1.setFont(fo2);
		value1.setFont(fo2);
		number1.setFont(fo2);
		str2.setFont(fo2);
		str3.setFont(fo2);
		str4.setFont(fo2);
		str5.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		ps.setBounds(100, 50, 400, 50);
		name1.setBounds(200,100,50,50);
		nature1.setBounds(200,170,50,50);
		value1.setBounds(200,240,50,50);
		number1.setBounds(200,310,50,50);
		str2.setBounds(250, 100, 150, 50);
		str3.setBounds(250, 170, 150, 50);
		str4.setBounds(250, 240, 150, 50);
		str5.setBounds(250, 310, 150, 50);
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
				First.f.setVisible(true);
				f.setVisible(false);
				str2.setText("");
				str3.setText("");
				str4.setText("");
				str5.setText("");
			}
		});
		f.add(title);
		f.add(ps);
		f.add(name1);
		f.add(nature1);
		f.add(value1);
		f.add(number1);
		f.add(str2);
		f.add(str3);
		f.add(str4);
		f.add(str5);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		String name,nature;
		double value;
		long number;
		if(str2.getText().equals("")&&str3.getText().equals("")&&str4.getText().equals("")&&str5.getText().equals(""))
			return;
		String str;
		str = str4.getText();
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
			{
				JOptionPane.showMessageDialog(null, "请输入正确信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
				return;
			}
		str = str5.getText();
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
			{
				JOptionPane.showMessageDialog(null, "请输入正确信息", "信息错误",JOptionPane.ERROR_MESSAGE);//报错的消息框
				return;
			}
		if(!str2.getText().equals(""))
		{
			name = str2.getText();
			f.mo.update(Change.id, name);
		}
		if(!str3.getText().equals(""))
		{
			nature = str3.getText();
			f.mo.update1(Change.id, nature);
		}
		if(!str4.getText().equals(""))
		{
			value = Double.parseDouble(str4.getText());
			f.mo.update(Change.id, value);
		}
		if(!str5.getText().equals(""))
		{
			number = Long.parseLong(str4.getText());
			f.mo.update(Change.id, number,1);
		}
		JOptionPane.showMessageDialog(null, "修改成功","修改商品信息",JOptionPane.PLAIN_MESSAGE);
		First.f.setVisible(true);
		f.setVisible(false);
	}
}
