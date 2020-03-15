package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.daos.NewsDao;
import com.beans.*;
import java.util.ArrayList;

public final class Shownews_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title> Show News </title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("      \n");
      out.write("            <script>\n");
      out.write("\n");
      out.write("                function submitForm() {\n");
      out.write("                    document.getElementById(\"f1\").submit();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            </script>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <form id=\"f1\" method=\"get\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <select onchange=\"submitForm();\" name=\"cat_id\" id=\"cat_id\" class=\"dropdown dropdown-header form-control\">\n");
      out.write("                            <option value=\"-1\" >select news category</option>\n");
      out.write("                            <option value=\"\">All News</option>\n");
      out.write("                        ");


                            NewsDao ndo = new NewsDao();
                            ArrayList<News> category = new ArrayList();
                            category = ndo.getNewsCategory();
                            for (NewsCategory cat : category) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(cat.getId());
      out.write('"');
      out.write('>');
      out.print(cat.getName());
      out.write("<br/>\n");
      out.write("\n");
      out.write("                        ");
}


                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    ");
                        
                        
                        int start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : 0;
                        int end = 3;
                        int total = ndo.getRecordCount();
                        ArrayList<News> rows = new ArrayList();
                        String cat_id = request.getParameter("cat_id");
                        if (cat_id == null || cat_id.equals("")) {
                            rows = ndo.getNewsByLimit(start, end);
                        } else {
                            rows = ndo.getNewsByCategory(cat_id);
                        }

                        //  System.out.println("rows:"+rows);
                        for (News news : rows) {
      out.write("\n");
      out.write("                    <div class=\"card col col-md-4\">\n");
      out.write("                        <img src=\"media/news/");
      out.print(news.getImage());
      out.write("\" class=\"card-img-top\" alt=\"...\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">");
      out.print(news.getTitle());
      out.write("</h5>\n");
      out.write("                            ");

                                String description = news.getDescription().trim();
                                if (description.length() > 100) {
                                    description = description.substring(0, 100);
                                }
                            
      out.write("\n");
      out.write("                            <p class=\"card-text\">");
      out.print(description);
      out.write("</p>\n");
      out.write("                            <a href=\"detailNews.jsp?id=");
      out.print(news.getId());
      out.write("\" class=\"btn btn-primary\">view more</a>\n");
      out.write("                            <a href=\"NewsController?id=");
      out.print(news.getId());
      out.write("&op=delete\" class=\"btn btn-outline-danger\">Delete</a>\n");
      out.write("                            <a href=\"editNews.jsp?id=");
      out.print(news.getId());
      out.write("\" class=\"btn btn-outline-primary\">update</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <center>\n");
      out.write("                ");

                    int pages = total / end + (total % end == 0 ? 0 : 1);
                    for (int i = 0; i < pages; i++) {
      out.write("\n");
      out.write("                <span style=\"text-decoration: none; align-content: center;  ");
 if (Math.floor(start / end) == i) {
               out.println("background-color: orange");
           }
      out.write("\" class=\"btn btn-dark\"><a href=\"Shownews.jsp?start=");
      out.print(end * i);
      out.write("\">Page ");
      out.print(i + 1);
      out.write("</a></span> \n");
      out.write("                ");
}
                
      out.write("\n");
      out.write("            </center>\n");
      out.write("            <span style=\"float:left\"><a href=\"Shownews.jsp?start=");
      out.print(start - end);
      out.write("\" class=\"btn btn-primary ");
 if (start == 0) {
              out.println(" disabled");
          }
      out.write(" \">PREVIOUS</a></span>\n");
      out.write("\n");
      out.write("            <span style=\"float:right\"><a href=\"Shownews.jsp?start=");
      out.print(start + end);
      out.write("\" class=\"btn btn-primary ");
 if (start + end >= total) {
                out.println(" disabled");
            }
      out.write(" \">NEXT</a></span>\n");
      out.write("            <br><center> <a href=\"addNews.jsp\" class=\"btn btn-outline-primary\">Add News</a></center>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
