package Servlets;

import dao.OffreTravailDAO;
import entities.Offretravail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.Console;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;


@WebServlet(name = "InsertOffreTravailServlet", value = "/InsertOffreTravailServlet")
public class InsertOffreTravailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Offretravail newOffreTravail = new Offretravail();

       /* int idOffreTravail = 2;
        String nom = "Bathroom renovation";
        String description="description pour la renovation de salle de bain.";
        double budget = 999.99;
        int duree =30;
        String etatOffre = "attend";
        String date_creation = "2019-05-17";
        String date_modification = "2019-05-18";
        Date dateCreationOffre = Date.valueOf(date_creation);//converting string into sql date
        Date dateDernierModification = Date.valueOf(date_modification);//converting string into sql date
        int idPersonne = 3;*/


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idOffreTravail = OffreTravailDAO.nextID();
        System.out.println("id" + idOffreTravail);
        String nom = request.getParameter("nom");
        System.out.println("nom" + nom);
        String description=request.getParameter("description");
        System.out.println("description" +description);
        double budget = Double.valueOf(request.getParameter("budget"));
        System.out.println(request.getParameter("budget"));
        int duree = Integer.valueOf(request.getParameter("duree"));
        System.out.println(duree);
        String etatOffre = "attend";

        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(formatter.format(date));
        Date dateCreationOffre = Date.valueOf(formatter.format(date));//converting string into sql date
        Date dateDernierModification = Date.valueOf(formatter.format(date));//converting string into sql date

        HttpSession session = request.getSession();
        int idPersonne = (int)session.getAttribute("idPersonne");


        Offretravail offretravail = new Offretravail();
        offretravail.setIdoffretravail(idOffreTravail);
        offretravail.setNom(nom);
        offretravail.setDescription(description);
        offretravail.setBudget(budget);
        offretravail.setDuree(duree);
        offretravail.setEtatoffre(etatOffre);
        offretravail.setDatecreationoffre((java.sql.Date) dateCreationOffre);
        offretravail.setDatederniermodification((java.sql.Date) dateDernierModification);
        offretravail.setUtilisateurpersonneidpersonne(idPersonne);

        OffreTravailDAO.insert(offretravail);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listoffretravail.jsp");
        dispatcher.forward( request, response );
    }
}
