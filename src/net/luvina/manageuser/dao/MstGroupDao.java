/**
 * Copyright(C) 2014 Luvina
 *
 * MstGroupDao.java, Jun 26, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao;

import java.util.List;

import net.luvina.manageuser.entities.MstGroup;

/**
 * MstGroupDao
 *
 * @author LA-PM
 *
 */
public interface MstGroupDao extends BaseDao {
	/**
	 * Lấy danh sách các nhóm trong db
	 * @return danh sách các nhóm
	 */
	public List<MstGroup> getAllMstGroups();

	/**
	 * Lấy group bằng tên group
	 * @param groupName tên group
	 * @return group
	 */
	public MstGroup getGroupByName(String groupName);

	/**
	 * Lấy group bằng group id
	 * @param groupId
	 * @return group
	 */
	public MstGroup getGroupById(int groupId);

	/**
	 *Lấy group name bằng id
	 * @param groupId
	 * @return tên group
	 */
	public String getGroupNameById(int groupId);
}
