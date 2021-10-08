package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OffretravailNaturetravailPK implements Serializable {
    private int offretravailidoffretravail;
    private String naturetravailnom;

    @Column(name = "OFFRETRAVAILIDOFFRETRAVAIL")
    @Id
    public int getOffretravailidoffretravail() {
        return offretravailidoffretravail;
    }

    public void setOffretravailidoffretravail(int offretravailidoffretravail) {
        this.offretravailidoffretravail = offretravailidoffretravail;
    }

    @Column(name = "NATURETRAVAILNOM")
    @Id
    public String getNaturetravailnom() {
        return naturetravailnom;
    }

    public void setNaturetravailnom(String naturetravailnom) {
        this.naturetravailnom = naturetravailnom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OffretravailNaturetravailPK that = (OffretravailNaturetravailPK) o;

        if (offretravailidoffretravail != that.offretravailidoffretravail) return false;
        if (naturetravailnom != null ? !naturetravailnom.equals(that.naturetravailnom) : that.naturetravailnom != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = offretravailidoffretravail;
        result = 31 * result + (naturetravailnom != null ? naturetravailnom.hashCode() : 0);
        return result;
    }
}
