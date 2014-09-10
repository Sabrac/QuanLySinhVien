/**
 * Copyright(C) K16SE 2014
 *
 * NganhLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.Nganh;

/**
 *
 * @author HaVH
 *
 */
public interface NganhLogics {
	/**
	 * Lấy danh sách tất cả ngành
	 *
	 * @return List<Nganh> Danh sách đối tượng ngành
	 */
	List<Nganh> getAllNganh();

	/**
	 * Lấy thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @return Nganh đối tượng ngành
	 */
	Nganh getNganhByMaNganh(String maNganh);

	/**
	 * Thêm mới ngành
	 *
	 * @param nganh Nganh đối tượng ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean addNganh(Nganh nganh);

	/**
	 * Cập nhật thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @param nganh Nganh đối tượng ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean updateNganhByMaNganh(String maNganh, Nganh nganh);

	/**
	 * Xóa thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteNganhByMaNganh(String maNganh);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();
}
