  package xinyi.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Enumeration;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.CremeSkin;
import org.jvnet.substance.skin.ModerateSkin;

import xinyi.dao.UserDao;
import xinyi.model.User;
import xinyi.util.DbUtil;
import xinyi.util.StringUtil;

public class LogOnFrm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNmaeField;
	private JPasswordField passwordField;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		 try {
			// �������⣬ ���Ҫ��������ֻ��Ҫ������һ�д���
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");		
		    //org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		//	 UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif���������
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//windows���
			// UIManager.setLookAndFeel();
			 //�������
			// UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
		//	 JFrame.setDefaultLookAndFeelDecorated(true);
			 //��������
					} catch (Exception e) {
						e.printStackTrace();
					}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//SubstanceLookAndFeel.setSkin(new CremeSkin());
					//SubstanceLookAndFeel.setSkin(new GeminiSkin());
					//SubstanceLookAndFeel.setSkin(new ModerateSkin());
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 559, 416);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//����ͼ��
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogOnFrm.class.getResource("/images/moneyPage.png")));
		
		
		JLabel lblNewLabel = new JLabel("\u946B\u4EBF\u53D1\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/xieDi.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D :");
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/userName.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801 :");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
		
		userNmaeField = new JTextField();
		userNmaeField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/refresh.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(131)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(158)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(20))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(8)
											.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
									.addComponent(userNmaeField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(btnNewButton_1)))))
					.addGap(172))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNmaeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(43))
		);
		contentPane.setLayout(gl_contentPane);
		//���õ�¼����Ĭ�Ͼ���
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * ��¼�¼�����
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = this.userNmaeField.getText();
		String passWord = new String(this.passwordField.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��! ");
			return;
		}
		
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��! ");
			return;
		}
		
		User user=new User(userName,passWord);
		Connection con=null;
		try {
			con = dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser != null) {
				//���ٵ�ǰ����
				dispose();
				//������������ʾ
				new MainFrm().setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, " �û��������������! ");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}

	/**
	 * �����¼�����
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.userNmaeField.setText("");
		this.passwordField.setText("");;
	}
}
