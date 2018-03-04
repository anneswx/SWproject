package loginregistration;

import DataConnection.MyConnectionProvider;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginRegister")
public class LoginRegister extends HttpServlet {
    static Connection con;
    static PreparedStatement ps;

    //private static final long serialVersionUID = 1L;

    // public LoginRegister() {

    // }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        AdminDao ad = new AdminDaoImpl();
        CustomerDAO cd = new CustomerDAOImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String submitType = request.getParameter("submit");



        Customer c = cd.getCustomer(username, password);
        Admin a = ad.getAdmin(username, password);

        if (submitType.equals("login")) {

            //admin
            if (a != null && a.getAusername() != null) {
                request.getSession().setAttribute("USERNAME", a.getAusername());
                request.setAttribute("ausername", a.getAusername());
                if (ad.isManager(username)) {
                    request.getRequestDispatcher("/Admin/manager.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/Admin/admin.jsp").forward(request, response);
                }
            }

            //customer
            if (c != null && c.getUsername() != null) {
                request.getSession().setAttribute("USERNAME", c.getUsername());
                request.getSession().setAttribute("USER", c);
                request.setAttribute("username", c.getUsername());
                request.setAttribute("voterstatus", c.getVoterstatus());
                if (c.getVoterstatus() == 0) {
                    request.setAttribute("noteMessage", "You are not a voter now. Please register!");
                } else if (c.getVoterstatus() == 1) {
                    request.setAttribute("noteMessage", "We are verifying your information. Please wait!");
                } else if (c.getVoterstatus() == 2) {
                    request.setAttribute("noteMessage", "Your information is valid. You are a voter now!");
                }

                request.getRequestDispatcher("/User/welcome.jsp").forward(request, response);

            } else {
                request.setAttribute("errorMessage", "Invalid username or password. Please try again or click Registration.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }

        //registration
        if (submitType.equals("register")) {
            boolean passwordRequirement = TestLoginFunctions.passwordRequirementCheck(password); //returns true if password meets requirements (at least 1 capital, no spaces, 1 symbol)
            boolean usernameRequirement = TestLoginFunctions.usernameRequirementCheck(username);
            boolean passwordsMatch = false;

            //checks that both passwords match
            if(password.equals(password2)){
                passwordsMatch=true;
            }

            if (c.getUsername() == null && cd.isNewUsername(username) && usernameRequirement && passwordRequirement && passwordsMatch) {

                TestLoginFunctions.sendEmailVerification(email, username);
                c.setEmail(email);
                c.setUsername(username);
                c.setPassword(password);

                cd.insertCustomer(c);
                request.setAttribute("successMessage", "Registered successfully!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else if(!passwordsMatch){
                request.setAttribute("errorMessage", "Password fields don't match.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else if(!usernameRequirement){
                request.setAttribute("errorMessage", "Username does not meet requirements. Usernames may not contain any special symbols or white spaces. Usernames must also be at least 3 characters long.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else if(!passwordRequirement){
                request.setAttribute("errorMessage", "Password does not meet requirements. Passwords must contain 1 upper-case letter, 1 symbol, and no spaces.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            else {
                request.setAttribute("errorMessage", "This username was registered! Please use another username!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }

        if (submitType.equals("logout")) {
            request.getSession().setAttribute("USERNAME", null);
            request.getSession().setAttribute("USER", null);
            request.getSession().setAttribute("USERID", null);
            response.sendRedirect("login.jsp");
        }

        //voter registration
        if(submitType.equals("become a voter")){
            request.setAttribute("username", c.getUsername());
            request.getRequestDispatcher("/User/voteregister.jsp").forward(request, response);
        }
        if (submitType.equals("infosubmit")) {

            String realname = request.getParameter("name");
            int ssn = Integer.parseInt(request.getParameter("ssn"));
            String address = request.getParameter("address");

            c = (Customer) request.getSession().getAttribute("USER");
            c.setRealname(realname);
            c.setSsn(ssn);
            c.setAddress(address);

            cd.updateVoterinfo(c);
            request.setAttribute("successMessage", "Your information is submitted.");
            request.setAttribute("username", c.getUsername());
            request.setAttribute("voterstatus", 1);
            request.setAttribute("noteMessage", "We are verifying your information. Please wait!");

            request.getRequestDispatcher("/User/welcome.jsp").forward(request, response);
        }
    }

}
