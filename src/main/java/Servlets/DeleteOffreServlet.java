/*
 * Created by: Mario Blanco
 * Project: A11
 * */

package Servlets;

import dao.OffreTravailDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteOffreServlet", value = "/DeleteOffreServlet")
public class DeleteOffreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        OffreTravailDAO.delete(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListOffreTravailServlet");
        dispatcher.forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
