/**
 * Copyright(C) 2014 Luvina
 *
 * TblUserLogicImpl.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.logics.impl;

import java.util.List;

import net.luvina.manageuser.dao.impl.TblDetailUserJapanDaoImpl;
import net.luvina.manageuser.dao.impl.TblUserDaoImpl;
import net.luvina.manageuser.dao.impl.UserDaoImpl;
import net.luvina.manageuser.entities.TblDetailUserJapan;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.TblUserLogic;

/**
 * Xử lý login TblUser
 *
 * @author LA-PM
 *
 */
public class TblUserLogicImpl implements TblUserLogic {

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#getListUsers(int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<UserInfor> getListUsers(int offset, int limit, int groupId,
			String fullName, String sortType, String sortByFullName,
			String sortByCodeLevel, String sortByEndDate) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		List<UserInfor> lsUser = userDao.getListUsers(offset, limit, groupId, fullName, sortType, sortByFullName, sortByCodeLevel, sortByEndDate);
		return lsUser;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#getTotalRecordṣ(int, java.lang.String)
	 */
	@Override
	public int getTotalRecordṣ(int groupId, String fullName) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		int total = userDao.getTotalUsers(groupId, fullName);
		return total;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#existLoginId(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existLoginId(String loginId, String password) {
    	TblUserDaoImpl userDao = new TblUserDaoImpl();
        int count = userDao.getUserByLoginId(loginId, password);
        boolean result = false;
        if(count > 0) {
        	result = true;
        }
        return result;
    }

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#existLoginName(java.lang.String)
	 */
	@Override
	public boolean existLoginName(String loginId) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		int count = userDao.countUserByLoginName(loginId);
		boolean result = false;
		if (count > 0) {
			result = true;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#existEmail(java.lang.String)
	 */
	@Override
	public boolean existEmail(String email) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		int count = userDao.countUserByEmail(email);
		boolean result = false;
		if (count > 0) {
			result = true;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#createUser(net.luvina.manageuser.entities.UserInfor)
	 */
	@Override
	public boolean createUser(UserInfor user) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		boolean result = userDao.insertUser(user);
		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#getUserInfor(int)
	 */
	@Override
	public UserInfor getUserInfor(int userId) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		UserInfor user = userDao.getUserInfor(userId);

		if (user != null) {
			TblDetailUserJapanDaoImpl detailUserDao = new TblDetailUserJapanDaoImpl();
			TblDetailUserJapan detailUser = detailUserDao.getDetailUserJapan(userId);

			if (detailUser != null) {
				user.setCodeLevel(detailUser.getCode());
				user.setNameLevel(detailUser.getName());
				user.setStartDate(detailUser.getStart_date());
				user.setEndDate(detailUser.getEnd_date());
				user.setPointString(detailUser.getTotal() + "");
			} else {
				user.setCodeLevel("-1");
			}
		}

		return user;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.TblUserLogic#updateUser(net.luvina.manageuser.entities.UserInfor)
	 */
	@Override
	public boolean updateUser(UserInfor user) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		boolean result = userDao.updateUser(user);
		return result;
	}

}
