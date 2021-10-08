package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@IdClass(EvaluationPK.class)
public class Evaluation {
    private int personneidpersonne;
    private int offretravailidoffretravail;
    private int rang;
    private String commentaire;
    private Date dateevaluation;
    private String typeevaluateur;

    @Id
    @Column(name = "PERSONNEIDPERSONNE")
    public int getPersonneidpersonne() {
        return personneidpersonne;
    }

    public void setPersonneidpersonne(int personneidpersonne) {
        this.personneidpersonne = personneidpersonne;
    }

    @Id
    @Column(name = "OFFRETRAVAILIDOFFRETRAVAIL")
    public int getOffretravailidoffretravail() {
        return offretravailidoffretravail;
    }

    public void setOffretravailidoffretravail(int offretravailidoffretravail) {
        this.offretravailidoffretravail = offretravailidoffretravail;
    }

    @Basic
    @Column(name = "RANG")
    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    @Basic
    @Column(name = "COMMENTAIRE")
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Basic
    @Column(name = "DATEEVALUATION")
    public Date getDateevaluation() {
        return dateevaluation;
    }

    public void setDateevaluation(Date dateevaluation) {
        this.dateevaluation = dateevaluation;
    }

    @Basic
    @Column(name = "TYPEEVALUATEUR")
    public String getTypeevaluateur() {
        return typeevaluateur;
    }

    public void setTypeevaluateur(String typeevaluateur) {
        this.typeevaluateur = typeevaluateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evaluation that = (Evaluation) o;

        if (personneidpersonne != that.personneidpersonne) return false;
        if (offretravailidoffretravail != that.offretravailidoffretravail) return false;
        if (rang != that.rang) return false;
        if (commentaire != null ? !commentaire.equals(that.commentaire) : that.commentaire != null) return false;
        if (dateevaluation != null ? !dateevaluation.equals(that.dateevaluation) : that.dateevaluation != null)
            return false;
        if (typeevaluateur != null ? !typeevaluateur.equals(that.typeevaluateur) : that.typeevaluateur != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personneidpersonne;
        result = 31 * result + offretravailidoffretravail;
        result = 31 * result + rang;
        result = 31 * result + (commentaire != null ? commentaire.hashCode() : 0);
        result = 31 * result + (dateevaluation != null ? dateevaluation.hashCode() : 0);
        result = 31 * result + (typeevaluateur != null ? typeevaluateur.hashCode() : 0);
        return result;
    }
}
