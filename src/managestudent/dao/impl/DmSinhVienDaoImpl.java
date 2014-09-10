/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVienDaoImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import managestudent.dao.DmSinhVienDao;
import managestudent.entities.DmSinhVien;

/**
 *
 * @author HaVH
 *
 */
public class DmSinhVienDaoImpl extends BaseDaoImpl implements DmSinhVienDao {

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getAllSinhVien()
	 */
	@Override
	public List<DmSinhVien> getAllSinhVien() {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, quoctich_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien, anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien sinhVien = new DmSinhVien(rs.getInt("sinhvienid"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getBoolean("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getInt("quoctich_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("hedt_id"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));

						lsSinhVien.add(sinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getListSinhVienByHeDaoTaoId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, quoctich_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien, anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("WHERE hedt_id = ?");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, heDaoTaoId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien sinhVien = new DmSinhVien(rs.getInt("sinhvienid"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getBoolean("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getInt("quoctich_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("hedt_id"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));

						lsSinhVien.add(sinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getListSinhVienByKhoaHocId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, quoctich_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien, anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("WHERE khoahoc_id = ?");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, khoaHocId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien sinhVien = new DmSinhVien(rs.getInt("sinhvienid"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getBoolean("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getInt("quoctich_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("hedt_id"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));

						lsSinhVien.add(sinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getListSinhVienByLopId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByLopId(int lopId) {
		List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, quoctich_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien, anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("WHERE lop_id = ?");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setInt(1, lopId);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						DmSinhVien sinhVien = new DmSinhVien(rs.getInt("sinhvienid"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getBoolean("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getInt("quoctich_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("hedt_id"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));

						lsSinhVien.add(sinhVien);
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				lsSinhVien = null;
			}
			closeConnect();
		}

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#getSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public DmSinhVien getSinhVienByMaSinhVien(String maSinhVien) {
		DmSinhVien sinhVien = null;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("SELECT sinhvien_id, masv, hodem, ten, ngaysinh, gioitinh, cmtnd, ");
				sqlCommand.append("sodthoai, noisinh, quequan, hokhauthuongtru, noiohientai, ");
				sqlCommand.append("chedouudai, dantoc_id, tongiao_id, quoctich_id, hotenbo, ");
				sqlCommand.append("nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ");
				sqlCommand.append("ngaynhaphoc, diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien, anhsinhvien ");
				sqlCommand.append("FROM dmsinhvien ");
				sqlCommand.append("WHERE masv = ?");
				sqlCommand.append("ORDER BY masv ASC");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maSinhVien);
				rs = preparedStatement.executeQuery();

				if(rs != null) {
					while(rs.next()) {
						sinhVien = new DmSinhVien(rs.getInt("sinhvienid"), rs.getString("masv"), rs.getString("hodem"), rs.getString("ten"),
								rs.getDate("ngaysinh"), rs.getBoolean("gioitinh"), rs.getString("cmtnd"), rs.getString("sodthoai"), rs.getString("noisinh"),
								rs.getString("quequan"), rs.getString("hokhauthuongtru"), rs.getString("noiohientai"), rs.getString("chedouudai"),
								rs.getInt("dantoc_id"), rs.getInt("tongiao_id"), rs.getInt("quoctich_id"), rs.getString("hotenbo"), rs.getString("nghenghiepbo"),
								rs.getString("hotenme"), rs.getString("nghenghiepme"), rs.getInt("hedt_id"), rs.getInt("lop_id"), rs.getInt("khoahoc_id"),
								rs.getDate("ngaynhaphoc"), rs.getFloat("diemdauvao1"), rs.getFloat("diemdauvao2"), rs.getFloat("diemdauvao3"), rs.getString("anhsinhvien"));
					}
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("An error occur: " + e.getMessage());
				sinhVien = null;
			}
			closeConnect();
		}

		return sinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.dao.DmSinhVienDao#addSinhVien(managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean addSinhVien(DmSinhVien sinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("INSERT INTO dmsinhvien ");
				sqlCommand.append("(masv, hodem, ten, ngaysinh, gioitinh, cmtnd, sodthoai, noisinh, ");
				sqlCommand.append("quequan, hokhauthuongtru, noiohientai, chedouudai, dantoc_id, tongiao_id, quoctich_id, ");
				sqlCommand.append("hotenbo, nghenghiepbo, hotenme, nghenghiepme, hedt_id, lop_id, khoahoc_id, ngaynhaphoc, ");
				sqlCommand.append("diemdauvao1, diemdauvao2, diemdauvao3, anhsinhvien) ");
				sqlCommand.append("VALUES ");
				sqlCommand.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, sinhVien.getMaSinhVien());
				preparedStatement.setString(2, sinhVien.getHoDem());
				preparedStatement.setString(3, sinhVien.getTen());
				preparedStatement.setDate(4, new Date(sinhVien.getNgaySinh().getTime()));
				preparedStatement.setBoolean(5, sinhVien.isGioiTinh());
				preparedStatement.setString(6, sinhVien.getCmtnd());
				preparedStatement.setString(7, sinhVien.getSoDienThoai());
				preparedStatement.setString(8, sinhVien.getNoiSinh());
				preparedStatement.setString(9, sinhVien.getQueQuan());
				preparedStatement.setString(10, sinhVien.getHoKhauThuongTru());
				preparedStatement.setString(11, sinhVien.getNoiOHienTai());
				preparedStatement.setString(12, sinhVien.getCheDoUuDai());
				preparedStatement.setInt(13, sinhVien.getDanTocId());
				preparedStatement.setInt(14, sinhVien.getTonGiaoId());
				preparedStatement.setInt(15, sinhVien.getQuocTichId());
				preparedStatement.setString(16, sinhVien.getHoTenBo());
				preparedStatement.setString(17, sinhVien.getNgheNghiepBo());
				preparedStatement.setString(18, sinhVien.getHoTenMe());
				preparedStatement.setString(19, sinhVien.getNgheNghiepMe());
				preparedStatement.setInt(20, sinhVien.getHeDtId());
				preparedStatement.setInt(21, sinhVien.getLopId());
				preparedStatement.setInt(22, sinhVien.getKhoaHocId());
				preparedStatement.setDate(23, new Date(sinhVien.getNgayNhapHoc().getTime()));
				preparedStatement.setFloat(24, sinhVien.getDiemDauVao1());
				preparedStatement.setFloat(25, sinhVien.getDiemDauVao2());
				preparedStatement.setFloat(26, sinhVien.getDiemDauVao3());
				preparedStatement.setString(27, sinhVien.getAnhSinhVien());
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
	 * @see managestudent.dao.DmSinhVienDao#deleteSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public boolean deleteSinhVienByMaSinhVien(String maSinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("DELETE FROM dmsinhvien ");
				sqlCommand.append("WHERE masv = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, maSinhVien);
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
	 * @see managestudent.dao.DmSinhVienDao#updateSinhVienByMaSinhVien(managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean updateSinhVienByMaSinhVien(String maSinhVien, DmSinhVien sinhVien) {
		boolean result = false;

		if(connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				sqlCommand.append("UPDATE dmsinhvien ");
				sqlCommand.append("SET masv = ?, hodem = ?, ten = ?, ngaysinh = ?, gioitinh = ?, cmtnd = ?, sodthoai = ?, noisinh = ?, ");
				sqlCommand.append("quequan = ?, hokhauthuongtru = ?, noiohientai = ?, chedouudai = ?, dantoc_id = ?, tongiao_id = ?, ");
				sqlCommand.append("quoctich_id = ?, hotenbo = ?, nghenghiepbo = ?, hotenme = ?, nghenghiepme = ?, hedt_id = ?, lop_id = ?, ");
				sqlCommand.append("khoahoc_id = ?, ngaynhaphoc = ?, diemdauvao1 = ?, diemdauvao2 = ?, diemdauvao3 = ?, anhsinhvien = ? ");
				sqlCommand.append("WHERE masv = ?");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());
				preparedStatement.setString(1, sinhVien.getMaSinhVien());
				preparedStatement.setString(2, sinhVien.getHoDem());
				preparedStatement.setString(3, sinhVien.getTen());
				preparedStatement.setDate(4, new Date(sinhVien.getNgaySinh().getTime()));
				preparedStatement.setBoolean(5, sinhVien.isGioiTinh());
				preparedStatement.setString(6, sinhVien.getCmtnd());
				preparedStatement.setString(7, sinhVien.getSoDienThoai());
				preparedStatement.setString(8, sinhVien.getNoiSinh());
				preparedStatement.setString(9, sinhVien.getQueQuan());
				preparedStatement.setString(10, sinhVien.getHoKhauThuongTru());
				preparedStatement.setString(11, sinhVien.getNoiOHienTai());
				preparedStatement.setString(12, sinhVien.getCheDoUuDai());
				preparedStatement.setInt(13, sinhVien.getDanTocId());
				preparedStatement.setInt(14, sinhVien.getTonGiaoId());
				preparedStatement.setInt(15, sinhVien.getQuocTichId());
				preparedStatement.setString(16, sinhVien.getHoTenBo());
				preparedStatement.setString(17, sinhVien.getNgheNghiepBo());
				preparedStatement.setString(18, sinhVien.getHoTenMe());
				preparedStatement.setString(19, sinhVien.getNgheNghiepMe());
				preparedStatement.setInt(20, sinhVien.getHeDtId());
				preparedStatement.setInt(21, sinhVien.getLopId());
				preparedStatement.setInt(22, sinhVien.getKhoaHocId());
				preparedStatement.setDate(23, new Date(sinhVien.getNgayNhapHoc().getTime()));
				preparedStatement.setFloat(24, sinhVien.getDiemDauVao1());
				preparedStatement.setFloat(25, sinhVien.getDiemDauVao2());
				preparedStatement.setFloat(26, sinhVien.getDiemDauVao3());
				preparedStatement.setString(27, sinhVien.getAnhSinhVien());
				preparedStatement.setString(28, maSinhVien);
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
