/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * UserLogic.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.dao.impl;
import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.UserDao;
import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.utils.Common;


/**
 * UserDao
 *
 * @author ntmhuong
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao{


	/* (non-Javadoc)
     * @see manageuser.dao.UserDao#getUserByLoginId(java.lang.String, java.lang.String)
     */
    public TblUser getUserByLoginId(String loginId, String password) {
    	TblUser tblUser = null;
        if (connectToDB()) {
            try {
                StringBuilder sqlCommand = new StringBuilder();
                /*
                // create SQL
                sqlCommand.append("SELECT u.* ");
                sqlCommand.append("FROM tbl_user AS u ");
                sqlCommand.append("WHERE ");
                //Start fix bug ID 133 - HaVH 2014/06/17
                sqlCommand.append("u.login_id = ?");
                sqlCommand.append(" AND ");
                sqlCommand.append("u.password = ?");

                preparedStatement = connection.prepareStatement(sqlCommand
                        .toString());
                // Biding values search to SQL
                preparedStatement.setString(1, loginId);
                preparedStatement.setString(2, password);
                //End fix bug ID 133 - HaVH 2014/06/17
                */

                sqlCommand.append("SELECT u.user_id, u.login_name, u.password, u.email, u.tel, u.full_name ");
                sqlCommand.append("FROM tbl_user AS u ");
                sqlCommand.append("WHERE ");
                //Start fix bug ID 133 - HaVH 2014/06/17
                sqlCommand.append("u.login_name = ?");
                sqlCommand.append(" AND ");
                sqlCommand.append("u.password = ?");

                preparedStatement = connection.prepareStatement(sqlCommand
                        .toString());
                //Biding values search to SQL
                preparedStatement.setString(1, loginId);
                preparedStatement.setString(2, password);

                // run SQL
                rs = preparedStatement.executeQuery();

                // read result from SQL
                if (rs != null) {
                    while (rs.next()) {
                        tblUser = new TblUser(rs.getInt("user_id"), rs
                                .getString("full_name"), rs.getString("email"),
                                rs.getString("tel"),rs.getString("login_name"), rs.getString("password"));
                    }
                    rs.close();
                }

            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            closeConnect();

        }
        return tblUser;
    }


    /* (non-Javadoc)
     * @see manageuser.dao.UserDao#getAllGroups()
     */
    public List<MstGroup> getAllGroups() {
        List<MstGroup> lsGroups = new ArrayList<MstGroup>();
        if (connectToDB()) {
            try {
                StringBuilder sqlCommand = new StringBuilder();
                sqlCommand.append("SELECT * FROM mst_group");
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
     * @see manageuser.dao.UserDao#getListUsers(manageuser.entities.TblUser, int, int)
     */
    public List<TblUser> getListUsers(TblUser user, int offset, int limit) {
        List<TblUser> lsUsers = new ArrayList<TblUser>();
        if (connectToDB()) {
            try {
                StringBuilder sqlCommand = new StringBuilder();
                String name = user.getFullName();
                //Start fix bug ID 132 - HaVH 2014/06/17
                String fullName = Common.escapeInjection(user.getFullName().trim());
                //End fix bug ID 132 - HaVH 2014/06/17
                int grpId = user.getGroupId();

                // create SQL
                sqlCommand.append("SELECT u.*, g.group_name as name ");
                sqlCommand.append("FROM tbl_user AS u ");
                sqlCommand.append("INNER JOIN mst_group AS g ");
                sqlCommand.append("ON u.group_id = g.group_id ");

                // Conditions search
                if (grpId > 0 && name.length() > 0) {
                    sqlCommand.append("WHERE ");
                    sqlCommand.append("u.group_id = " + grpId );
                    sqlCommand.append(" AND ");
                    //Start fix bug ID 127 - HaVH 2014/06/17
                    sqlCommand.append("u.full_name LIKE '%" + fullName + "%' ");
                    //End fix bug ID 127 - HaVH 2014/06/17
                } else {
                    if (grpId > 0) {
                        sqlCommand.append("WHERE ");
                        sqlCommand.append("u.group_id = " + grpId );
                    }
                    if (name.length() > 0) {
                        sqlCommand.append("WHERE ");
                        //Start fix bug ID 127 - HaVH 2014/06/17
                        sqlCommand.append("u.full_name LIKE '%" + fullName + "%' ");
                        //End fix bug ID 127 - HaVH 2014/06/17
                    }
                }

                // Order by full_name ASC
                sqlCommand.append(" ORDER BY u.full_name ASC ");
                sqlCommand.append("  LIMIT " + offset + " , " + limit);

                preparedStatement = connection.prepareStatement(sqlCommand
                        .toString());

                // run SQL
                rs = preparedStatement.executeQuery();

                // read result from SQL
                if (rs != null) {
                    while (rs.next()) {
                        TblUser tblUser = new TblUser(rs.getInt("user_id"), rs
                                .getString("full_name"), rs.getString("email"),
                                rs.getString("tel"), rs.getString("name"));
                        lsUsers.add(tblUser);
                    }
                    rs.close();
                }

            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            closeConnect();

        }
        return lsUsers;
    }


    /* (non-Javadoc)
     * @see manageuser.dao.UserDao#getTotalUsers(manageuser.entities.TblUser)
     */
    public int getTotalUsers(TblUser user) {
        int totalUsers = 0;
        if (connectToDB()) {
            try {
                StringBuilder sqlCommand = new StringBuilder();
                String name = user.getFullName();
                //Start fix bug ID 132 - HaVH 2014/06/17
                String fullName = Common.escapeInjection(user.getFullName().trim());
                //End fix bug ID 132 - HaVH 2014/06/17
                int grpId = user.getGroupId();

                // create SQL
                sqlCommand.append("SELECT count(*) AS total ");
                sqlCommand.append("FROM tbl_user AS u ");
                sqlCommand.append("INNER JOIN mst_group AS g ");
                sqlCommand.append("ON u.group_id = g.group_id ");

                // Conditions search
                if (grpId > 0 && name.length() > 0) {
                    sqlCommand.append("WHERE ");
                    sqlCommand.append("u.group_id = " + grpId);
                    sqlCommand.append(" AND ");
                    //Start fix bug ID 127 - HaVH 2014/06/17
                    sqlCommand.append("u.full_name LIKE '%" + fullName + "%' ");
                    //End fix bug ID 127 - HaVH 2014/06/17
                } else {
                    if (grpId > 0) {
                        sqlCommand.append("WHERE ");
                        sqlCommand.append("u.group_id = " + grpId);
                    }
                    if (name.length() > 0) {
                        sqlCommand.append("WHERE ");
                        //Start fix bug ID 127 - HaVH 2014/06/17
                        sqlCommand.append("u.full_name LIKE '%" + fullName + "%' ");
                        //End fix bug ID 127 - HaVH 2014/06/17
                    }
                }
                preparedStatement = connection.prepareStatement(sqlCommand
                        .toString());


                // run SQL
                rs = preparedStatement.executeQuery();

                // read result from SQL
                if (rs != null) {
                    while (rs.next()) {
                        totalUsers = rs.getInt("total");
                    }
                    rs.close();
                }

            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            closeConnect();

        }
        return totalUsers;
    }

}
