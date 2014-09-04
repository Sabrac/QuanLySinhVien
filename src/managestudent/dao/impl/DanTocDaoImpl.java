/**
 * Copyright(C) K16SE 2014
 *
 * DanTocDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.List;

import managestudent.dao.DanTocDao;
import managestudent.entities.DanToc;

/**
 *
 * @author HaVH
 *
 */
public class DanTocDaoImpl extends BaseDaoImpl implements DanTocDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#getAllDanToc()
	 */
	@Override
	public List<DanToc> getAllDanToc() {
		List<DanToc> lsDanToc = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT dantoc_id, tendantoc ");
				sqlCommand.append("FROM dantoc ");
				sqlCommand.append("ORDER BY dantoc_id");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DanToc dt = new DanToc(
								rs.getInt("dantoc_id"),
								rs.getString("tendantoc"));

						lsDanToc.add(dt);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsDanToc = null;
			}
			closeConnect();
		}

		return lsDanToc;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DanTocDao#getDanTocById(int)
	 */
	@Override
	public DanToc getDanTocById(int danTocId) {
		DanToc dt = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT dantoc_id, tendantoc ");
				sqlCommand.append("FROM dantoc ");
				sqlCommand.append("WHERE dantoc_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, danTocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						dt = new DanToc();
						dt.setDanTocId(rs.getInt("dantoc_id"));
						dt.setTenDanToc(rs.getString("tendantoc"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				dt = null;
			}
			closeConnect();
		}

		return dt;
	}

}
