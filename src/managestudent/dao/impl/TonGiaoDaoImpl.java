/**
 * Copyright(C) K16SE 2014
 *
 * TonGiaoDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.TonGiaoDao;
import managestudent.entities.TonGiao;

/**
 *
 * @author HaVH
 *
 */
public class TonGiaoDaoImpl extends BaseDaoImpl implements TonGiaoDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.TonGiaoDao#addTonGiao(managestudent.entities.TonGiao)
	 */
	@Override
	public boolean addTonGiao(TonGiao tonGiao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO tongiao ");
				sqlCommand.append("(tentongiao) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, tonGiao.getTenTonGiao());
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
	 * @see managestudent.dao.TonGiaoDao#deleteTonGiaoById(int)
	 */
	@Override
	public boolean deleteTonGiaoById(int tonGiaoId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM tongiao ");
				sqlCommand.append("WHERE tongiao_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, tonGiaoId);
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
	 * @see managestudent.dao.TonGiaoDao#getAllTonGiao()
	 */
	@Override
	public List<TonGiao> getAllTonGiao() {
		List<TonGiao> lsTonGiao = new ArrayList<TonGiao>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT tongiao_id, tentongiao ");
				sqlCommand.append("FROM tongiao ");
				sqlCommand.append("ORDER BY tongiao_id ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						TonGiao tonGiao = new TonGiao(rs.getInt("tongiao_id"), rs.getString("tentongiao"));

						lsTonGiao.add(tonGiao);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsTonGiao = null;
			}
			closeConnect();
		}

		return lsTonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.TonGiaoDao#getTonGiaoById(int)
	 */
	@Override
	public TonGiao getTonGiaoById(int tonGiaoId) {
		TonGiao tonGiao = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT tongiao_id, tentongiao ");
				sqlCommand.append("FROM tongiao ");
				sqlCommand.append("WHERE tongiao_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, tonGiaoId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						tonGiao = new TonGiao(rs.getInt("tongiao_id"), rs.getString("tentongiao"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				tonGiao = null;
			}
			closeConnect();
		}

		return tonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.TonGiaoDao#updateTonGiaoById(int, managestudent.entities.TonGiao)
	 */
	@Override
	public boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE tongiao ");
				sqlCommand.append("SET tentongiao = ? ");
				sqlCommand.append("WHERE tongiao_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, tonGiao.getTenTonGiao());
				preparedStatement.setInt(2, tonGiaoId);
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
