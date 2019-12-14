package xinyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xinyi.model.BookType;
import xinyi.model.PageInfo;
import xinyi.util.StringUtil;

/**
 * 图书持久层类
 * @author qq348
 *
 */
public class BookTypeDao {
	
	/**
	 * 图书类别添加
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception 
	 */
	public int add(Connection con,BookType bookType) throws Exception {
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, bookType.getBookTypeName());
		psmt.setString(2, bookType.getBookTypeDesc());
		return psmt.executeUpdate();
	}
	
	public ResultSet list(Connection con,BookType bookType) throws Exception {
		StringBuffer sb = new StringBuffer(" select * from t_bookType  where 1=1 " );
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
	PreparedStatement psmt = con.prepareStatement(sb.toString());
	return psmt.executeQuery();
	}
	
	public PageInfo list(int currentPage,Connection con,BookType bookType) throws Exception {
//		StringBuffer sb = new StringBuffer(" select * from t_bookType where 1=1 " );
//		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
//			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
//		}
		
	PageInfo pageInfo = new PageInfo();
	StringBuffer sb = new StringBuffer(" select * from t_bookType  where 1=1 " );
	if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
		sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
	}
		//获取总记录
	PreparedStatement psmt2 = con.prepareStatement(sb.toString());
	ResultSet resultSet = psmt2.executeQuery(sb.toString());
	int rowCount = 0;
	while (resultSet.next()) {
		rowCount++;		
	}
	System.out.println("总记录数: "+rowCount);
	sb.append(" limit " +(currentPage-1)*10+","+"10");
	PreparedStatement psmt = con.prepareStatement(sb.toString());
	ResultSet set = psmt.executeQuery();
	pageInfo.setResultSet(set);
	//System.out.println(set);
	//获取总页数 totalPage = totalRecord % pageSize== 0 ? totalRecord / pageSize: totalRecord / pageSize+ 1 ;

	pageInfo.settotalPage( rowCount % 10== 0 ? rowCount / 10:rowCount  / 10+ 1);
	return pageInfo;
	}
	/**
	 * 根据id删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception {
		String sql = "delete from t_bookType where id = ?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, id);
		return psmt.executeUpdate();
	}
	
	public int update(Connection con,BookType bookType) throws Exception {
		String sql = "update t_bookType set bookTypeName=?, bookTypeDesc=? where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, bookType.getBookTypeName());
		psmt.setString(2, bookType.getBookTypeDesc());
		psmt.setInt(3, bookType.getId());
		return psmt.executeUpdate();
	}
}
