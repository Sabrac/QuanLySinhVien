/**
 * Copyright(C) K16SE 2014
 *
 * LopHocDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.List;

import managestudent.dao.LopHocDao;
import managestudent.entities.LopHoc;

/**
 *
 * @author HaVH
 *
 */
public class LopHocDaoImpl extends BaseDaoImpl implements LopHocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.LopHocDao#addLopHoc(managestudent.entities.LopHoc)
	 */
	@Override
	public boolean addLopHoc(LopHoc lopHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO lophoc ");
				sqlCommand.append("(tenlop) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, lopHoc.getTenLopHoc());
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
	 * @see managestudent.dao.LopHocDao#deleteLopHocById(int)
	 */
	@Override
	public boolean deleteLopHocById(int lopHocId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM lophoc ");
				sqlCommand.append("WHERE lop_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, lopHocId);
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
	 * @see managestudent.dao.LopHocDao#getAllLopHoc()
	 */
	@Override
	public List<LopHoc> getAllLopHoc() {
		List<LopHoc> lsLop = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT lop_id, tenlop ");
				sqlCommand.append("FROM lophoc");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						LopHoc lop = new LopHoc(rs.getInt("lop_id"), rs.getString("tenlop"));

						lsLop.add(lop);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsLop = null;
			}
			closeConnect();
		}

		return lsLop;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.LopHocDao#getLopHocById(int)
	 */
	@Override
	public LopHoc getLopHocById(int lopHocId) {
		LopHoc lop = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT lop_id, tenlop ");
				sqlCommand.append("FROM lophoc ");
				sqlCommand.append("WHERE lop_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, lopHocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						lop = new LopHoc(rs.getInt("lop_id"), rs.getString("tenlop"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lop = null;
			}
			closeConnect();
		}

		return lop;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.LopHocDao#updateLopHocById(int, managestudent.entities.LopHoc)
	 */
	@Override
	public boolean updateLopHocById(int lopHocId, LopHoc lopHoc) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE lophoc ");
				sqlCommand.append("SET tenlop = ? ");
				sqlCommand.append("WHERE lop_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, lopHoc.getTenLopHoc());
				preparedStatement.setInt(2, lopHocId);
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
