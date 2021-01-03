package User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fileRead.Book;
import fileRead.BookDeal;
import fileRead.delnull;
import fileRead.fileChange;
//import fileRead.text;


public class showall extends JFrame{
	private JTable jg_table;
	
	public Vector<List<String>> getVect() {
		return vect;
	}
 
	private JScrollPane jsp;
	Vector<List<String>> vect;// ����һ����������
 
	public JTable getJg_table() {
		return jg_table;
	}
 
	private static void firtPage(final JFrame jf){
		//1.���ô����С�ͱ���
		try {
			delnull d = new delnull();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jf.setPreferredSize(new Dimension(700, 600));
		//2.���ùرմ��ھ��ǹرճ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ò��ֹ�����
		GridLayout glo=new GridLayout(10, 1);
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
		jmenu.add(addbook);
		jmenu.add(delbook);
		jmenu.add(chabook);
		jmenu.add(seabook);
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
	public showall() {
		
		try { 
			showall frame = new showall();
			frame.pack();
			frame.setVisible(true);
			
			BookDeal bd = new BookDeal();
			ArrayList<Book> b =  bd.findAllBooks();
		
			for(Book book:b){
				Vector<String> list = new Vector<String>();
				list.add(book.getName());
				list.add(book.getNum());
				list.add(book.getAuthor());
				list.add(book.getPrice());
				list.add(book.getState());

				frame.getVect().add(list);
				 ((AbstractTableModel)frame.getJg_table().getModel()).fireTableDataChanged();
				frame.getJg_table().updateUI();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		final JFrame jf=new JFrame("ͼ�����ϵͳ");
		firtPage(jf);
		TableModel tableModel=new AbstractTableModel(){

            public int getColumnCount(){return 10;}

            public int getRCount(){return 10;}

            public Object getValueAt(int row,int col){return new Integer(row*col) ;}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			

};
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 100, 100);
getContentPane().setLayout(new BorderLayout(0, 0));

AbstractTableModel tm;
final String title[] = { "ְ����", "ְ����", "�Ա�", "��������", "����" }; // ��ά������
vect = new Vector<List<String>>();// ʵ��������
tm = new AbstractTableModel() {
	public int getColumnCount() {
		return title.length;
	}// ȡ�ñ������

	public int getRowCount() {
		return vect.size();
	}// ȡ�ñ������

	public Object getValueAt(int row, int column) {
		if (!vect.isEmpty())
			return ((Vector<String>) vect.elementAt(row))
					.elementAt(column);
		else
			return null;
	}// ȡ�õ�Ԫ���е�����ֵ

};

vect.removeAllElements();// ��ʼ����������
tm.fireTableStructureChanged();// ���±������


tm.fireTableStructureChanged();

// ���Ʊ��
jg_table = new JTable(tm);// �����Լ�������ģ��

jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
// ���ñ������ߴ�ģʽ
jg_table.setCellSelectionEnabled(false);
// ���õ�Ԫ��ѡ��ʽ
jg_table.setShowVerticalLines(true);//
// �����Ƿ���ʾ��Ԫ���ķָ���
jg_table.setShowHorizontalLines(true);
jg_table.setFont(new Font("����", Font.BOLD, 14));

jsp = new JScrollPane(jg_table);// �������Ϲ�����

jsp.addComponentListener(new ComponentAdapter() {
	@Override
	public void componentResized(ComponentEvent e) {
//		resizeTable(true);
	}
});
getContentPane().add(jsp, BorderLayout.CENTER);
}
	public static void main(String[] args) {

	}
	public void resizeTable(boolean bool) {
		Dimension containerwidth = null;
		if (!bool) {
			// ��ʼ��ʱ����������СΪ��ѡ��С��ʵ�ʴ�СΪ0
			containerwidth = jsp.getPreferredSize();
		} else {
			// ������ʾ�������������С�ı䣬ʹ��ʵ�ʴ�С��������ѡ��С
			containerwidth = jsp.getSize();
		}
		// ������������ getTable().
		int allwidth = jg_table.getIntercellSpacing().width;
		for (int j = 0; j < jg_table.getColumnCount(); j++) {
			// �����������Ŀ��
			int max = 0;
			for (int i = 0; i < jg_table.getRowCount(); i++) {
				int width = jg_table
						.getCellRenderer(i, j)
						.getTableCellRendererComponent(jg_table,
								jg_table.getValueAt(i, j), false, false, i, j)
						.getPreferredSize().width;
				if (width > max) {
					max = width;
				}
			}
			// �����ͷ�Ŀ��
			int headerwidth = jg_table
					.getTableHeader()
					.getDefaultRenderer()
					.getTableCellRendererComponent(
							jg_table,
							jg_table.getColumnModel().getColumn(j)
									.getIdentifier(), false, false, -1, j)
					.getPreferredSize().width;
			// �п�����ӦΪ��ͷ���
			max += headerwidth;
			// �����п�
			jg_table.getColumnModel().getColumn(j).setPreferredWidth(max);
			// �����������ȸ�ֵ���ǵ�Ҫ���ϵ�Ԫ��֮����������1������
			allwidth += max + jg_table.getIntercellSpacing().width;
		}
		allwidth += jg_table.getIntercellSpacing().width;
		// ������ʵ�ʿ�ȴ�С�������Ŀ�ȣ�����Ҫ�����ֶ���Ӧ�������ñ������Ӧ
		if (allwidth > containerwidth.width) {
			jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		} else {
			jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		}
	}
 
}


