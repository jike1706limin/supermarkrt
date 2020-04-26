package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sdut.opreation.Book;
public class show {
	static Frame f;
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	JLabel title;
	JButton end,jb1;
	Object[][] data;
	String[] tn = {"编号","名称","类别","价格","库存"};
	final JTextField str1 = new JTextField();
	public show(List<Book> list)
	{
		f = new Frame("显示商品信息",600,600);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置只关闭当前窗口
		init(list);
		f.setVisible(true);
		JOptionPane.showMessageDialog(null, "共有"+list.size()+"条信息","显示商品信息",JOptionPane.PLAIN_MESSAGE);
	}
	void init(List<Book> list)
	{
		jb1 = new JButton("返回");
		end = f.end();
		end.setBounds(450, 480, 100, 50);
		jb1.setBounds(50, 480, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
			}
		});
		data = new Object[list.size()][4];
		for(int i = 0;i<list.size();i++)
		{
			Book book = list.get(i);
			data[i] = new Object[]{book.getId(),book.getName(),book.getNature(),book.getValue(),book.getNum()};
		}
		JTable table=new JTable(data,tn);
		table.setFont(fo3);
		JScrollPane jsp= new JScrollPane(table);
//		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//滚动条，总是显示
		jsp.setBounds(0, 0, 600, 450);
		f.add(jsp);
		f.add(end);
		f.add(jb1);
	}
}