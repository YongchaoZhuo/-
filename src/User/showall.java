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
	Vector<List<String>> vect;// 声明一个向量对象
 
	public JTable getJg_table() {
		return jg_table;
	}
 
	private static void firtPage(final JFrame jf){
		//1.设置窗体大小和标题
		try {
			delnull d = new delnull();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jf.setPreferredSize(new Dimension(700, 600));
		//2.设置关闭窗口就是关闭程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置布局管理器
		GridLayout glo=new GridLayout(10, 1);
		jf.setLocation(100, 100);
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
		jb.setPreferredSize(new Dimension(680, 30));
		jb.setBackground(Color.decode("#65991a"));
		jf.setJMenuBar(jb);
		jp1.add(jb);
		//新建一个菜单选项
		JMenu jmenu=new JMenu("选项");
		jmenu.setForeground(Color.white);
		jmenu.setPreferredSize(new Dimension(200, 30));
		final JMenuItem addbook=new JMenuItem("添加图书信息");
		final JMenuItem delbook=new JMenuItem("删除图书信息");
		JMenuItem chabook=new JMenuItem("修改图书信息");
		JMenuItem seabook=new JMenuItem("查找图书信息");
		jmenu.add(addbook);
		jmenu.add(delbook);
		jmenu.add(chabook);
		jmenu.add(seabook);
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
		
		//***
		//用户修改
		//**//
		//3.设置窗体可见
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
		final JFrame jf=new JFrame("图书管理系统");
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
final String title[] = { "职工号", "职工名", "性别", "出生日期", "工资" }; // 二维表列名
vect = new Vector<List<String>>();// 实例化向量
tm = new AbstractTableModel() {
	public int getColumnCount() {
		return title.length;
	}// 取得表格列数

	public int getRowCount() {
		return vect.size();
	}// 取得表格行数

	public Object getValueAt(int row, int column) {
		if (!vect.isEmpty())
			return ((Vector<String>) vect.elementAt(row))
					.elementAt(column);
		else
			return null;
	}// 取得单元格中的属性值

};

vect.removeAllElements();// 初始化向量对象
tm.fireTableStructureChanged();// 更新表格内容


tm.fireTableStructureChanged();

// 定制表格：
jg_table = new JTable(tm);// 生成自己的数据模型

jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
// 设置表格调整尺寸模式
jg_table.setCellSelectionEnabled(false);
// 设置单元格选择方式
jg_table.setShowVerticalLines(true);//
// 设置是否显示单元格间的分割线
jg_table.setShowHorizontalLines(true);
jg_table.setFont(new Font("楷体", Font.BOLD, 14));

jsp = new JScrollPane(jg_table);// 给表格加上滚动杠

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
			// 初始化时，父容器大小为首选大小，实际大小为0
			containerwidth = jsp.getPreferredSize();
		} else {
			// 界面显示后，如果父容器大小改变，使用实际大小而不是首选大小
			containerwidth = jsp.getSize();
		}
		// 计算表格总体宽度 getTable().
		int allwidth = jg_table.getIntercellSpacing().width;
		for (int j = 0; j < jg_table.getColumnCount(); j++) {
			// 计算该列中最长的宽度
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
			// 计算表头的宽度
			int headerwidth = jg_table
					.getTableHeader()
					.getDefaultRenderer()
					.getTableCellRendererComponent(
							jg_table,
							jg_table.getColumnModel().getColumn(j)
									.getIdentifier(), false, false, -1, j)
					.getPreferredSize().width;
			// 列宽至少应为列头宽度
			max += headerwidth;
			// 设置列宽
			jg_table.getColumnModel().getColumn(j).setPreferredWidth(max);
			// 给表格的整体宽度赋值，记得要加上单元格之间的线条宽度1个像素
			allwidth += max + jg_table.getIntercellSpacing().width;
		}
		allwidth += jg_table.getIntercellSpacing().width;
		// 如果表格实际宽度大小父容器的宽度，则需要我们手动适应；否则让表格自适应
		if (allwidth > containerwidth.width) {
			jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		} else {
			jg_table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		}
	}
 
}


