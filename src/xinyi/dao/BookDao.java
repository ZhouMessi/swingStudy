package xinyi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import xinyi.model.Book;
import xinyi.util.StringUtil;

/**
 * 图书持久类
 * @author qq348
 *
 */
public class BookDao {

	/**
	 * 图书添加
	 * @param connection
	 * @param book
	 * @return
	 */
	public int add(Connection connection,Book book) throws Exception {
		String sql ="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement psmt=connection.prepareStatement(sql);
		psmt.setString(1, book.getBookName());
		psmt.setString(2, book.getAuthor());
		psmt.setString(3, book.getSex());
		psmt.setFloat(4, book.getPrice());
		psmt.setInt(5, book.getBookTypeId());
		psmt.setString(6, book.getBookDesc());
		return psmt.executeUpdate();
	}
	
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb = new StringBuffer(" select * from t_book b,t_bookType bt where b.bookTypeId = bt.id ");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId() !=null && book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId = "+book.getBookTypeId());
		}
		PreparedStatement psmt = con.prepareStatement(sb.toString());
		System.out.println(sb);
		return psmt.executeQuery();
	}
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 */
	public int delete(Connection con,String id) throws Exception {
		String sql = "delete from t_book where id =?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, id);
		return psmt.executeUpdate();
	}
	/**
	 * 图书信息修改
	 * @return
	 */
	public int update(Connection con,Book book) throws Exception {
		String sql = "update t_book set bookName=?, author = ?,sex =?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, book.getBookName());
		psmt.setString(2, book.getAuthor());
		psmt.setString(3, book.getSex());
		psmt.setFloat(4, book.getPrice());
		psmt.setString(5, book.getBookDesc());
		psmt.setInt(6, book.getBookTypeId());
		psmt.setInt(7, book.getId());
		return psmt.executeUpdate();
	}
}
