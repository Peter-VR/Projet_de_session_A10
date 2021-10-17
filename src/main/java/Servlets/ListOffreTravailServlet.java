/*
 * Created by: Mario Blanco
 * Project: A11
 * */

package Servlets;

import dao.OffreTravailDAO;
import entities.Offretravail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListOffreTravailServlet", value = "/ListOffreTravailServlet")
public class ListOffreTravailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Offretravail> list = OffreTravailDAO.getOffresTravails();

        request.setAttribute("mylist", list);
        System.out.println(list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listoffretravail.jsp");
        dispatcher.forward( request, response );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
