/**
 * Copyright(C) K16SE 2014
 *
 * TonGIaoLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.TonGiaoDaoImpl;
import managestudent.entities.TonGiao;
import managestudent.logics.TonGiaoLogics;

/**
 *
 * @author HaVH
 *
 */
public class TonGIaoLogicsImpl implements TonGiaoLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#addTonGiao(managestudent.entities.TonGiao)
	 */
	@Override
	public boolean addTonGiao(TonGiao tonGiao) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		boolean rs = tonGiaoDao.addTonGiao(tonGiao);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#deleteTonGiaoById(int)
	 */
	@Override
	public boolean deleteTonGiaoById(int tonGiaoId) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		boolean rs = tonGiaoDao.deleteTonGiaoById(tonGiaoId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#getAllTonGiao()
	 */
	@Override
	public List<TonGiao> getAllTonGiao() {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		List<TonGiao> lsTonGiao = tonGiaoDao.getAllTonGiao();

		return lsTonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#getTonGiaoById(int)
	 */
	@Override
	public TonGiao getTonGiaoById(int tonGiaoId) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		TonGiao tonGiao = tonGiaoDao.getTonGiaoById(tonGiaoId);

		return tonGiao;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.TonGiaoLogics#updateTonGiaoById(int, managestudent.entities.TonGiao)
	 */
	@Override
	public boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao) {
		TonGiaoDaoImpl tonGiaoDao = new TonGiaoDaoImpl();
		boolean rs = tonGiaoDao.updateTonGiaoById(tonGiaoId, tonGiao);

		return rs;
	}

}
