/**
 * Copyright(C) 2014 Luvina
 *
 * AddUserConfirmController.java, Jun 25, 2014 LA-PM
 *
 */
package net.luvina.manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.luvina.manageuser.entities.TblDetailUserJapan;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;
import net.luvina.manageuser.utils.Constant;

/**
 * Servlet implementation class AddUserConfirmController
 */
public class AddUserConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserConfirmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String template = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginId") != null) {
			if (request.getParameter("ref") != null) {
				String ref = request.getParameter("ref");
				if ("ADM002".equals(ref)) {
					template = Constant.ADM004;
					request.setAttribute("back", Constant.ADD_USER);
					request.setAttribute("ref", ref);
				}
			} else {
				template = Constant.ERROR;
			}
		} else {
			template = Constant.ADM001;
		}


		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TblUserLogicImpl userLogic = new TblUserLogicImpl();
		HttpSession session = request.getSession();
		UserInfor user = (UserInfor) session.getAttribute("userInfor");
		boolean result = false;
		String ref = "";
		if (request.getParameter("ref") != null) {
			ref = request.getParameter("ref");
			if ("ADM002".equals(ref)) {
				result = userLogic.createUser(user);

				if (result) {
					response.sendRedirect(Constant.SUCCESS + "?type=" + Constant.INSERT_SUCCESS);
				}
				return;
			} else if ("ADM005".equals(ref)) {
				result = userLogic.updateUser(user);

				if (result) {
					response.sendRedirect(Constant.SUCCESS + "?type=" + Constant.UPDATE_SUCCESS);
				}
				return;
			}

			response.sendRedirect(Constant.SUCCESS + "?type=" + Constant.SYSTEM_ERROR);
		}
	}

}
