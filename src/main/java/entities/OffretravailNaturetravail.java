package entities;

import javax.persistence.*;

@Entity
@Table(name = "OFFRETRAVAIL_NATURETRAVAIL", schema = "EQUIPE3_A10", catalog = "")
@IdClass(OffretravailNaturetravailPK.class)
public class OffretravailNaturetravail {
    private int offretravailidoffretravail;
    private String naturetravailnom;

    @Id
    @Column(name = "OFFRETRAVAILIDOFFRETRAVAIL")
    public int getOffretravailidoffretravail() {
        return offretravailidoffretravail;
    }

    public void setOffretravailidoffretravail(int offretravailidoffretravail) {
        this.offretravailidoffretravail = offretravailidoffretravail;
    }

    @Id
    @Column(name = "NATURETRAVAILNOM")
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

        OffretravailNaturetravail that = (OffretravailNaturetravail) o;

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
