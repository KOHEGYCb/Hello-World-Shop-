<%-- 
    Document   : registration
    Created on : 02.05.2018, 20:04:55
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include flush="true" page="head.jsp"/>
        <div class="content">
            <h1>Registration</h1>
        <form action="registrationServlet" method="post">
            <ul class="signin">
                <li><span>Name</span><input type="text" name="name" value=""/></li>
                <li><span>Surname</span><input type="text" name="surname" value=""/></li>
                <li><span>Email</span><input type="text" name="email" value=""/></li>
                <li><span>Password</span><input type="password" name="password" value=""/></li>
                <li><span>не трогать</span><input type="checkbox" name="isAdmin"/></li>
                <li><span>Пни меня</span><input type="submit" name="registration" value="Sign in"/></li>
            </ul>
        </form>
        </div>
        
<jsp:include flush="true" page="foot.jsp"/>
