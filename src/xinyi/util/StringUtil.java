package xinyi.util;
/**
 * �ַ���������
 * @author qq348
 *
 */
public class StringUtil {
	/**
	 * �ж��ǿ�
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
	 * �жϲ��ǿ�
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
