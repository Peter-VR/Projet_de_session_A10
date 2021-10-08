package com.example.webappv6;

import dao.PersonneDao;
import dao.UtilisateurDao;
import entities.Personne;
import entities.Utilisateur;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //Creation d'un objet de classe Personne
        Personne person1 = new Personne();
        //Attribution des attributs à l'objet person1
        person1.setIdpersonne(3);
        person1.setNom("JetBrains3");
        person1.setPrenom("IntelliJ3");
        person1.setCourriel("mymail@google.com3");
        person1.setMotpasse("anypw3");
        //Insertion de l'objet Personne dans la base de donnée
        PersonneDao.insert(person1);

        //Creation d'un objet de classe Utilisateur
        Utilisateur user1 = new Utilisateur();
        //Attribution des attributs à l'objet utilisateur
        user1.setPersonneidpersonne(3);
        user1.setAdresse("123 Fake Street3");
        user1.setVille("Fake City3");
        user1.setPostalcode("H1H1H13");
        user1.setProvince("Province3");
        //Insertion de l'objet Utilisateur dans la base de donnée
        UtilisateurDao.insert(user1);

        message=user1.getAdresse();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}