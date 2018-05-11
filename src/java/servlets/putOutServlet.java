/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Product;
import beans.Reserv;
import dao.CartDAO;
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
@WebServlet("/putOutServlet")
public class putOutServlet extends ManagerServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("reserv_id"));
        try {
            Reserv reserv = CartDAO.getINSTANCE().getReservById(id);
            int kol = reserv.getKol();
            
            Product product = ProductDAO.getINSTANCE().getProductById(reserv.getIdProduct());
            kol = kol + product.getKol();
            ProductDAO.getINSTANCE().updateProductKol(product.getId(), kol);
            CartDAO.getINSTANCE().deleteReservById(id);
        } catch (SQLException ex) {
            Logger.getLogger(putOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.forward("/cart.jsp", req, resp);
    }
    
    
    
}
