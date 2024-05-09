package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto extends DefaultCriacao{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Integer idProduto;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "DESC_PRODUTO")
    private String descProduto;
    @Column(name = "CONT_PRODUTO")
    private byte[] contProduto;
    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PRODUTO")
    private TipoProduto tipoProduto;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS_PRODUTO")
    private StatusProduto statusProduto;


    public Produto() {
    }

    public Produto(Integer idProduto, String nomeProduto, String descProduto, byte[] contProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
        this.contProduto = contProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public byte[] getContProduto() {
        return contProduto;
    }

    public void setContProduto(byte[] contProduto) {
        this.contProduto = contProduto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }
}
