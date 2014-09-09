/**
 * Copyright(C) 2014 Luvina
 *
 * MstGroupLogicImpl.java, Jun 26, 2014 LA-PM
 *
 */
package net.luvina.manageuser.logics.impl;

import java.util.List;

import net.luvina.manageuser.dao.impl.MstGroupDaoImpl;
import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.logics.MstGroupLogic;

/**
 * Xử lý logic group
 *
 * @author LA-PM
 *
 */
public class MstGroupLogicImpl implements MstGroupLogic {

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.MstGroupLogic#getAllGroups()
	 */
	@Override
	public List<MstGroup> getAllGroups() {
		// TODO Auto-generated method stub
		MstGroupDaoImpl groupDao = new MstGroupDaoImpl();
        List<MstGroup> lsGroups = groupDao.getAllMstGroups();
        return lsGroups;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.MstGroupLogic#getGroupByName(java.lang.String)
	 */
	@Override
	public MstGroup getGroupByName(String groupName) {
		// TODO Auto-generated method stub
		MstGroupDaoImpl groupDao = new MstGroupDaoImpl();
		MstGroup group = groupDao.getGroupByName(groupName);
		return group;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.MstGroupLogic#getGroupById(java.lang.String)
	 */
	@Override
	public MstGroup getGroupById(int groupId) {
		// TODO Auto-generated method stub
		MstGroupDaoImpl groupDao = new MstGroupDaoImpl();
		MstGroup group = groupDao.getGroupById(groupId);
		return group;
	}

	@Override
	public String getGroupNameById(int groupId) {
		// TODO Auto-generated method stub
		MstGroupDaoImpl groupDao = new MstGroupDaoImpl();
		String groupName = groupDao.getGroupNameById(groupId);
		return groupName;
	}

}
