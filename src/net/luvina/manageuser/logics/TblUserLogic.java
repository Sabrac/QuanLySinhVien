/**
 * Copyright(C) 2014 Luvina
 *
 * TblUserLogic.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.logics;

import java.util.List;

import net.luvina.manageuser.entities.UserInfor;

/**
 * TblUserLogic.java
 *
 * @author LA-PM
 *
 */
public interface TblUserLogic {

	/**
	 * Lấy danh sách user
	 *
	 * @param offset
	 *            vị trí data lấy vào
	 * @param limit
	 *            số lượng lấy
	 * @param groupID
	 *            mã nhóm search
	 * @param fullName
	 *            full name search
	 * @param sortType
	 *            full name hoặc end date hoặc code level
	 * @param sortByFullName
	 *            ASC hoặc DESC
	 * @param sortByCodeLevel
	 *            ASC hoặc DESC
	 * @param sortByEndDate
	 *            ASC hoặc DESC
	 * @return List<UserInfor>  danh sach user
	 */
	public List<UserInfor> getListUsers(int offset, int limit, int groupId,
			String fullName, String sortType, String sortByFullName,
			String sortByCodeLevel, String sortByEndDate);

	/**
	 * Lấy tổng số user
	 *
	 * @param groupId
	 *            mã nhóm search
	 * @param fullName
	 *            full name search
	 * @return int tổng số record
	 */
	public int getTotalRecordṣ(int groupId, String fullName);

	/**
	 * Kiểm tra tồn tại 1 account
	 * @param loginId tên đăng nhập
	 * @param password mật khẩu
	 * @return true: tồn tại Id trong db / false: không tồn tại
	 */
	public boolean existLoginId(String loginId, String password);

	/**
	 * Kiểm tra tồn tại login name
	 * @param loginId tên đăng nhập
	 * @return true: tồn tại login name trong db / false: không tồn tại
	 */
	public boolean existLoginName(String loginId);

	/**
	 * Kiểm tra tồn tại email
	 * @param email
	 * @return true: tồn tại email trong db / false: không tồn tại
	 */
	public boolean existEmail(String email);

	/**
	 *	Thêm user vào db
	 * @param user UserInfor
	 * @return true: Thành công / false: Thất bại
	 */
	public boolean createUser(UserInfor user);

	/**
	 * Lấy thông tin user bằng id
	 * @param userId int id user
	 * @return UserInfor thông tin chi tiết user
	 */
	public UserInfor getUserInfor(int userId);

	/**
	 * Logic cập nhật thông tin user
	 * @param user UserInfor thông tin user
	 * @return true: cập nhật thành công / false: thất bại
	 */
	public boolean updateUser(UserInfor user);
}
