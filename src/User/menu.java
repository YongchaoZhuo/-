package User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu extends JFrame{
	static int size = 3;
	static JButton bt[] =new JButton[size]; 
	
	private static void firtPage(final JFrame jf){
		//1.���ô����С�ͱ���
		jf.setPreferredSize(new Dimension(700, 600));
		//2.���ùرմ��ھ��ǹرճ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ò��ֹ�����
		GridLayout glo=new GridLayout(10, 1);
		jf.setLocation(200, 200);
		jf.setLayout(glo);
		//���ö�λ
		JPanel jp=new JPanel();
		jp.setBackground(Color.decode("#375a7f"));
		jf.add(jp);
		JLabel jl=new JLabel("ͼ�����ϵͳ",JLabel.CENTER);
		jl.setFont(new Font("����", Font.BOLD, 24));
		jl.setForeground(Color.white);
	
		jp.add(jl);
		//�˵���
		//�½�һ�����div
		JPanel jp1=new JPanel();
		jf.add(jp1);
		//�½�һ���˵���
		
		JMenuBar jb=new JMenuBar();
		jb.setPreferredSize(new Dimension(700, 30));
		jb.setBackground(Color.decode("#65991a"));
		jf.setJMenuBar(jb);
		jp1.add(jb);
		//�½�һ���˵�ѡ��
		JMenu jmenu=new JMenu("ѡ��");
		jmenu.setEnabled(false);
		jmenu.setForeground(Color.white);
		jmenu.setPreferredSize(new Dimension(300, 30));
		final JMenuItem addbook=new JMenuItem("���ͼ����Ϣ");
		final JMenuItem delbook=new JMenuItem("ɾ��ͼ����Ϣ");
		JMenuItem chabook=new JMenuItem("�޸�ͼ����Ϣ");
		JMenuItem seabook=new JMenuItem("����ͼ����Ϣ");
		JMenuItem showall=new JMenuItem("�鿴����ͼ��");
		
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
		//�½�һ���˵���
		//�½�һ���˵�ѡ��
		JMenu jmenu1=new JMenu("��������");
		jmenu1.setForeground(Color.white);
		jmenu1.setPreferredSize(new Dimension(200, 30));
		
		jb.add(jmenu1);
		//�½�һ���˵���
		JMenuItem jm1=new JMenuItem("��������");
jm1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				About a = new About();
			}
		});
		jmenu1.add(jm1);

		JMenu changeuser=new JMenu("�޸��˻���Ϣ");
		changeuser.setForeground(Color.white);
		changeuser.setPreferredSize(new Dimension(200, 30));
		
		jb.add(jmenu1);
		//�½�һ���˵���
		JMenuItem deluser=new JMenuItem("ע��");
		changeuser.add(deluser);
	deluser.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			denglu l = new denglu();
			jf.setVisible(false);
		}
	});
		jb.add(changeuser);
		jf.pack();
		
		
		
		
		bt[0] = new JButton("ע��");
		bt[1] = new JButton("��¼");
		bt[2] = new JButton("����Ա");
		
		for(int i=0;i<3;i++){
			bt[i].setBorder(BorderFactory.createRaisedBevelBorder());
			bt[i].setFont(new java.awt.Font("����", 1, 16));
			bt[i].setBackground(Color.white);
		}
		bt[1].setBounds(10, 150, 60, 50);
		bt[2].setBounds(330, 150, 60, 50);
		bt[0].setBounds(170, 150, 60, 50);
		 jf.setLayout(null);
		 for(int i=0;i<size;i++)
			 jf.add(bt[i]);
		 jf.setTitle("ͼ�����ϵͳ");
		 jf.setSize(600, 600);
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jf.setLocation(100, 100);
		 jf.setVisible(true);
	        
	     bt[0].addActionListener(new ActionListener() {
				//ע��ҳ������
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
					System.out.println("����Աҳ��");
					
				}
			});
	}
		
		
	
	public static void main(String[] args) {
		final JFrame jf=new JFrame("ͼ�����ϵͳ");
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
