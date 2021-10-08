package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professionel {
    private int personneidpersonne;
    private String nomcompagnie;

    @Id
    @Column(name = "PERSONNEIDPERSONNE")
    public int getPersonneidpersonne() {
        return personneidpersonne;
    }

    public void setPersonneidpersonne(int personneidpersonne) {
        this.personneidpersonne = personneidpersonne;
    }

    @Basic
    @Column(name = "NOMCOMPAGNIE")
    public String getNomcompagnie() {
        return nomcompagnie;
    }

    public void setNomcompagnie(String nomcompagnie) {
        this.nomcompagnie = nomcompagnie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professionel that = (Professionel) o;

        if (personneidpersonne != that.personneidpersonne) return false;
        if (nomcompagnie != null ? !nomcompagnie.equals(that.nomcompagnie) : that.nomcompagnie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personneidpersonne;
        result = 31 * result + (nomcompagnie != null ? nomcompagnie.hashCode() : 0);
        return result;
    }
}
