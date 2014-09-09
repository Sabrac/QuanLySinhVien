/**
 * Copyright(C) 2014 Luvina
 *
 * SuccessController.java, Jun 25, 2014 LA-PM
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

import net.luvina.manageuser.utils.Constant;
import net.luvina.manageuser.utils.MessageProperties;

/**
 * Servlet implementation class SuccessController
 */
public class SuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuccessController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String template = "";
		HttpSession session = request.getSession();

		if (session.getAttribute("loginId") != null) {
			if (request.getHeader("referer") != null) {
				if (request.getHeader("referer").indexOf("AddUser.do?submit=true") > 0) {
					doPost(request, response);
					return;
				}
			}

			session.removeAttribute("userInfor");
			template = Constant.ERROR;
		} else {
			session.removeAttribute("userInfor");
			template = Constant.ADM001;
		}

		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String template = "";

		session.removeAttribute("userInfor");
		if (request.getParameter("type") != null) {
			String type = request.getParameter("type");
			if ("insert".equals(type)) {
				request.setAttribute("message", MessageProperties.getMessage("msg_001"));
			} else if ("update".equals(type)) {
				request.setAttribute("message", MessageProperties.getMessage("msg_002"));
			} else if ("delete".equals(type)) {
				request.setAttribute("message", MessageProperties.getMessage("msg_003"));
			} else if ("confirm".equals(type)) {
				request.setAttribute("message", MessageProperties.getMessage("msg_004"));
			} else if ("systemerror".equals(type)) {
				request.setAttribute("message", MessageProperties.getMessage("msg_006"));
			}
		} else {
			request.setAttribute("message", MessageProperties.getMessage("msg_006"));
		}

		template = Constant.ADM006;

		RequestDispatcher req = request.getRequestDispatcher(template);
		req.forward(request, response);
	}

}
