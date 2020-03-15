package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Person;
import com.daos.PersonDao;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title> Register Page </title>\n");
      out.write("        <link rel=\"icon\" href=\"assests/images/favicon.ico\" type=\"x/image\"/>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                    $(\"#form1\").submit(function (e) {\n");
      out.write("\n");
      out.write("                        x = $(\"#password\").val();\n");
      out.write("                        y = $(\"#cpassword\").val();\n");
      out.write("\n");
      out.write("                        if (x === y)\n");
      out.write("                            return true;\n");
      out.write("                        else\n");
      out.write("                        {\n");
      out.write("                            alert('sorry! password and confirm password not matched');\n");
      out.write("                            e.preventDefault();\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    $(\"#userid\").blur(function () {\n");
      out.write("                        $(\"#sp1\").load(\"PersonController?op=check_userid&userid=\" + $(this).val());\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    $(\"#accept\").change(function () {\n");
      out.write("                        if ($(this).prop(\"checked\") == true) \n");
      out.write("                            $(\"#submit\").prop(\"disabled\",false);\n");
      out.write("                       else  \n");
      out.write("                             $(\"#submit\").prop(\"disabled\",true);\n");
      out.write("                       \n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                });\n");
      out.write("             \n");
      out.write("        </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
      com.beans.Person person = null;
      synchronized (session) {
        person = (com.beans.Person) _jspx_page_context.getAttribute("person", PageContext.SESSION_SCOPE);
        if (person == null){
          person = new com.beans.Person();
          _jspx_page_context.setAttribute("person", person, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\t<center><h2>Registration page </h2></center>\n");
      out.write("        <form  method='post'  class=\"form\" onsubmit=\"return matchPwd(password.value, cpassword.value);\" action=\"addPic.jsp\"> \n");
      out.write("            <table width=\"600\" class=\"table\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Enter Name </td>\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"name\" required=\"required\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Enter Father Name </td>\n");
      out.write("                        <td><input type=\"text\" name=\"fname\" required=\"required\"  class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.fname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                      \n");
      out.write("                        </td>\n");
      out.write("\t\t</tr>   \n");
      out.write("                <tr>\n");
      out.write("\t\t\t<td>Enter UserID </td>\n");
      out.write("                        <td><input type=\"text\" name=\"userid\" required=\"required\" class=\"form-control\" id=\"userid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                              <span id =\"sp1\"> </span>\n");
      out.write("                        </td>\n");
      out.write("\t\t</tr>\n");
      out.write("                <tr>\n");
      out.write("\t\t\t<td>Enter Password</td>\n");
      out.write("                        <td><input type=\"password\" pattern=\"(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\" name=\"password\" id=\"password\" required=\"required\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <br/>\n");
      out.write("                        <b>Password must contains atleast one uppercase,one lowercase , one special char and more than 8 characters</b>\n");
      out.write("                        </td>\n");
      out.write("\t\t</tr>\n");
      out.write("                <tr>\n");
      out.write("\t\t\t<td>Confirm Password</td>\n");
      out.write("                        <td><input type=\"password\" name=\"cpassword\" id=\"cpassword\" required=\"required\" class=\"form-control\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Enter Age</td>\n");
      out.write("\t\t\t<td><input type=\"number\" name=\"age\"class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.age}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Select Gender </td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"Male\" value=\"Male\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.gender eq \"Male\" ? \"checked\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" />Male\n");
      out.write("\t\t\t\t<br/>\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"Female\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.gender eq \"Female\" ? \"checked\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/> Female\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>Select Your Hobbies : </td>\n");
      out.write("\t\t\t<td>\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Dancing\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains(\"Dancing\") ? \"checked\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" >Dancing\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Singing\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains(\"Singing\") ? \"checked\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" >Singing <br/>\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Cooking\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains(\"Cooking\") ? \"checked\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">Cooking\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"hobbies\" value=\"Drawing\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.hobbies.contains(\"Drawing\") ? \"checked\": \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" >Drawing <br/>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</td>\n");
      out.write("                </tr>\n");
      out.write("\t\t<tr>\n");
      out.write("                    <th> <input type=\"checkbox\" value=\"accept\" name=\"accept\" id=\"accept\" onchange=\"checkValue(this,submit)\"/> Accept Terms and Contdi..</th>\n");
      out.write("                    <th><input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Next Page\" class=\"btn btn-primary\" disabled=\"disabled\"> </th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("</body>\n");
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
