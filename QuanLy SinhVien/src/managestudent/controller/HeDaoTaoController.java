/**
 * Copyright(C) K16SE 2014
 *
 * HeDaoTaoController.java, Aug 26, 2014 HaVH
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
import javax.servlet.http.HttpSession;

import managestudent.entities.HeDaoTao;
import managestudent.logics.impl.HeDaoTaoLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class HeDaoTaoController
 */
public class HeDaoTaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeDaoTaoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			HttpSession session = request.getSession();
			template = Constant.HEDAOTAO;
			HeDaoTaoLogicsImpl hdtLogics = new HeDaoTaoLogicsImpl();
			List<HeDaoTao> lsHdt = new ArrayList<HeDaoTao>();
			HeDaoTao hdt = new HeDaoTao();
			int limit = Integer.parseInt(MessageProperties.getMessage("limit"));
			int range = Integer.parseInt(MessageProperties.getMessage("range"));
			List<Integer> lsPage = new ArrayList<Integer>();
			int page = 0;
			int totalPage = 0;
			int totalRecords = 0;
			int offset = 0;
			int sortColumn = 1;
			String sortType = "";

			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if(page == 0) {
				page = 1;
			}

			if(request.getParameter("mahedaotao") != null) {
				hdt.setMaHeDt(request.getParameter("mahedaotao"));
				session.setAttribute("mahedaotao", hdt.getMaHeDt());
			} else if(session.getAttribute("mahedaotao") != null) {
				hdt.setMaHeDt(session.getAttribute("mahedaotao").toString());
			}
			if(request.getParameter("tenhedaotao") != null) {
				hdt.setTenHeDt(request.getParameter("tenhedaotao"));
				session.setAttribute("tenhedaotao", hdt.getTenHeDt());
			} else if(session.getAttribute("tenhedaotao") != null) {
				hdt.setTenHeDt(session.getAttribute("tenhedaotao").toString());
			}

			if(request.getParameter("sortcolumn") != null) {
				if(request.getParameter("sortcolumn").length() > 0) {
					sortColumn = Integer.parseInt(request.getParameter("sortcolumn"));
				}

				request.setAttribute("sortcolumn", sortColumn);
			}
			if(request.getParameter("sorttype") != null) {
				sortType = request.getParameter("sorttype");
				request.setAttribute("sorttype", sortType);
			}

			totalRecords = hdtLogics.getTotalRecords(hdt);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsHdt = hdtLogics.getAllHeDaoTao(hdt, offset, limit, sortColumn, sortType);
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsHdt == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsHdt.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsHdt);
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
