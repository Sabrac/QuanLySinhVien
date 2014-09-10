/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.HeDaoTaoDaoImpl;
import managestudent.entities.HeDaoTao;
import managestudent.logics.HeDaoTaoLogics;

/**
 *
 * @author HaVH
 *
 */
public class HeDaoTaoLogicsImpl implements HeDaoTaoLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#addHeDaoTao(managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean addHeDaoTao(HeDaoTao hdt) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.addHeDaoTao(hdt);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#deleteHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public boolean deleteHeDaoTaoByMaHe(String maHeDaoTao) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.deleteHeDaoTaoByMaHe(maHeDaoTao);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getAllHeDaoTao()
	 */
	@Override
	public List<HeDaoTao> getAllHeDaoTao() {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		List<HeDaoTao> lsHdt = hdtDao.getAllHeDaoTao();

		return lsHdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#getHeDaoTaoByMaHe(java.lang.String)
	 */
	@Override
	public HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		HeDaoTao hdt = hdtDao.getHeDaoTaoByMaHe(maHeDaoTao);

		return hdt;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.HeDaoTaoLogics#updateHeDaoTaoByMaHe(java.lang.String, managestudent.entities.HeDaoTao)
	 */
	@Override
	public boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt) {
		HeDaoTaoDaoImpl hdtDao = new HeDaoTaoDaoImpl();
		boolean rs = hdtDao.updateHeDaoTaoByMaHe(maHeDaoTao, hdt);

		return rs;
	}

}
