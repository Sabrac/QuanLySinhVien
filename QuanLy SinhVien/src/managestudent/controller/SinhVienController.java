package managestudent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managestudent.entities.DmSinhVien;
import managestudent.entities.HeDaoTao;
import managestudent.entities.KhoaHoc;
import managestudent.entities.LopHoc;
import managestudent.logics.impl.DmSinhVienLogicsImpl;
import managestudent.logics.impl.HeDaoTaoLogicsImpl;
import managestudent.logics.impl.KhoaHocLogicsImpl;
import managestudent.logics.impl.LopHocLogicsImpl;
import managestudent.utils.Common;
import managestudent.utils.Constant;
import managestudent.utils.MessageErrorProperties;
import managestudent.utils.MessageProperties;

/**
 * Servlet implementation class SinhVienController
 */
public class SinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SinhVienController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String template = "";
		List<String> lsMessage = new ArrayList<String>();

		if(Common.checkLogin(request.getSession())) {
			DmSinhVienLogicsImpl sinhVienLogics = new DmSinhVienLogicsImpl();
			HeDaoTaoLogicsImpl heDtLogics = new HeDaoTaoLogicsImpl();
			LopHocLogicsImpl lopHocLogics = new LopHocLogicsImpl();
			KhoaHocLogicsImpl khoaHocLogics = new KhoaHocLogicsImpl();
			int limit = Integer.parseInt(MessageProperties.getMessage("limit"));
			int range = Integer.parseInt(MessageProperties.getMessage("range"));
			List<Integer> lsPage = new ArrayList<Integer>();
			int page = 0;
			int totalPage = 0;
			int totalRecords = 0;
			DmSinhVien sinhVien = new DmSinhVien();
			int offset = 0;
			int sortColumn = 1;
			String sortType = "";

			List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();
			List<HeDaoTao> lsHdt = new ArrayList<HeDaoTao>();
			List<LopHoc> lsLop = new ArrayList<LopHoc>();
			List<KhoaHoc> lsKhoaHoc = new ArrayList<KhoaHoc>();

			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			if(page == 0) {
				page = 1;
			}

			if(request.getParameter("masv") != null) {
				sinhVien.setMaSinhVien(request.getParameter("masv"));
				request.setAttribute("masv", sinhVien.getMaSinhVien());
			}
			if(request.getParameter("hodem") != null) {
				sinhVien.setHoDem(request.getParameter("hodem"));
				request.setAttribute("hodem", sinhVien.getHoDem());
			}
			if(request.getParameter("ten") != null) {
				sinhVien.setTen(request.getParameter("ten"));
				request.setAttribute("ten", sinhVien.getTen());
			}
			if(request.getParameter("ngaysinh") != null) {
				try {
					sinhVien.setNgaySinh(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("ngaysinh")));
					request.setAttribute("ngaysinh", sinhVien.getNgaySinh());
				} catch (ParseException e) {
					System.out.println("An error occur: " + e.getMessage());
					sinhVien.setNgaySinh(new Date());
					request.setAttribute("ngaysinh", new Date());
				}
			}
			if(request.getParameter("hedaotaoid") != null) {
				try {
					sinhVien.setHeDtId(Integer.parseInt(request.getParameter("hedaotaoid")));
					request.setAttribute("hedaotaoid", sinhVien.getHeDtId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tenhedaotao") != null) {
				sinhVien.setTenHeDaoTao(request.getParameter("tenhedaotao"));
				request.setAttribute("tenhedaotao", sinhVien.getTenHeDaoTao());
			}
			if(request.getParameter("lopid") != null) {
				try {
					sinhVien.setLopId(Integer.parseInt(request.getParameter("lopid")));
					request.setAttribute("lopid", sinhVien.getLopId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tenlop") != null) {
				sinhVien.setTenLopHoc(request.getParameter("tenlop"));
				request.setAttribute("tenlop", sinhVien.getTenLopHoc());
			}
			if(request.getParameter("khoahocid") != null) {
				try {
					sinhVien.setKhoaHocId(Integer.parseInt(request.getParameter("khoahocid")));
					request.setAttribute("khoahocid", sinhVien.getKhoaHocId());
				} catch (NumberFormatException e) {
					System.out.println("An error occur: " + e.getMessage());
				}
			}
			if(request.getParameter("tenkhoahoc") != null) {
				sinhVien.setTenKhoaHoc(request.getParameter("tenkhoahoc"));
				request.setAttribute("tenkhoahoc", sinhVien.getTenKhoaHoc());
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

			totalRecords = sinhVienLogics.getTotalRecords(sinhVien);
			offset = (page > 0) ? limit * ((int) page - 1) : 0;

			lsSinhVien = sinhVienLogics.getAllSinhVien(sinhVien, offset, limit, sortColumn, sortType);
			lsHdt = heDtLogics.getAllHeDaoTao(new HeDaoTao(), 0, heDtLogics.getTotalRecords(new HeDaoTao()), 1, "ASC");
			lsLop = lopHocLogics.getAllLopHoc(new LopHoc(), 0, lopHocLogics.getTotalRecords(new LopHoc()), 1, "ASC");
			lsKhoaHoc = khoaHocLogics.getAllKhoaHoc(new KhoaHoc(), 0, khoaHocLogics.getTotalRecords(new KhoaHoc()), 1, "ASC");
			lsPage = Common.getListPaging(totalRecords, limit, page);
			totalPage = Common.getTotalPage(totalRecords, limit);

			request.setAttribute("page", page);
	        request.setAttribute("lsPage", lsPage);
	        request.setAttribute("range", range);
	        request.setAttribute("totalPage", totalPage);

			if (lsSinhVien == null) {
				lsMessage.add(MessageErrorProperties.getMessage("error_022"));
				request.setAttribute("showTable", false);
			} else if (lsSinhVien.size() <= 0) {
				lsMessage.add(MessageErrorProperties.getMessage("error_001_table"));
				request.setAttribute("showTable", false);
			} else {
				request.setAttribute("lsData", lsSinhVien);
				request.setAttribute("lsHdt", lsHdt);
				request.setAttribute("lsLop", lsLop);
				request.setAttribute("lsKhoaHoc", lsKhoaHoc);
			}

			template = Constant.SINHVIEN;
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
