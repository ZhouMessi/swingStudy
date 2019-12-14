package xinyi.view;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import xinyi.dao.BookTypeDao;
import xinyi.model.BookType;
import xinyi.model.PageInfo;
import xinyi.util.DbUtil;
import xinyi.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManegerInterFrm extends JInternalFrame {
	/**
	 * 
	 */

	private JTable bookTypeTable;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private JTextField currentPage;
	private JTextField totalPage;
	private JButton prePage;
	private JButton nextPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManegerInterFrm frame = new BookTypeManegerInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public BookTypeManegerInterFrm() throws PropertyVetoException {
		setClosable(true);
		setClosed(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setBounds(100, 100, 712, 689);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeManegerInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		prePage = new JButton("\u4E0A\u4E00\u9875");
//		上一页
		prePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
					paging(e);		
			}
		});
		prePage.setIcon(new ImageIcon(BookTypeManegerInterFrm.class.getResource("/images/backward_page_18.079096045198px_1189181_easyicon.net.png")));
		
		nextPage = new JButton("\u4E0B\u4E00\u9875");
		nextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
		nextPage.setIcon(new ImageIcon(BookTypeManegerInterFrm.class.getResource("/images/forward_page_18.181818181818px_1189511_easyicon.net.png")));
		
		currentPage = new JTextField();
		currentPage.setColumns(10);
		//初始化当前页为1
		currentPage.setText("1");
		
		JLabel label_1 = new JLabel("\u7B2C");
		
		JLabel label_2 = new JLabel("\u9875");
		
		JButton location = new JButton("Go");
		location.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paging(e);
			}
		});
		location.setIcon(new ImageIcon(BookTypeManegerInterFrm.class.getResource("/images/go_jump_16px_509800_easyicon.net.png")));
		
		JLabel label_3 = new JLabel("\u5171");
		
		totalPage = new JTextField();
		totalPage.setEditable(false);
		totalPage.setColumns(10);
		
		JLabel label_4 = new JLabel("\u9875");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(86)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(prePage)
							.addGap(24)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(currentPage, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(location)
							.addGap(12)
							.addComponent(nextPage)
							.addGap(18)
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalPage, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addGap(66)
								.addComponent(btnNewButton))))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(label_2)
							.addComponent(currentPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(prePage))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(nextPage)
							.addComponent(label_3)
							.addComponent(totalPage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_4))
						.addComponent(location))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7:");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u63CF\u8FF0:");
		
	    bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManegerInterFrm.class.getResource("/images/modify.png")));
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					bookTypeDeleteActionEvent(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon(BookTypeManegerInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(69)
									.addComponent(btnNewButton_1)
									.addGap(50)
									.addComponent(button))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(label)
											.addGap(18)
											.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
										.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton_1))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			//给表格添加鼠标点击事件
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(124);
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(171);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
//		this.fillTable(new BookType());
		this.fillTable2(new BookType());
	}
	
	//翻页  (上一页下一页 跳转到自定页都用这个)
	private void paging(ActionEvent e)  {
		String eveString = e.getActionCommand();
		int currentPage = Integer.valueOf(this.currentPage.getText());
		int totalPage = Integer.valueOf(this.totalPage.getText());		
		//获取查询信息
		String s_bookTypeNameString = this.s_bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeNameString);
		switch (eveString) {
		case "上一页":
			currentPage--;
			if(currentPage > 1) {
				this.currentPage.setText(String.valueOf(currentPage));
				this.nextPage.setEnabled(true);		
				fillTable2(bookType);
			}else{
				this.currentPage.setText(String.valueOf("1"));
				this.prePage.setEnabled(false);
				this.nextPage.setEnabled(true);		
				fillTable2(bookType);
			}
			break;
		case "下一页":
			currentPage++;
			if(currentPage < totalPage) {
				this.currentPage.setText(String.valueOf(currentPage));
				this.prePage.setEnabled(true);
			    fillTable2(bookType);
			}else {
				this.currentPage.setText(String.valueOf(totalPage));
				this.nextPage.setEnabled(false);
				this.prePage.setEnabled(true);
			    fillTable2(bookType);
			}
				break;				
	   case "Go":
		   if(currentPage<=1) {
			   this.currentPage.setText(String.valueOf("1"));
				this.prePage.setEnabled(false);
				this.nextPage.setEnabled(true);		
				fillTable2(bookType);
		   }else if (currentPage >= totalPage) {
			    this.currentPage.setText(String.valueOf(totalPage));
				this.nextPage.setEnabled(false);
				this.prePage.setEnabled(true);
			    fillTable2(bookType);
		}else {
			    this.currentPage.setText(String.valueOf(currentPage));
				this.nextPage.setEnabled(true);
				this.prePage.setEnabled(true);
			    fillTable2(bookType);
		}
		   break;
		default:
			System.out.println("默认");
			break;
		    }
	
		}	

	/**
	 * 图书类别删除
	 * @param e
	 * @throws Exception 
	 */
	private void bookTypeDeleteActionEvent(ActionEvent e) throws Exception {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择需要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗?");
		if(n == 0) {
			Connection connection = dbUtil.getCon();
			int deleteNum = bookTypeDao.delete(connection, id);
			if(deleteNum == 1) {
				JOptionPane.showMessageDialog(null, "删除成功!");
				this.resetValue();
				this.fillTable(new BookType());
			}else {
				JOptionPane.showMessageDialog(null, "删除失败!");
			}
			try {
				connection = dbUtil.getCon();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败!");
			}finally {
				try {
					dbUtil.closeCon(connection);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 图书类别更新
	 * @param e
	 */
	private void bookTypeUpdateActionEvent(ActionEvent e) {
		String id = idTxt.getText();
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int modifyNum = bookTypeDao.update(con, bookType);
			if(modifyNum == 1 ) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.resetValue();
				this.fillTable(new BookType());
				
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param e
	 */
	private void bookTypeTableMousePressed(MouseEvent evt) {
		 int row =	bookTypeTable.getSelectedRow();//获取选中的行号
		 idTxt.setText((String)bookTypeTable.getValueAt(row, 0));//根据选中的行和列获取对应的值
		 bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
		 bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2));
	}

	/**
	 * 图书类别搜索事件处理
	 * @param e
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_bookTypeNameString = this.s_bookTypeNameTxt.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeNameString);
		this.currentPage.setText("1");
		fillTable2(bookType);
		this.nextPage.setEnabled(true);
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm =  (DefaultTableModel)bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行 清空表格
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rSet = bookTypeDao.list(con, bookType);
			while(rSet.next()) {
				Vector v = new Vector();
				v.add(rSet.getString("id"));
				v.add(rSet.getString("bookTypeName"));
				v.add(rSet.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void fillTable2(BookType bookType) {
		DefaultTableModel dtm =  (DefaultTableModel)bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行 清空表格

	    String currentPage	= (String)this.currentPage.getText();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			PageInfo pageInfo = bookTypeDao.list(Integer.valueOf(currentPage),con, bookType);
			ResultSet rSet = pageInfo.getResultSet();
			this.totalPage.setText(pageInfo.gettotalPage()+"");
			System.out.println(pageInfo.gettotalPage());
			while(rSet.next()) {
				Vector v = new Vector();
				v.add(rSet.getString("id"));
				v.add(rSet.getString("bookTypeName"));
				v.add(rSet.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText(""); 
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
