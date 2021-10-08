package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EvaluationPK implements Serializable {
    private int personneidpersonne;
    private int offretravailidoffretravail;

    @Column(name = "PERSONNEIDPERSONNE")
    @Id
    public int getPersonneidpersonne() {
        return personneidpersonne;
    }

    public void setPersonneidpersonne(int personneidpersonne) {
        this.personneidpersonne = personneidpersonne;
    }

    @Column(name = "OFFRETRAVAILIDOFFRETRAVAIL")
    @Id
    public int getOffretravailidoffretravail() {
        return offretravailidoffretravail;
    }

    public void setOffretravailidoffretravail(int offretravailidoffretravail) {
        this.offretravailidoffretravail = offretravailidoffretravail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationPK that = (EvaluationPK) o;

        if (personneidpersonne != that.personneidpersonne) return false;
        if (offretravailidoffretravail != that.offretravailidoffretravail) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personneidpersonne;
        result = 31 * result + offretravailidoffretravail;
        return result;
    }
}
