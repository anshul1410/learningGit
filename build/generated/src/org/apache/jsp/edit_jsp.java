package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.beans.Person;
import com.daos.PersonDao;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Edit Person Details </title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("         function readURL(input) {\n");
      out.write("            //       alert('hello');\n");
      out.write("            if (input.files && input.files[0]) {\n");
      out.write("                var reader = new FileReader();\n");
      out.write("\n");
      out.write("                reader.onload = function (e) {\n");
      out.write("                   preview.src= e.target.result;\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                reader.readAsDataURL(input.files[0]);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      com.beans.Person person1 = null;
      synchronized (session) {
        person1 = (com.beans.Person) _jspx_page_context.getAttribute("person1", PageContext.SESSION_SCOPE);
        if (person1 == null){
          person1 = new com.beans.Person();
          _jspx_page_context.setAttribute("person1", person1, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\">\n");
      out.write("        \n");
      out.write("        ");

        int id = request.getParameter("id")!=null ? Integer.parseInt(request.getParameter("id")):0;
        PersonDao pd= new PersonDao();
        Person person= pd.getById(id);
        session.setAttribute("person1",person);
        
      out.write("\n");
      out.write("              \n");
      out.write("          <center><h2> Updation page </h2></center>\n");
      out.write("     \n");
      out.write("    <form  method='post' class=\"form-check\"> \n");
      out.write("    <!--<input type=\"text\" value=\"");
//=person.getId()
      out.write("\" readonly=\"readonly\" name=\"id\"/> -->\n");
      out.write("\t<table width=\"600\">\n");
      out.write("                <tr>\n");
      out.write("\t        <td>Enter Name </td>\n");
      out.write("                <td><input type=\"text\" name=\"name\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person1.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-outline-light text-dark\"></td>\n");
      out.write("\t        </tr>\n");
      out.write("            \n");
      out.write("\t\t<tr>\n");
      out.write("\t\t    <td>Enter Father Name </td>\n");
      out.write("\t\t    <td><input type=\"text\" name=\"fname\" required=\"required\" \" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person1.fname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-outline-light text-dark\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("                \n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Enter Age</td>\n");
      out.write("\t\t\t<td><input type=\"number\" name=\"age\" \" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person1.age}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-outline-light text-dark\" ></td>\n");
      out.write("\t\t</tr>\n");
      out.write("                \n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Select Gender </td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"gender\" value= \"Male\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.gender eq \"male\" ? \"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" class=\"btn btn-outline-light text-dark\" />Male\n");
      out.write("        \t\t\t<br/>\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"gender\" value= \"Female\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.gender eq \"female\" ? \"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" class=\"btn btn-outline-light text-dark\" />Female\n");
      out.write("                                         \n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("                \n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Select Your Hobbies : </td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Dancing\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains (\"Dancing\") ? \"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Dancing\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Singing\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains (\"Singing\") ? \"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Singing <br/>\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Cooking\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains (\"Cooking\") ? \"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Cooking\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Drawing\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains(\"Drawing\") ? \"checked\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Drawing <br/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("                \n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th colspan=\"2\"><input name=\"submit\" type=\"submit\" value=\"Click here to next page\" class=\"btn btn-secondary btn-sm\"> </th>\n");
      out.write("\t\t</tr>\n");
      out.write("                \n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("                                \n");
      out.write("        ");
 if(request.getParameter("submit")!=null){
      out.write("                                                       \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("person1"), request);
      out.write("\n");
      out.write("     \n");
      out.write("    \n");
      out.write("                <form action=\"PersonController?op=update\" method=\"post\" enctype=\"multipart/form-data\" class=\"form\"> \n");
      out.write("                <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person1.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"img img-thumbnail\" width=\"20%\" height=\"20%\" id=\"preview\"/> <br/>\n");
      out.write("                 <input type=\"file\" name=\"photo\"   onchange=\"readURL(this);\"/><br/><br>\n");
      out.write("                       <input type=\"submit\" value=\"Update\" class=\"btn btn-primary form-control\"/>\n");
      out.write("                </form>\n");
      out.write("     ");

   //if (pd.update(person1))
       //response.sendRedirect("show.jsp");
   }
      out.write("     \n");
      out.write("               </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
