/**
 * Copyright(C) K16SE 2014
 *
 * DiemDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.DiemDao;
import managestudent.entities.Diem;

/**
 *
 * @author HaVH
 *
 */
public class DiemDaoImpl extends BaseDaoImpl implements DiemDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.DiemDao#addDiem(managestudent.entities.Diem)
	 */
	@Override
	public boolean addDiem(Diem diem) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO diem ");
				sqlCommand.append("(monhoc_id, lanthi, diemthi, diemchuyencan, diemgiuaky, ");
				sqlCommand.append("hocky_id, sinhvien_id) ");
				sqlCommand.append("VALUES");
				sqlCommand.append("(?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, diem.getMonHocId());
				preparedStatement.setString(2, diem.getLanThi());
				preparedStatement.setFloat(3, diem.getDiemThi());
				preparedStatement.setFloat(4, diem.getDiemChuyenCan());
				preparedStatement.setFloat(5, diem.getDiemGiuaKy());
				preparedStatement.setInt(6, diem.getHocKyId());
				preparedStatement.setInt(7, diem.getSinhVienId());
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
	 * @see managestudent.dao.DiemDao#getDiemBySinhVienId(int)
	 */
	@Override
	public List<Diem> getDiemBySinhVienId(int sinhVienId) {
		List<Diem> lsDiem = new ArrayList<Diem>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT diem_id, monhoc_id, lanthi, diemthi, ");
				sqlCommand.append("diemchuyencan, diemgiuaky, hocky_id, sinhvien_id ");
				sqlCommand.append("FROM diem ");
				sqlCommand.append("WHERE sinhvien_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, sinhVienId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						Diem diem = new Diem(rs.getInt("diem_id"), rs.getInt("monhoc_id"), rs.getString("lanthi"),
								rs.getFloat("diemthi"), rs.getFloat("diemchuyencan"), rs.getFloat("diemgiuaky"),
								rs.getInt("hocky_id"), rs.getInt("sinhvien_id"));

						lsDiem.add(diem);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An exception occur: " + e.getMessage());
				lsDiem = null;
			}
			closeConnect();
		}

		return lsDiem;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DiemDao#deleteDiemById(int)
	 */
	@Override
	public boolean deleteDiemById(int diemId) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM diem ");
				sqlCommand.append("WHERE diem_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, diemId);
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
	 * @see managestudent.dao.DiemDao#updateDiemById(int, managestudent.entities.Diem)
	 */
	@Override
	public boolean updateDiemById(int diemId, Diem diem) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE diem ");
				sqlCommand.append("SET monhoc_id = ?, lanthi = ?, diemthi = ?, diemchuyencan = ?, diemgiuaky = ?, hocky_id = ?, sinhvien_id = ? ");
				sqlCommand.append("WHERE diem_id = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, diem.getMonHocId());
				preparedStatement.setString(2, diem.getLanThi());
				preparedStatement.setFloat(3, diem.getDiemThi());
				preparedStatement.setFloat(4, diem.getDiemChuyenCan());
				preparedStatement.setFloat(5, diem.getDiemGiuaKy());
				preparedStatement.setFloat(6, diem.getHocKyId());
				preparedStatement.setFloat(7, diem.getSinhVienId());
				preparedStatement.setInt(8, diem.getDiemId());
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
