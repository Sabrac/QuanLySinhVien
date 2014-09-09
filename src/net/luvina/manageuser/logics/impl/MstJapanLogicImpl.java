/**
 * Copyright(C) 2014 Luvina
 *
 * MstJapanLogicImpl.java, Jul 4, 2014 LA-PM
 *
 */
package net.luvina.manageuser.logics.impl;

import java.util.List;

import net.luvina.manageuser.dao.impl.MstJapanDaoImpl;
import net.luvina.manageuser.entities.MstJapan;
import net.luvina.manageuser.logics.MstJapanLogic;

/**
 * MstJapanLogicImpl.java
 *
 * @author LA-PM
 *
 */
public class MstJapanLogicImpl implements MstJapanLogic {

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.MstJapanLogic#getAllMstJapan()
	 */
	@Override
	public List<MstJapan> getAllMstJapan() {
		// TODO Auto-generated method stub
		MstJapanDaoImpl japanDao = new MstJapanDaoImpl();
		List<MstJapan> lsJapan = japanDao.getAllMstJapan();
		return lsJapan;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.MstJapanLogic#checkJapanExist()
	 */
	@Override
	public boolean checkJapanExist(String name_level) {
		// TODO Auto-generated method stub
		MstJapanDaoImpl japanDao = new MstJapanDaoImpl();
		boolean result = japanDao.checkJapanExist(name_level);
		return result;
	}

	/* (non-Javadoc)
	 * @see net.luvina.manageuser.logics.MstJapanLogic#getJapanByCode(java.lang.String)
	 */
	@Override
	public MstJapan getJapanByCode(String codeLevel) {
		// TODO Auto-generated method stub
		MstJapanDaoImpl japanDao = new MstJapanDaoImpl();
		MstJapan japan = japanDao.getJapanByCode(codeLevel);
		return japan;
	}

	@Override
	public String getNameLevelByCode(String codeLevel) {
		// TODO Auto-generated method stub
		MstJapanDaoImpl japanDao = new MstJapanDaoImpl();
		String name_level = japanDao.getNameLevelByCode(codeLevel);
		return name_level;
	}

}
