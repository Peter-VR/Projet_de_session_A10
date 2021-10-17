package Servlets;

import dao.PersonneDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("psw");

        int myid = PersonneDao.findOne(id, password);
        if (myid != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("idPersonne", id);
        }
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
        disp.forward(request, response);
    }
}
