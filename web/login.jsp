<%-- 
    Document   : login
    Created on : 02.05.2018, 20:04:45
    Author     : dmitry
--%>

<%@page import="beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("user") != null) {
        User user = (User) session.getAttribute("user");
%>
<span>Hello <%= user.getSurname()%> <%= user.getName()%></span>
<form action="logoutServlet" method="post" >
    <input type="submit" name="log_out" value="Log out"/>
    <%
        if (user.getRole() == 0) {
    %>
    <a class="button" href="createProduct.jsp">Add Product</a>

    <%
        }
    %>
    <span>Your cart: </span>
</form>
    
<%
} else {
%>

<form action="loginServlet" method="post">

    <ul class="login">
        <li><span>Log In: </span></li>
        <li><span>email: </span><input type="text" name="email"/></li>
        <li><span>password: </span><input type="password" name="password"/></li>
        <li><input type="submit" name="log_in" value="Log In"/></li>
    </ul>
</form>
<a class="registration" href="registration.jsp" >Sign in</a>
<%
    }
%>



