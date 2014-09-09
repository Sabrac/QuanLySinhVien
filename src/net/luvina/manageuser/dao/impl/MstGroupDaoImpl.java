/**
 * Copyright(C) 2014 Luvina
 *
 * MstGroupDaoImpl.java, Jun 26, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.MstGroupDao;
import net.luvina.manageuser.entities.MstGroup;

/**
 * Xử lý dữ liệu table MstGroup
 *
 * @author LA-PM
 *
 */
public class MstGroupDaoImpl extends BaseDaoImpl implements MstGroupDao {

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.MstGroupDao#getAllMstGroups()
	 */
	@Override
	public List<MstGroup> getAllMstGroups() {
		// TODO Auto-generated method stub
		List<MstGroup> lsGroups = new ArrayList<MstGroup>();
        if (connectToDB()) {
            try {
                StringBuilder sqlCommand = new StringBuilder();
                sqlCommand.append("SELECT g.group_id, g.group_name ");
                sqlCommand.append("FROM mst_group g ");
                // Order by id ASC
                sqlCommand.append(" ORDER BY group_id ASC ");
                preparedStatement = connection.prepareStatement(sqlCommand
                        .toString());
                // run SQL
                rs = preparedStatement.executeQuery();

                // read result from SQL
                if (rs != null) {
                    while (rs.next()) {
                        MstGroup group = new MstGroup(rs.getInt("group_id"), rs
                                .getString("group_name"));
                        lsGroups.add(group);
                    }
                    rs.close();
                }

            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            closeConnect();

        }
        return lsGroups;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.MstGroupDao#getGroupIdByName(java.lang.String)
	 */
	@Override
	public MstGroup getGroupByName(String groupName) {
		// TODO Auto-generated method stub
		MstGroup group = null;
		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT g.group_id, g.group_name ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_group g ");
				sqlCommand.append("WHERE group_name = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, groupName);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						group = new MstGroup(rs.getInt("group_id"),
							rs.getString("group_name"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return group;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.MstGroupDao#getGroupById(int)
	 */
	@Override
	public MstGroup getGroupById(int groupId) {
		// TODO Auto-generated method stub
		MstGroup group = null;
		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT g.group_id, g.group_name ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_group g ");
				sqlCommand.append("WHERE g.group_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, groupId);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						group = new MstGroup(rs.getInt("group_id"),
							rs.getString("group_name"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return group;
	}

	@Override
	public String getGroupNameById(int groupId) {
		// TODO Auto-generated method stub
		String groupName = "";

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT g.group_name ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_group g ");
				sqlCommand.append("WHERE g.group_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, groupId);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						groupName = rs.getString("group_name");
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return groupName;
	}

}
