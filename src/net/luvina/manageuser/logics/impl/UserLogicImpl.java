/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * UserLogic.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.logics.impl;

import java.util.List;

import net.luvina.manageuser.dao.impl.TblUserDaoImpl;
import net.luvina.manageuser.dao.impl.UserDaoImpl;
import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.logics.UserLogic;


/**
 * UserLogic
 *
 * @author ntmhuong
 *
 */
public class UserLogicImpl implements UserLogic{



    /* (non-Javadoc)
     * @see manageuser.logics.UserLogic#existLoginId(java.lang.String, java.lang.String)
     */
    public Boolean existLoginId(String loginId, String password) {
    	TblUserDaoImpl userDao = new TblUserDaoImpl();
        int count = userDao.getUserByLoginId(loginId, password);
        Boolean result = false;
        if(count > 0) {
        	result = true;
        }
        return result;
    }


    /* (non-Javadoc)
     * @see manageuser.logics.UserLogic#getAllGroups()
     */
    public List<MstGroup> getAllGroups() {
        UserDaoImpl userDao = new UserDaoImpl();
        List<MstGroup> lsGroups = userDao.getAllGroups();
        return lsGroups;
    }


    /* (non-Javadoc)
     * @see manageuser.logics.UserLogic#getListUsers(manageuser.entities.TblUser, int, int)
     */
    public List<TblUser> getListUsers(TblUser tblUser, int offset, int limit) {
        UserDaoImpl userDao = new UserDaoImpl();
        List<TblUser> lsUsers = userDao.getListUsers(tblUser, offset, limit);
        return lsUsers;
    }


    /* (non-Javadoc)
     * @see manageuser.logics.UserLogic#getTotalUsers(manageuser.entities.TblUser)
     */
    public int getTotalUsers(TblUser tblUser) {
        UserDaoImpl userDao = new UserDaoImpl();
        int totalUsers = userDao.getTotalUsers(tblUser);
        return totalUsers;
    }

}
