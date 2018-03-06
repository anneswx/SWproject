package login.submit.registration;

import javax.servlet.*
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "LoginRegister")
public class LoginRegister extends HttpServlet {


    private static final long serialVersionUID = 1L;

    public LoginRegister() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        CustomerDAO cd = new CustomerDAOImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String submitType = request.getParameter("submit");

        Customer c = cd.getCustomer(username, password);


        if (submitType.equals("login") && c != null && c.getUsername() != null) {
            request.setAttribute("message", c.getUsername());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else if (submitType.equals("register")) {

            c.setUsername(username);
            c.setPassword(password);
            cd.insertCustomer(c);
            request.setAttribute("successMessage", "Registrated successfully");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Data Not Found, click on Register!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
