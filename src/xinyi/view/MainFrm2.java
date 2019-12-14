package xinyi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JTabbedPane;

public class MainFrm2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm2 frame = new MainFrm2();
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
	public MainFrm2() {
		setTitle("\u946B\u4EBF\u53D1\u4FE1\u606F\u7BA1\u7406\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1973, 1056);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setForeground(Color.YELLOW);
		menuBar.setFont(new Font("微软雅黑", Font.BOLD, 14));
		setJMenuBar(menuBar);
		//设置图标
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm2.class.getResource("/images/moneyPage.png")));
		
		JMenu mnNewMenu = new JMenu("\u8D22\u52A1\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/money.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/dingGou.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		//图书类别添加
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/add_dinggoudan.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManegerInterFrm bookTypeManegerInterFrm = null;
				try {
					bookTypeManegerInterFrm = new BookTypeManegerInterFrm();
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bookTypeManegerInterFrm.setVisible(true);
				table.add(bookTypeManegerInterFrm);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/weihu.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		//图书添加
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/add.png")));
		mnNewMenu_1.add(menuItem_1);
		
		//图书维护
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/weihu.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u8D26\u5355\u7BA1\u7406");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenu menu = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/guanYuWoMen.png")));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u946B\u4EBF\u53D1\u978B\u5E95\u7EC4\u5408");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xinyiIF xinyiIF=new xinyiIF();
				xinyiIF.setVisible(true);
				table.add(xinyiIF);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/qiye.png")));
		menu.add(mntmNewMenuItem);
		
		JMenu menu_1 = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu_1.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/xitongshezhi.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统?");
				if(result == 0) {
					dispose();
				}
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/anquantuichu.png")));
		menu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//为table设置背景
				ImageIcon icon = new ImageIcon(MainFrm2.class.getResource("/images/BCI.jpg"));
				Image image =icon.getImage();
	    table = new JDesktopPane() {
	    	public void print(Graphics g) {
				g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
			};
	    };
		table.setBackground(Color.LIGHT_GRAY);
		
		
		contentPane.add(table, BorderLayout.CENTER);
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
