/**
 * Copyright(C) 2014 Luvina
 *
 * DetailUserController.java, Jul 16, 2014 LA-PM
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

import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;
import net.luvina.manageuser.utils.Constant;

/**
 * Servlet implementation class DeatailUserController
 */
public class DeatailUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeatailUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String template = "";
		int userId = -1;

		if (session.getAttribute("loginId") != null) {
			try {
				userId = Integer.parseInt(request.getParameter("userId"));
				//Set link cho button back
				request.setAttribute("back", Constant.LIST_USER);

				TblUserLogicImpl userLogic = new TblUserLogicImpl();
				UserInfor user = userLogic.getUserInfor(userId);

				if (user != null) {
					session.setAttribute("userInfor", user);
					template = Constant.ADM005;
				} else {
					template = Constant.ERROR;
				}
			} catch (NumberFormatException e) {
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
		doGet(request, response);
	}

}
