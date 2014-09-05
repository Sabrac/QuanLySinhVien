/**
 * Copyright(C) K16SE 2014
 *
 * DanTocDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.DanToc;

/**
 *
 * @author HaVH
 *
 */
public interface DanTocDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả các dân tộc trong database
	 * @return List<DanToc> Danh sách các dân tộc
	 */
	List<DanToc> getAllDanToc();

	/**
	 * Lấy 1 dân tộc bằng id dân tộc
	 * @param danTocId int id dân tộc
	 * @return DanToc đối tượng dân tộc
	 */
	DanToc getDanTocById(int danTocId);

	/**
	 * Thêm dân tộc
	 *
	 * @param dt DanToc đối tượng dân tộc
	 * @return true: thành công / false: thất bại
	 */
	boolean addDanToc(DanToc dt);

	/**
	 * Cập nhật thông tin dân tộc
	 *
	 * @param dt DanToc đối tượng dân tộc (danTocId = điều kiện update)
	 * @return true: thành công / false: thất bại
	 */
	boolean updateDanTocById(DanToc dt);

	/**
	 * Xóa dân tộc
	 *
	 * @param danTocId int dân tộc id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteDanTocById(int danTocId);
}
