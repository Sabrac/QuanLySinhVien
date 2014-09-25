package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.HeDaoTao;
import managestudent.logics.impl.HeDaoTaoLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class HeDaoTaoProcessController
 */
public class HeDaoTaoProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeDaoTaoProcessController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getSession().getAttribute("hedaotao") != null) {
				request.setAttribute("hedaotao", request.getSession().getAttribute("hedaotao"));
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
			}

			template = Constant.HEDAOTAOPROCESS;
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
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getParameter("submit") != null) {
				HeDaoTao hdt = setDefaultData(request, response);

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateHeDtInfor(hdt, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateHeDtInfor(hdt, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("hedaotao", hdt);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					template = Constant.HEDAOTAOPROCESS;
				} else {
					request.getSession().setAttribute("hedaotao", hdt);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, hdt, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("hedaotao");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								HeDaoTaoLogicsImpl hdtLogics = new HeDaoTaoLogicsImpl();
								hdt = hdtLogics.getHeDaoTaoById(Integer.parseInt(request.getParameter("id")));

								if(hdt != null) {
									boolean rs = processData(Integer.parseInt(request.getParameter("id")), hdt, false);

									if (rs) {
										//lsMessage.add(MessageProperties.getMessage("msg_002"));
										response.sendRedirect("Result.do?add=success");
										return;
									} else {
										template = Constant.SYSTEM_ERR;
									}
								} else {
									template = Constant.SYSTEM_ERR;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else {
							template = Constant.SYSTEM_ERR;
						}
					} else {
						template = Constant.SYSTEM_ERR;
					}
				}
			} else {
				doGet(request, response);
				return;
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
	 * Gán dữ liệu vào đối tượng hệ đào tạo
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return HeDaoTao đối tượng hệ đào tạo
	 */
	protected HeDaoTao setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		HeDaoTao hdt = new HeDaoTao();

		if(request.getParameter("id") != null) {
			hdt.setHeDtId(Integer.parseInt(request.getParameter("id")));
		}
		if(request.getParameter("mahedaotao") != null) {
			hdt.setMaHeDt(request.getParameter("mahedaotao"));
		}
		if(request.getParameter("tenhedaotao") != null) {
			hdt.setTenHeDt(request.getParameter("tenhedaotao"));
		}

		return hdt;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int hdtId, HeDaoTao hdt, boolean isAdd) {
		boolean rs = false;
		HeDaoTaoLogicsImpl hdtLogics = new HeDaoTaoLogicsImpl();

		if(isAdd) {
			rs = hdtLogics.addHeDaoTao(hdt);
		} else {
			rs = hdtLogics.updateHeDaoTaoById(hdtId, hdt);
		}

		return rs;
	}
}
