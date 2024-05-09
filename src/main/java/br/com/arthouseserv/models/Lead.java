package br.com.arthouseserv.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENTE_LEAD")
public class Lead extends DefaultCriacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE_LEAD")
    private Integer idLead;

    @Column(name="NOME_CLIENTE_LEAD")
    private String nomeLead;


    @ManyToOne()
    @JoinColumn(name = "ID_CONTATO_CLIENTE_LEAD")
    private Contato contato;

    public Lead(Integer idLead, String nomeLead, Contato contato) {
        this.idLead = idLead;
        this.nomeLead = nomeLead;
        this.contato = contato;
    }

    public Lead() {
    }

    public Integer getIdLead() {
        return idLead;
    }

    public void setIdLead(Integer idLead) {
        this.idLead = idLead;
    }

    public String getNomeLead() {
        return nomeLead;
    }

    public void setNomeLead(String nomeLead) {
        this.nomeLead = nomeLead;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
