package xinyi.util;
/**
 * 字符串工具类
 * @author qq348
 *
 */
public class StringUtil {
	/**
	 * 判断是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断不是空
	 * @param str
	 * @return
	 */
public static boolean isNotEmpty(String str) {
		
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
