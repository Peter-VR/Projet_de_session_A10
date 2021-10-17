/*
 * Created by: Mario Blanco
 * Project: A11
 * */

package Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "LangueServlet", value = "/LangueServlet")
public class LangueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session =request.getSession();

        String newlangue= request.getParameter("lang");

        if (newlangue.equals("en_US"))
        {
            Locale newLocal = new Locale("en", "US");
            session.setAttribute("langue", newLocal);
        }
        else if (newlangue.equals("fr_FR")){
            Locale newLocal = new Locale("fr", "FR");
            session.setAttribute("langue", newLocal);
        }
        else
        {
            Locale newLocal = new Locale("es", "ES");
            session.setAttribute("langue", newLocal);
        }


        RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
        disp.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
