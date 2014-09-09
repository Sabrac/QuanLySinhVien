/**
 * Copyright(C) 2014 Luvina
 *
 * MstGroupLogic.java, Jun 26, 2014 LA-PM
 *
 */
package net.luvina.manageuser.logics;

import java.util.List;

import net.luvina.manageuser.entities.MstGroup;

/**
 * MstGroupLogic.java
 *
 * @author LA-PM
 *
 */
public interface MstGroupLogic {
	/**
	 * Lấy danh sách các group
	 * @return List<MstGroup> danh sách group
	 */
	public List<MstGroup> getAllGroups();

	/**
	 * Lấy đối tượng group bằng tên group
	 * @param groupName tên group
	 * @return đối tượng mstGroup
	 */
	public MstGroup getGroupByName(String groupName);

	/**
	 * Lấy đối tượng group bằng id group
	 * @param groupId id group
	 * @return đối tượng mstGroup
	 */
	public MstGroup getGroupById(int groupId);

	/**
	 * Lấy group name bằng Id
	 * @param groupId
	 * @return tên group
	 */
	public String getGroupNameById(int groupId);
}
