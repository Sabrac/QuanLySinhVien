/**
 * Copyright(C) K16SE 2014
 *
 * ChuyenNganhController.java, Aug 26, 2014 HaVH
 *
 */
package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.ChuyenNganh;
import managestudent.entities.Nganh;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;

/**
 * Servlet implementation class ChuyenNganhController
 */
public class ChuyenNganhController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChuyenNganhController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			ChuyenNganhLogicsImpl chuyenNganhLogics = new ChuyenNganhLogicsImpl();
			template = Constant.CHUYENNGANH;
			NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
			List<ChuyenNganh> lsChuyenNganh = new ArrayList<ChuyenNganh>();
			List<Nganh> lsNganh = new ArrayList<Nganh>();

			lsChuyenNganh = chuyenNganhLogics.getAllChuyenNganh();
			lsNganh = nganhLogics.getAllNganh();

			if (lsChuyenNganh == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
			} else if (lsChuyenNganh.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsChuyenNganh);
				request.setAttribute("lsNganh", lsNganh);
			}
		} else {
			template = Constant.LOGIN;
			lsMessage.add(MessageErrorProperties.getMessage("error_023"));
		}

		request.setAttribute("lsMessage", lsMessage);
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
