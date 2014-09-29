/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVienDao.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.dao;

import java.util.List;

import managestudent.entities.DmSinhVien;

/**
 *
 * @author HaVH
 *
 */
public interface DmSinhVienDao extends BaseDao {
	/**
	 * Lấy danh sách tất cả sinh viên
	 *
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getAllSinhVien(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy danh sách thông tin chi tiết tất cả sinh viên
	 *
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getAllSinhVienDetail(DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy danh sách sinh viên trong hệ đào tạo
	 *
	 * @param heDaoTaoId int hệ đào tạo id
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy danh sách sinh viên trong lớp
	 *
	 * @param lopId int lớp id
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByLopId(int lopId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy danh sách sinh viên trong khóa học
	 *
	 * @param khoaHocId int khóa học id
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId, DmSinhVien sinhVien, int offset, int limit, int sortColumn, String sortType);

	/**
	 * Lấy sinh viên theo mã sinh viên
	 *
	 * @param maSinhVien String mã sinh viên
	 * @return DmSinhVien đối tượng DmSinhVien
	 */
	DmSinhVien getSinhVienByMaSinhVien(String maSinhVien);

	/**
	 * Lấy sinh viên theo id sinh viên
	 *
	 * @param sinhVienId int id sinh viên
	 * @return DmSinhVien đối tượng DmSinhVien
	 */
	DmSinhVien getSinhVienById(int sinhVienId);

	/**
	 * Thêm sinh viên
	 *
	 * @param sinhVien DmSinhVien đối tượng DmSinhVien
	 * @return true: thành công / false: thất bại
	 */
	boolean addSinhVien(DmSinhVien sinhVien);

	/**
	 * Cập nhật thông tin sinh viên
	 *
	 * @param maSinhVien String mã sinh viên
	 * @param sinhVien DmSinhVien đối tượng DmSinhVien
	 * @return true: thành công / false: thất bại
	 */
	boolean updateSinhVienByMaSinhVien(String maSinhVien, DmSinhVien sinhVien);

	/**
	 * Cập nhật thông tin sinh viên bằng id
	 *
	 * @param idSinhVien id sinh viên
	 * @param sinhVien DmSinhVien đối tượng DmSinhVien
	 * @return true: thành công / false: thất bại
	 */
	boolean updateSinhVienById(int idSinhVien, DmSinhVien sinhVien);

	/**
	 * Xóa thông tin sinh viên
	 *
	 * @param maSinhVien String mã sinh viên
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteSinhVienByMaSinhVien(String maSinhVien);

	/**
	 * Xóa thông tin sinh viên
	 *
	 * @param idSinhVien int id sinh viên
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteSinhVienById(int idSinhVien);

	/**
	 * Lấy tổng số tất cả bản ghi thỏa mãn điều kiện tìm kiếm
	 *
	 * @param sinhVien DmSinhVien đối tượng sinh viên (chứa thông tin điều kiện tìm kiếm)
	 * @return int tổng số tất cả bản ghi thỏa mãn điều kiện tìm kiếm
	 */
	int getTotalRecords(DmSinhVien sinhVien);
}
