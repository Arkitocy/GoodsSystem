import Entity.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us = new UserService();
        String name = request.getParameter("username");
        String pwd = request.getParameter("userpwd");
        if (request.getParameter("username").equals("")) {
            response.sendRedirect("regist.html");
        } else {
            User user = us.registUser(name, pwd);
            if (user==null) {
                response.sendRedirect("regist.html");
            } else {
                response.sendRedirect("login.html");
            }
        }

    }
}
