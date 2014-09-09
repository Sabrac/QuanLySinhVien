/**
 * Copyright(C) 2014
 *
 * TblDetailUserJapanDaoImpl.java, Jul 10, 2014 HaVH
 *
 */
package net.luvina.manageuser.dao.impl;

import java.sql.Date;
import java.sql.SQLException;

import net.luvina.manageuser.dao.TblDetailUserJapanDao;
import net.luvina.manageuser.entities.TblDetailUserJapan;

/**
 * Implement tblDetailUserJapan
 * @author HaVH
 *
 */
public class TblDetailUserJapanDaoImpl extends BaseDaoImpl implements TblDetailUserJapanDao {

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblDetailUserJapanDao#insertDetailUserJapan(net.luvina.manageuser.entities.TblDetailUserJapan)
	 */
	@Override
	public boolean insertDetailUserJapan(TblDetailUserJapan detailJapan) {
		boolean result = false;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("INSERT INTO tbl_detail_user_japan (user_id, code_level, start_date, end_date, total) ");
				sqlCommand.append("VALUES(?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, detailJapan.getUserID());
				preparedStatement.setString(2, detailJapan.getCode());
				preparedStatement.setDate(3, new Date(detailJapan.getStart_date().getTime()));
				preparedStatement.setDate(4, new Date(detailJapan.getEnd_date().getTime()));
				preparedStatement.setInt(5, detailJapan.getTotal());

				int res = preparedStatement.executeUpdate();
				if (res > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.TblDetailUserJapanDao#getDetailUserJapan(int)
	 */
	@Override
	public TblDetailUserJapan getDetailUserJapan(int userId) {
		TblDetailUserJapan userDetail = null;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT d.code_level, j.name_level, d.start_date, d.end_date, d.total ");
				sqlCommand.append("FROM mst_japan j ");
				sqlCommand.append("RIGHT JOIN tbl_detail_user_japan d ");
				sqlCommand.append("ON d.code_level = j.code_level ");
				sqlCommand.append("WHERE d.user_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, userId);
				rs = preparedStatement.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						userDetail = new TblDetailUserJapan();
						userDetail.setCode(rs.getString("code_level"));
						userDetail.setName(rs.getString("name_level"));
						userDetail.setStart_date(rs.getDate("start_date"));
						userDetail.setEnd_date(rs.getDate("end_date"));
						userDetail.setTotal(rs.getInt("total"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("an exception occur: " + e.getMessage());
				userDetail = null;
			}
		}
		closeConnect();

		return userDetail;
	}

}
