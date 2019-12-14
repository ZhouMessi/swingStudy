package xinyi.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author qq348
 *
 */
public class DbUtil {
	
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?characterEncoding=utf8&amp;useSSL=false";//数据库地址
	private String dbUserName="root";
	private String dbPassWord="root";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
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
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库连接失败");
		}
	}
}
