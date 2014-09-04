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
	List<ChuyenNganh> getAllChuyenNganh();

	/**
	 * Lấy 1 chuyên ngành bằng mã chuyên ngành
	 * @param maChuyenNganh String mã chuyên ngành
	 * @return ChuyenNganh đối tượng chuyên ngành
	 */
	ChuyenNganh getChuyenNganhByMaCN(String maChuyenNganh);

	/**
	 * Lấy ra danh sách các chuyên ngành dựa trên mã ngành
	 * @param nganhId int Id ngành
	 * @return List<ChuyenNganh> Danh sách các chuyên ngành thuộc ngành id
	 */
	List<ChuyenNganh> getChuyenNganhByNganhId(int nganhId);
}
