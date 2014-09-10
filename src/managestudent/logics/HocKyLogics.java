/**
 * Copyright(C) K16SE 2014
 *
 * HocKyLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.HocKy;

/**
 *
 * @author HaVH
 *
 */
public interface HocKyLogics {
	/**
	 * Lấy danh sách tất cả học kỳ
	 *
	 * @return List<HocKy> Danh sách đối tượng học kỳ
	 */
	List<HocKy> getAllHocKy();

	/**
	 * Lấy thông tin 1 học kỳ bằng học kỳ id
	 *
	 * @param hocKyId int học kỳ id
	 * @return HocKy đối tượng học kỳ
	 */
	HocKy getHocKyById(int hocKyId);

	/**
	 * Thêm học kỳ
	 *
	 * @param hocKy HocKy đối tượng học kỳ
	 * @return true: thành công / false: thất bại
	 */
	boolean addHocKy(HocKy hocKy);

	/**
	 * Cập nhật thông tin học kỳ
	 *
	 * @param hocKyId int học kỳ id
	 * @param hocKy HocKy đối tượng học kỳ
	 * @return true: thành công / false: thất bại
	 */
	boolean updateHocKyById(int hocKyId, HocKy hocKy);

	/**
	 * Xóa thông tin học kỳ
	 *
	 * @param hocKyId int học kỳ id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteHocKyById(int hocKyId);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();
}
