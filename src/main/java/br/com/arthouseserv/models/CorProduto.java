package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CORES_PRODUTO")
public class CorProduto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COR_PRODUTO")
    private Integer idCorProduto;
    @Column(name = "NOME_COR_PRODUTO")
    private String nomeCorProduto;

    @Column(name = "DESC_COR_PRODUTO")
    private String descCorProduto;
    @Column(name = "IMG_CORES_PRODUTO")
    private byte[] imgCorProduto;

    public CorProduto(Integer idCorProduto, String nomeCorProduto, String descCorProduto, byte[] imgCorProduto) {
        this.idCorProduto = idCorProduto;
        this.nomeCorProduto = nomeCorProduto;
        this.descCorProduto = descCorProduto;
        this.imgCorProduto = imgCorProduto;
    }

    public CorProduto() {
    }

    public Integer getIdCorProduto() {
        return idCorProduto;
    }

    public void setIdCorProduto(Integer idCorProduto) {
        this.idCorProduto = idCorProduto;
    }

    public String getNomeCorProduto() {
        return nomeCorProduto;
    }

    public void setNomeCorProduto(String nomeCorProduto) {
        this.nomeCorProduto = nomeCorProduto;
    }

    public String getDescCorProduto() {
        return descCorProduto;
    }

    public void setDescCorProduto(String descCorProduto) {
        this.descCorProduto = descCorProduto;
    }

    public byte[] getImgCorProduto() {
        return imgCorProduto;
    }

    public void setImgCorProduto(byte[] imgCorProduto) {
        this.imgCorProduto = imgCorProduto;
    }
}
