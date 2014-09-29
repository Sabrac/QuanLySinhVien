package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managestudent.entities.QuocTich;
import managestudent.logics.impl.QuocTichLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class QuocTichProcessController
 */
public class QuocTichProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuocTichProcessController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			template = Constant.SYSTEM_ERR;
			if(request.getSession().getAttribute("quoctich") != null) {
				request.setAttribute("quoctich", request.getSession().getAttribute("quoctich"));
				template = Constant.QUOCTICHPROCESS;
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
				template = Constant.QUOCTICHPROCESS;
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
				template = Constant.QUOCTICHPROCESS;
			}
			if(request.getParameter("id") != null) {
				request.setAttribute("id", request.getParameter("id"));
				template = Constant.QUOCTICHPROCESS;
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
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getParameter("submit") != null) {
				QuocTich quocTich = setDefaultData(request, response);

				if(request.getAttribute("lsMessage") != null) {
					request.setAttribute("quoctich", quocTich);
					RequestDispatcher req = request.getRequestDispatcher(Constant.QUOCTICHPROCESS);
					req.forward(request, response);
					return;
				}

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateQuocTichInfor(quocTich, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateQuocTichInfor(quocTich, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("quoctich", quocTich);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					if(request.getParameter("id") != null) {
						request.setAttribute("id", request.getParameter("id"));
					}
					template = Constant.QUOCTICHPROCESS;
				} else {
					request.getSession().setAttribute("quoctich", quocTich);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, quocTich, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("quoctich");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("id") != null) {
								try {
									QuocTichLogicsImpl quocTichLogics = new QuocTichLogicsImpl();
									QuocTich quocTichTemp = quocTichLogics.getQuocTichById(Integer.parseInt(request.getParameter("id")));

									if(quocTichTemp != null) {
										boolean rs = processData(Integer.parseInt(request.getParameter("id")), quocTich, false);

										if (rs) {
											//lsMessage.add(MessageProperties.getMessage("msg_002"));
											response.sendRedirect("Result.do?update=success");
											return;
										} else {
											template = Constant.SYSTEM_ERR;
										}
									} else {
										template = Constant.SYSTEM_ERR;
									}
								} catch (NumberFormatException e) {
									System.out.println("An error occur: " + e.getMessage());
									lsMessage.add(MessageErrorProperties.getMessage("error_024"));
									template = Constant.QUOCTICHPROCESS;
								}
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if("delete".equals(ref)) {
							try {
								if(request.getParameter("id") != null) {
									QuocTichLogicsImpl quocTichLogics = new QuocTichLogicsImpl();
									QuocTich quocTichTemp = quocTichLogics.getQuocTichById(Integer.parseInt(request.getParameter("id")));

									if(quocTichTemp != null) {
										boolean rs = quocTichLogics.deleteQuocTichById(quocTichTemp.getQuocTichId());

										if(rs) {
											response.sendRedirect("Result.do?delete=success");
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
							} catch (NumberFormatException e) {
								System.out.println("An error occur: " + e.getMessage());
								lsMessage.add(MessageErrorProperties.getMessage("error_024"));
								template = Constant.QUOCTICHPROCESS;
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
	 * Gán dữ liệu vào đối tượng quốc tịch
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return QuocTich đối tượng quốc tịch
	 */
	protected QuocTich setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		QuocTich quocTich = new QuocTich();
		List<String> lsMessage = new ArrayList<String>();

		try {
			if(request.getParameter("id") != null && request.getParameter("id").length() > 0) {
				quocTich.setQuocTichId(Integer.parseInt(request.getParameter("id")));
			}
			if(request.getParameter("tenquoctich") != null) {
				quocTich.setTenQuocTich(request.getParameter("tenquoctich"));
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occur: " + e.getMessage());
			lsMessage.add(MessageErrorProperties.getMessage("error_024"));
			request.setAttribute("lsMessage", lsMessage);
		}

		return quocTich;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int quocTichId, QuocTich quocTich, boolean isAdd) {
		boolean rs = false;
		QuocTichLogicsImpl quocTichLogics = new QuocTichLogicsImpl();

		if(isAdd) {
			rs = quocTichLogics.addQuocTich(quocTich);
		} else {
			rs = quocTichLogics.updateQuocTichById(quocTichId, quocTich);
		}

		return rs;
	}
}
