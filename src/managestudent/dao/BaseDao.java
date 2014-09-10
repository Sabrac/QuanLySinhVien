/**
 * Copyright(C) K16SE 2014
 *
 * BaseDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

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

	/**
	 * Lấy danh sách tên các column có trong bảng
	 *
	 * @param tableName String tên bảng
	 * @return List<String> Danh sách tên các column trong bảng
	 */
	List<String> getAllColumnName(String tableName);
}
