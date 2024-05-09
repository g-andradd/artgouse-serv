package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CORES_PRODUTO_PRODUTO")
public class CorProdutoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CORES_PRODUTO_PRODUTO")
    private Integer idCoresProdutoProduto;

    @ManyToOne
    @JoinColumn(name = "ID_COR_PRODUTO")
    private CorProduto coresProduto;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    public CorProdutoProduto(CorProduto coresProduto, Produto produto) {
        this.coresProduto = coresProduto;
        this.produto = produto;
    }

    public CorProdutoProduto() {
    }

    public Integer getIdCoresProdutoProduto() {
        return idCoresProdutoProduto;
    }

    public void setIdCoresProdutoProduto(Integer idCoresProdutoProduto) {
        this.idCoresProdutoProduto = idCoresProdutoProduto;
    }

    public CorProduto getCoresProduto() {
        return coresProduto;
    }

    public void setCoresProduto(CorProduto coresProduto) {
        this.coresProduto = coresProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
