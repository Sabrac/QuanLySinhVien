/**
 * Copyright(C) K16SE 2014
 *
 * NganhDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.Nganh;

/**
 *
 * @author HaVH
 *
 */
public interface NganhDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả ngành
	 *
	 * @param nganh Nganh đối tượng ngành (chứa điều kiện tìm kiếm)
	 * @param offset int vị trí bản ghi đầu tiên
	 * @param limit int số bản ghi tối đa cần lấy
	 * @param sortColumn int vị trí cột cần sắp xếp
	 * @param sortType String kiểu sắp xếp (ASC / DESC)
	 * @return List<Nganh> Danh sách đối tượng ngành
	 */
	List<Nganh> getAllNganh(Nganh nganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @return Nganh đối tượng ngành
	 */
	Nganh getNganhByMaNganh(String maNganh);

	/**
	 * Lấy thông tin ngành bằng id ngành
	 *
	 * @param nganhId int id ngành
	 * @return Nganh đối tượng ngành
	 */
	Nganh getNganhById(int nganhId);

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
	 * Cập nhật thông tin ngành bằng ngành id
	 *
	 * @param nganhId int ngành id
	 * @param nganh Nganh đối tượng ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean updateNganhByID(int nganhId, Nganh nganh);

	/**
	 * Xóa thông tin ngành bằng mã ngành
	 *
	 * @param maNganh String mã ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteNganhByMaNganh(String maNganh);

	/**
	 * Xóa thông tin ngành bằng id ngành
	 *
	 * @param idNganh int id ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteNganhById(int idNganh);

	/**
	 * Lấy tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 *
	 * @param nganh Nganh đối tượng ngành (chứa điều kiện tìm kiếm)
	 * @return int tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 */
	int getTotalRecords(Nganh nganh);
}
