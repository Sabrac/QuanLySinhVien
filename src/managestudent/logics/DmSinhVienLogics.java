/**
 * Copyright(C) K16SE 2014
 *
 * DmSinhVienLogics.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.logics;

import java.util.List;

import managestudent.entities.DmSinhVien;

/**
 *
 * @author HaVH
 *
 */
public interface DmSinhVienLogics {
	/**
	 * Lấy danh sách tất cả sinh viên
	 *
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getAllSinhVien();

	/**
	 * Lấy danh sách sinh viên trong hệ đào tạo
	 *
	 * @param heDaoTaoId int hệ đào tạo id
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByHeDaoTaoId(int heDaoTaoId);

	/**
	 * Lấy danh sách sinh viên trong lớp
	 *
	 * @param lopId int lớp id
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByLopId(int lopId);

	/**
	 * Lấy danh sách sinh viên trong khóa học
	 *
	 * @param khoaHocId int khóa học id
	 * @return List<DmSinhVien> Danh sách đối tượng DmSinhVien
	 */
	List<DmSinhVien> getListSinhVienByKhoaHocId(int khoaHocId);

	/**
	 * Lấy sinh viên theo mã sinh viên
	 *
	 * @param maSinhVien String mã sinh viên
	 * @return DmSinhVien đối tượng DmSinhVien
	 */
	DmSinhVien getSinhVienByMaSinhVien(String maSinhVien);

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
	 * Xóa thông tin sinh viên
	 *
	 * @param maSinhVien String mã sinh viên
	 * @return true: thành công / false: thất bại
	 */
	boolean deleteSinhVienByMaSinhVien(String maSinhVien);

	/**
	 * Lấy danh sách tên các column có trong table
	 *
	 * @return List<String> Danh sách tên các column có trong table
	 */
	List<String> getAllColumnName();
}
