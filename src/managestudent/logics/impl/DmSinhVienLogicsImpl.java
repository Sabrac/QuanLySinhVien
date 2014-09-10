/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVienLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.DmSinhVienDaoImpl;
import managestudent.entities.DmSinhVien;
import managestudent.logics.DmSinhVienLogics;

/**
 *
 * @author HaVH
 *
 */
public class DmSinhVienLogicsImpl implements DmSinhVienLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#addSinhVien(managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean addSinhVien(DmSinhVien sinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.addSinhVien(sinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#deleteSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public boolean deleteSinhVienByMaSinhVien(String maSinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.deleteSinhVienByMaSinhVien(maSinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getAllSinhVien()
	 */
	@Override
	public List<DmSinhVien> getAllSinhVien() {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getAllSinhVien();

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getListSinhVienByHeDaoTaoId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getListSinhVienByHeDaoTaoId(heDaoTaoId);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getListSinhVienByKhoaHocId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getListSinhVienByKhoaHocId(khoaHocId);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getListSinhVienByLopId(int)
	 */
	@Override
	public List<DmSinhVien> getListSinhVienByLopId(int lopId) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<DmSinhVien> lsSinhVien = sinhVienDao.getListSinhVienByLopId(lopId);

		return lsSinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getSinhVienByMaSinhVien(java.lang.String)
	 */
	@Override
	public DmSinhVien getSinhVienByMaSinhVien(String maSinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		DmSinhVien sinhVien = sinhVienDao.getSinhVienByMaSinhVien(maSinhVien);

		return sinhVien;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#updateSinhVienByMaSinhVien(java.lang.String, managestudent.entities.DmSinhVien)
	 */
	@Override
	public boolean updateSinhVienByMaSinhVien(String maSinhVien,
			DmSinhVien sinhVien) {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		boolean rs = sinhVienDao.updateSinhVienByMaSinhVien(maSinhVien, sinhVien);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DmSinhVienLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		DmSinhVienDaoImpl sinhVienDao = new DmSinhVienDaoImpl();
		List<String> lsColumn = sinhVienDao.getAllColumnName("dmsinhvien");

		return lsColumn;
	}

}
