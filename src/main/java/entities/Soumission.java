/*
 * Created by: Mario Blanco
 * Project: A10
 * */

package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Soumission {
    private int idsoumission;
    private double prix;
    private String description;
    private Integer offretravailidoffretravail;
    private Integer professionelpersonneidpersonne;
    private String etatsoumission;
    private Date datesoumission;

    @Id
    @Column(name = "IDSOUMISSION")
    public int getIdsoumission() {
        return idsoumission;
    }

    public void setIdsoumission(int idsoumission) {
        this.idsoumission = idsoumission;
    }

    @Basic
    @Column(name = "PRIX")
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
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
    @Column(name = "OFFRETRAVAILIDOFFRETRAVAIL")
    public Integer getOffretravailidoffretravail() {
        return offretravailidoffretravail;
    }

    public void setOffretravailidoffretravail(Integer offretravailidoffretravail) {
        this.offretravailidoffretravail = offretravailidoffretravail;
    }

    @Basic
    @Column(name = "PROFESSIONELPERSONNEIDPERSONNE")
    public Integer getProfessionelpersonneidpersonne() {
        return professionelpersonneidpersonne;
    }

    public void setProfessionelpersonneidpersonne(Integer professionelpersonneidpersonne) {
        this.professionelpersonneidpersonne = professionelpersonneidpersonne;
    }

    @Basic
    @Column(name = "ETATSOUMISSION")
    public String getEtatsoumission() {
        return etatsoumission;
    }

    public void setEtatsoumission(String etatsoumission) {
        this.etatsoumission = etatsoumission;
    }

    @Basic
    @Column(name = "DATESOUMISSION")
    public Date getDatesoumission() {
        return datesoumission;
    }

    public void setDatesoumission(Date datesoumission) {
        this.datesoumission = datesoumission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soumission that = (Soumission) o;

        if (idsoumission != that.idsoumission) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (offretravailidoffretravail != null ? !offretravailidoffretravail.equals(that.offretravailidoffretravail) : that.offretravailidoffretravail != null)
            return false;
        if (professionelpersonneidpersonne != null ? !professionelpersonneidpersonne.equals(that.professionelpersonneidpersonne) : that.professionelpersonneidpersonne != null)
            return false;
        if (etatsoumission != null ? !etatsoumission.equals(that.etatsoumission) : that.etatsoumission != null)
            return false;
        if (datesoumission != null ? !datesoumission.equals(that.datesoumission) : that.datesoumission != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idsoumission;
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (offretravailidoffretravail != null ? offretravailidoffretravail.hashCode() : 0);
        result = 31 * result + (professionelpersonneidpersonne != null ? professionelpersonneidpersonne.hashCode() : 0);
        result = 31 * result + (etatsoumission != null ? etatsoumission.hashCode() : 0);
        result = 31 * result + (datesoumission != null ? datesoumission.hashCode() : 0);
        return result;
    }
}
