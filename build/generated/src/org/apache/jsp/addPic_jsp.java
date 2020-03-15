package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Person;
import com.daos.PersonDao;
import java.util.ArrayList;

public final class addPic_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Profile Pic</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("                function readURL(input) {\n");
      out.write("                    if (input.files && input.files[0]) {\n");
      out.write("                        var reader = new FileReader();\n");
      out.write("\n");
      out.write("                        reader.onload = function (e) {\n");
      out.write("                            preview.src = e.target.result;\n");
      out.write("                        };\n");
      out.write("\n");
      out.write("                        reader.readAsDataURL(input.files[0]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col col-md-6\">\n");
      out.write("                        <center>\n");
      out.write("                        ");
 if (request.getParameter("submit") != null) {
      out.write("\n");
      out.write("\n");
      out.write("                        ");
      com.beans.Person person = null;
      synchronized (session) {
        person = (com.beans.Person) _jspx_page_context.getAttribute("person", PageContext.SESSION_SCOPE);
        if (person == null){
          person = new com.beans.Person();
          _jspx_page_context.setAttribute("person", person, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("person"), request);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");
 String hobbies[] = request.getParameterValues("hobbies");
                            String hbs = "";
                            for (String s : hobbies) {
                                hbs += s + ",";
                            }
                            person.setHobbies(hbs); 
      out.write("\n");
      out.write("\n");
      out.write("                        <form action=\"PersonController?op=add\" method=\"post\" enctype=\"multipart/form-data\" class=\"form\">\n");
      out.write("                            <h4>Upload Profile Image </h4>\n");
      out.write("                            <img src=\"assests/images/preview.png\" style=\"width:300px;height: 300px\" class=\"img img-thumbnail\" id=\"preview\"/> <br/>\n");
      out.write("                            <input type=\"file\" name=\"photo\" class=\"form-control bg-dark\" onchange=\"readURL(this);\"/><br/>\n");
      out.write("                            <input type=\"submit\" value=\"Register Me\" class=\"btn btn-primary form-control\"/>\n");
      out.write("                        </form>\n");
      out.write("                            <br/>\n");
      out.write("                            <a href=\"add.jsp\" class=\"btn btn-success\"> << Check Previous Data</a>\n");
      out.write("                        ");
} else {
                                out.println("<b> Please Complete  Registration Page-1</b> <br/>"
                                        + "<a href='add.jsp'> Go To Register Page</a>");
                            }
      out.write("\n");
      out.write("\n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
