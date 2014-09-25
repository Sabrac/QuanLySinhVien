package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import managestudent.entities.Nganh;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class NganhProcessController
 */
public class NganhProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NganhProcessController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getSession().getAttribute("nganh") != null) {
				request.setAttribute("nganh", request.getSession().getAttribute("nganh"));
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
			}

			template = Constant.NGANHPROCESS;
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
				Nganh nganh = setDefaultData(request, response);

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateNganhInfor(nganh, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateNganhInfor(nganh, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("nganh", nganh);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					template = Constant.NGANHPROCESS;
				} else {
					request.getSession().setAttribute("nganh", nganh);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, nganh, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("nganh");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("nganhid") != null) {
								NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
								nganh = nganhLogics.getNganhById(Integer.parseInt(request.getParameter("nganhid")));

								if(nganh != null) {
									boolean rs = processData(Integer.parseInt(request.getParameter("nganhid")), nganh, false);

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
	 * Gán dữ liệu vào đối tượng ngành
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return Nganh đối tượng ngành
	 */
	protected Nganh setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		Nganh nganh = new Nganh();

		if(request.getParameter("manganh") != null) {
			nganh.setMaNganh(request.getParameter("manganh"));
		}
		if(request.getParameter("tennganh") != null) {
			nganh.setTenNganh(request.getParameter("tennganh"));
		}
		if(request.getParameter("ghichu") != null) {
			nganh.setGhiChu(request.getParameter("ghichu"));
		}

		return nganh;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param nganhId int id ngành
	 * @param nganh Nganh đối tượng ngành
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int nganhId, Nganh nganh, boolean isAdd) {
		boolean rs = false;

		NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
		if(isAdd) {
			rs = nganhLogics.addNganh(nganh);
		} else {
			rs = nganhLogics.updateNganhByID(nganhId, nganh);
		}

		return rs;
	}
}
