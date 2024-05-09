package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CARACTERISTICA_PRODUTO_PRODUTO")
public class CaracteristicaProdutoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARACTERISTICA_PRODUTO_PRODUTO")
    private Integer idCaracteristicasProdutoProduto;

    @ManyToOne
    @JoinColumn(name = "ID_CARACTERISTICAS_PRODUTO")

    private CaracteristicaProduto caracteristicasProduto;
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    public CaracteristicaProdutoProduto(CaracteristicaProduto caracteristicasProduto, Produto produto) {
        this.caracteristicasProduto = caracteristicasProduto;
        this.produto = produto;
    }

    public CaracteristicaProdutoProduto() {
    }

    public Integer getIdCaracteristicasProdutoProduto() {
        return idCaracteristicasProdutoProduto;
    }

    public void setIdCaracteristicasProdutoProduto(Integer idCaracteristicasProdutoProduto) {
        this.idCaracteristicasProdutoProduto = idCaracteristicasProdutoProduto;
    }

    public CaracteristicaProduto getCaracteristicasProduto() {
        return caracteristicasProduto;
    }

    public void setCaracteristicasProduto(CaracteristicaProduto caracteristicasProduto) {
        this.caracteristicasProduto = caracteristicasProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
