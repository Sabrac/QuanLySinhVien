/**
 * Copyright(C) K16SE 2014
 *
 * HocKyDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.HocKyDao;
import managestudent.entities.HocKy;

/**
 *
 * @author HaVH
 *
 */
public class HocKyDaoImpl extends BaseDaoImpl implements HocKyDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#addHocKy(managestudent.entities.HocKy)
	 */
	@Override
	public boolean addHocKy(HocKy hocKy) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO hocky ");
				sqlCommand.append("(tenhocky) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hocKy.getTenHocKy());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#deleteHocKyById(int)
	 */
	@Override
	public boolean deleteHocKyById(int hocKyId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM hocky ");
				sqlCommand.append("WHERE hocky_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, hocKyId);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#getAllHocKy()
	 */
	@Override
	public List<HocKy> getAllHocKy() {
		List<HocKy> lsHocKy = new ArrayList<HocKy>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hocky_id, tenhocky ");
				sqlCommand.append("FROM hocky ");
				sqlCommand.append("ORDER BY hocky_id");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						HocKy hocKy = new HocKy(rs.getInt("hocky_id"), rs.getString("tenhocky"));

						lsHocKy.add(hocKy);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsHocKy = null;
			}
			closeConnect();
		}

		return lsHocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#getHocKyById(int)
	 */
	@Override
	public HocKy getHocKyById(int hocKyId) {
		HocKy hocKy = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hocky_id, tenhocky ");
				sqlCommand.append("FROM hocky ");
				sqlCommand.append("WHERE hocky_id = ? ");
				sqlCommand.append("ORDER BY hocky_id");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, hocKyId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						hocKy = new HocKy(rs.getInt("hocKy_id"), rs.getString("tenhocky"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				hocKy = null;
			}
			closeConnect();
		}

		return hocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HocKyDao#updateHocKyById(int, managestudent.entities.HocKy)
	 */
	@Override
	public boolean updateHocKyById(int hocKyId, HocKy hocKy) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE hocky ");
				sqlCommand.append("SET tenhocky = ? ");
				sqlCommand.append("WHERE hocky_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hocKy.getTenHocKy());
				preparedStatement.setInt(2, hocKyId);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

}
