package User;
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
import javax.xml.soap.Text;

import fileRead.Book;
import fileRead.BookDeal;
import fileRead.delnull;
import fileRead.fileChange;


public class changebook_KJ {

	static int KJ_count=0;
	String str=null;
	private static void firtPage(final JFrame jf){
		//1.���ô����С�ͱ���
		try {
			delnull dn = new delnull();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jf.setPreferredSize(new Dimension(700, 600));
		//2.���ùرմ��ھ��ǹرճ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ò��ֹ�����
		GridLayout glo=new GridLayout(14, 1);
		jf.setLocation(100, 100);
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
		jb.setPreferredSize(new Dimension(680, 30));
		jb.setBackground(Color.decode("#65991a"));
		jf.setJMenuBar(jb);
		jp1.add(jb);
		//�½�һ���˵�ѡ��
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
		
		//***
		//�û��޸�
		//**//
		//3.���ô���ɼ�
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
		jf.setVisible(true);
	}
	public changebook_KJ() {
		
		final JFrame jf=new JFrame("ͼ�����ϵͳ");
		firtPage(jf);
		JLabel name_label;
		final JLabel msg;
		final JTextField name_txt;
		JButton sea_button,close_button;
		JPanel jp1, jp5,jp6;
		
		
		jp1 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();

		
		name_label = new JLabel("ͼ������:");
		msg = new JLabel();
		msg.setFont(new Font("����", Font.BOLD, 30));
		
		sea_button = new JButton("����");
		close_button = new JButton("ȡ��");
		
		Font f = new Font("����", Font.BOLD, 18);
		name_label.setFont(f);
		
		
		
		name_txt = new JTextField(30);
		
		
		jp1.add(name_label);
		jp1.add(name_txt);
		
		jp5.add(sea_button);
		jp5.add(close_button);
		
		jp6.add(msg);
		
		
		jf.add(jp1);
		jf.add(jp5);
		jf.add(jp6);
		
		KJ_count++;
		jf.setVisible(true);
		
		sea_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					fileChange f = new fileChange();
					str = f.seach(name_txt.getText(), 1);
					settxt(str, jf);					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					mymsg m= new mymsg("���޴���");
				}
				
			}
		});
	}
	
	public void settxt(final String str,JFrame jf){
		String s[] = str.split(",");
		JLabel name_label, num_label,author_label,price_label,state_label,msg;
		final JTextField name_txt = new JTextField(30);
		final JTextField num_txt = new JTextField(30);
		final JTextField author_txt = new JTextField(30);
		final JTextField price_txt = new JTextField(30);
		final JTextField state_txt = new JTextField(30);
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
		state_label =new JLabel("�Ƿ���");
		
		
		
		
		
		
		add_button = new JButton("�޸�");
		close_button = new JButton("ȡ��");
		
		Font f = new Font("����", Font.BOLD, 18);
		name_label.setFont(f);
		num_label.setFont(f);
		author_label.setFont(f);
		price_label.setFont(f);
		state_label.setFont(f);

		name_txt.setText(s[0]);
		num_txt.setText(s[1]);
		author_txt.setText(s[2]);
		price_txt.setText(s[3]);
		state_txt.setText(s[4]);

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
					bd.updateBook(b);
					mymsg m = new mymsg("�޸ĳɹ�");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					
				}
			}
		});
	}

}

