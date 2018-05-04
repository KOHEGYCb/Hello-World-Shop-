/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Product;
import beans.Reserv;
import beans.User;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author dmitry
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Integer.parseInt(req.getParameter("kol")) > 0) {
            Reserv reserv = new Reserv();
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            Product product = null;
            try {
                product = ProductDAO.getINSTANCE().getProductById(Integer.parseInt(req.getParameter("product_id")));
            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            reserv.setKol(Integer.parseInt(req.getParameter("kol")));
            reserv.setIdProduct(Integer.parseInt(req.getParameter("product_id")));
            reserv.setIdUser(user.getId());

            int newKol = product.getKol() - reserv.getKol();
            System.out.println("old kol|reserved|newKol = " + product.getKol() + "|" + reserv.getKol() + "|" + newKol);
            try {
                CartDAO.getINSTANCE().createReserv(reserv);
                ProductDAO.getINSTANCE().updateProductKol(product, newKol);
            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.forward("/", req, resp);

    }

}
