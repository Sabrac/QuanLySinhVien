/**
 * Copyright(C) 2014 Luvina
 *
 * MstJapanLogic.java, Jul 4, 2014 LA-PM
 *
 */
package net.luvina.manageuser.logics;

import java.util.List;

import net.luvina.manageuser.entities.MstJapan;

/**
 * Xử lý thông tin MstJapanLogic table
 *
 * @author LA-PM
 *
 */
public interface MstJapanLogic {
	/**
	 * Lấy danh sách japan level
	 * @return
	 */
	public List<MstJapan> getAllMstJapan();

	/**
	 * Kiểm tra tồn tại kỹ năng tiếng Nhật
	 * @param code_level mã kỹ năng
	 * @return true: tồn tại / false: không tồn tại
	 */
	public boolean checkJapanExist(String name_level);

	/**
	 * Lấy đối tượng mstJapan bằng code level
	 * @param code_level
	 * @return đối tượng mstJapan
	 */
	public MstJapan getJapanByCode(String code_level);

	/**
	 * Lấy name level bằng code
	 * @param code_level
	 * @return tên trình độ tiếng nhật
	 */
	public String getNameLevelByCode(String code_level);
}
