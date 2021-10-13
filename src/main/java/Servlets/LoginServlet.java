package Servlets;

import dao.PersonneDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("uname"));
        String password = request.getParameter("psw");

        System.out.println(id + password);

        int myid = PersonneDao.findOne(id,password);
        if(myid != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("idPersonne", id);
        }

        System.out.println(request.getRequestURL());

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
        disp.forward(request, response);
    }
}
