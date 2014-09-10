/**
 * Copyright(C) K16SE 2014
 *
 * BaseDaoImpl.java, Aug 26, 2014 HaVH
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
import managestudent.entities.DanToc;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HeDaoTao;
import managestudent.entities.HocKy;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.entities.MonHoc;
import managestudent.entities.Nganh;
import managestudent.entities.QuocTich;
import managestudent.entities.TonGiao;
import managestudent.logics.impl.ChuyenNganhLogicsImpl;
import managestudent.logics.impl.DanTocLogicsImpl;
import managestudent.logics.impl.DmSinhVienLogicsImpl;
import managestudent.logics.impl.HeDaoTaoLogicsImpl;
import managestudent.logics.impl.HocKyLogicsImpl;
import managestudent.logics.impl.KhoaHocLogicsImpl;
import managestudent.logics.impl.LopHocLogicsImpl;
import managestudent.logics.impl.MonHocLogicsImpl;
import managestudent.logics.impl.NganhLogicsImpl;
import managestudent.logics.impl.QuocTichLogicsImpl;
import managestudent.logics.impl.TonGIaoLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;

/**
 * Servlet implementation class ListDanhMucController
 */
public class ListDanhMucController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDanhMucController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if (Common.checkLogin(request.getSession())) {
			if (request.getParameter("name") != null) {
				String danhMuc = request.getParameter("name");

				if (danhMuc.equals("chuyennganh")) {
					response.sendRedirect("ChuyenNganh.do");
					return;
				} else if (danhMuc.equals("dantoc")) {
					response.sendRedirect("DanToc.do");
					return;
				} else if (danhMuc.equals("sinhvien")) {
					response.sendRedirect("SinhVien.do");
					return;
				} else if (danhMuc.equals("hedaotao")) {
					HeDaoTaoLogicsImpl hdtLogics = new HeDaoTaoLogicsImpl();
					List<HeDaoTao> lsHdt = new ArrayList<HeDaoTao>();

					lsHdt = hdtLogics.getAllHeDaoTao();

					if (lsHdt == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsHdt.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.HEDAOTAO;
						request.setAttribute("lsData", lsHdt);
					}
				} else if (danhMuc.equals("hocky")) {
					HocKyLogicsImpl hocKyLogics = new HocKyLogicsImpl();
					List<HocKy> lsHocKy = new ArrayList<HocKy>();

					lsHocKy = hocKyLogics.getAllHocKy();

					if (lsHocKy == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsHocKy.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.HOCKY;
						request.setAttribute("lsData", lsHocKy);
					}
				} else if (danhMuc.equals("khoahoc")) {
					KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();
					List<KhoaHoc> lsKhoaHoc = new ArrayList<KhoaHoc>();

					lsKhoaHoc = khoaHocLogics.getAllKhoaHoc();

					if (lsKhoaHoc == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsKhoaHoc.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.KHOAHOC;
						request.setAttribute("lsData", lsKhoaHoc);
					}
				} else if (danhMuc.equals("lophoc")) {
					LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
					List<LopHoc> lsLopHoc = new ArrayList<LopHoc>();

					lsLopHoc = lopHocLogics.getAllLopHoc();

					if (lsLopHoc == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsLopHoc.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.LOPHOC;
						request.setAttribute("lsData", lsLopHoc);
					}
				} else if (danhMuc.equals("monhoc")) {
					MonHocLogicsImpl monHocLogics = new MonHocLogicsImpl();
					List<MonHoc> lsMonHoc = new ArrayList<MonHoc>();

					lsMonHoc = monHocLogics.getAllMonHoc();

					if (lsMonHoc == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsMonHoc.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.MONHOC;
						request.setAttribute("lsData", lsMonHoc);
					}
				} else if (danhMuc.equals("nganh")) {
					NganhLogicsImpl nganhLogics = new NganhLogicsImpl();
					List<Nganh> lsNganh = new ArrayList<Nganh>();

					lsNganh = nganhLogics.getAllNganh();

					if (lsNganh == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsNganh.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.NGANH;
						request.setAttribute("lsData", lsNganh);
					}
				} else if (danhMuc.equals("quoctich")) {
					QuocTichLogicsImpl quocTichLogics = new QuocTichLogicsImpl();
					List<QuocTich> lsQuocTich = new ArrayList<QuocTich>();

					lsQuocTich = quocTichLogics.getAllQuocTich();

					if (lsQuocTich == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsQuocTich.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.QUOCTICH;
						request.setAttribute("lsData", lsQuocTich);
					}
				} else if (danhMuc.equals("tongiao")) {
					TonGIaoLogicsImpl tonGiaoLogics = new TonGIaoLogicsImpl();
					List<TonGiao> lsTonGiao = new ArrayList<TonGiao>();

					lsTonGiao = tonGiaoLogics.getAllTonGiao();

					if (lsTonGiao == null) {
						lsMessage.add(MessageErrorProperties.getMessage("error_022"));
					} else if (lsTonGiao.size() <= 0) {
						lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
					} else {
						template = Constant.TONGIAO;
						request.setAttribute("lsData", lsTonGiao);
					}
				} else {
					response.sendRedirect(Constant.SYSTEM_ERR);
					return;
				}

				request.setAttribute("lsMessage", lsMessage);
			} else {
				response.sendRedirect(Constant.SYSTEM_ERR);
				return;
			}
		} else {
			template = Constant.LOGIN;
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
		doGet(request, response);
	}

}
