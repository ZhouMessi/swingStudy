package xinyi.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author qq348
 *
 */
public class DbUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?characterEncoding=utf8&amp;useSSL=false";//���ݿ��ַ
	private String dbUserName="root";
	private String dbPassWord="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		 Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);		 
		 return con;
	}
	
	
	public void closeCon(Connection con) throws Exception {
		if(con!=null) {
			con.close();
		}
	}
	
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
