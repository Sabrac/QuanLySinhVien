/**
 * Copyright(C) K16SE 2014
 *
 * BaseDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

/**
 *
 * @author HaVH
 *
 */
public interface BaseDao {
	/**
	 * Kết nối cơ sở dữ liệu
	 * @return true: Kết nối thành công / false: Kết nối thất bại
	 */
	public boolean connectToDB();

	/**
	 * Đóng kết nối cơ sở dữ liệu
	 *
	 */
	public void closeConnect();
}
