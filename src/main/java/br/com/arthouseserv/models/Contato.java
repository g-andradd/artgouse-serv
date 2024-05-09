package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CONTATO_CLIENTE_LEAD")
public class Contato extends  DefaultCriacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO_CLIENTE_LEAD")
    private Integer idContatoLead;

    @Column(name = "EMAIL_CLIENTE_LEAD")
    private String emailLead;

    @Column(name = "CELULAR_CLIENTE_LEAD")
    private String celularLead;



    public Contato () {
    }

    public Contato(Integer idContatoLead, String emailLead, String celularLead) {
        this.idContatoLead = idContatoLead;
        this.emailLead = emailLead;
        this.celularLead = celularLead;

    }

    public Integer getIdContatoLead() {
        return idContatoLead;
    }

    public void setIdContatoLead(Integer idContatoLead) {
        this.idContatoLead = idContatoLead;
    }

    public String getEmailLead() {
        return emailLead;
    }

    public void setEmailLead(String emailLead) {
        this.emailLead = emailLead;
    }

    public String getCelularLead() {
        return celularLead;
    }

    public void setCelularLead(String celularLead) {
        this.celularLead = celularLead;
    }


}
