/**
 * Copyright(C) K16SE 2014
 *
 * ChuyenNganhDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.ChuyenNganh;

/**
 *
 * @author HaVH
 *
 */
public interface ChuyenNganhDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả chuyên ngành trong database
	 * @return List<ChuyenNganh> Danh sách các chuyên ngành
	 */
	List<ChuyenNganh> getAllChuyenNganh(ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy 1 chuyên ngành bằng mã chuyên ngành
	 * @param maChuyenNganh String mã chuyên ngành
	 * @return ChuyenNganh đối tượng chuyên ngành
	 */
	ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh);

	/**
	 * Lấy thông tin chuyên ngành bằng id chuyên ngành
	 *
	 * @param chuyenNganhId int chuyên ngành id
	 * @return ChuyenNganh đối tượng chuyên ngành
	 */
	ChuyenNganh getChuyenNganhById(int chuyenNganhId);

	/**
	 * Lấy ra danh sách các chuyên ngành dựa trên mã ngành
	 * @param nganhId int Id ngành
	 * @return List<ChuyenNganh> Danh sách các chuyên ngành thuộc ngành id
	 */
	List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId, ChuyenNganh chuyenNganh, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Thêm chuyên ngành
	 *
	 * @param cn ChuyenNganh đối tượng chuyên ngành (chuyenNganhId = -1)
	 * @return true: thành công / false: thất bại
	 */
	boolean addChuyenNganh(ChuyenNganh cn);

	/**
	 * Cập nhật chuyên ngành bằng mã chuyên ngành
	 *
	 * @param cn ChuyenNganh đối tượng chuyên ngành (maChuyenNganh: điều kiện update)
	 * @return true: thành công / false: thất bại
	 */
	boolean updateChuyenNganhByMaChuyenNganh(ChuyenNganh cn);

	/**
	 * Cập nhật chuyên ngành bằng id chuyên ngành
	 *
	 * @param cn ChuyenNganh đối tượng chuyên ngành (maChuyenNganh: điều kiện update)
	 * @return true: thành công / false: thất bại
	 */
	boolean updateChuyenNganhById(int chuyenNganhId, ChuyenNganh cn);

	/**
	 * Xóa chuyên ngành bằng mã chuyên ngành
	 *
	 * @param maChuyenNganh String mã chuyên ngành
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteChuyenNganhByMaChuyenNganh(String maChuyenNganh);

	/**
	 * Lấy tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 *
	 * @param chuyenNganh ChuyenNganh đối tượng chuyên ngành (chứa thông tin điều kiện tìm kiếm)
	 * @return int tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 */
	int getTotalRecords(ChuyenNganh chuyenNganh);
}
