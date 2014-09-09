/**
 * Copyright(C) 2014 Luvina
 *
 * MstJapanDaoImpl.java, Jul 4, 2014 LA-PM
 *
 */
package net.luvina.manageuser.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.MstJapanDao;
import net.luvina.manageuser.entities.MstJapan;

/**
 * Implement MstJapanDao
 *
 * @author LA-PM
 *
 */
public class MstJapanDaoImpl extends BaseDaoImpl implements MstJapanDao {

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.MstJapanDao#getAllMstJapan()
	 */
	@Override
	public List<MstJapan> getAllMstJapan() {
		// TODO Auto-generated method stub
		List<MstJapan> lsJapan = new ArrayList<MstJapan>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT j.code_level, j.name_level ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_japan j ");
				sqlCommand.append("ORDER BY ");
				sqlCommand.append("code_level");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						MstJapan japan = new MstJapan(rs.getString("code_level"),
								rs.getString("name_level"));
						lsJapan.add(japan);
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return lsJapan;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.MstJapanDao#checkJapanExist()
	 */
	@Override
	public boolean checkJapanExist(String name_level) {
		// TODO Auto-generated method stub
		boolean result = false;
		int count = 0;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT COUNT(*) AS total ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_japan j ");
				sqlCommand.append("WHERE name_level = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, name_level);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						count = rs.getInt("total");
					}
					rs.close();
				}

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.dao.MstJapanDao#getJapanByCode(java.lang.String)
	 */
	@Override
	public MstJapan getJapanByCode(String codeLevel) {
		// TODO Auto-generated method stub
		MstJapan japan = null;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT j.code_level, j.name_level ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_japan j ");
				sqlCommand.append("WHERE code_level = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, codeLevel);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						japan = new MstJapan(rs.getString("code_level"),
								rs.getString("name_level"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return japan;
	}

	@Override
	public String getNameLevelByCode(String codeLevel) {
		// TODO Auto-generated method stub
		String nameLevel = "";

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT j.name_level ");
				sqlCommand.append("FROM ");
				sqlCommand.append("mst_japan j ");
				sqlCommand.append("WHERE code_level = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, codeLevel);

				rs = preparedStatement.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						nameLevel = rs.getString("name_level");
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("an exception occur: " + e.getMessage());
			}
		}
		closeConnect();

		return nameLevel;
	}

}
