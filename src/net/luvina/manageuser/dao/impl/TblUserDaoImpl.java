/**
 * Copyright(C) 2014 Luvina
 *
 * TblUserDaoImpl.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.TblUserDao;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.utils.Common;

/**
 * Xử lý data cho tabl TblUser
 *
 * @author LA-PM
 *
 */
public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao {

	/*
	 * (non-Javadoc)
	 *
	 * @see net.luvina.manageuser.dao.tblUserDao#getListUsers(int, int, int,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<UserInfor> getListUsers(int offset, int limit, int groupID,
			String fullName, String sortType, String sortByFullName,
			String sortByCodeLevel, String sortByEndDate) {
		List<UserInfor> lsUser = new ArrayList<UserInfor>();
		UserInfor user = null;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT u.user_id, u.full_name, u.birthday, g.group_name, u.email, u.tel, j.name_level, d.end_date, d.total ");
				sqlCommand.append("FROM tbl_user u ");
				sqlCommand.append("JOIN mst_group g ON u.group_id = g.group_id ");
				sqlCommand.append("LEFT JOIN tbl_detail_user_japan d ON d.user_id = u.user_id ");
				sqlCommand.append("LEFT JOIN mst_japan j ON j.code_level = d.code_level ");

				if (fullName != null && fullName.trim().length() > 0 && groupID > 0) {
					sqlCommand.append("WHERE ");
					sqlCommand.append("u.group_id = ?");
					sqlCommand.append(" AND u.full_name LIKE ? ");
//					sqlCommand.append("u.group_id = " + groupID);
//					sqlCommand.append(" AND u.full_name LIKE '%" + fullName + "%' ");
				} else if (groupID > 0) {
					sqlCommand.append("WHERE ");
					sqlCommand.append("u.group_id = ?");
//					sqlCommand.append("u.group_id = " + groupID);
				} else if (fullName.trim().length() > 0)  {
					sqlCommand.append("WHERE ");
					sqlCommand.append("u.full_name LIKE ? ");
//					sqlCommand.append(" u.full_name LIKE '%" + fullName + "%' ");
				}

				if (sortType == null) {
					sqlCommand.append(" ORDER BY u.full_name ASC, j.code_level DESC, d.end_date DESC ");
					sqlCommand.append("LIMIT " + offset + ", " + limit);
				} else {
					if ("DESC".equalsIgnoreCase(sortByFullName)) {
						sqlCommand.append(" ORDER BY u.full_name DESC ");
					} else if ("ASC".equalsIgnoreCase(sortByCodeLevel)) {
						sqlCommand.append(" ORDER BY j.code_level ASC ");
					} else if ("DESC".equalsIgnoreCase(sortByCodeLevel)) {
						sqlCommand.append(" ORDER BY j.code_level DESC ");
					} else if ("ASC".equalsIgnoreCase(sortByEndDate)) {
						sqlCommand.append(" ORDER BY d.end_date ASC ");
					} else if ("DESC".equalsIgnoreCase(sortByEndDate)) {
						sqlCommand.append(" ORDER BY d.end_date DESC ");
					}  else {
						sqlCommand.append(" ORDER BY u.full_name ASC, j.code_level DESC, d.end_date DESC ");
					}
					sqlCommand.append("LIMIT " + offset + ", " + limit);
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				int paramCount = preparedStatement.getParameterMetaData().getParameterCount();
				if (paramCount > 1) {
					preparedStatement.setInt(1, groupID);
					preparedStatement.setString(2, "%" + fullName + "%");
				} else if (paramCount > 0) {
					if (sqlCommand.indexOf("WHERE u.group_id =") > 0) {
						preparedStatement.setInt(1, groupID);
					} else {
						preparedStatement.setString(1, "%" + fullName + "%");
					}
				}

				rs = preparedStatement.executeQuery();
				int i = 1;

				if(rs != null) {
					while (rs.next()) {
						i = 1;
						user = new UserInfor(rs.getInt(i++), rs.getString(i++),
								rs.getDate(i++), rs.getString(i++), rs.getString(i++),
								rs.getString(i++), rs.getString(i++), rs.getDate(i++),
								rs.getInt(i));
						lsUser.add(user);
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			} catch (Exception ex) {
				System.out.println("an exception occur: " + ex.getMessage());
			}

			closeConnect();
		}
		return lsUser;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.luvina.manageuser.dao.tblUserDao#getTotalUsers(int,
	 * java.lang.String)
	 */
	@Override
	public int getTotalUsers(int groupId, String fullName) {
		int total = 0;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT COUNT(*) AS total ");
				sqlCommand.append("FROM tbl_user u ");
				if (fullName != null && fullName.trim().length() > 0 && groupId > 0) {
					sqlCommand.append("WHERE ");
					sqlCommand.append("u.group_id = ?");
					sqlCommand.append(" AND u.full_name LIKE ? ");
//					sqlCommand.append("u.group_id = " + groupId);
//					sqlCommand.append(" AND u.full_name LIKE '%" + fullName + "%' ");
				} else if (groupId > 0) {
					sqlCommand.append("WHERE ");
//					sqlCommand.append("u.group_id = " + groupId);
					sqlCommand.append("u.group_id = ? ");
				} else if (fullName.trim().length() > 0) {
					sqlCommand.append("WHERE ");
//					sqlCommand.append("u.full_name LIKE '%" + fullName + "%' ");
					sqlCommand.append("u.full_name LIKE ? ");
				}

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				int paramCount = preparedStatement.getParameterMetaData().getParameterCount();
				if (paramCount > 1) {
					preparedStatement.setInt(1, groupId);
					preparedStatement.setString(2, "%" + fullName + "%");
				} else if (paramCount > 0) {
					if (sqlCommand.indexOf("WHERE u.group_id =") > 0) {
						preparedStatement.setInt(1, groupId);
					} else {
						preparedStatement.setString(1, "%" + fullName + "%");
					}
				}

				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						total = rs.getInt(1);
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			} catch (Exception ex) {
				System.out.println("an exception occur: " + ex.getMessage());
			}
			closeConnect();
		}

		return total;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#getUserByLoginId(java.lang.String, java.lang.String)
	 */
	@Override
	public int getUserByLoginId(String loginId, String password) {
		int count = 0;
        if (connectToDB()) {
            try {
                StringBuilder sqlCommand = new StringBuilder();

                sqlCommand.append("SELECT COUNT(*) AS total ");
                sqlCommand.append("FROM tbl_user AS u ");
                sqlCommand.append("WHERE ");
                sqlCommand.append("u.login_name = ?");
                sqlCommand.append(" AND ");
                sqlCommand.append("u.password = ?");

                preparedStatement = connection.prepareStatement(sqlCommand
                        .toString());
                //Biding values search to SQL
                preparedStatement.setString(1, loginId);
                preparedStatement.setString(2, Common.endcodeString(password));

                // run SQL
                rs = preparedStatement.executeQuery();

                // read result from SQL
                if (rs != null) {
                    while (rs.next()) {
                        count = rs.getInt("total");
                    }
                    rs.close();
                }

            } catch (Exception e) {
                System.out.println("an exception occur: " + e.getMessage());
            }
            closeConnect();

        }
        return count;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#getUserByLoginName(java.lang.String)
	 */
	@Override
	public int countUserByLoginName(String loginId) {
		int count = 0;
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT COUNT(*) AS total ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("WHERE ");
				sqlCommand.append("u.login_name = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, loginId);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						count = rs.getInt("total");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return count;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#countUserByEmail(java.lang.String)
	 */
	@Override
	public int countUserByEmail(String email) {
		int count = 0;
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT COUNT(*) AS total ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("WHERE ");
				sqlCommand.append("u.email = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, email);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						count = rs.getInt("total");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return count;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#insertUser(net.luvina.manageuser.entities.UserInfor)
	 */
	@Override
	public boolean insertUser(UserInfor user) {
		boolean result = false;
		int userId = getCurrentUserId();

		if (connectToDB()) {
			try {
				user.setID(userId + 1);
				//insert into tbl_user
				connection.setAutoCommit(false);
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("INSERT INTO tbl_user(user_id, group_id, login_name, `password`, full_name, full_name_kana, email, tel, birthday) ");
				sqlCommand.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, user.getID());
				preparedStatement.setInt(2, user.getGroupId());
				preparedStatement.setString(3, user.getLoginName());
				preparedStatement.setString(4, Common.endcodeString(user.getPass()));
				preparedStatement.setString(5, user.getFullName());
				preparedStatement.setString(6, user.getKanaName());
				preparedStatement.setString(7, user.getEmail());
				preparedStatement.setString(8, user.getTel());
				preparedStatement.setDate(9, new Date(user.getBirth().getTime()));

				int res = preparedStatement.executeUpdate();
				if (res > 0) {
					result = true;

					//insert into detail user japan table
					if (!"-1".equals(user.getCodeLevel())) {
						sqlCommand = new StringBuilder();
						sqlCommand.append("INSERT INTO tbl_detail_user_japan(user_id, code_level, start_date, end_date, total) ");
						sqlCommand.append("VALUES (?, ?, ?, ?, ?)");

						preparedStatement = connection.prepareStatement(sqlCommand.toString());
						preparedStatement.setInt(1, user.getID());
						preparedStatement.setString(2, user.getCodeLevel());
						preparedStatement.setDate(3, new Date(user.getStartDate().getTime()));
						preparedStatement.setDate(4, new Date(user.getEndDate().getTime()));
						preparedStatement.setInt(5, Integer.parseInt(user.getPointString()));

						res = preparedStatement.executeUpdate();
						if (res <= 0) {
							connection.rollback();
							result = false;
						}
					}
				}
				connection.commit();
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("an exception occur: " + e1.getMessage());
				}
				result = false;
			} catch (NullPointerException npe) {
				System.out.println("an exception occur: " + npe.getMessage());
				result = false;
			}
		}
		closeConnect();

		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#deleteUserById(int)
	 */
	@Override
	public boolean deleteUserById(int id) {
		boolean result = false;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("DELETE FROM ");
				sqlCommand.append("tbl_user ");
				sqlCommand.append("WHERE user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, id);

				int res = preparedStatement.executeUpdate();
				if (res > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return false;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#getCurrentUserId()
	 */
	@Override
	public int getCurrentUserId() {
		int userId = -1;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT MAX(user_id) AS max ");
				sqlCommand.append("FROM tbl_user");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						userId = rs.getInt("max");
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return userId;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#getUserInfor(int)
	 */
	@Override
	public UserInfor getUserInfor(int userId) {
		UserInfor user = null;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT u.user_id, u.group_id, g.group_name, u.login_name, ");
				sqlCommand.append("u.full_name, u.full_name_kana, u.email, ");
				sqlCommand.append("u.tel, u.birthday ");
				sqlCommand.append("FROM mst_group g ");
				sqlCommand.append("JOIN tbl_user u ON g.group_id = u.group_id ");
				sqlCommand.append("WHERE u.user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, userId);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						user = new UserInfor();
						user.setID(rs.getInt("user_id"));
						user.setGroupId(rs.getInt("group_id"));
						user.setGroupName(rs.getString("group_name"));
						user.setLoginName(rs.getString("login_name"));
						user.setFullName(rs.getString("full_name"));
						user.setKanaName(rs.getString("full_name_kana"));
						user.setEmail(rs.getString("email"));
						user.setTel(rs.getString("tel"));
						user.setBirth(rs.getDate("birthday"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
				user = null;
			}
		}
		closeConnect();

		return user;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblUserDao#updateUser(int)
	 */
	@Override
	public boolean updateUser(UserInfor user) {
		boolean result = false;

		if (connectToDB()) {
			try {
				connection.setAutoCommit(false);
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("UPDATE tbl_user ");
				sqlCommand.append("SET group_id = ?, login_name = ?, full_name = ?, ");
				sqlCommand.append("full_name_kana = ?, email = ?, tel = ?, birthday = ? ");
				sqlCommand.append("WHERE user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, user.getID());
				preparedStatement.setString(2, user.getLoginName());
				preparedStatement.setString(3, user.getFullName());
				preparedStatement.setString(4, user.getKanaName());
				preparedStatement.setString(5, user.getEmail());
				preparedStatement.setString(6, user.getTel());
				preparedStatement.setDate(7, new Date(user.getBirth().getTime()));
				preparedStatement.setInt(8, user.getID());

				int count = preparedStatement.executeUpdate();
				if (count > 0) {
					result = true;
					if (!"-1".equals(user.getCodeLevel()) || !user.getCodeLevel().trim().isEmpty()) {
						sqlCommand = new StringBuilder();
						sqlCommand.append("UPDATE tbl_detail_user_japan ");
						sqlCommand.append("SET code_level = ?, start_date = ?, end_date = ?, total = ? ");
						sqlCommand.append("WHERE user_id = ?");

						preparedStatement = connection.prepareStatement(sqlCommand.toString());
						preparedStatement.setString(1, user.getCodeLevel());
						preparedStatement.setDate(2, new Date(user.getStartDate().getTime()));
						preparedStatement.setDate(3, new Date(user.getEndDate().getTime()));
						preparedStatement.setInt(4, Integer.parseInt(user.getPointString()));
						preparedStatement.setInt(5, user.getID());

						count = preparedStatement.executeUpdate();
						if (count <= 0) {
							result = false;
							connection.rollback();
						}
					}
				}
				connection.commit();
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("an exception occur: " + e1.getMessage());
				}
				result = false;
			}
		}
		closeConnect();

		return result;
	}
}
