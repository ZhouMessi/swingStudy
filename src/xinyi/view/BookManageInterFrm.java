package xinyi.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import xinyi.dao.BookDao;
import xinyi.dao.BookTypeDao;
import xinyi.model.Book;
import xinyi.model.BookType;
import xinyi.util.DbUtil;
import xinyi.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	
	private JRadioButton manJrb; 
	private JRadioButton femaleJrb; 
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;
	
	private JComboBox s_bookTypeJcb;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookManageInterFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 889, 512);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, Color.LIGHT_GRAY));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scrollPane, Alignment.LEADING)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7:");
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("\u4F5C\u8005\u6027\u522B:");
		
	    manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_1 = new JLabel("\u4EF7\u683C:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
		
		bookDescTxt = new JTextArea();
		bookDescTxt.setForeground(Color.BLACK);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		//ͼ������¼�
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			//ͼ��ɾ���¼�
			public void actionPerformed(ActionEvent e) {
				try {
					bookDeleteActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(label_3))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(29)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(femaleJrb)
									.addGap(18)
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(btnNewButton_1)
									.addGap(18)
									.addComponent(btnNewButton_2)))
							.addContainerGap(175, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_4)
							.addGap(18)
							.addComponent(bookDescTxt))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label_1)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton_2)
							.addComponent(btnNewButton_1)
							.addComponent(label_2)
							.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		//ͼ���ѯ
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnNewButton)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblNewLabel)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		//����������ݵ���¼�
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent Me) {
				bookTableMousePressed(Me);
			}
		});
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(159);
		getContentPane().setLayout(groupLayout);
		
		//�����ı���߿�
		bookDescTxt.setBorder(new LineBorder(new Color(127,157,185),1,false));
		
		//��ʼ����ѯ������
		this.fillBookType("search");
		
		//��ʼ���޸�������
		this.fillBookType("modify");
		//��ʼ�����
		this.fillTable(new Book());
	}
	/**
	 * ͼ��ɾ���¼�
	 * @param e
	 */
	private void bookDeleteActionPerformed(ActionEvent e) throws Exception {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ���ļ�¼");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ���ü�¼��?");
		if(n == 0) {
			Connection connection = dbUtil.getCon();
			int deleteNum = bookDao.delete(connection, id);
			if(deleteNum == 1) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�!");
				this.resetValue();
				this.fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��!");
			}
			try {
				connection = dbUtil.getCon();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��!");
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
	 * ͼ���޸��¼�����
	 * @param e
	 */
	private void bookUpdateActionPerformed(ActionEvent e) {
		String id = this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵļ�¼");
			return;
		}
		
		String bookName = this.bookNameTxt.getText();
		String author = this.authorTxt.getText();
		String price = this.priceTxt.getText();
		String bookDesc = this.bookDescTxt.getText();
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "ͼ�����Ʋ���Ϊ��! ");
			return;
		}
		
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "ͼ�����߲���Ϊ��! ");
			return;
		}
		
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "ͼ��۸���Ϊ��! ");
			return;
		}
		
		String sex = "";
		if(manJrb.isSelected()) {
			sex = "��";
		}else {
			sex = "Ů";
		}
		
		BookType bookType =(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book = new Book(Integer.valueOf(id), bookName, author, sex, Float.valueOf(price) ,bookTypeId,bookDesc); 
		
		Connection connection = null;
		try {
			connection = dbUtil.getCon();
			int addNum = bookDao.update(connection, book);
			if(addNum == 1) {
				JOptionPane.showMessageDialog(null, "ͼ���޸ĳɹ�!");
				resetValue();
				this.fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "ͼ���޸�ʧ��!");
			}
		} catch (Exception e2) {
					// TODO: handle exception
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "ͼ���޸�ʧ��!");
		}finally {
			try {
				dbUtil.closeCon(connection);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * ���ñ�
	 */
	private void resetValue() {
		// TODO Auto-generated method stub
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.priceTxt.setText("");
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}

	/**
	 * ����е���¼�����
	 * @param met
	 */
	private void bookTableMousePressed(MouseEvent met) {
		int row = this.bookTable.getSelectedRow();//��ȡѡ�е���
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex = (String)bookTable.getValueAt(row, 3);
		if("��".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if("Ů".equals(sex)){
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
		String bookTypeName = (String)this.bookTable.getValueAt(row, 6); 
		int n =this.bookTypeJcb.getItemCount();
		System.out.println("һ�� "+n+"��");
		for (int i = 0; i < n; i++) {
			BookType item = (BookType)this.bookTypeJcb.getItemAt(i);
			System.out.println(item.toString2());
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);	
			}	
		}
		
	}

	/**
	 * ͼ���ѯ�¼�����
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent e) {
		String bookName = this.s_bookNameTxt.getText();
		String author = this.s_authorTxt.getText();
		BookType bookType =(BookType)this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName,author,bookTypeId);
		this.fillTable(book);
		
	}

	/**
	 * ��ʼ��������
	 * @param Type ����������
	 */
	private void fillBookType(String Type) {
		Connection con = null;
		BookType bookType = null;
		try {
			 con= dbUtil.getCon();
			 ResultSet rs= bookTypeDao.list(con, new BookType());
			 if("search".equals(Type)) {
				 bookType = new BookType();
				 bookType.setId(-1);
				 bookType.setBookTypeName("��ѡ��");
				 this.s_bookTypeJcb.addItem(bookType);
			 }
			 while(rs.next()) {
				 bookType = new BookType(); 
				 bookType.setId(rs.getInt("id"));
				 bookType.setBookTypeName(rs.getString("bookTypeName"));
				 if("search".equals(Type)) {
					 this.s_bookTypeJcb.addItem(bookType);
				 }else if("modify".equals(Type)){
					this.bookTypeJcb.addItem(bookType);
				}			
			 }
		} catch (Exception e) {
			// TODO: handle exception
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
	 * ��ʼ���������
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm =  (DefaultTableModel)bookTable.getModel();
		dtm.setRowCount(0);//���ó�0�� ��ձ��
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rSet = bookDao.list(con, book);
			while(rSet.next()) {
				Vector v = new Vector();
				v.add(rSet.getString("id"));
				v.add(rSet.getString("bookName"));
				v.add(rSet.getString("author"));
				v.add(rSet.getString("sex"));
				v.add(rSet.getFloat("price"));
				v.add(rSet.getString("bookDesc"));
				v.add(rSet.getString("bookTypeName"));
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
}
