package xinyi.model;

import java.sql.ResultSet;

public class PageInfo {

	private ResultSet resultSet;
	
	private int totalPage;

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public int gettotalPage() {
		return totalPage;
	}

	public void settotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(ResultSet resultSet, int totalPage) {
		super();
		this.resultSet = resultSet;
		this.totalPage = totalPage;
	}
	
	
}
