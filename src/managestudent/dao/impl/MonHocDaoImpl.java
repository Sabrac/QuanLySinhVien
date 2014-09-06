/**
 * Copyright(C) K16SE 2014
 *
 * MonHocDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.List;

import managestudent.dao.MonHocDao;
import managestudent.entities.MonHoc;

/**
 *
 * @author HaVH
 *
 */
public class MonHocDaoImpl extends BaseDaoImpl implements MonHocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#addMonHoc(managestudent.entities.MonHoc)
	 */
	@Override
	public boolean addMonHoc(MonHoc monHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO monhoc ");
				sqlCommand.append("(tenmonhoc, sotrinh, hesochuyencan, hesogiuaky, hesohocky, tinhtrang, chuyennganh_id, songaynghi) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, monHoc.getTenMonHoc());
				preparedStatement.setString(2, monHoc.getSoTrinh());
				preparedStatement.setFloat(3, monHoc.getHeSoChuyenCan());
				preparedStatement.setFloat(4, monHoc.getHeSoGiuaKy());
				preparedStatement.setFloat(5, monHoc.getHeSoHocKy());
				preparedStatement.setInt(6, monHoc.getTinhTrang());
				preparedStatement.setInt(7, monHoc.getChuyenNganhId());
				preparedStatement.setInt(8, monHoc.getSoNgayNghi());
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
	 * @see managestudent.dao.MonHocDao#deleteMonHocById(int)
	 */
	@Override
	public boolean deleteMonHocById(int monHocId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM monhoc ");
				sqlCommand.append("WHERE monhoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, monHocId);
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
	 * @see managestudent.dao.MonHocDao#getAllMonHoc()
	 */
	@Override
	public List<MonHoc> getAllMonHoc() {
		List<MonHoc> lsMonHoc = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT monhoc_id, tenmonhoc, sotrinh, hesochuyencan, hesogiuaky, hesohocky, tinhtrang, chuyennganh_id, songaynghi ");
				sqlCommand.append("FROM monhoc ");
				sqlCommand.append("ORDER BY monhoc_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						MonHoc monHoc = new MonHoc(rs.getInt("monhoc_id"), rs.getString("tenmonhoc"), rs.getString("sotrinh"), rs.getFloat("hesochuyencan"),
								rs.getFloat("hesogiuaky"), rs.getFloat("hesohocky"), rs.getInt("tinhtrang"), rs.getInt("chuyennganh_id"), rs.getInt("songaynghi"));

						lsMonHoc.add(monHoc);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsMonHoc = null;
			}
			closeConnect();
		}

		return lsMonHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#getMonHocByChuyenNganh(int)
	 */
	@Override
	public MonHoc getMonHocByChuyenNganh(int chuyenNganhId) {
		MonHoc monHoc = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT monhoc_id, tenmonhoc, sotrinh, hesochuyencan, hesogiuaky, hesohocky, tinhtrang, chuyennganh_id, songaynghi ");
				sqlCommand.append("FROM monhoc ");
				sqlCommand.append("WHERE chuyennganh_id = ? ");
				sqlCommand.append("ORDER BY monhoc_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, chuyenNganhId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						monHoc = new MonHoc(rs.getInt("monhoc_id"), rs.getString("tenmonhoc"), rs.getString("sotrinh"), rs.getFloat("hesochuyencan"),
								rs.getFloat("hesogiuaky"), rs.getFloat("hesohocky"), rs.getInt("tinhtrang"), rs.getInt("chuyennganh_id"), rs.getInt("songaynghi"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				monHoc = null;
			}
			closeConnect();
		}

		return monHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#getMonHocById(int)
	 */
	@Override
	public MonHoc getMonHocById(int monHocId) {
		MonHoc monHoc = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT monhoc_id, tenmonhoc, sotrinh, hesochuyencan, hesogiuaky, hesohocky, tinhtrang, chuyennganh_id, songaynghi ");
				sqlCommand.append("FROM monhoc ");
				sqlCommand.append("WHERE monhoc_id = ? ");
				sqlCommand.append("ORDER BY monhoc_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, monHocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						monHoc = new MonHoc(rs.getInt("monhoc_id"), rs.getString("tenmonhoc"), rs.getString("sotrinh"), rs.getFloat("hesochuyencan"),
								rs.getFloat("hesogiuaky"), rs.getFloat("hesohocky"), rs.getInt("tinhtrang"), rs.getInt("chuyennganh_id"), rs.getInt("songaynghi"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				monHoc = null;
			}
			closeConnect();
		}

		return monHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.MonHocDao#updateMonJHocById(int, managestudent.entities.MonHoc)
	 */
	@Override
	public boolean updateMonHocById(int monHocId, MonHoc monHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE monhoc ");
				sqlCommand.append("SET tenmonhoc = ?, sotrinh = ?, hesocuyencan = ?, hesogiuaky = ?, hesohocky = ?, tinhtrang = ?, chuyennganh_id = ?, songaynghi = ? ");
				sqlCommand.append("WHERE monhoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, monHoc.getTenMonHoc());
				preparedStatement.setString(2, monHoc.getSoTrinh());
				preparedStatement.setFloat(3, monHoc.getHeSoChuyenCan());
				preparedStatement.setFloat(4, monHoc.getHeSoGiuaKy());
				preparedStatement.setFloat(5, monHoc.getHeSoHocKy());
				preparedStatement.setInt(6, monHoc.getTinhTrang());
				preparedStatement.setInt(7, monHoc.getChuyenNganhId());
				preparedStatement.setInt(8, monHoc.getSoNgayNghi());
				preparedStatement.setInt(9, monHoc.getMonHocId());
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
