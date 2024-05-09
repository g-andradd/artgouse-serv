package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_PRODUTO")
public class TipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_PRODUTO")
    private Integer idTipoProduto;

    @Column(name = "NOME_TIPO_PRODUTO")
    private String nomeTipoProduto;

    public TipoProduto(Integer idTipoProduto, String nomeTipoProduto) {
        this.idTipoProduto = idTipoProduto;
        this.nomeTipoProduto = nomeTipoProduto;
    }

    public TipoProduto() {
    }

    public Integer getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Integer idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getNomeTipoProduto() {
        return nomeTipoProduto;
    }

    public void setNomeTipoProduto(String nomeTipoProduto) {
        this.nomeTipoProduto = nomeTipoProduto;
    }
}
