/**
 * Copyright(C) K16SE 2014
 *
 * QuocTichLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.QuocTichDaoImpl;
import managestudent.entities.QuocTich;
import managestudent.logics.QuocTichLogics;

/**
 *
 * @author HaVH
 *
 */
public class QuocTichLogicsImpl implements QuocTichLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.QuocTichLogics#addQuocTich(managestudent.entities.QuocTich)
	 */
	@Override
	public boolean addQuocTich(QuocTich quocTich) {
		QuocTichDaoImpl quocTichDao = new QuocTichDaoImpl();
		boolean rs = quocTichDao.addQuocTich(quocTich);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.QuocTichLogics#deleteQuocTichById(int)
	 */
	@Override
	public boolean deleteQuocTichById(int quocTichId) {
		QuocTichDaoImpl quocTichDao = new QuocTichDaoImpl();
		boolean rs = quocTichDao.deleteQuocTichById(quocTichId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.QuocTichLogics#getAllQuocTich()
	 */
	@Override
	public List<QuocTich> getAllQuocTich() {
		QuocTichDaoImpl quocTichDao = new QuocTichDaoImpl();
		List<QuocTich> lsQuocTich = quocTichDao.getAllQuocTich();

		return lsQuocTich;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.QuocTichLogics#getQuocTichById(int)
	 */
	@Override
	public QuocTich getQuocTichById(int quocTichId) {
		QuocTichDaoImpl quocTichDao = new QuocTichDaoImpl();
		QuocTich quocTich = quocTichDao.getQuocTichById(quocTichId);

		return quocTich;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.QuocTichLogics#updateQuocTichById(int, managestudent.entities.QuocTich)
	 */
	@Override
	public boolean updateQuocTichById(int quocTichId, QuocTich quocTich) {
		QuocTichDaoImpl quocTichDao = new QuocTichDaoImpl();
		boolean rs = quocTichDao.updateQuocTichById(quocTichId, quocTich);

		return rs;
	}

}
