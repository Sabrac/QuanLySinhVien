/**
 * Copyright(C) K16SE 2014
 *
 * HocKyLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.HocKyDaoImpl;
import managestudent.entities.HocKy;
import managestudent.logics.HocKyLogics;

/**
 *
 * @author HaVH
 *
 */
public class HocKyLogicsImpl implements HocKyLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#addHocKy(managestudent.entities.HocKy)
	 */
	@Override
	public boolean addHocKy(HocKy hocKy) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		boolean rs = hocKyDao.addHocKy(hocKy);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#deleteHocKyById(int)
	 */
	@Override
	public boolean deleteHocKyById(int hocKyId) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		boolean rs = hocKyDao.deleteHocKyById(hocKyId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getAllHocKy()
	 */
	@Override
	public List<HocKy> getAllHocKy() {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		List<HocKy> lsHocKy = hocKyDao.getAllHocKy();

		return lsHocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getHocKyById(int)
	 */
	@Override
	public HocKy getHocKyById(int hocKyId) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		HocKy hocKy = hocKyDao.getHocKyById(hocKyId);

		return hocKy;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#updateHocKyById(int, managestudent.entities.HocKy)
	 */
	@Override
	public boolean updateHocKyById(int hocKyId, HocKy hocKy) {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		boolean rs = hocKyDao.updateHocKyById(hocKyId, hocKy);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HocKyLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		HocKyDaoImpl hocKyDao = new HocKyDaoImpl();
		List<String> lsColumn = hocKyDao.getAllColumnName("hocky");

		return lsColumn;
	}

}
