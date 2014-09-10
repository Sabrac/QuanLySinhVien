/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.HeDaoTaoDao;
import managestudent.entities.HeDaoTao;

/**
 *
 * @author HaVH
 *
 */
public class HeDaoTaoDaoImpl extends BaseDaoImpl implements HeDaoTaoDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#addHeDaoTao(managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean addHeDaoTao(HeDaoTao hdt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO hedaotao ");
				sqlCommand.append("(mahedt, ten_hedt) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hdt.getMaHeDt());
				preparedStatement.setString(2, hdt.getTenHeDt());
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
	 * @see managestudent.dao.HeDaoTaoDao#deleteHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public boolean deleteHeDaoTaoByMaHe(String maHeDaoTao) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM hedaotao ");
				sqlCommand.append("WHERE mahedt = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maHeDaoTao);
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
	 * @see managestudent.dao.HeDaoTaoDao#getAllHeDaoTao()
	 */
	@Override
	public List<HeDaoTao> getAllHeDaoTao() {
		List<HeDaoTao> lsHdt = new ArrayList<HeDaoTao>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hedt_id, mahedt, ten_hedt ");
				sqlCommand.append("FROM hedaotao");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						HeDaoTao hdt = new HeDaoTao(rs.getInt("hedt_id"), rs.getString("mahedt"), rs.getString("ten_hedt"));

						lsHdt.add(hdt);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsHdt = null;
			}
			closeConnect();
		}

		return lsHdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#getHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao) {
		HeDaoTao hdt = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT hedt_id, mahedt, ten_hedt ");
				sqlCommand.append("FROM hedaotao ");
				sqlCommand.append("WHERE mahedt = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maHeDaoTao);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						hdt = new HeDaoTao(rs.getInt("hedt_id"), rs.getString("mahedt"), rs.getString("ten_hedt"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				hdt = null;
			}
			closeConnect();
		}

		return hdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.HeDaoTaoDao#updateHeDaoTaoByMaHe(java.lang.String, managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE hedaotao ");
				sqlCommand.append("SET mahedt = ?, ten_hedt = ? ");
				sqlCommand.append("WHERE mahedt = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, hdt.getMaHeDt());
				preparedStatement.setString(2, hdt.getTenHeDt());
				preparedStatement.setString(3, maHeDaoTao);
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
