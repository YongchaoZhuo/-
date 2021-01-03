package User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu extends JFrame{
	static int size = 3;
	static JButton bt[] =new JButton[size]; 
	
	private static void firtPage(final JFrame jf){
		//1.设置窗体大小和标题
		jf.setPreferredSize(new Dimension(700, 600));
		//2.设置关闭窗口就是关闭程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局管理器
		GridLayout glo=new GridLayout(10, 1);
		jf.setLocation(200, 200);
		jf.setLayout(glo);
		//设置定位
		JPanel jp=new JPanel();
		jp.setBackground(Color.decode("#375a7f"));
		jf.add(jp);
		JLabel jl=new JLabel("图书管理系统",JLabel.CENTER);
		jl.setFont(new Font("楷体", Font.BOLD, 24));
		jl.setForeground(Color.white);
	
		jp.add(jl);
		//菜单栏
		//新建一个面板div
		JPanel jp1=new JPanel();
		jf.add(jp1);
		//新建一个菜单条
		
		JMenuBar jb=new JMenuBar();
		jb.setPreferredSize(new Dimension(700, 30));
		jb.setBackground(Color.decode("#65991a"));
		jf.setJMenuBar(jb);
		jp1.add(jb);
		//新建一个菜单选项
		JMenu jmenu=new JMenu("选项");
		jmenu.setEnabled(false);
		jmenu.setForeground(Color.white);
		jmenu.setPreferredSize(new Dimension(300, 30));
		final JMenuItem addbook=new JMenuItem("添加图书信息");
		final JMenuItem delbook=new JMenuItem("删除图书信息");
		JMenuItem chabook=new JMenuItem("修改图书信息");
		JMenuItem seabook=new JMenuItem("查找图书信息");
		JMenuItem showall=new JMenuItem("查看所有图书");
		
		addbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addbook_KJ a = new addbook_KJ();
				jf.setDefaultCloseOperation(2);
				jf.dispose();
			}
		});
		delbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delbook_KJ a = new delbook_KJ();	
				jf.setDefaultCloseOperation(2);
				jf.dispose();
						
			}			
			
		});
		jmenu.add(addbook);
		jmenu.add(delbook);
		jmenu.add(chabook);
		jmenu.add(seabook);
		jmenu.add(showall);
		jb.add(jmenu);
		//新建一个菜单项
		//新建一个菜单选项
		JMenu jmenu1=new JMenu("关于我们");
		jmenu1.setForeground(Color.white);
		jmenu1.setPreferredSize(new Dimension(200, 30));
		
		jb.add(jmenu1);
		//新建一个菜单项
		JMenuItem jm1=new JMenuItem("关于我们");
jm1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				About a = new About();
			}
		});
		jmenu1.add(jm1);

		JMenu changeuser=new JMenu("修改账户信息");
		changeuser.setForeground(Color.white);
		changeuser.setPreferredSize(new Dimension(200, 30));
		
		jb.add(jmenu1);
		//新建一个菜单项
		JMenuItem deluser=new JMenuItem("注销");
		changeuser.add(deluser);
	deluser.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			denglu l = new denglu();
			jf.setVisible(false);
		}
	});
		jb.add(changeuser);
		jf.pack();
		
		
		
		
		bt[0] = new JButton("注册");
		bt[1] = new JButton("登录");
		bt[2] = new JButton("管理员");
		
		for(int i=0;i<3;i++){
			bt[i].setBorder(BorderFactory.createRaisedBevelBorder());
			bt[i].setFont(new java.awt.Font("楷体", 1, 16));
			bt[i].setBackground(Color.white);
		}
		bt[1].setBounds(10, 150, 60, 50);
		bt[2].setBounds(330, 150, 60, 50);
		bt[0].setBounds(170, 150, 60, 50);
		 jf.setLayout(null);
		 for(int i=0;i<size;i++)
			 jf.add(bt[i]);
		 jf.setTitle("图书管理系统");
		 jf.setSize(600, 600);
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setLocation(100, 100);
		 jf.setVisible(true);
	        
	     bt[0].addActionListener(new ActionListener() {
				//注册页面设置
				public void actionPerformed(ActionEvent e) {
					reg r = new reg();	
				}
			});
	        
	        bt[1].addActionListener(new ActionListener() {
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					denglu l = new denglu();
					jf.setVisible(false);
				}
			});
	        bt[2].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("管理员页面");
					
				}
			});
	}
		
		
	
	public static void main(String[] args) {
		final JFrame jf=new JFrame("图书管理系统");
		firtPage(jf);
	}

//	public static void main(String[] args) {
//		//menu m= new menu();		
//	}
	
	public menu(){
//		 for (int i = 0; i < size; i++) {
//	            bt[i] = new JButton(String.valueOf(i));
//	        }
		
}
}
