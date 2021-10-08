package com.example.webappv6;

import dao.OffreTravailDAO;
import entities.Offretravail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "OffreTravailServlet", value = "/OffreTravailServlet")
public class OffreTravailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Offretravail newOffreTravail = new Offretravail();

        int idOffreTravail = 2;
        String nom = "Bathroom renovation";
        String description="description pour la renovation de salle de bain.";
        double budget = 999.99;
        int duree =30;
        String etatOffre = "attend";


        String date_creation = "2019-05-17";
        String date_modification = "2019-05-18";
        Date dateCreationOffre = Date.valueOf(date_creation);//converting string into sql date
        Date dateDernierModification = Date.valueOf(date_modification);//converting string into sql date


        int idPersonne = 3;

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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
