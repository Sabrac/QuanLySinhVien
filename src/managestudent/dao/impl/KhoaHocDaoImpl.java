/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHocDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.KhoaHocDao;
import managestudent.entities.KhoaHoc;

/**
 *
 * @author HaVH
 *
 */
public class KhoaHocDaoImpl extends BaseDaoImpl implements KhoaHocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.KhoaHocDao#addKhoaHoc(managestudent.entities.KhoaHoc)
	 */
	@Override
	public boolean addKhoaHoc(KhoaHoc khoaHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO khoahoc ");
				sqlCommand.append("(tenkhoahoc) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?) ");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, khoaHoc.getTenKhoaHoc());
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
	 * @see managestudent.dao.KhoaHocDao#deleteKhoaHocById(int)
	 */
	@Override
	public boolean deleteKhoaHocById(int khoaHocId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM khoahoc ");
				sqlCommand.append("WHERE khoaHocId = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, khoaHocId);
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
	 * @see managestudent.dao.KhoaHocDao#getAllKhoaHoc()
	 */
	@Override
	public List<KhoaHoc> getAllKhoaHoc() {
		List<KhoaHoc> lsKhoaHoc = new ArrayList<KhoaHoc>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT khoahoc_id, tenkhoahoc ");
				sqlCommand.append("FROM khoahoc ");
				sqlCommand.append("ORDER BY khoahoc_id");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						KhoaHoc khoaHoc = new KhoaHoc(rs.getInt("khoahoc_id"), rs.getString("tenkhoahoc"));

						lsKhoaHoc.add(khoaHoc);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsKhoaHoc = null;
			}
			closeConnect();
		}

		return lsKhoaHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.KhoaHocDao#getKhoaHocById(int)
	 */
	@Override
	public KhoaHoc getKhoaHocById(int khoaHocId) {
		KhoaHoc khoaHoc = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT khoahoc_id, tenkhoahoc ");
				sqlCommand.append("FROM khoahoc ");
				sqlCommand.append("WHERE khoahoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, khoaHocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						khoaHoc = new KhoaHoc(rs.getInt("khoahoc_id"), rs.getString("tenkhoahoc"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				khoaHoc = null;
			}
			closeConnect();
		}

		return khoaHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.KhoaHocDao#updateKhoaHocById(int, managestudent.entities.KhoaHoc)
	 */
	@Override
	public boolean updateKhoaHocById(int khoaHocId, KhoaHoc khoaHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE khoahoc ");
				sqlCommand.append("SET tenkhoahoc = ? ");
				sqlCommand.append("WHERE khoahoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, khoaHoc.getTenKhoaHoc());
				preparedStatement.setInt(2, khoaHocId);
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
