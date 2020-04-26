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
	Font fo = new Font("宋体",Font.PLAIN,16);//定义字体（类型，风格，字号）
//    Font.PLAIN（普通）
//    Font.BOLD（加粗）
//    Font.ITALIC（斜体）
//    Font.BOLD+ Font.ITALIC（粗斜体）
	public First()
	{
		f = new Frame("超市进销存系统",550,600);
		f.setForeground(Color.PINK);//设置文字的颜色
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
		JButton add = setButton("上架商品");
		JButton del = setButton("下架商品");
		JButton change = setButton("修改信息");
		JButton find = setButton("商品查询");
		JButton show = setButton("阅览所有商品");
		JButton truncate = setButton("清空数据");
		JButton controllsale = setButton("管理销售人员");
		JButton select = setButton("库存查询");
		JButton end = f.end();
		add.setBounds(50, 40, 150, 75);//设置位置、大小
		del.setBounds(300, 40, 150, 75);
		change.setBounds(50, 165, 150, 75);
		find.setBounds(300, 165, 150, 75);
		show.setBounds(50, 290, 150, 75);
		truncate.setBounds(300, 290, 150, 75);
		select.setBounds(300, 415, 150, 75);
		controllsale.setBounds(50, 415, 150, 75);
		end.setBounds(170, 500, 150, 75);
		end.setFont(fo);
		//添加窗口按钮的单击事件
		add.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Add.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//删除窗口按钮的单击事件
		del.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Del.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//修改窗口按钮的单击事件
		change.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Change.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//显示所有窗口按钮的单击事件
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
		//查询窗口按钮的单击事件
		find.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Find.f.setVisible(true);
				f.setVisible(false);
			}
			
		});
		//清空数据窗口按钮的单击事件
		truncate.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//选择框，返回值为0或1；
				int a = JOptionPane.showConfirmDialog(null, "该操作无法撤回是否继续？", "提示",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					int b = JOptionPane.showConfirmDialog(null, "请再次确认", "提示",JOptionPane.YES_NO_OPTION);
					if(b==0)
					{
						try {
							f.mo.Truncate();
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "清除完毕","清除数据",JOptionPane.PLAIN_MESSAGE);  
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
