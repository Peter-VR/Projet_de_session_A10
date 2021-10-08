package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personne {
    private int idpersonne;
    private String nom;
    private String prenom;
    private String courriel;
    private String motpasse;

    @Id
    @Column(name = "IDPERSONNE")
    public int getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(int idpersonne) {
        this.idpersonne = idpersonne;
    }

    @Basic
    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "PRENOM")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "COURRIEL")
    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    @Basic
    @Column(name = "MOTPASSE")
    public String getMotpasse() {
        return motpasse;
    }

    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (idpersonne != personne.idpersonne) return false;
        if (nom != null ? !nom.equals(personne.nom) : personne.nom != null) return false;
        if (prenom != null ? !prenom.equals(personne.prenom) : personne.prenom != null) return false;
        if (courriel != null ? !courriel.equals(personne.courriel) : personne.courriel != null) return false;
        if (motpasse != null ? !motpasse.equals(personne.motpasse) : personne.motpasse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpersonne;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (courriel != null ? courriel.hashCode() : 0);
        result = 31 * result + (motpasse != null ? motpasse.hashCode() : 0);
        return result;
    }
}
