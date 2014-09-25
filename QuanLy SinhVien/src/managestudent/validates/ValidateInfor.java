/**
 * Copyright(C) K16SE 2014
 *
 * ValidateInfor.java, Sep 15, 2014 HaVH
 *
 */
package managestudent.validates;

import java.util.ArrayList;
import java.util.List;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.DanToc;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HeDaoTao;
import managestudent.entities.HocKy;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.entities.MonHoc;
import managestudent.entities.Nganh;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.HeDaoTaoLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.MessageErrorProperties;

/**
 *
 * @author HaVH
 *
 */
public class ValidateInfor {
	/**
	 * Kiểm tra thông tin ngành
	 *
	 * @param nganh Nganh đối tượng ngành
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateNganhInfor(Nganh nganh, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();
		NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
		String maNganh = nganh.getMaNganh();
		String tenNganh = nganh.getTenNganh();

		if(Common.checkNull(maNganh)) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_manganh"));
		} else {
			if(isAdd) {
				if(nganhLogics.getNganhByMaNganh(maNganh) != null) {
					lsMessage.add(MessageErrorProperties.getMessage("error_003_manganh"));
				}
			} else {
				if(nganhLogics.getNganhByMaNganh(maNganh) == null) {
					lsMessage.add(MessageErrorProperties.getMessage("error_004_manganh"));
				}
			}
		}
		if(Common.checkNull(tenNganh)) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tennganh"));
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin chuyên ngành
	 *
	 * @param cn ChuyenNganh
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateChuyenNganhInfor(ChuyenNganh cn, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();
		ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();

		if(isAdd) {
			if(Common.checkNull(cn.getMaChuyenNganh())) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_machuyennganh"));
			} else {
				if(isAdd) {
					if(chuyenNganhLogics.getChuyenNganhByMaCN(cn.getMaChuyenNganh()) != null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_003_machuyennganh"));
					}
				} else {
					if(chuyenNganhLogics.getChuyenNganhByMaCN(cn.getMaChuyenNganh()) == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_004_machuyennganh"));
					}
				}
			}
			if(Common.checkNull(cn.getTenChuyenNganh())) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_tenchuyennganh"));
			}
			if(cn.getNganhId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_002_nganh"));
			}
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin dân tộc
	 *
	 * @param danToc DanToc
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateDanTocInfor(DanToc danToc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkNull(danToc.getTenDanToc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tendantoc"));
		}
		if(!isAdd) {
			if(danToc.getDanTocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_dantocid"));
			}
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin hệ đào tạo
	 *
	 * @param hdt HeDaoTao đối tượng hệ đào tạo
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateHeDtInfor(HeDaoTao hdt, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();
		HeDaoTaoLogicsImpl hdtLogics = new HeDaoTaoLogicsImpl();

		if(Common.checkNull(hdt.getMaHeDt())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_mahdt"));
		}
		if(Common.checkNull(hdt.getTenHeDt())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenhdt"));
		}
		if(isAdd) {
			if(hdtLogics.getHeDaoTaoByMaHe(hdt.getMaHeDt()) != null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_003_mahdt"));
			}
		} else {
			if(hdtLogics.getHeDaoTaoByMaHe(hdt.getMaHeDt()) == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_mahdt"));
			}
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin học kỳ
	 *
	 * @param hocKy HocKy đối tượng học kỳ
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateHocKyInfor(HocKy hocKy, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(hocKy.getHocKyId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_hockyid"));
			}
		}
		if(Common.checkNull(hocKy.getTenHocKy())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenhocky"));
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin khóa học
	 *
	 * @param khoaHoc KhoaHoc đối tượng khóa học
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateKhoaHocInfor(KhoaHoc khoaHoc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(khoaHoc.getKhoaHocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_khoahocid"));
			}
		}
		if(Common.checkNull(khoaHoc.getTenKhoaHoc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenkhoahoc"));
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin lớp học
	 *
	 * @param lopHoc LopHoc đối tượng lớp học
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateLopHocInfor(LopHoc lopHoc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(lopHoc.getLopHocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_lophocid"));
			}
		}
		if(Common.checkNull(lopHoc.getTenLopHoc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenlophoc"));
		}

		return lsMessage;
	}

	/**
	 * Kiểm tra thông tin môn học
	 *
	 * @param monHoc MonHoc đối tượng môn học
	 * @param isAdd boolean
	 * @return List<String> Danh sách lỗi nếu có
	 */
	public static List<String> validateMonHocInfor(MonHoc monHoc, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(monHoc.getMonHocId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_monhocid"));
			}
		}
		if(Common.checkNull(monHoc.getTenMonHoc())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_tenmonhoc"));
		}
		if(Common.checkNull(monHoc.getSoTrinh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_sotrinh"));
		} else if(!Common.isNumberHalfSize(monHoc.getSoTrinh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_sotrinh"));
		} else if (Integer.parseInt(monHoc.getSoTrinh()) < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_sotrinh"));
		}
		if(monHoc.getHeSoChuyenCan() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_hesochuyencan"));
		}
		if(monHoc.getHeSoGiuaKy() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_hesogiuaky"));
		}
		if(monHoc.getHeSoHocKy() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_hesohocky"));
		}
		if(monHoc.getChuyenNganhId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_002_chuyennganh"));
		}

		return lsMessage;
	}

	public static List<String> validateSinhVienInfor(DmSinhVien sinhVien, boolean isAdd) {
		List<String> lsMessage = new ArrayList<String>();

		if(!isAdd) {
			if(sinhVien.getSinhVienId() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_004_sinhvienid"));
			}
		}
		if(Common.checkNull(sinhVien.getMaSinhVien())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_masinhvien"));
		}
		if(Common.checkNull(sinhVien.getHoDem())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hodem"));
		}
		if(Common.checkNull(sinhVien.getTen())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_ten"));
		}
		if(Common.checkNull(sinhVien.getCmtnd())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_cmtnd"));
		}
		if(Common.checkNotValidPhone(sinhVien.getSoDienThoai())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_005_sodienthoai"));
		}
		if(Common.checkNull(sinhVien.getNoiSinh())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_noisinh"));
		}
		if(Common.checkNull(sinhVien.getQueQuan())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_quequan"));
		}
		if(Common.checkNull(sinhVien.getHoKhauThuongTru())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hokhauthuongtru"));
		}
		if(Common.checkNull(sinhVien.getNoiOHienTai())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_noiohientai"));
		}
		if(Common.checkNull(sinhVien.getCheDoUuDai())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_chedouudai"));
		}
		if(sinhVien.getDanTocId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_dantocid"));
		}
		if(sinhVien.getTonGiaoId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_tongiaoid"));
		}
		if(sinhVien.getQuocTichId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_quoctichid"));
		}
		if(Common.checkNull(sinhVien.getHoTenBo())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hotenbo"));
		}
		if(Common.checkNull(sinhVien.getNgheNghiepBo())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_nghenghiepbo"));
		}
		if(Common.checkNull(sinhVien.getHoTenMe())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_hotenme"));
		}
		if(Common.checkNull(sinhVien.getNgheNghiepMe())) {
			lsMessage.add(MessageErrorProperties.getMessage("error_001_nghenghiepme"));
		}
		if(sinhVien.getHeDtId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_hedaotaoid"));
		}
		if(sinhVien.getLopId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_lophocid"));
		}
		if(sinhVien.getKhoaHocId() <= 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_004_khoahocid"));
		}
		if(sinhVien.getDiemDauVao2() < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_diemdauvao1"));
		}
		if(sinhVien.getDiemDauVao2() < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_diemdauvao2"));
		}
		if(sinhVien.getDiemDauVao3() < 0) {
			lsMessage.add(MessageErrorProperties.getMessage("error_020_diemdauvao3"));
		}

		return lsMessage;
	}
}
