package com.Controllers;

import com.beans.Person;
import com.daos.PersonDao;
import com.utilities.FileUploadUtility;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class PersonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            PersonDao pd = new PersonDao();
            if (pd.removeById(id)) {
                response.sendRedirect("show.jsp");
            }
        }

        if (op != null && op.equalsIgnoreCase("check_userid")) {
            String userid = request.getParameter("userid");
            PersonDao pd = new PersonDao();
            if (userid == null || userid.equals("")) {
                out.println("<font size='4' > Please provide Userid </font>");
                return;
            }
            if (pd.isUseridExist(userid)) {
                out.println("<font color='red' size='4' > Sorry this userid already exits!!! </font>");
            } else {
                out.println("<font color='blue' size='4' > Congrats this user id available!!! </font>");
            }
        }
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("add")) {
            System.out.println("request found ......");

            //check the enctype of the incoming request -
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            String encodedPassword = "";
            String imagePath = "";
            HttpSession session = request.getSession();
            com.beans.Person person = (com.beans.Person) session.getAttribute("person");

            if (isMultipart) {
                imagePath = FileUploadUtility.getUploadedPath(getServletContext(), "media/person", request);
            }

            //JDBC Code 
            person.setImage(imagePath);

            encodedPassword = Base64.getEncoder().encodeToString(person.getPassword().getBytes("UTF-8"));
            person.setPassword(encodedPassword);
            com.daos.PersonDao pd = new com.daos.PersonDao();
            if (pd.add(person)) {
                session.removeAttribute("person");
                response.sendRedirect("show.jsp");

            }

        }

        //update operation will be done here
        if (op != null && op.equalsIgnoreCase("update")) {
            //  int id=Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            Person person = (Person) session.getAttribute("person1");
            String oldImage = person.getImage();
            System.out.println("op=" + op);
            try {
                //check the enctype of the incomming request -
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                // String encodedPassword = "";
                String photo = "", imagePath = "";

                if (isMultipart) {
                    System.out.println("Multipart data found.......");
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload upload = new ServletFileUpload(factory);
                    List items = null;
                    items = upload.parseRequest(request);
                    System.out.println("multi op=" + op);
                    Iterator itr = items.iterator();
                    while (itr.hasNext()) {
                        FileItem item = (FileItem) itr.next();
                        if (!item.isFormField()) {
                            photo = item.getName();
                            System.out.println("photo : " + photo);
                            if (photo != "") {
                                imagePath = "media/person/" + photo;
                                File savedFile = new File(getServletContext().getRealPath("/") + imagePath);
                                item.write(savedFile);
                                person.setImage(imagePath);
                            }
                        }

                    }

                    //JDBC Code 
                    PersonDao pd = new PersonDao();

                    String name = person.getName();
                    System.out.println("name====" + name);

                    if (pd.update(person)) {
                        session.removeAttribute("person");
                        response.sendRedirect("show.jsp");
                    }

                }

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }

        }

    }

}
