/**
 * Copyright(C) K16SE 2014
 *
 * ChuyenNganhLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.net.ConnectException;
import java.util.List;

import managestudent.dao.impl.ChuyenNganhDaoImpl;
import managestudent.entities.ChuyenNganh;
import managestudent.logics.ChuyenNganhLogics;


/**
 *
 * @author HaVH
 *
 */
public class ChuyenNganhLogicsImpl implements ChuyenNganhLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#addChuyenNganh(managestudent.entities.ChuyenNganh)
	 */
	@Override
	public boolean addChuyenNganh(ChuyenNganh cn) {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		boolean rs = chuyenNganhDao.addChuyenNganh(cn);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#deleteChuyenNganhByMaChuyenNganh(java.lang.String)
	 */
	@Override
	public boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh) {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		boolean rs = chuyenNganhDao.deleteChuyenNganhByMaChuyenNganh(maChuyenNganh);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#getAllChuyenNganh()
	 */
	@Override
	public List<ChuyenNganh> getAllChuyenNganh() {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		List<ChuyenNganh> lsChuyenNganh = chuyenNganhDao.getAllChuyenNganh();

		return lsChuyenNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#getChuyenNganhByMaCN(java.lang.String)
	 */
	@Override
	public ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh) {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		ChuyenNganh cn = chuyenNganhDao.getChuyenNganhByMaCN(maChuyenNganh);

		return cn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#getChuyenNganhByNganhId(int)
	 */
	@Override
	public List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId) {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		List<ChuyenNganh> lsChuyenNganh = chuyenNganhDao.getChuyenNganhByNganhId(nganhId);

		return lsChuyenNganh;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#updateChuyenNganhByMaChuyenNganh(managestudent.entities.ChuyenNganh)
	 */
	@Override
	public boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn) {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		boolean rs = chuyenNganhDao.updateChuyenNganhByMaChuyenNganh(cn);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#getAllColumnName()
	 */
	@Override
	public List<String> getAllColumnName() {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		List<String> lsColumn = chuyenNganhDao.getAllColumnName("chuyennganh");

		return lsColumn;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.ChuyenNganhLogics#getChuyenNganhById(int)
	 */
	@Override
	public ChuyenNganh getChuyenNganhById(int chuyenNganhId) {
		ChuyenNganhDaoImpl chuyenNganhDao = new ChuyenNganhDaoImpl();
		ChuyenNganh cn = chuyenNganhDao.getChuyenNganhById(chuyenNganhId);

		return cn;
	}

}
