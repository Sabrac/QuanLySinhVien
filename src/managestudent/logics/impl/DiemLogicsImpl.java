/**
 * Copyright(C) K16SE 2014
 *
 * DiemLogicsImpl.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics.impl;

import java.util.List;

import managestudent.dao.impl.DiemDaoImpl;
import managestudent.entities.Diem;
import managestudent.logics.DiemLogics;

/**
 *
 * @author HaVH
 *
 */
public class DiemLogicsImpl implements DiemLogics {

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#addDiem(managestudent.entities.Diem)
	 */
	@Override
	public boolean addDiem(Diem diem) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		boolean rs = diemDao.addDiem(diem);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#deleteDiemById(int)
	 */
	@Override
	public boolean deleteDiemById(int diemId) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		boolean rs = diemDao.deleteDiemById(diemId);

		return rs;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#getDiemBySinhVienId(int)
	 */
	@Override
	public List<Diem> getDiemBySinhVienId(int sinhVienId) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		List<Diem> lsDiem = diemDao.getDiemBySinhVienId(sinhVienId);

		return lsDiem;
	}

	/* (non-Javadoc)
	 * @see managestudent.logics.DiemLogics#updateDiemById(int, managestudent.entities.Diem)
	 */
	@Override
	public boolean updateDiemById(int diemId, Diem diem) {
		DiemDaoImpl diemDao = new DiemDaoImpl();
		boolean rs = diemDao.updateDiemById(diemId, diem);

		return rs;
	}

}
