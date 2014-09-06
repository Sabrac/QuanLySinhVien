/**
 * Copyright(C) K16SE 2014
 *
 * QuocTichDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.QuocTich;

/**
 *
 * @author HaVH
 *
 */
public interface QuocTichDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả quốc tịch
	 *
	 * @return List<QuocTich> Danh sách đối tượng quốc tịch
	 */
	List<QuocTich> getAllQuocTich();

	/**
	 * Lấy thông tin quốc tịch bằng id
	 *
	 * @param quocTichId int quốc tịch id
	 * @return QuocTich đối tượng quốc tịch
	 */
	QuocTich getQuocTichById(int quocTichId);

	/**
	 * Thêm thông tin quốc tịch
	 *
	 * @param quocTich QuocTich đối tượng quốc tịch
	 * @return true: thành công / false: thất bại
	 */
	boolean addQuocTich(QuocTich quocTich);

	/**
	 * Cập nhật thông tin quốc tịch
	 *
	 * @param quocTichId int quốc tịch id
	 * @param quocTich QuocTich đối tượng quốc tịch
	 * @return true: thành công / false: thất bại
	 */
	boolean updateQuocTichById(int quocTichId, QuocTich quocTich);

	/**
	 * Xóa thông tin quốc tịch
	 *
	 * @param quocTichId int quốc tịch id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteQuocTichById(int quocTichId);
}
