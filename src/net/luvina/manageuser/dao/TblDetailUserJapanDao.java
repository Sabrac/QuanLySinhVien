/**
 * Copyright(C) 2014 Luvina
 *
 * TblDetailUserJapan.java, Jun 26, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao;

import net.luvina.manageuser.entities.TblDetailUserJapan;

/**
 * Xử lý data cho table tbl_detail_user_japan
 * @author HaVH
 *
 */
public interface TblDetailUserJapanDao extends BaseDao {
	/**
	 * Xử lý add thêm thông tin vào bảng tbl_detail_user_japan
	 * @param detailJapan thông tin object TblDetailUserJapan
	 * @return true: thêm thành công / false: thêm thất bại
	 */
	public boolean insertDetailUserJapan(TblDetailUserJapan detailJapan);

	/**
	 * Hàm lấy thông tin trình độ tiếng nhật
	 * @param userId int id user
	 * @return TblDetailUserJapan thông tin trình độ tiếng Nhật
	 */
	public TblDetailUserJapan getDetailUserJapan(int userId);
}
