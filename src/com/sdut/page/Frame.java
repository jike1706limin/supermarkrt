package com.sdut.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sdut.dao.MenuOpreation;
//extends为继承父类
public class Frame	extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuOpreation mo = new MenuOpreation();
	public Frame(String title,int w,int h)
	{
		super(title);   //设置标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置能关闭窗口
        this.setSize(w, h);     //设置窗口的大小
        this.setLayout(null);       //设置程序默认布局格式为空，以便于后期自己简单的设置布局
        this.setResizable(false);   //设置不可缩放
//        this.setVisible(true);      //使程序可见
        this.setLocationRelativeTo(null);//窗口居中显示
	}
	public JButton end()
	{
		JButton e = new JButton("结束程序");
		e.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			//按钮被按下会调用
		});
		return e;
	}
	public JButton last()
	{
		JButton e = new JButton("返回菜单");
		e.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				First.f.setVisible(true);
				
			}
			
		});
		return e;
	}
	
}
