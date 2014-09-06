/**
 * Copyright(C) K16SE 2014
 *
 * NganhDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.List;

import managestudent.dao.NganhDao;
import managestudent.entities.Nganh;

/**
 *
 * @author HaVH
 *
 */
public class NganhDaoImpl extends BaseDaoImpl implements NganhDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#addNganh(managestudent.entities.Nganh)
	 */
	@Override
	public boolean addNganh(Nganh nganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO nganh ");
				sqlCommand.append("(manganh, tennganh, ghichu) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, nganh.getMaNganh());
				preparedStatement.setString(2, nganh.getTenNganh());
				preparedStatement.setString(3, nganh.getGhiChu());
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
	 * @see managestudent.dao.NganhDao#deleteNganhByMaNganh(java.lang.String)
	 */
	@Override
	public boolean deleteNganhByMaNganh(String maNganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM nganh ");
				sqlCommand.append("WHERE manganh = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maNganh);
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
	 * @see managestudent.dao.NganhDao#getAllNganh()
	 */
	@Override
	public List<Nganh> getAllNganh() {
		List<Nganh> lsNganh = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT nganh_id, manganh, tennganh, ghichu ");
				sqlCommand.append("FROM nganh ");
				sqlCommand.append("ORDER BY manganh ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						Nganh nganh = new Nganh(rs.getInt("nganh_id"), rs.getString("manganh"), rs.getString("tennganh"), rs.getString("ghichu"));

						lsNganh.add(nganh);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsNganh = null;
			}
			closeConnect();
		}

		return lsNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#getNganhByMaNganh(java.lang.String)
	 */
	@Override
	public Nganh getNganhByMaNganh(String maNganh) {
		Nganh nganh = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT nganh_id, manganh, tennganh, ghichu ");
				sqlCommand.append("FROM nganh ");
				sqlCommand.append("WHERE manganh = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maNganh);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						nganh = new Nganh(rs.getInt("nganh_id"), rs.getString("manganh"), rs.getString("tennganh"), rs.getString("ghichu"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				nganh = null;
			}
			closeConnect();
		}

		return nganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.NganhDao#updateNganhByMaNganh(java.lang.String, managestudent.entities.Nganh)
	 */
	@Override
	public boolean updateNganhByMaNganh(String maNganh, Nganh nganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE nganh ");
				sqlCommand.append("SET manganh = ?, tennganh = ?, ghichu = ? ");
				sqlCommand.append("WHERE manganh = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, nganh.getMaNganh());
				preparedStatement.setString(2, nganh.getTenNganh());
				preparedStatement.setString(3, nganh.getGhiChu());
				preparedStatement.setString(4, maNganh);
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
