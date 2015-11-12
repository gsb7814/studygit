package mytags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import java.io.*;

public class Tag1 extends BodyTagSupport {
    public Tag1() {
    }

    public int doEndTag() {
        BodyContent bc = getBodyContent();
        String newStr = bc.getString().toUpperCase();
        JspWriter out = pageContext.getOut();
        try {
            out.println(newStr);
            out.println("<font color='red'>¥¶¿ÌΩ· ¯</font>");
            bc.clear();
        } catch (IOException ex) {
        }
        return EVAL_PAGE;
    }
}
