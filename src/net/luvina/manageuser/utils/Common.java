/**
 * Copyright(C) 2014 Luvina
 *
 * Common.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.utils;

import java.lang.Math;
import java.lang.Character.UnicodeBlock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

/**
 * Common
 *
 * @author LA-PM
 *
 */
public class Common {

	/**
	 * Paging
	 *
	 * @param record_num
	 *            int
	 * @param record_per_page
	 *            int
	 * @param page_range
	 *            int
	 * @param url
	 *            String
	 * @param pageid
	 *            int
	 * @param f_name_js
	 *            String
	 * @return String paging
	 */
	public static String paging(int record_num, int record_per_page,
			int page_range, String url, int pageid, String f_name_js) {

		String separator = "";
		String pre_str = "&lsaquo;";
		String next_str = "&rsaquo;";
		String first_str = "&laquo;";
		String last_str = "&raquo;";

		if (record_per_page == 0) {
			return "";
		}

		String st = "";
		String cc;
		if (url.indexOf("?") > -1) {
			cc = "&";
		} else {
			cc = "?";
		}

		int page_num;
		page_num = (int) Math.ceil((double) record_num / record_per_page);

		pageid = (int) pageid;

		if (pageid < 1) {
			pageid = 1;
		}

		if (pageid > page_num) {
			pageid = page_num;
		}

		if (page_num < page_range) {
			page_range = page_num;
		}

		int division;
		int page_lim1 = 0;
		int page_lim2 = 0;

		if (page_range == 0) {
			division = 0;
		} else {
			division = (int) Math.floor(page_num / page_range);
		}

		for (int i = 0; i <= division; i++) {
			if (((i * page_range + 1) <= pageid)
					&& (((i + 1) * page_range) >= pageid)) {
				page_lim1 = i * page_range + 1;
				page_lim2 = page_lim1 + page_range - 1;
				if (page_lim2 > page_num) {
					page_lim2 = page_num;
				}
				break;
			}
		}

		String urlEncode = url;

		if (page_num > 1) {
			if (pageid > 1) {
				if (f_name_js.trim().compareTo("") != 0) {
					if (first_str.trim().compareTo("") != 0)
						st += " <a href='javascript:" + f_name_js + "(\""
								+ urlEncode + "\", 1)'  class='txtBlue'>"
								+ first_str + "</a>";
					if (pre_str.trim().compareTo("") != 0)
						st += separator + " <a href='javascript:" + f_name_js
								+ "(\"" + urlEncode + "\", " + (pageid - 1)
								+ ")' class='txtBlue'>" + pre_str + "</a> ";
				} else {
					if (first_str.trim().compareTo("") != 0)
						st += " <a href='" + url + cc
								+ "page=1&isBack=1' class='txtBlue'>"
								+ first_str + "&nbsp;</a>";
					if (pre_str.trim().compareTo("") != 0)
						st += " <a href='" + url + cc + "page=" + (pageid - 1)
								+ "&isBack=1' class='txtBlue'>" + pre_str
								+ "</a> ";
				}
			}
		}

		for (int i = page_lim1; i < pageid; i++) {
			if (f_name_js.trim().compareTo("") != 0) {
				st += separator + "<a href='javascript:" + f_name_js + "(\""
						+ urlEncode + "\", " + i + ")' class='txtBlue'>" + i
						+ "</a> ";
			} else {
				st += separator + "<a href='" + url + cc + "page=" + i
						+ "&isBack=1' class='txtBlue'>" + i + "</a> ";
			}
		}

		st += separator + "<span class='txtGrey11'>" + pageid + "</span>&nbsp;";

		for (int i = pageid + 1; i <= page_lim2; i++) {
			if (f_name_js.trim().compareTo("") != 0) {
				st += separator + "<a href='javascript:" + f_name_js + "(\""
						+ urlEncode + "\", " + i + ")' class='txtBlue'>" + i
						+ "</a> ";
			} else {
				st += separator + "<a href='" + url + cc + "page=" + i
						+ "&isBack=1' class='txtBlue'>" + (i) + "</a> ";
			}
		}
		st += separator;

		if (page_num > 1) {
			if (pageid + 1 <= page_num) {
				if (f_name_js.trim().compareTo("") != 0) {
					if (next_str.trim().compareTo("") != 0)
						st += " <a href='javascript:" + f_name_js + "(\""
								+ urlEncode + "\", " + (pageid + 1)
								+ ")' class='txtBlue'>" + next_str + "</a>";
					if (last_str.trim().compareTo("") != 0)
						st += separator + " &nbsp;<a href='javascript:"
								+ f_name_js + "(\"" + urlEncode + "\", "
								+ page_num + ")' class='txtBlue'>" + last_str
								+ "</a>";
				} else {
					if (next_str.trim().compareTo("") != 0)
						st += " <a href='" + url + cc + "page=" + (pageid + 1)
								+ "&isBack=1' class='txtBlue'>" + next_str
								+ "</a>";
					if (last_str.trim().compareTo("") != 0)
						st += "  <a href='" + url + cc + "page=" + page_num
								+ "&isBack=1' class='txtBlue'>" + last_str
								+ "</a>";
				}
			}
		} else {
			st = "";
		}
		return st;
	}

	/**
	 * Escape special chars html
	 *
	 * @param content
	 *            String
	 * @return String htmlspecialchars
	 */
	public static String escapeHTML(String content) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);

			switch (c) {
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;

			case '&':
				sb.append("&amp;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			 case '\'':
				sb.append("&apos;");
				break;
			default:
				sb.append(c);
			}
		}
		content = sb.toString();
		return content;
	}

	/**
	 * escapeInjection
	 *
	 * @param str
	 *            String
	 * @return String escapeInjection
	 */
	public static String escapeInjection(String str) {
//		String tem = str.replace("'", "''");
		String tem = str.replace("\\", "\\\\").replace("%", "\\%");
		return tem;
	}

	/**
	 * checkLogin
	 *
	 * @param session
	 *            HttpSession
	 * @return ADM001
	 */
	public static String checkLogin(HttpSession session) {
		String template = "";
		if (session.getAttribute("loginId") == null) {
			template = Constant.ADM001;
		}
		return template;

	}

	/**
	 * Tạo chuỗi paging
	 *
	 * @param totalRecords
	 *            tổng sô record
	 * @param limit
	 *            số record trên 1 trang
	 * @param currentPage
	 *            trang hiện tại
	 * @return List<Integer> chuoi lien ket den cac trang khac
	 */
	public static List<Integer> getListPaging(int totalRecords, int limit,
			int currentPage) {
		List<Integer> lsPaging = new ArrayList<Integer>();
		// Tổng số trang
		int totalPage = 0;
		int range = 3;

		if (limit != 0) {
			totalPage = getTotalPage(totalRecords, limit);
		}

		if (totalPage == 0) {
			currentPage = 0;
		}

		int currentSequence = getCurrentSequence(currentPage, range);
		int lastPage = getLastPage(currentSequence, range);
		int firstPage = getFirstPage(currentSequence, range);

		if(lastPage > totalPage) {
			lastPage = totalPage;
		}

		int pageAdd = firstPage;
		while(pageAdd <= lastPage) {
			lsPaging.add(pageAdd++);
		}

		return lsPaging;
	}

	/**
	 * Lấy tổng số trang
	 * @param totalRecords tổng số bản ghi
	 * @param limit số bản ghi 1 trang
	 * @return tổng số trang
	 */
	public static int getTotalPage(int totalRecords, int limit) {
		return (int) Math.ceil((double) totalRecords / limit);
	}

	/**
	 * Lấy sequence hiện tại
	 * @param currentPage trang hiện tại
	 * @param range số trang hiển thị
	 * @return sequence hiện tại
	 */
	public static int getCurrentSequence(int currentPage, int range) {
		return (int) Math.ceil((double) currentPage / range);
	}

	/**
	 * Lấy trang lớn nhất trong sequence hiện tại
	 * @param currentSequence sequence hiện tại
	 * @param range số trang hiển thị
	 * @return trang lớn nhất trong sequence hiện tại
	 */
	public static int getLastPage(int currentSequence, int range) {
		return currentSequence * range;
	}

	/**
	 * Lấy trang nhỏ nhất trong sequence hiện tại
	 * @param currentSequence sequence hiện tại
	 * @param range số trang hiển thị
	 * @return trang nhỏ nhất trong sequence hiện tại
	 */
	public static int getFirstPage(int currentSequence, int range) {
		return getLastPage(currentSequence, range) - (range - 1);
	}

	/**
	 * Lấy danh sách các năm
	 * @param start năm bắt đầu
	 * @param end năm kết thúc
	 * @return danh sách năm
	 */
	public static List<Integer> getListYear(int start, int end) {
		List<Integer> lsYear = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			lsYear.add(i);
		}

		return lsYear;
	}

	/**
	 * Lấy danh sách các tháng
	 * @return danh sách các tháng
	 */
	public static List<Integer> getListMonth() {
		List<Integer> lsMonth = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			lsMonth.add(i);
		}

		return lsMonth;
	}

	/**
	 * Lấy danh sách các ngày
	 * @return danh sách các ngày
	 */
	public static List<Integer> getListDay() {
		List<Integer> lsDay = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			lsDay.add(i);
		}

		return lsDay;
	}

	/**
	 * Hàm kiểm tra trống
	 *
	 * @param input
	 *            chuỗi nhập vào
	 * @return true: null / false: not null
	 */
	public static boolean checkNull(String input) {
		boolean result = false;
		if (input.trim().length() == 0) {
			result = true;
		}

		return result;
	}

	/**
	 * Kiểm tra độ dài chuỗi
	 *
	 * @param input
	 *            chuỗi nhập vào
	 * @param min
	 *            độ dài tối thiểu
	 * @param max
	 *            độ dài tối đa
	 * @return true: nằm ngoài khoảng cho phép / false: nằm trong khoảng cho phép
	 */
	public static boolean checkMinMaxLength(String input, int min, int max) {
		boolean result = false;
		int length = input.trim().length();
		if (length < min || length > max) {
			result = true;
		}

		return result;
	}

	/**
	 * Kiểm tra độ dài chuỗi
	 *
	 * @param input
	 *            chuỗi nhập vào
	 * @param max
	 *            độ dài tối đa của chuỗi
	 * @return true: lớn hơn độ dài tối đa / false: nhỏ hơn độ dài tối đa
	 */
	public static boolean checkMaxLength(String input, int max) {
		boolean result = false;
		int length = input.trim().length();
		if (length > max) {
			result = true;
		}

		return result;
	}

	/**
	 * Kiểm tra chuỗi có ký tự nào ko phải tiếng Nhật không
	 *
	 * @param input
	 *            chuỗi nhập vào
	 * @return true: không phải chuỗi katakana / false: là chuỗi katakana
	 */
	public static boolean checkNotKanaString(String input) {
		boolean result = true;
		char[] tmp = input.toCharArray();
		for (char c : tmp) {
			if (Character.UnicodeBlock.of(c) == UnicodeBlock.KATAKANA) {
				result = false;
			} else {
				result = true;
				break;
			}
		}

		return result;
	}

	/**
	 * Hàm kiểm tra valid ngày sinh
	 *
	 * @param input
	 *            Date ngày sinh
	 * @return true: ngày không tồn tại / false: ngày tồn tại
	 */
	public static boolean checkNotValidDay(int year, int month, int date) {
		if (date < 1) {
			return true;
		}

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (date > 31) {
				return true;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (date > 30) {
				return true;
			}
		case 2:
			if (year % 4 == 0 && date > 29) {
				return true;
			}
			if (year % 4 != 0 && date > 28) {
				return true;
			}
		}

		return false;
	}

	/**
	 * So sánh ngày chỉ định với ngày hiện tại
	 *
	 * @param input
	 *            ngày chỉ định
	 * @return <0 nếu ngày chỉ định nhỏ hơn ngày hiện tại, 0 nếu bằng ngày hiện
	 *         tại, >0 nếu lớn hơn ngày hiện tại
	 */
	public static int compareToDay(Date input) {
		Date now = new Date();

		return input.compareTo(now);
	}

	/**
	 * Kiểm tra valid cho ngày sinh và start date
	 * @param input ngày sinh / start date
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidBirth(int year, int month, int date) {
		boolean result = checkNotValidDay(year, month, date);

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, date);
		Date input = c.getTime();

		if(!result) {
			if(compareToDay(input) > 0) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * Kiểm tra valid cho end date
	 * @param input end date
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidEnd(int year, int month, int date) {
		boolean result = checkNotValidDay(year, month, date);

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, date);
		Date input = c.getTime();

		if(!result) {
			if(compareToDay(input) < 0) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * Kiểm tra format email
	 * @param input chuỗi nhập vào
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidEmail(String input) {
		boolean result = true;
		String regex = "[\\w]+(@)[\\w]+((.)[\\w]+)+";
		Pattern p = Pattern.compile(regex);

		if (p.matcher(input).matches()) {
			result = false;
		}

		return result;
	}

	/**
	 * Kiểm tra format phone number
	 * @param input chuỗi nhập vào
	 * @return true: not valid / false: valid
	 */
	public static boolean checkNotValidPhone(String input) {
		boolean result = true;
		String regex = "[\\d]+[-][\\d]+[-]([\\d]+)";
		Pattern p = Pattern.compile(regex);

		if(p.matcher(input).matches()) {
			result = false;
		}

		return result;
	}

	/**
	 * Kiểm tra 1 chuỗi có phải chứa tất cả ký tự 1 byte hay không
	 * @param input chuỗi nhập vào
	 * @return true: không có ký tự nào >1byte / false: chứa ký tự >1byte
	 */
	public static boolean is1Byte(String input) {
		boolean result = true;
		char[] c = input.toCharArray();

		for (char tmp : c) {
			if (tmp > 255) {
				result = false;
			}
			break;
		}

		return result;
	}

	/**
	 * Kiểm tra 1 chuỗi có phải chuỗi số half size không
	 * @param input chuỗi nhập vào
	 * @return true: số halfsize / false: không phải số halfszie
	 */
	public static boolean isNumberHalfSize(String input) {
		boolean result = true;
		try {
			int tmp = Integer.parseInt(input);
			result = is1Byte(input);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			result = false;
		}

		return result;
	}

	/**
	 * Kiểm tra 1 chuỗi có nằm trong format (a-z, A-Z, 0-9 và _)
	 * @param input chuỗi nhập vào
	 * @return true: chỉ chứa các kỹ tự (a-z, A-Z, 0-9 và _) / false: không đúng format
	 */
	public static boolean checkFormatUser(String input) {
		boolean result = true;
		char[] c = input.toCharArray();
		int i = 1;

		for (char tmp : c) {
			int ascii = (int)tmp;
			if (ascii < 48 || (ascii > 57 && ascii < 65) ||
					(ascii > 90 && ascii < 95) || (ascii > 95 && ascii < 97) ||
					ascii > 122) {
				result = false;
				break;
			}
			if (ascii >= 48 && ascii <= 57 && i == 1) {
				result = false;
				break;
			}
			i++;
		}

		return result;
	}

	/**
	 * Mã hóa chuỗi nhập vào
	 * @param str chuỗi nhập vào
	 * @return Chuỗi sau khi mã hóa
	 */
	public static String endcodeString(String str) {
		String rs = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes());
			byte messageDigest[] = md5.digest();

	        // Create Hex String
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < messageDigest.length; i++) {
	            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
	        }
	        rs = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("an exception occur: " + e.getMessage());
			rs = "";
		}

		return rs;
	}
}
