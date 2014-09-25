/**
 * Copyright(C) K16SE 2014
 *
 * TonGiaoDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.TonGiao;

/**
 *
 * @author HaVH
 *
 */
public interface TonGiaoDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả tôn giáo
	 *
	 * @return List<TonGiao> Danh sách đối tượng tôn giáo
	 */
	List<TonGiao> getAllTonGiao(TonGiao tonGiao, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy thông tin tôn giáo bằng id tôn giáo
	 *
	 * @param tonGiaoId int tôn giáo id
	 * @return TonGiao đối tượng tôn giáo
	 */
	TonGiao getTonGiaoById(int tonGiaoId);

	/**
	 * Thêm tôn giáo
	 *
	 * @param tonGiao TonGiao đối tượng tôn giáo
	 * @return true: thành công / false: thất bại
	 */
	boolean addTonGiao(TonGiao tonGiao);

	/**
	 * Cập nhật thông tin tôn giáo
	 *
	 * @param tonGiaoId int tôn giáo id
	 * @param tonGiao TonGiao đối tượng tôn giáo
	 * @return true: thành công / false: thất bại
	 */
	boolean updateTonGiaoById(int tonGiaoId, TonGiao tonGiao);

	/**
	 * Xóa thông tin tôn giáo bằng tôn giáo id
	 *
	 * @param tonGiaoId int id tôn giáo
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteTonGiaoById(int tonGiaoId);

	/**
	 * Lấy tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 *
	 * @param tonGiao TonGiao đối tượng tôn giáo (chứa thông tin điều kiện tìm kiếm)
	 * @return int tổng số bản ghi thỏa mãn điều kiện tìm kiếm
	 */
	int getTotalRecords(TonGiao tonGiao);
}
