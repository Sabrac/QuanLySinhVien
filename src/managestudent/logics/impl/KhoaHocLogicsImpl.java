/**
 * Copyright(C) K16SE 2014
 *
 * KhoaHocLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.KhoaHocDaoImpl;
import managestudent.entities.KhoaHoc;
import managestudent.logics.KhoaHocLogics;

/**
 *
 * @author HaVH
 *
 */
public class KhoaHocLogicsImpl implements KhoaHocLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.KhoaHocLogics#addKhoaHoc(managestudent.entities.KhoaHoc)
	 */
	@Override
	public boolean addKhoaHoc(KhoaHoc khoaHoc) {
		KhoaHocDaoImpl khoaHocDao = new KhoaHocDaoImpl();
		boolean rs = khoaHocDao.addKhoaHoc(khoaHoc);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.KhoaHocLogics#deleteKhoaHocById(int)
	 */
	@Override
	public boolean deleteKhoaHocById(int khoaHocId) {
		KhoaHocDaoImpl khoaHocDao = new KhoaHocDaoImpl();
		boolean rs = khoaHocDao.deleteKhoaHocById(khoaHocId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.KhoaHocLogics#getAllKhoaHoc()
	 */
	@Override
	public List<KhoaHoc> getAllKhoaHoc() {
		KhoaHocDaoImpl khoaHocDao = new KhoaHocDaoImpl();
		List<KhoaHoc> lsKhoaHoc = khoaHocDao.getAllKhoaHoc();

		return lsKhoaHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.KhoaHocLogics#getKhoaHocById(int)
	 */
	@Override
	public KhoaHoc getKhoaHocById(int khoaHocId) {
		KhoaHocDaoImpl khoaHocDao = new KhoaHocDaoImpl();
		KhoaHoc khoaHoc = khoaHocDao.getKhoaHocById(khoaHocId);

		return khoaHoc;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.KhoaHocLogics#updateKhoaHocById(int, managestudent.entities.KhoaHoc)
	 */
	@Override
	public boolean updateKhoaHocById(int khoaHocId, KhoaHoc khoaHoc) {
		KhoaHocDaoImpl khoaHocDao = new KhoaHocDaoImpl();
		boolean rs = khoaHocDao.updateKhoaHocById(khoaHocId, khoaHoc);

		return rs;
	}

}
