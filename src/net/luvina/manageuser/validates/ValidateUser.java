/**
 * Copyright(C) 2014 Luvina
 *
 * ValidateUser.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.validates;

import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import net.luvina.manageuser.dao.MstGroupDao;
import net.luvina.manageuser.dao.impl.MstGroupDaoImpl;
import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.MstJapan;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.impl.MstGroupLogicImpl;
import net.luvina.manageuser.logics.impl.MstJapanLogicImpl;
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;
import net.luvina.manageuser.logics.impl.UserLogicImpl;
import net.luvina.manageuser.utils.Common;
import net.luvina.manageuser.utils.MessageErrorProperties;
import net.luvina.manageuser.utils.MessageProperties;

/**
 * Xử lý ValidateUser
 *
 * @author LA-PM
 *
 */
public class ValidateUser {

	/**
	 * validateLogin
	 *
	 * @param loginId
	 *            String loginId
	 * @param password
	 *            String password
	 * @return list errorMess
	 */
	public static List<String> validateLogin(String loginId, String password) {
		List<String> lsErrorMess = new ArrayList<String>();
		if (loginId.trim().length() == 0) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_user"));
		}
		if (password.length() == 0) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_pass"));
		}
		UserLogicImpl userLogic = new UserLogicImpl();
		if (loginId.trim().length() != 0 && password.length() != 0) {
			// Start fix bug ID 122 - HaVH 2014/06/17
			if (!userLogic.existLoginId(loginId, password)) {
				// End fix bug ID 122 - HaVH 2014/06/17
				lsErrorMess.add(MessageErrorProperties.getMessage("error_016"));
			}
		}

		return lsErrorMess;
	}

	/**
	 * validate thông tin user
	 *
	 * @param user
	 *            UserInfor thông tin user
	 * @return Mảng lỗi
	 */
	public static List<String> validateUserInfor(UserInfor user, boolean addUser) {
		List<String> lsErrorMess = new ArrayList<String>();
		TblUserLogicImpl userLogic = new TblUserLogicImpl();
		MstGroupLogicImpl groupLogic = new MstGroupLogicImpl();
		List<MstGroup> lsGroup = groupLogic.getAllGroups();
		MstJapanLogicImpl japanLogic = new MstJapanLogicImpl();
		List<MstJapan> lsJapan = japanLogic.getAllMstJapan();
		Calendar cal = Calendar.getInstance();

		// Kiểm tra logic username
		if (!Common.checkFormatUser(user.getLoginName())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_019_user"));
		} else if (Common.checkNull(user.getLoginName())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_user"));
		} else if (!Common.is1Byte(user.getLoginName())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_008_user"));
		} else if (Common.checkMinMaxLength(user.getLoginName(), 4, 15)) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_007_user_4_15"));
		} else if (addUser) {
			if (userLogic.existLoginName(user.getLoginName().trim())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_003_user"));
			}
		}

		// Kiểm tra logic select box group
		MstGroup group = groupLogic.getGroupById(user.getGroupId());
		if ("-1".equals(user.getGroupId())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_002_group"));
		} else if (!lsGroup.contains(group)) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_004_group"));
		}

		// Kiểm tra logic full name
		if (Common.checkNull(user.getFullName())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_fullname"));
		} else if (Common.checkMaxLength(user.getFullName(), 255)) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_006_fullname_255"));
		}

		// Kiểm tra kana name
		if (!Common.checkNull(user.getKanaName().trim())) {
			if (Common.checkNotKanaString(user.getKanaName())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_009_kananame"));
			} else if (Common.checkMaxLength(user.getKanaName(), 255)) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_006_kananame_255"));
			}
		}

		// Kiểm tra select box ngày sinh
		cal.setTime(user.getBirth());
		if (Common.checkNotValidBirth(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_011_birthday"));
		}

		// Kiểm tra email
		if (Common.checkNull(user.getEmail())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_email"));
		} else if (Common.checkNotValidEmail(user.getEmail())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_005_email"));
		} else if (addUser) {
			if (userLogic.existEmail(user.getEmail())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_003_email"));
			}
		} else if (Common.checkMaxLength(user.getEmail(), 255)) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_006_email_255"));
		}

		//Kiểm tra số điện thoại
		if (Common.checkNull(user.getTel())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_001_tel"));
		} else if (Common.checkNotValidPhone(user.getTel())) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_005_tel"));
		} else if (Common.checkMaxLength(user.getTel(), 14)) {
			lsErrorMess.add(MessageErrorProperties.getMessage("error_006_tel_14"));
		}

		if (addUser) {
			//Kiểm tra mật khẩu
			if (Common.checkNull(user.getPass())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_001_pass"));
			} else if (!Common.is1Byte(user.getPass())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_008_pass"));
			} else if (Common.checkMinMaxLength(user.getPass(), 5, 15)) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_007_pass_5_15"));
			}

			//Kiểm tra mật khẩu nhập lại
			if (!user.getPass().equals(user.getRePass())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_017_repass"));
			}
		} else {
			if (!Common.checkNull(user.getPass())) {
				if (!Common.is1Byte(user.getPass())) {
					lsErrorMess.add(MessageErrorProperties.getMessage("error_008_pass"));
				} else if (Common.checkMinMaxLength(user.getPass(), 5, 15)) {
					lsErrorMess.add(MessageErrorProperties.getMessage("error_007_pass_5_15"));
				}
			}
		}

		if (!"-1".equals(user.getCodeLevel())) {
			//Kiểm tra trình độ tiếng Nhật
			MstJapan japan = japanLogic.getJapanByCode(user.getCodeLevel());
			if (!lsJapan.contains(japan)) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_004_japan"));
			}

			//Kiểm tra ngày cấp chứng chỉ
			cal.setTime(user.getStartDate());
			if (Common.checkNotValidBirth(cal.get(Calendar.YEAR),
					cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_011_startdate"));
			}

			//Kiểm tra ngày hết hạn
			int compare = user.getEndDate().compareTo(user.getStartDate());
			cal.setTime(user.getEndDate());
			if (Common.checkNotValidBirth(cal.get(Calendar.YEAR),
					cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_011_enddate"));
			} else if(compare <= 0) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_012_enddate"));
			}

			//Kiểm tra điểm
			if (Common.checkNull(user.getPointString())) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_001_point"));
			} else if (!Common.isNumberHalfSize(user.getPointString()) || Integer.parseInt(user.getPointString()) < 0) {
				lsErrorMess.add(MessageErrorProperties.getMessage("error_018_point"));
			}
		}

		return lsErrorMess;
	}
}
