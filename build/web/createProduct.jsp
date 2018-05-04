<%-- 
    Document   : createProduct
    Created on : 04.05.2018, 14:06:35
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include flush="true" page="head.jsp"/> 

        <div class="content">
            <h1>Create product</h1>
            <form action="productCreateServlet" method="post">
                <ul class="signin">
                <li><span>Name</span><input type="text" name="product_name"/></li>
                <li><span>Kol</span><input type="number" name="product_kol"/></li>
                <li><span>Description</span><input type="text" name="product_description"/></li>
                <li><span>Price</span><input type="number" name="product_price"/></li>
                <li><span>Image url</span><input type="text" name="product_image"/></li>
                <li><span></span><input type="submit" name="create_product" value="create"/></li>
                </ul>
            </form>
        </div>

<jsp:include flush="true" page="foot.jsp"/>

