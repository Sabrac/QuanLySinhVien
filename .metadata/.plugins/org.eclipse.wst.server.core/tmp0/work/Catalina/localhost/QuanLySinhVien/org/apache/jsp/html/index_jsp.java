package org.apache.jsp.html;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Retina Dashboard</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"css/style.css\" media=\"all\" />\r\n");
      out.write("\t<!--[if IE]><link rel=\"stylesheet\" href=\"css/ie.css\" media=\"all\" /><![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login\">\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<h1><strong>Hệ thống</strong> Quản Lý Sinh Viên</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Start list thông báo lỗi (nếu có) -->\r\n");
      out.write("\t\t\t");

			if(request.getAttribute("lsMessage") != null) {
				List<String> lsErrMessage = (ArrayList<String>)request.getAttribute("lsMessage");
				for (String errMessage : lsErrMessage) {
			
      out.write("\r\n");
      out.write("\t\t\t<a style=\"font: bold; color: red\"> ");
      out.print( errMessage );
      out.write(" </a><br />\r\n");
      out.write("\t\t\t");

				}
			}

			String loginId = "Tên đăng nhập";
			if(session.getAttribute("loginId") != null) {
				loginId = session.getAttribute("loginId").toString();
			}

			String pass = "password";
			if(session.getAttribute("password") != null) {
				pass = session.getAttribute("password").toString();
			}
			
      out.write("\r\n");
      out.write("\t\t<!-- End list thông báo lỗi -->\r\n");
      out.write("\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<form method=\"post\" action=\"Login.do\">\r\n");
      out.write("\t\t\t<input name=\"loginId\" type=\"text\" value=\"");
      out.print( loginId);
      out.write("\" />\r\n");
      out.write("\t\t\t<input name=\"password\" value=\"");
      out.print( pass);
      out.write("\" type=\"password\" />\r\n");
      out.write("\t\t\t<button class=\"blue\">Login</button>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<p><a href=\"#\">Quên mật khẩu?</a></p>\r\n");
      out.write("\t</section>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("// Page load delay by Curtis Henson - http://curtishenson.com/articles/quick-tip-delay-page-loading-with-jquery/\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('.login button').click(function(e){\r\n");
      out.write("\t\t// Get the url of the link\r\n");
      out.write("\t\tvar toLoad = $(this).attr('href');\r\n");
      out.write("\r\n");
      out.write("\t\t// Do some stuff\r\n");
      out.write("\t\t$(this).addClass(\"loading\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t// Stop doing stuff\r\n");
      out.write("\t\t\t// Wait 700ms before loading the url\r\n");
      out.write("\t\t\tsetTimeout(function(){window.location = toLoad}, 10000);\r\n");
      out.write("\r\n");
      out.write("\t\t// Don't let the link do its natural thing\r\n");
      out.write("\t\te.preventDefault\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$('input').each(function() {\r\n");
      out.write("\r\n");
      out.write("       var default_value = this.value;\r\n");
      out.write("\r\n");
      out.write("       $(this).focus(function(){\r\n");
      out.write("               if(this.value == default_value) {\r\n");
      out.write("                       this.value = '';\r\n");
      out.write("               }\r\n");
      out.write("       });\r\n");
      out.write("\r\n");
      out.write("       $(this).blur(function(){\r\n");
      out.write("               if(this.value == '') {\r\n");
      out.write("                       this.value = default_value;\r\n");
      out.write("               }\r\n");
      out.write("       });\r\n");
      out.write("\r\n");
      out.write("});\r\n");
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
}
