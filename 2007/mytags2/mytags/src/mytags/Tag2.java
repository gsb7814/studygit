package mytags;

import java.io.*;
import java.sql.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class Tag2 extends BodyTagSupport {

    private String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    private String url = "jdbc:odbc:petclinicapps";
    private String sql = "select * from employee";
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

        Connection conn = this.getConnection(url,driver);
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

    public String getDriver() {
        return driver;
    }

    public String getSql() {
        return sql;
    }

    public String getUrl() {
        return url;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
