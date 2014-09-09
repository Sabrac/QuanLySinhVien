/**
 * Copyright(C) 2014 Luvina
 *
 * TblUserDao.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao;

import java.util.List;

import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;

/**
 * TblUserDao
 *
 * @author LA-PM
 *
 */
public interface TblUserDao extends BaseDao {

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
	 * @return List<UserInfor> danh sách user
	 */
	public List<UserInfor> getListUsers(int offset, int limit, int groupID,
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
	public int getTotalUsers(int groupId, String fullName);

	/**
     * getUserByLoginId
     *
     * @param loginId
     *            String loginId
     * @param password
     *            String password
     * @return int số user valid
     */
    public int getUserByLoginId(String loginId, String password) ;

    /**
     * getUserByLoginId
     *
     * @param loginId
     *            String loginId
     * @return int số user valid
     */
    public int countUserByLoginName(String loginId) ;

    /**
     * Đếm số user có email trùng với email chỉ định
     * @param email email chỉ định
     * @return count
     */
    public int countUserByEmail(String email);

    /**
     * Hàm thêm user vào db
     * @param user UserInfor
     * @return true: Thành công / false: Thất bại
     */
    public boolean insertUser(UserInfor user);

    /**
     * Hàm xóa user bằng user id
     * @param id user id
     * @return true: thành công / false: thất bại
     */
    public boolean deleteUserById(int id);

    /**
     * Hàm lấy user id vừa được thêm vào gần nhất
     * @return int user id
     */
    public int getCurrentUserId();

    /**
     * Hàm lấy thông tin user bằng user id
     * @param userId int id user
     * @return UserInfor thông tin user
     */
    public UserInfor getUserInfor(int userId);

    /**
     * Hàm cập nhật thông tin user
     * @param user UserInfor thông tin user
     * @return true: update thành công / false: update thất bại
     */
    public boolean updateUser(UserInfor user);
}
