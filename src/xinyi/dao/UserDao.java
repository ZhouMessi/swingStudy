package xinyi.dao;
/**
 * ”√ªßdao¿‡
 * @author qq348
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xinyi.model.User;

public class UserDao {
	
		public User login(Connection con,User user)  throws Exception{
			User resultUser=null;
			String sql="select * from t_user where userName=? and passWord=? ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			ResultSet rSet=pstmt.executeQuery();
			if(rSet.next()) {
				resultUser=new User();
				resultUser.setId(rSet.getInt("id"));
				resultUser.setUserName(rSet.getString("userName"));
				resultUser.setPassWord(rSet.getString("passWord"));
			}
			return resultUser;
		}
}
