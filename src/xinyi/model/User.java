package xinyi.model;
/**
 * 用户实体
 * @author qq348
 *
 */
public class User {

	private int id;// 编号
	private String userName; //用户名
	private String passWord;//密码
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
