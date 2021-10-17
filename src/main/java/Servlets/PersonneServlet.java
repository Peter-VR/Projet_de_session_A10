/*
 * Created by: Pedro Amado
 * Project: A11
 * */

package Servlets;

import dao.PersonneDao;
import dao.UtilisateurDao;
import entities.Personne;
import entities.Utilisateur;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "PersonneServlet", value = "/PersonneServlet")
public class PersonneServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        //Creation d'un objet de classe Personne
        Personne person1 = new Personne();
        //Attribution des attributs à l'objet person1
        int idPersonne = 6;
        person1.setIdpersonne(idPersonne);
        person1.setNom("JetBrains4");
        person1.setPrenom("IntelliJ4");
        person1.setCourriel("mymail@google.com4");
        person1.setMotpasse("anypw4");
        //Insertion de l'objet Personne dans la base de donnée
        PersonneDao.insert(person1);

        //Creation d'un objet de classe Utilisateur
        Utilisateur user1 = new Utilisateur();
        //Attribution des attributs à l'objet utilisateur
        user1.setPersonneidpersonne(idPersonne);
        user1.setAdresse("123 Fake Street4");
        user1.setVille("Fake City4");
        user1.setPostalcode("H1H1H14");
        user1.setProvince("Province4");
        //Insertion de l'objet Utilisateur dans la base de donnée
        UtilisateurDao.insert(user1);

        HttpSession session = request.getSession();
        session.setAttribute("idPersonne",idPersonne);

        RequestDispatcher disp = getServletContext().getRequestDispatcher("index.jsp");
        disp.forward(request, response);

    }

    public void destroy() {
    }
}