<%-- 
    Document   : index
    Created on : 02.05.2018, 19:30:59
    Author     : dmitry
--%>

<%@page import="beans.User"%>
<%@page import="beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include flush="true" page="head.jsp"/>
<div class="content">
    <div class="block_category">
        <div class="categories_header"><h1>Category Header</h1></div>
        <div class="categories_list"><h1>Category List</h1></div>
    </div>

    <div class="users">
        <jsp:include flush="true" page="login.jsp"/>
    </div>
    <div class="products">
        <jsp:include flush="true" page="products.jsp"/>
    </div>
</div>
<jsp:include flush="true" page="foot.jsp"/>
