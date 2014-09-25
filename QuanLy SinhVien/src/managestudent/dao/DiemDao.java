/**
 * Copyright(C) K16SE 2014
 *
 * DiemDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.Diem;

/**
 *
 * @author HaVH
 *
 */
public interface DiemDao extends BaseDao {
	/**
	 * Lấy danh sách điểm dựa trên sinh viên id
	 *
	 * @param sinhVienId int sinh viên id
	 * @return List<Diem> Danh sách điểm
	 */
	List<Diem> getDiemBySinhVienId(int sinhVienId);

	/**
	 * Thêm điểm
	 *
	 * @param diem Diem đối tượng điểm
	 * @return true: thành công / false: thất bại
	 */
	boolean addDiem(Diem diem);

	/**
	 * Cập nhật thông tin điểm bằng điểm id
	 *
	 * @param diemId int điểm id
	 * @param diem Diem đối tượng điểm
	 * @return true: thành công / false: thất bại
	 */
	boolean updateDiemById(int diemId, Diem diem);

	/**
	 * Xóa thông tin điểm
	 *
	 * @param diemId int điểm id
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteDiemById(int diemId);
}
