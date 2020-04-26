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

import com.sdut.opreation.Sale;
public class show1 {
	static Frame f;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	JLabel title;
	JButton end,jb1;
	Object[][] data;
	String[] sn = {"���","����","�Ա�","סַ"};
	final JTextField str1 = new JTextField();
	public show1(List<Sale> list)
	{
		f = new Frame("��ʾ����Ա��Ϣ",600,600);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//����ֻ�رյ�ǰ����
		init1(list);
		f.setVisible(true);
		JOptionPane.showMessageDialog(null, "����"+list.size()+"����Ϣ","��ʾ����Ա��Ϣ",JOptionPane.PLAIN_MESSAGE);
	}
	void init1(List<Sale> list)
	{
		jb1 = new JButton("����");
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
			Sale sale= list.get(i);
			data[i] = new Object[]{sale.getId(),sale.getName(),sale.getGender(),sale.getAddress()};
		}
		JTable table=new JTable(data,sn);
		table.setFont(fo3);
		JScrollPane jsp= new JScrollPane(table);
//		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//��������������ʾ
		jsp.setBounds(0, 0, 600, 450);
		f.add(jsp);
		f.add(end);
		f.add(jb1);
	}
}