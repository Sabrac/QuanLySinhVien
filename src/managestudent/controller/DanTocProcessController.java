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
import managestudent.validates.ValidateInfor;

/**
 * Servlet implementation class DanTocProcessController
 */
public class DanTocProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanTocProcessController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			if(request.getSession().getAttribute("dantoc") != null) {
				request.setAttribute("dantoc", request.getSession().getAttribute("dantoc"));
			}
			if(request.getParameter("lsMessage") != null) {
				lsMessage.add(request.getParameter("lsMessage"));
			}
			if(request.getParameter("ref") != null) {
				request.setAttribute("ref", request.getParameter("ref"));
			}

			template = Constant.DANTOCPROCESS;
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
				DanToc danToc = setDefaultData(request, response);

				if (request.getParameter("ref") != null) {
					if("add".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateDanTocInfor(danToc, true);
					} else if("update".equals(request.getParameter("ref"))) {
						lsMessage = ValidateInfor.validateDanTocInfor(danToc, false);
					}
				}

				if (lsMessage.size() > 0) {
					request.setAttribute("lsMessage", lsMessage);
					request.setAttribute("dantoc", danToc);
					if (request.getParameter("ref") != null) {
						request.setAttribute("ref", request.getParameter("ref"));
					}
					template = Constant.DANTOCPROCESS;
				} else {
					request.getSession().setAttribute("dantoc", danToc);
					if (request.getParameter("ref") != null) {
						String ref = request.getParameter("ref");

						if ("add".equals(ref)) {
							boolean rs = processData(-1, danToc, true);

							if (rs) {
								//lsMessage.add(MessageProperties.getMessage("msg_001"));
								request.getSession().removeAttribute("dantoc");
								response.sendRedirect("Result.do?add=success");
								return;
							} else {
								template = Constant.SYSTEM_ERR;
							}
						} else if ("update".equals(ref)) {
							if (request.getParameter("dantocid") != null) {
								DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
								danToc = danTocLogics.getDanTocById((Integer.parseInt(request.getParameter("dantocid"))));

								if(danToc != null) {
									boolean rs = processData(Integer.parseInt(request.getParameter("dantocid")), danToc, false);

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
	 * Gán dữ liệu vào đối tượng dân tộc
	 *
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return DanToc đối tượng dân tộc
	 */
	protected DanToc setDefaultData(HttpServletRequest request, HttpServletResponse response) {
		DanToc danToc = new DanToc();

		if(request.getParameter("id") != null) {
			danToc.setDanTocId(Integer.parseInt(request.getParameter("id")));
		}
		if(request.getParameter("tendantoc") != null) {
			danToc.setTenDanToc(request.getParameter("tendantoc"));
		}

		return danToc;
	}

	/**
	 * Xử lý dữ liệu vào tầng logics
	 *
	 * @param isAdd true: action add / false: action update
	 * @return true: thành công / false: thất bại
	 */
	protected boolean processData(int danTocId, DanToc danToc, boolean isAdd) {
		boolean rs = false;

		DanTocLogicsImpl danTocLogics = new DanTocLogicsImpl();
		if(isAdd) {
			rs = danTocLogics.addDanToc(danToc);
		} else {
			rs = danTocLogics.updateDanTocById(danTocId, danToc);
		}

		return rs;
	}
}
