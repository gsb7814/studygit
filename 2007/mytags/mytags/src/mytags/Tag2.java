package mytags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.sql.*;
import javax.servlet.jsp.JspWriter;

public class Tag2 extends BodyTagSupport {
    public Tag2() {
        super();
    }

   public int doStartTag() {
    try {
        pageContext.getOut().println("开始调用doStartTag。。。<br>");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
       return EVAL_BODY_INCLUDE;
   }

    public int doEndTag() throws JspException {

        Connection conn = this.getConnection("jdbc:odbc:petclinicapps","sun.jdbc.odbc.JdbcOdbcDriver");
        String sql = "select * from employee";
        ResultSet rs = this.query(conn,sql);
        JspWriter out = pageContext.getOut();
        try {
            out.println("开始调用doEndTag。。。<br>");
            while (rs.next()) {
                out.println("<p>name = " + rs.getString("name")+"  ");
                out.println("password = " + rs.getString("password")+"</p>");
            }
            if(rs != null) {
                rs.close();
            }
            if(conn != null) {
               close(conn);
           }


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return EVAL_PAGE;
    }

    public void setBodyContent(BodyContent bc) {
        super.setBodyContent(bc);
        try {
            pageContext.getOut().println("开始调用setBodyContent。。。<br>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void doInitBody() throws JspException {
        super.doInitBody();
        try {
            pageContext.getOut().println("开始调用doInitBody。。。<br>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int doAfterBody() throws JspException {

        try {
            pageContext.getOut().println("开始调用doAfterBody。。。<br>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

       return super.doAfterBody();
   }


    private Connection getConnection(String url, String driver) {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    private ResultSet query(Connection conn, String sql) {
        if (conn != null) {
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            return psmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        }
        return null;
    }

    private void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}
