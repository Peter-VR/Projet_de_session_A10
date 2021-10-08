package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Offretravail {
    private int idoffretravail;
    private String nom;
    private String description;
    private double budget;
    private int duree;
    private String etatoffre;
    private Date datecreationoffre;
    private Date datederniermodification;
    private Integer utilisateurpersonneidpersonne;

    @Id
    @Column(name = "IDOFFRETRAVAIL")
    public int getIdoffretravail() {
        return idoffretravail;
    }

    public void setIdoffretravail(int idoffretravail) {
        this.idoffretravail = idoffretravail;
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
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "BUDGET")
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "DUREE")
    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "ETATOFFRE")
    public String getEtatoffre() {
        return etatoffre;
    }

    public void setEtatoffre(String etatoffre) {
        this.etatoffre = etatoffre;
    }

    @Basic
    @Column(name = "DATECREATIONOFFRE")
    public Date getDatecreationoffre() {
        return datecreationoffre;
    }

    public void setDatecreationoffre(Date datecreationoffre) {
        this.datecreationoffre = datecreationoffre;
    }

    @Basic
    @Column(name = "DATEDERNIERMODIFICATION")
    public Date getDatederniermodification() {
        return datederniermodification;
    }

    public void setDatederniermodification(Date datederniermodification) {
        this.datederniermodification = datederniermodification;
    }

    @Basic
    @Column(name = "UTILISATEURPERSONNEIDPERSONNE")
    public Integer getUtilisateurpersonneidpersonne() {
        return utilisateurpersonneidpersonne;
    }

    public void setUtilisateurpersonneidpersonne(Integer utilisateurpersonneidpersonne) {
        this.utilisateurpersonneidpersonne = utilisateurpersonneidpersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offretravail that = (Offretravail) o;

        if (idoffretravail != that.idoffretravail) return false;
        if (Double.compare(that.budget, budget) != 0) return false;
        if (duree != that.duree) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (etatoffre != null ? !etatoffre.equals(that.etatoffre) : that.etatoffre != null) return false;
        if (datecreationoffre != null ? !datecreationoffre.equals(that.datecreationoffre) : that.datecreationoffre != null)
            return false;
        if (datederniermodification != null ? !datederniermodification.equals(that.datederniermodification) : that.datederniermodification != null)
            return false;
        if (utilisateurpersonneidpersonne != null ? !utilisateurpersonneidpersonne.equals(that.utilisateurpersonneidpersonne) : that.utilisateurpersonneidpersonne != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idoffretravail;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(budget);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + duree;
        result = 31 * result + (etatoffre != null ? etatoffre.hashCode() : 0);
        result = 31 * result + (datecreationoffre != null ? datecreationoffre.hashCode() : 0);
        result = 31 * result + (datederniermodification != null ? datederniermodification.hashCode() : 0);
        result = 31 * result + (utilisateurpersonneidpersonne != null ? utilisateurpersonneidpersonne.hashCode() : 0);
        return result;
    }
}
