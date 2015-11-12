package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class testTag2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/mytags.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_guo_queryDB_url_sql_driver;

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_guo_queryDB_url_sql_driver = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_guo_queryDB_url_sql_driver.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>\r\n");
      out.write("testTag1\r\n");
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#ffffff\">\r\n");
      out.write("private String driver = \"sun.jdbc.odbc.JdbcOdbcDriver\";\r\n");
      out.write("    private String url = \"jdbc:odbc:petclinicapps\";\r\n");
      out.write("    private String sql = \"select * from employee\";<br /><br />\r\n");
      if (_jspx_meth_guo_queryDB_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_guo_queryDB_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  guo:queryDB
    mytags.Tag2 _jspx_th_guo_queryDB_0 = (mytags.Tag2) _jspx_tagPool_guo_queryDB_url_sql_driver.get(mytags.Tag2.class);
    _jspx_th_guo_queryDB_0.setPageContext(_jspx_page_context);
    _jspx_th_guo_queryDB_0.setParent(null);
    _jspx_th_guo_queryDB_0.setDriver("sun.jdbc.odbc.JdbcOdbcDriver");
    _jspx_th_guo_queryDB_0.setUrl("jdbc:odbc:petclinicapps");
    _jspx_th_guo_queryDB_0.setSql("select * from employee");
    int _jspx_eval_guo_queryDB_0 = _jspx_th_guo_queryDB_0.doStartTag();
    if (_jspx_eval_guo_queryDB_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_guo_queryDB_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_guo_queryDB_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_guo_queryDB_0.doInitBody();
      }
      do {
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_guo_queryDB_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_guo_queryDB_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_guo_queryDB_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    _jspx_tagPool_guo_queryDB_url_sql_driver.reuse(_jspx_th_guo_queryDB_0);
    return false;
  }
}
