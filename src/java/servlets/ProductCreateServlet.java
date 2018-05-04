/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Product;
import dao.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmitry
 */
@WebServlet("/productCreateServlet")
public class ProductCreateServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int kol = Integer.parseInt(req.getParameter("product_kol"));
        int price = Integer.parseInt(req.getParameter("product_price"));
        String name = req.getParameter("product_name");
        String description = req.getParameter("product_description");
        String image = req.getParameter("product_image");
        
        try {
            
            if (ProductDAO.getINSTANCE().isNewProduct(name)){
                Product product = new Product();
                product.setName(name);
                product.setDescription(description);
                product.setKol(kol);
                product.setPrice(price);
                product.setImage(image);
                ProductDAO.getINSTANCE().createProduct(product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.forward("/", req, resp);
    }   
    
}
