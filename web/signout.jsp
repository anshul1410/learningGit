<%-- 
    Document   : signout
    Created on : Mar 7, 2020, 12:02:31 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.removeAttribute("reporter");
    response.sendRedirect("login.jsp");
    %>
