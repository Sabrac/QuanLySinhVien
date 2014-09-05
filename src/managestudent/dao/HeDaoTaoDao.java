/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.HeDaoTao;

/**
 *
 * @author HaVH
 *
 */
public interface HeDaoTaoDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả hệ đào tạo
	 *
	 * @return List<HeDaoTao> Danh sách đối tượng hệ đào tạo
	 */
	List<HeDaoTao> getAllHeDaoTao();

	/**
	 * Lấy hệ đào tạo bằng mã hệ
	 *
	 * @param maHeDaoTao String mã hệ đào tạo
	 * @return HeDaoTao đối tượng hệ đào tạo
	 */
	HeDaoTao getHeDaoTaoByMaHe(String maHeDaoTao);

	/**
	 * Thêm hệ đào tạo
	 *
	 * @param hdt HeDaoTao đối tượng hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean addHeDaoTao(HeDaoTao hdt);

	/**
	 * Cập nhật hệ đào tạo bằng mã hệ
	 *
	 * @param maHeDaoTao String mã hệ đào tạo
	 * @param hdt HeDaoTao đối tượng hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean updateHeDaoTaoByMaHe(String maHeDaoTao, HeDaoTao hdt);

	/**
	 * Xóa thông tin hệ đào tạo
	 *
	 * @param maHeDaoTao String mã hệ đào tạo
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteHeDaoTaoByMaHe(String maHeDaoTao);
}
