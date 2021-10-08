package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Message {
    private int idmessage;
    private String objet;
    private String contenu;
    private Date datemessage;
    private String etatmessage;
    private Integer idpersonneenvoyer;
    private Integer idpersonnerecevoir;

    @Id
    @Column(name = "IDMESSAGE")
    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }

    @Basic
    @Column(name = "OBJET")
    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    @Basic
    @Column(name = "CONTENU")
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Basic
    @Column(name = "DATEMESSAGE")
    public Date getDatemessage() {
        return datemessage;
    }

    public void setDatemessage(Date datemessage) {
        this.datemessage = datemessage;
    }

    @Basic
    @Column(name = "ETATMESSAGE")
    public String getEtatmessage() {
        return etatmessage;
    }

    public void setEtatmessage(String etatmessage) {
        this.etatmessage = etatmessage;
    }

    @Basic
    @Column(name = "IDPERSONNEENVOYER")
    public Integer getIdpersonneenvoyer() {
        return idpersonneenvoyer;
    }

    public void setIdpersonneenvoyer(Integer idpersonneenvoyer) {
        this.idpersonneenvoyer = idpersonneenvoyer;
    }

    @Basic
    @Column(name = "IDPERSONNERECEVOIR")
    public Integer getIdpersonnerecevoir() {
        return idpersonnerecevoir;
    }

    public void setIdpersonnerecevoir(Integer idpersonnerecevoir) {
        this.idpersonnerecevoir = idpersonnerecevoir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (idmessage != message.idmessage) return false;
        if (objet != null ? !objet.equals(message.objet) : message.objet != null) return false;
        if (contenu != null ? !contenu.equals(message.contenu) : message.contenu != null) return false;
        if (datemessage != null ? !datemessage.equals(message.datemessage) : message.datemessage != null) return false;
        if (etatmessage != null ? !etatmessage.equals(message.etatmessage) : message.etatmessage != null) return false;
        if (idpersonneenvoyer != null ? !idpersonneenvoyer.equals(message.idpersonneenvoyer) : message.idpersonneenvoyer != null)
            return false;
        if (idpersonnerecevoir != null ? !idpersonnerecevoir.equals(message.idpersonnerecevoir) : message.idpersonnerecevoir != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idmessage;
        result = 31 * result + (objet != null ? objet.hashCode() : 0);
        result = 31 * result + (contenu != null ? contenu.hashCode() : 0);
        result = 31 * result + (datemessage != null ? datemessage.hashCode() : 0);
        result = 31 * result + (etatmessage != null ? etatmessage.hashCode() : 0);
        result = 31 * result + (idpersonneenvoyer != null ? idpersonneenvoyer.hashCode() : 0);
        result = 31 * result + (idpersonnerecevoir != null ? idpersonnerecevoir.hashCode() : 0);
        return result;
    }
}
