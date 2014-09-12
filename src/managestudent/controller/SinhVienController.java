package managestudent.controller;

import java.io.IOException;
import java.util.ArrayList;
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

			List<DmSinhVien> lsSinhVien = new ArrayList<DmSinhVien>();
			List<HeDaoTao> lsHdt = new ArrayList<HeDaoTao>();
			List<LopHoc> lsLop = new ArrayList<LopHoc>();
			List<KhoaHoc> lsKhoaHoc = new ArrayList<KhoaHoc>();

			lsSinhVien = sinhVienLogics.getAllSinhVien();
			lsHdt = heDtLogics.getAllHeDaoTao();
			lsLop = lopHocLogics.getAllLopHoc();
			lsKhoaHoc = khoaHocLogics.getAllKhoaHoc();

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
