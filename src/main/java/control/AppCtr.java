package control;

import dao.PersonneDao;
import dao.UtilisateurDao;
import entities.Personne;
import entities.Utilisateur;

public class AppCtr {

    public static void main(String[] args) {

//        //Creation d'un objet de classe Personne
//        Personne person1 = new Personne();
//        //Attribution des attributs à l'objet person1
//        person1.setIdpersonne(1);
//        person1.setNom("JetBrains");
//        person1.setPrenom("IntelliJ");
//        person1.setCourriel("mymail@google.com");
//        person1.setMotpasse("anypw");
//        //Insertion de l'objet Personne dans la base de donnée
//        PersonneDao.insert(person1);
//
//        //Creation d'un objet de classe Utilisateur
//        Utilisateur user1 = new Utilisateur();
//        //Attribution des attributs à l'objet utilisateur
//        user1.setPersonneidpersonne(1);
//        user1.setAdresse("123 Fake Street");
//        user1.setVille("Fake City");
//        user1.setPostalcode("H1H1H1");
//        user1.setProvince("Province");
//        //Insertion de l'objet Utilisateur dans la base de donnée
//        UtilisateurDao.insert(user1);

//        Supression d'un utilisateur dans la base de donnée
//        Note que la supression de l'utilisateur se fait mais l'objet Personnne
//        ayant la même clé primaire n'est pas détruit
//        UtilisateurDao.delete(2);

        //Supression d'une personne dans la base de donnée
//        PersonneDao.delete(1);

        //Update d'une personne dans la base de donnée
        PersonneDao.update(2, "PedroTest");



    }

}
