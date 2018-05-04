package servlets;

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
@WebServlet("/loginServlet")
public class LoginServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (!(email.equals("") || password.equals(""))) {
            try {
                if (UserDAO.getINSTANCE().isTruePassword(email, password)) {
                    session.setAttribute("user", UserDAO.getINSTANCE().getUserByEmail(email));
                } else {
                    session.setAttribute("user", null);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            session.setAttribute("user", null);
        }

        super.forward("/", req, resp);

    }

}
