package com.sdut.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sdut.dao.MenuOpreation;
//extendsΪ�̳и���
public class Frame	extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MenuOpreation mo = new MenuOpreation();
	public Frame(String title,int w,int h)
	{
		super(title);   //���ñ���
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //�����ܹرմ���
        this.setSize(w, h);     //���ô��ڵĴ�С
        this.setLayout(null);       //���ó���Ĭ�ϲ��ָ�ʽΪ�գ��Ա��ں����Լ��򵥵����ò���
        this.setResizable(false);   //���ò�������
//        this.setVisible(true);      //ʹ����ɼ�
        this.setLocationRelativeTo(null);//���ھ�����ʾ
	}
	public JButton end()
	{
		JButton e = new JButton("��������");
		e.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			//��ť�����»����
		});
		return e;
	}
	public JButton last()
	{
		JButton e = new JButton("���ز˵�");
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
