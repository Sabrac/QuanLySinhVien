/**
 * Copyright(C) K16SE 2014
 *
 * NganhLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.NganhDaoImpl;
import managestudent.entities.Nganh;
import managestudent.logics.NganhLogics;

/**
 *
 * @author HaVH
 *
 */
public class NganhLogicsImpl implements NganhLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#addNganh(managestudent.entities.Nganh)
	 */
	@Override
	public boolean addNganh(Nganh nganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.addNganh(nganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#deleteNganhByMaNganh(java.lang.String)
	 */
	@Override
	public boolean deleteNganhByMaNganh(String maNganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.deleteNganhByMaNganh(maNganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getAllNganh()
	 */
	@Override
	public List<Nganh> getAllNganh() {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		List<Nganh> lsNganh = nganhDao.getAllNganh();

		return lsNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#getNganhByMaNganh(java.lang.String)
	 */
	@Override
	public Nganh getNganhByMaNganh(String maNganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		Nganh nganh = nganhDao.getNganhByMaNganh(maNganh);

		return nganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.NganhLogics#updateNganhByMaNganh(java.lang.String, managestudent.entities.Nganh)
	 */
	@Override
	public boolean updateNganhByMaNganh(String maNganh, Nganh nganh) {
		NganhDaoImpl nganhDao = new NganhDaoImpl();
		boolean rs = nganhDao.updateNganhByMaNganh(maNganh, nganh);

		return rs;
	}

}
