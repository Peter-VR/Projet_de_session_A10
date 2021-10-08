package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    private int personneidpersonne;
    private String adresse;
    private String ville;
    private String postalcode;
    private String province;

    @Id
    @Column(name = "PERSONNEIDPERSONNE")
    public int getPersonneidpersonne() {
        return personneidpersonne;
    }

    public void setPersonneidpersonne(int personneidpersonne) {
        this.personneidpersonne = personneidpersonne;
    }

    @Basic
    @Column(name = "ADRESSE")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "VILLE")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Basic
    @Column(name = "POSTALCODE")
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "PROVINCE")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (personneidpersonne != that.personneidpersonne) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (ville != null ? !ville.equals(that.ville) : that.ville != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personneidpersonne;
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (ville != null ? ville.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        return result;
    }
}
