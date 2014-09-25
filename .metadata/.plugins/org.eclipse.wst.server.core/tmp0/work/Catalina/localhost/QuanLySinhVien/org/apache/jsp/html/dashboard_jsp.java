package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>Retina Dashboard</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\" media=\"all\" />\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction redirect(dmName) {\r\n");
      out.write("\t\t\twindow.location.href = \"ListDM.do?name=\" + dmName;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!--[if IE]><link rel=\"stylesheet\" href=\"css/ie.css\" media=\"all\" /><![endif]-->\r\n");
      out.write("\t<!--[if lt IE 9]><link rel=\"stylesheet\" href=\"css/lt-ie-9.css\" media=\"all\" /><![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"testing\">\r\n");
      out.write("<header class=\"main\">\r\n");
      out.write("\t<h1><strong>Retina</strong> Dashboard</h1>\r\n");
      out.write("\t<input type=\"text\" value=\"search\" />\r\n");
      out.write("</header>\r\n");
      out.write("<section class=\"user\">\r\n");
      out.write("\t<div class=\"profile-img\">\r\n");
      out.write("\t\t<p><img src=\"./images/uiface2.png\" alt=\"\" height=\"40\" width=\"40\" /> Welcome back ");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"buttons\">\r\n");
      out.write("\t\t<span class=\"button\">Help</span>\r\n");
      out.write("\t\t<span class=\"button blue\"><a href=\"/QuanLySinhVien/Logout.do\">Đăng xuất</a></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "left-menu.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<section class=\"content\">\r\n");
      out.write("\t<section class=\"widget\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<span class=\"icon\">&#128200;</span>\r\n");
      out.write("\t\t\t<hgroup>\r\n");
      out.write("\t\t\t\t<h1>QUẢN LÝ DANH MỤC</h1>\r\n");
      out.write("\t\t\t\t<h2>Danh sách các danh mục</h2>\r\n");
      out.write("\t\t\t</hgroup>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<div class=\"content cycle\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table align=\"center\" class=\"dashboard-table\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLSV\" value=\"Quản Lý Hồ Sơ Sinh Viên\" onclick=\"redirect('sinhvien')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLCN\" value=\"Quản Lý Chuyên Ngành\" onclick=\"redirect('chuyennganh')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLDT\" value=\"Quản Lý Dân Tộc\" onclick=\"redirect('dantoc')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLHDT\" value=\"Quản Lý Hệ Đào Tạo\" onclick=\"redirect('hedaotao')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLHK\" value=\"Quản Lý Học Kỳ\" onclick=\"redirect('hocky')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLKH\" value=\"Quản Lý Khóa Học\" onclick=\"redirect('khoahoc')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLLH\" value=\"Quản Lý Lớp Học\" onclick=\"redirect('lophoc')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLMH\" value=\"Quản Lý Môn Học\" onclick=\"redirect('monhoc')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLN\" value=\"Quản Lý Ngành\" onclick=\"redirect('nganh')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLQT\" value=\"Quản Lý Quốc Tịch\" onclick=\"redirect('quoctich')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" name=\"btnQLTG\" value=\"Quản Lý Tôn Giáo\" onclick=\"redirect('tongiao')\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</section>\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.wysiwyg.js\"></script>\r\n");
      out.write("<script src=\"../js/custom.js\"></script>\r\n");
      out.write("<script src=\"../js/cycle.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.checkbox.min.js\"></script>\r\n");
      out.write("<script src=\"../js/flot.js\"></script>\r\n");
      out.write("<script src=\"../js/flot.resize.js\"></script>\r\n");
      out.write("<script src=\"../js/flot-time.js\"></script>\r\n");
      out.write("<script src=\"../js/flot-pie.js\"></script>\r\n");
      out.write("<script src=\"../js/flot-graphs.js\"></script>\r\n");
      out.write("<script src=\"../js/cycle.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.tablesorter.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// Feature slider for graphs\r\n");
      out.write("$('.cycle').cycle({\r\n");
      out.write("\tfx: \"scrollHorz\",\r\n");
      out.write("\ttimeout: 0,\r\n");
      out.write("    slideResize: 0,\r\n");
      out.write("    prev:    '.left-btn',\r\n");
      out.write("    next:    '.right-btn'\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /html/dashboard.jsp(29,83) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginId}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
