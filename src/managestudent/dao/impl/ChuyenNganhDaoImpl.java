/**
 * Copyright(C) K16SE 2014
 *
 * ChuyenNganhDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.List;

import managestudent.dao.ChuyenNganhDao;
import managestudent.entities.ChuyenNganh;

/**
 *
 * @author HaVH
 *
 */
public class ChuyenNganhDaoImpl extends BaseDaoImpl implements ChuyenNganhDao {

	/*
	 * (non-Javadoc)
	 *
	 * @see managestudent.dao.ChuyenNganhDao#getAllChuyenNganh()
	 */
	@Override
	public List<ChuyenNganh> getAllChuyenNganh() {
		List<ChuyenNganh> lsChuyenNganh = null;

		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand
						.append("SELECT chuyennganh_id, ma_cn, ten_cn, nganh_id ");
				sqlCommand.append("FROM chuyennganh ");
				sqlCommand.append("ORDER BY ma_cn ASC");

				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				rs = preparedStatement.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						ChuyenNganh cn = new ChuyenNganh(
								rs.getInt("chuyennganh_id"),
								rs.getString("ma_cn"),
								rs.getString("ten_cn"),
								rs.getInt("nganh_id"));

						lsChuyenNganh.add(cn);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsChuyenNganh = null;
			}
			closeConnect();
		}

		return lsChuyenNganh;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * managestudent.dao.ChuyenNganhDao#getChuyenNganhByMaCN(java.lang.String)
	 */
	@Override
	public ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh) {
		ChuyenNganh cn = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT chuyennganh_id, ma_cn, ten_cn, nganh_id ");
				sqlCommand.append("FROM chuyennganh ");
				sqlCommand.append("WHERE ma_cn = ? ");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maChuyenNganh);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						cn = new ChuyenNganh();
						cn.setChuyenNganhId(rs.getInt("chuyennganh_id"));
						cn.setMaChuyenNganh(rs.getString("ma_cn"));
						cn.setTenChuyenNganh(rs.getString("ten_cn"));
						cn.setNganhId(rs.getInt("nganh_id"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				cn = null;
			}
			closeConnect();
		}

		return cn;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see managestudent.dao.ChuyenNganhDao#getChuyenNganhByNganhId(int)
	 */
	@Override
	public List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId) {
		List<ChuyenNganh> lsChuyenNganh = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT chuyennganh_id, ma_cn, ten_cn, nganh_id ");
				sqlCommand.append("FROM chuyennganh ");
				sqlCommand.append("WHERE nganh_id = ? ");
				sqlCommand.append("ORDER BY ma_cn ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, nganhId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						ChuyenNganh cn = new ChuyenNganh(
								rs.getInt("chuyennganh_id"),
								rs.getString("ma_cn"),
								rs.getString("ten_cn"),
								rs.getInt("nganh_id"));

						lsChuyenNganh.add(cn);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsChuyenNganh = null;
			}
			closeConnect();
		}

		return lsChuyenNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.ChuyenNganhDao#addChuyenNganh(managestudent.entities.ChuyenNganh)
	 */
	@Override
	public boolean addChuyenNganh(ChuyenNganh cn) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO chuyennganh ");
				sqlCommand.append("(ma_cn, ten_cn, nganh_id) VALUES ");
				sqlCommand.append("(?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, cn.getMaChuyenNganh());
				preparedStatement.setString(2, cn.getTenChuyenNganh());
				preparedStatement.setInt(3, cn.getNganhId());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.ChuyenNganhDao#deleteChuyenNganhByMaChuyenNganh(managestudent.entities.ChuyenNganh)
	 */
	@Override
	public boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM chuyennganh ");
				sqlCommand.append("WHERE ma_cn = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maChuyenNganh);
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.ChuyenNganhDao#updateChuyenNganhByMaChuyenNganh(managestudent.entities.ChuyenNganh)
	 */
	@Override
	public boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE chuyennganh SET ");
				sqlCommand.append("ten_cn = ?, nganh_id = ? ");
				sqlCommand.append("WHERE ma_cn = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, cn.getTenChuyenNganh());
				preparedStatement.setInt(2, cn.getNganhId());
				preparedStatement.setString(3, cn.getMaChuyenNganh());
				int count = preparedStatement.executeUpdate();

				if(count > 0) {
					result = true;
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				result = false;
			}
			closeConnect();
		}

		return result;
	}

}
