package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.DanToc;
import managestudent.logics.impl.DanTocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;

/**
 * Servlet implementation class DanTocController
 */
public class DanTocController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanTocController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> lsMessage = new ArrayList<String>();
		String template = "";

		if(Common.checkLogin(request.getSession())) {
			DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
			List<DanToc> lsDanToc = new ArrayList<DanToc>();

			lsDanToc = danTocLogics.getAllDanToc();

			if (lsDanToc == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
			} else if (lsDanToc.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsDanToc);
			}

			template = Constant.DANTOC;
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
