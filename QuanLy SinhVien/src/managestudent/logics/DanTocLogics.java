/**
 * Copyright(C) K16SE 2014
 *
 * DanTocLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.DanToc;

/**
 *
 * @author HaVH
 *
 */
public interface DanTocLogics {
	/**
	 * Lấy danh sách tất cả các dân tộc trong database
	 * @return List<DanToc> Danh sách các dân tộc
	 */
	List<DanToc> getAllDanToc(DanToc danToc, int offset, int limit, int sortColumn, String sortType);

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
	boolean updateDanTocById(int danTocId, DanToc dt);

	/**
	 * Xóa dân tộc
	 *
	 * @param danTocId int dân tộc id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteDanTocById(int danTocId);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();

	/**
	 * Lấy toàn bộ số bản ghi trong bảng
	 *
	 * @return int tổng số bản ghi
	 */
	int getTotalRecords(DanToc danToc);
}
