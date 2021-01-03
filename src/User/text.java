package User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import fileRead.Book;
import fileRead.BookDeal;
 
public class text extends JFrame {
	private JTable jg_table;
	
	public Vector<List<String>> getVect() {
		return vect;
	}
 
	private JScrollPane jsp;
	Vector<List<String>> vect;// 声明一个向量对象
 
	public JTable getJg_table() {
		return jg_table;
	}
 
	public static void main(String[] args) {
 
		try { 
			text frame = new text();
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
	}
 
	public text() {
	
		this.setDefaultCloseOperation(text.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 100, 100);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		AbstractTableModel tm;
 
		final String title[] = { "书名", "书号", "作者", "价格", "类型" }; // 二维表列名
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
				resizeTable(true);
			}
		});
		getContentPane().add(jsp, BorderLayout.CENTER);
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