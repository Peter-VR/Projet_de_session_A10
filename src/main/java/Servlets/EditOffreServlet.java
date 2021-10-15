package Servlets;

import dao.OffreTravailDAO;
import entities.Offretravail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditOffreServlet", value = "/EditOffreServlet")
public class EditOffreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        Offretravail offre = OffreTravailDAO.getOffre(id);

        request.setAttribute("offre", offre);

        System.out.println(offre);

        RequestDispatcher dispatcher = request.getRequestDispatcher("editoffretravail.jsp");
        dispatcher.forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
