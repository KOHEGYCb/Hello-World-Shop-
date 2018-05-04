<%-- 
    Document   : products
    Created on : 04.05.2018, 14:00:02
    Author     : dmitry
--%>

<%@page import="dao.ProductDAO"%>
<%@page import="beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Products</h1>
<%
    ArrayList<Product> products = ProductDAO.getINSTANCE().getAllProducts();
    for (int i = 0; i < products.size(); i++) {

%>

<div class="block_product">
    <h3><%= products.get(i).getName()%></h3>
    <img src="<%= products.get(i).getImage()%>" alt=""/>
    <div>
        <p class="description_button">Description</p>
        <div class="product_description">
            <p><%= products.get(i).getDescription()%></p>
        </div>
    </div>
    <span>Kol: <%= products.get(i).getKol()%></span>
    <span>Price: <%= products.get(i).getPrice()%> $</span>

    <%
        if (session.getAttribute("user")!=null){
    %>

    <form action="addToCart" method="post">
        <input type="number" min="0" max="<%= products.get(i).getKol()%>" name="kol" />
        <input style="display: none" type="number" name="product_id" value="<%= products.get(i).getId() %>"/>
        <input type="submit" name="addToCart" value="add to cart"/>
        
    </form>
    <%
        }
    %>
</div>

<%
    }
%>
