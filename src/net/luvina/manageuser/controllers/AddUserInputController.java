/**
 * Copyright(C) 2014 Luvina
 *
 * AddUserInputController.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.MstJapan;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.MstGroupLogic;
import net.luvina.manageuser.logics.impl.MstGroupLogicImpl;
import net.luvina.manageuser.logics.impl.MstJapanLogicImpl;
import net.luvina.manageuser.utils.Common;
import net.luvina.manageuser.utils.Constant;
import net.luvina.manageuser.validates.ValidateUser;

/**
 * Servlet implementation class AddUserInputController
 */
public class AddUserInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserInputController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		HttpSession session = request.getSession();
		String ref = "";

		if (request.getParameter("ref") != null) {
			ref = request.getParameter("ref");
			if ("ADM002".equals(ref) || "ADM005".equals(ref)) {
				request.setAttribute("ref", ref);

				if (request.getParameter("submit") != null) {
		        	if ("true".equals(request.getParameter("submit"))) {
		        		if ("ADM005".equals(ref)) {
		        			addUserValidate(request, response, false);
		        		} else {
		        			addUserValidate(request, response, true);
		        		}

		        		if (request.getAttribute("lsError") != null) {
							template = Constant.ADM003;
							request.setAttribute("back", request.getHeader("referer"));
		        		} else {
		        			template = Constant.ADM004;
		    				request.setAttribute("back", Constant.ADD_USER);
		        		}
		        	}
		        } else {
		        	if (session.getAttribute("userInfor") != null) {
		        		setDataLogicADM003(request, response);
		        		request.setAttribute("userInfor", session.getAttribute("userInfor"));
		        	} else {
		        		addUserInput(request, response);
		        	}

					template = Constant.ADM003;
					request.setAttribute("back", request.getHeader("referer"));
		        }
			}
		} else {
			response.sendRedirect(Constant.LIST_USER);
			return;
		}

        RequestDispatcher req = request.getRequestDispatcher(template);
        req.forward(request, response);
	}

	/**
	 * Hàm lấy dữ liệu mặc định các control trên ADM003
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	protected void setDataLogicADM003(HttpServletRequest request, HttpServletResponse response) {
		MstGroupLogicImpl groupLogic = new MstGroupLogicImpl();
		MstJapanLogicImpl japanLogic = new MstJapanLogicImpl();
		List<MstGroup> lsGroup = groupLogic.getAllGroups();
		List<MstJapan> lsJapan = japanLogic.getAllMstJapan();
		List<Integer> lsBirthYear = Common.getListYear(2000, Calendar.getInstance().get(Calendar.YEAR));
		List<Integer> lsEndYear = Common.getListYear(2000, Calendar.getInstance().get(Calendar.YEAR) + 1);
		List<Integer> lsMonth = Common.getListMonth();
		List<Integer> lsDay = Common.getListDay();

		request.setAttribute("lsGroup", lsGroup);
		request.setAttribute("lsJapan", lsJapan);
		request.setAttribute("lsBirthYear", lsBirthYear);
		request.setAttribute("lsEndYear", lsEndYear);
		request.setAttribute("lsMonth", lsMonth);
		request.setAttribute("lsDay", lsDay);
	}

	/**
	 * Hàm lấy dữ liệu default của user
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return UserInfor thông tin user
	 */
	protected UserInfor setDefaultValue(HttpServletRequest request, HttpServletResponse response) {
		UserInfor user = new UserInfor();
		Calendar c = Calendar.getInstance();

		user.setLoginName(request.getParameter("id"));
		if (request.getParameter("group_id") != null) {
			int groupId = Integer.parseInt(request.getParameter("group_id"));
			MstGroupLogicImpl groupLogic = new MstGroupLogicImpl();

			user.setGroupId(groupId);
			user.setGroupName(groupLogic.getGroupNameById(groupId));
		} else {
			user.setGroupId(0);
		}
		user.setFullName(request.getParameter("name"));
		user.setKanaName(request.getParameter("kanaName"));
		if (request.getParameter("birthYear") != null) {
			c.set(Calendar.YEAR, Integer.parseInt(request.getParameter("birthYear").toString()));
		}
		if (request.getParameter("birthMonth") != null) {
			request.setAttribute("edited", true);
			c.set(Calendar.MONTH, Integer.parseInt(request.getParameter("birthMonth").toString()));
		}
		if (request.getParameter("birthDate") != null) {
			c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("birthDate").toString()));
		}
		user.setBirth(c.getTime());
		c.clear();
		c = Calendar.getInstance();
		user.setEmail(request.getParameter("email"));
		user.setTel(request.getParameter("tel"));
		user.setPass(request.getParameter("password"));
		user.setRePass(request.getParameter("repassword"));
		if (request.getParameter("kyu_id") != null) {
			String codeLevel = request.getParameter("kyu_id");
			MstJapanLogicImpl japanLogic = new MstJapanLogicImpl();

			user.setCodeLevel(codeLevel);
			user.setNameLevel(japanLogic.getNameLevelByCode(codeLevel));
		}
		if (request.getParameter("startYear") != null) {
			c.set(Calendar.YEAR, Integer.parseInt(request.getParameter("startYear").toString()));
		}
		if (request.getParameter("startMonth") != null) {
			c.set(Calendar.MONTH, Integer.parseInt(request.getParameter("startMonth").toString()));
		}
		if (request.getParameter("startDate") != null) {
			c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("startDate").toString()));
		}
		user.setStartDate(c.getTime());
		c.clear();
		c = Calendar.getInstance();
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
		if (request.getParameter("endYear") != null) {
			c.set(Calendar.YEAR, Integer.parseInt(request.getParameter("endYear").toString()));
		}
		if (request.getParameter("endMonth") != null) {
			request.setAttribute("edited", true);
			c.set(Calendar.MONTH, Integer.parseInt(request.getParameter("endMonth").toString()));
		}
		if (request.getParameter("endDate") != null) {
			request.setAttribute("edited", true);
			c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(request.getParameter("endDate").toString()));
		}
		user.setEndDate(c.getTime());
		if (request.getParameter("total") != null) {
			try {
				user.setPointString(request.getParameter("total").toString());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				user.setPointString("");
			}
		} else {
			user.setPointString("");
		}

		return user;
	}

	/**
	 * Hàm set dữ liệu cần thiết lên request
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	protected void addUserInput(HttpServletRequest request, HttpServletResponse response) {
		setDataLogicADM003(request, response);
    	UserInfor user = setDefaultValue(request, response);
    	request.setAttribute("userInfor", user);
	}

	/**
	 * Hàm validate thông tin user đã nhập
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	protected void addUserValidate(HttpServletRequest request, HttpServletResponse response, boolean addUser) {
		setDataLogicADM003(request, response);
		UserInfor user = setDefaultValue(request, response);
		List<String> lsError = ValidateUser.validateUserInfor(user, addUser);
		if (!lsError.isEmpty()) {
			request.setAttribute("lsError", lsError);
		} else {
			HttpSession session = request.getSession();

			//Fix date time jsp
			Calendar c = Calendar.getInstance();
			c.setTime(user.getBirth());
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
			user.setBirth(c.getTime());

			if (!"-1".equals(user.getCodeLevel())) {
				c.setTime(user.getStartDate());
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
				user.setStartDate(c.getTime());

				c.setTime(user.getEndDate());
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
				user.setEndDate(c.getTime());
			}

			session.setAttribute("userInfor", user);
		}
		request.setAttribute("userInfor", user);
	}
}
