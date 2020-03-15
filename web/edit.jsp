<%-- 
    Document   : edit
    Created on : Jan 26, 2020, 1:00:49 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,com.beans.Person,com.daos.PersonDao"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Person Details </title>
        <jsp:include page ="base.jsp"></jsp:include>
        
        <script>
         function readURL(input) {
            //       alert('hello');
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                   preview.src= e.target.result;
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
        </script>
        
    </head>
    <body>
        <jsp:useBean id="person1" class="com.beans.Person" scope="session"></jsp:useBean>
    <div class="container">
            <div class="row">
                <div class="col">
        
        <%
        int id = request.getParameter("id")!=null ? Integer.parseInt(request.getParameter("id")):0;
        PersonDao pd= new PersonDao();
        Person person= pd.getById(id);
        session.setAttribute("person1",person);
        %>
              
          <center><h2> Updation page </h2></center>
     
    <form  method='post' class="form-check"> 
    <!--<input type="text" value="<%//=person.getId()%>" readonly="readonly" name="id"/> -->
	<table width="600">
                <tr>
	        <td>Enter Name </td>
                <td><input type="text" name="name" required="required" value="${person1.name}" class="btn btn-outline-light text-dark"></td>
	        </tr>
            
		<tr>
		    <td>Enter Father Name </td>
		    <td><input type="text" name="fname" required="required" " value="${person1.fname}" class="btn btn-outline-light text-dark"></td>
		</tr>
                
		<tr>
			<td>Enter Age</td>
			<td><input type="number" name="age" " value="${person1.age}" class="btn btn-outline-light text-dark" ></td>
		</tr>
                
		<tr>
			<td>Select Gender </td>
			<td>
				<input type="radio" name="gender" value= "Male" ${person1.gender eq "male" ? "checked":""} class="btn btn-outline-light text-dark" />Male
        			<br/>
				<input type="radio" name="gender" value= "Female" ${person1.gender eq "female" ? "checked":""} class="btn btn-outline-light text-dark" />Female
                                         
			</td>
		</tr>
                
		<tr>
			<td>Select Your Hobbies : </td>
			<td>
				<input type="checkbox" name="hobbies" value="Dancing" ${person1.hobbies.contains("Dancing") ? "checked":""}>Dancing
				<input type="checkbox" name="hobbies" value="Singing" ${person1.hobbies.contains("Singing") ? "checked":""}>Singing <br/>
				<input type="checkbox" name="hobbies" value="Cooking" ${person1.hobbies.contains("Cooking") ? "checked":""}>Cooking
				<input type="checkbox" name="hobbies" value="Drawing" ${person1.hobbies.contains("Drawing") ? "checked":""}>Drawing <br/>
				
			</td>
		</tr>
                
		<tr>
			<th colspan="2"><input name="submit" type="submit" value="Click here to next page" class="btn btn-secondary btn-sm"> </th>
		</tr>
                
	</table>

        </form>
                                
        <% if(request.getParameter("submit")!=null){%>                                                       
    <jsp:setProperty name="person1" property="*"></jsp:setProperty>
     
    
                <form action="PersonController?op=update" method="post" enctype="multipart/form-data" class="form"> 
                <img src="${person1.image}" class="img img-thumbnail" width="20%" height="20%" id="preview"/> <br/>
                 <input type="file" name="photo"   onchange="readURL(this);"/><br/><br>
                       <input type="submit" value="Update" class="btn btn-primary form-control"/>
                </form>
     <%
   //if (pd.update(person1))
       //response.sendRedirect("show.jsp");
   }%>     
               </div>
            </div>
        </div>
      
    </body>
</html>
