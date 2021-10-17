package control;

import dao.OffreTravailDAO;
import dao.PersonneDao;
import dao.UtilisateurDao;
import entities.Offretravail;
import entities.Personne;
import entities.Utilisateur;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class AppCtr {

    public static void main(String[] args) {

        //Creation d'un objet de classe Personne
       Personne person1 = new Personne();
        //Attribution des attributs à l'objet person1
        int pid = PersonneDao.nextID();
        person1.setIdpersonne(pid);
        person1.setNom("JetBrains+pid");
       person1.setPrenom("IntelliJ");
        person1.setCourriel("mymail@google.com");
        person1.setMotpasse("anypw"+pid);
        //Insertion de l'objet Personne dans la base de donnée
        PersonneDao.insert(person1);

       //Creation d'un objet de classe Utilisateur
        Utilisateur user1 = new Utilisateur();
        //Attribution des attributs à l'objet utilisateur
        user1.setPersonneidpersonne(pid);
       user1.setAdresse("123 Fake Street");
        user1.setVille("Fake City");
        user1.setPostalcode("H1H1H1");
        user1.setProvince("Province");
        //Insertion de l'objet Utilisateur dans la base de donnée
        UtilisateurDao.insert(user1);

//        Supression d'un utilisateur dans la base de donnée
//        Note que la supression de l'utilisateur se fait mais l'objet Personnne
//        ayant la même clé primaire n'est pas détruit
//        UtilisateurDao.delete(2);

        //Supression d'une personne dans la base de donnée
//        PersonneDao.delete(1);

        //Update d'une personne dans la base de donnée
        PersonneDao.update(pid, "PedroTest");


        //insert offre travail
        int idOffreTravail = OffreTravailDAO.nextID();
        String nom = "Bathroom renovation";
        String description="description pour la renovation de salle de bain.";
        double budget = 999.99;
        int duree =30;
        String etatOffre = "attend";
        String date_creation = "2019-05-17";
        String date_modification = "2019-05-18";

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        Date dateCreationOffre = Date.valueOf(formatter.format(date));//converting string into sql date
        Date dateDernierModification = Date.valueOf(formatter.format(date));//converting string into sql date
        int idPersonne = pid;

        //liste offre travail
        List<Offretravail> offres = OffreTravailDAO.getOffresTravails();
        for (Offretravail offre: offres
             ) {
            System.out.println(offre.toString());
            System.out.println("---------------------------------------------");


        }

        //update description
        String description2 = "description changed.";
        OffreTravailDAO.updateDescription(idOffreTravail,description2);

        //display updated offert
        System.out.println(OffreTravailDAO.getOffre(idOffreTravail).toString());



    }

}
