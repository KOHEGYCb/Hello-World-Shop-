/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.User;
import dao.UserDAO;
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
@WebServlet("/registrationServlet")
public class RegistrationServlet extends ManagerServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int role;
        if (req.getParameter("isAdmin") != null){
            role = 0;
        }else{
            role = 1;
        }
        if (!(name.equals("") || surname.equals("") || password.equals("") || email.equals(""))){
            try {
                if (UserDAO.getINSTANCE().isNewUser(email)){
                    User user = new User();
                    user.setEmail(email);
                    user.setName(name);
                    user.setPassword(password);
                    user.setSurname(surname);
                    user.setRole(role);
                    UserDAO.getINSTANCE().createUser(user);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        super.forward("/", req, resp);
    }
    
}
