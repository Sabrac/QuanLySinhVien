/**
 * Copyright(C) K16SE 2014
 *
 * MonHocLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.MonHocDaoImpl;
import managestudent.entities.MonHoc;
import managestudent.logics.MonHocLogics;

/**
 *
 * @author HaVH
 *
 */
public class MonHocLogicsImpl implements MonHocLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#addMonHoc(managestudent.entities.MonHoc)
	 */
	@Override
	public boolean addMonHoc(MonHoc monHoc) {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		boolean rs = monHocDao.addMonHoc(monHoc);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#deleteMonHocById(int)
	 */
	@Override
	public boolean deleteMonHocById(int monHocId) {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		boolean rs = monHocDao.deleteMonHocById(monHocId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#getAllMonHoc()
	 */
	@Override
	public List<MonHoc> getAllMonHoc() {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		List<MonHoc> lsMonHoc = monHocDao.getAllMonHoc();

		return lsMonHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#getMonHocByChuyenNganh(int)
	 */
	@Override
	public List<MonHoc> getMonHocByChuyenNganh(int chuyenNganhId) {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		List<MonHoc> lsMonHoc = monHocDao.getMonHocByChuyenNganh(chuyenNganhId);

		return lsMonHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#getMonHocById(int)
	 */
	@Override
	public MonHoc getMonHocById(int monHocId) {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		MonHoc monHoc = monHocDao.getMonHocById(monHocId);

		return monHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#updateMonHocById(int, managestudent.entities.MonHoc)
	 */
	@Override
	public boolean updateMonHocById(int monHocId, MonHoc monHoc) {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		boolean rs = monHocDao.updateMonHocById(monHocId, monHoc);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.MonHocLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		MonHocDaoImpl monHocDao = new MonHocDaoImpl();
		List<String> lsColumn = monHocDao.getAllColumnName("monhoc");

		return lsColumn;
	}

}
