package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_002dmenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav>\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li class=\"section\" id=\"btn-nav-dashboard\"><a href=\"DashBoard.do\"><span>Dashboard</span></a></li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"SinhVien.do\" id=\"btn-nav-sv\"><span>Quản lý hồ sơ sinh viên</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"ChuyenNganh.do\" id=\"btn-nav-chuyenganh\"><span>Quản lý chuyên ngành</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"DanToc.do\" id=\"btn-nav-dantoc\"><span>Quản lý dân tộc</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li><a href=\"HeDaoTao.do\" id=\"btn-nav-hedaotao\"><span>Quản lý hệ đào tạo</span></a></li>\r\n");
      out.write("\t\t<li><a href=\"HocKy.do\" id=\"btn-nav-hocky\"><span>Quản lý học kỳ</span></a></li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"KhoaHoc.do\" id=\"btn-nav-khoahoc\"><span>Quản lý khóa học</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"LopHoc.do\" id=\"btn-nav-lophoc\"><span>Quản lý lớp học</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"MonHoc.do\" id=\"btn-nav-monhoc\"><span>Quản lý môn học</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"Nganh.do\" id=\"btn-nav-nganh\"><span>Quản lý ngành</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"QuocTich.do\" id=\"btn-nav-quoctich\"><span>Quản lý quốc tịch</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li>\r\n");
      out.write("\t\t\t<a href=\"TonGiao.do\" id=\"btn-nav-tongiao\"><span>Quản lý tôn giáo</span></a>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
