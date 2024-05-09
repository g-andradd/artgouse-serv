package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "MENSAGEM")
public class LeadMensagem extends DefaultCriacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MENSAGEM")
    private Integer idMensagem;

    @Column(name="ASSUNTO_MENSAGEM")
    private String assuntoMensagem;

    @Column(name = "TEXT_MENSAGEM")
    private String textoMensagem;

    @OneToOne()
    @JoinColumn(name = "ID_CLIENTE_LEAD")
    private Lead lead;

    public LeadMensagem(Integer idMensagem, String assuntoMensagem, String textoMensagem, Lead lead) {
        this.idMensagem = idMensagem;
        this.assuntoMensagem = assuntoMensagem;
        this.textoMensagem = textoMensagem;
        this.lead = lead;
    }

    public LeadMensagem() {
    }

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getAssuntoMensagem() {
        return assuntoMensagem;
    }

    public void setAssuntoMensagem(String assuntoMensagem) {
        this.assuntoMensagem = assuntoMensagem;
    }

    public String getTextoMensagem() {
        return textoMensagem;
    }

    public void setTextoMensagem(String textoMensagem) {
        this.textoMensagem = textoMensagem;
    }

    public Lead getLead() {
        return lead;
    }

    public void setLead(Lead lead) {
        this.lead = lead;
    }
}
