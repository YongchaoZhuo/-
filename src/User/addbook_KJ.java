package User;
import fileRead.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class addbook_KJ {

	static int KJ_count=0;
	
	private static void firtPage(final JFrame jf){
		
		jf.setPreferredSize(new Dimension(700, 600));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout glo=new GridLayout(10, 1);
		jf.setLocation(100, 100);
		jf.setLayout(glo);
		JPanel jp=new JPanel();
		jp.setBackground(Color.decode("#375a7f"));
		jf.add(jp);
		JLabel jl=new JLabel("ͼ�����ϵͳ",JLabel.CENTER);
		jl.setFont(new Font("����", Font.BOLD, 24));
		jl.setForeground(Color.white);
	
		jp.add(jl);
		JPanel jp1=new JPanel();
		jf.add(jp1);
		
		
		JMenuBar jb=new JMenuBar();
		jb.setPreferredSize(new Dimension(680, 30));
		jb.setBackground(Color.decode("#65991a"));
		jf.setJMenuBar(jb);
		jp1.add(jb);
		JMenu jmenu=new JMenu("ѡ��");
		jmenu.setForeground(Color.white);
		jmenu.setPreferredSize(new Dimension(200, 30));
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
		seabook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seachbook_KJ a = new seachbook_KJ();	
				jf.setDefaultCloseOperation(2);
				jf.dispose();		
			}			
			
		});
		chabook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changebook_KJ a = new changebook_KJ();	
				jf.setDefaultCloseOperation(2);
				jf.dispose();		
			}			
			
		});
		showall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text a = new text();
				a.main(null);
//				jf.setDefaultCloseOperation(2);
//				jf.dispose();		
			}			
		});
		jmenu.add(addbook);
		jmenu.add(delbook);
		jmenu.add(chabook);
		jmenu.add(seabook);
		jmenu.add(showall);
		jb.add(jmenu);
		JMenu jmenu1=new JMenu("��������");
		jmenu1.setForeground(Color.white);
		jmenu1.setPreferredSize(new Dimension(200, 30));
		
		jb.add(jmenu1);
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
		
		jf.setVisible(true);
	}
	
	public addbook_KJ() {
		
		final JFrame jf=new JFrame("ͼ�����ϵͳ");
		firtPage(jf);
		JLabel name_label, num_label,author_label,price_label,state_label,msg;
		final JTextField name_txt;
		final JTextField num_txt;
		final JTextField author_txt;
		final JTextField price_txt;
		final JTextField state_txt;
		JButton add_button,close_button;
		JPanel jp1, jp2, jp3,jp4,jp5,jp6;
		
		
		jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
		
		name_label = new JLabel("ͼ������:");
		num_label = new JLabel("ͼ�����:");
		author_label = new JLabel("ͼ������:");
		price_label = new JLabel("ͼ��۸�:");
		  state_label = new JLabel("�Ƿ���");
		
		add_button = new JButton("���");
		
		close_button = new JButton("ȡ��");
		
		Font f = new Font("����", Font.BOLD, 18);
		name_label.setFont(f);
		num_label.setFont(f);
		author_label.setFont(f);
		price_label.setFont(f);
		state_label.setFont(f);

		name_txt = new JTextField(30);
		author_txt = new JTextField(30);
		num_txt = new JTextField(30);
		price_txt = new JTextField(30);
		state_txt = new JTextField(30);

		jp1.add(name_label);
		jp1.add(name_txt);
		jp2.add(num_label);
		jp2.add(num_txt);
		jp3.add(author_label);
		jp3.add(author_txt);
		jp4.add(price_label);
		jp4.add(price_txt);
		jp5.add(state_label);
		jp5.add(state_txt);
		jp6.add(add_button);
		jp6.add(close_button);
		
		
		
		jf.add(jp1);
		jf.add(jp2);
		jf.add(jp3);
		jf.add(jp4);
		jf.add(jp5);
		jf.add(jp6);
		
		KJ_count++;
		jf.setVisible(true);
		
add_button.addActionListener(new ActionListener() {
			
			@Override
			//ʵ�ֹ���
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Book b = new Book(name_txt.getText(),num_txt.getText(),author_txt.getText(),price_txt.getText(),state_txt.getText());
					BookDeal bd = new BookDeal();
					bd.addBook(b);
					name_txt.setText(null);
					num_txt.setText(null);
					author_txt.setText(null);
					price_txt.setText(null);
					state_txt.setText(null);
					mymsg m = new mymsg("��ӳɹ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}

}

