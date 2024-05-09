package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CARACTERISTICAS_PRODUTO")
public class CaracteristicaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARACTERISTICAS_PRODUTO")
    private Integer idCaracteristicasProduto;
    @Column(name = "NOME_CARACTERISTICAS_PRODUTO")
    private String nomeCaracterisiticasProduto;

    @Column(name = "IMG_CARACTERISTICAS_PRODUTO")
    private byte[] imgCaracterisiticasProduto;

    public CaracteristicaProduto(Integer idCaracteristicasProduto, String nomeCaracterisiticasProduto, byte[] imgCaracterisiticasProduto) {
        this.idCaracteristicasProduto = idCaracteristicasProduto;
        this.nomeCaracterisiticasProduto = nomeCaracterisiticasProduto;
        this.imgCaracterisiticasProduto = imgCaracterisiticasProduto;
    }

    public CaracteristicaProduto() {
    }

    public Integer getIdCaracteristicasProduto() {
        return idCaracteristicasProduto;
    }

    public void setIdCaracteristicasProduto(Integer idCaracteristicasProduto) {
        this.idCaracteristicasProduto = idCaracteristicasProduto;
    }

    public String getNomeCaracterisiticasProduto() {
        return nomeCaracterisiticasProduto;
    }

    public void setNomeCaracterisiticasProduto(String nomeCaracterisiticasProduto) {
        this.nomeCaracterisiticasProduto = nomeCaracterisiticasProduto;
    }

    public byte[] getImgCaracterisiticasProduto() {
        return imgCaracterisiticasProduto;
    }

    public void setImgCaracterisiticasProduto(byte[] imgCaracterisiticasProduto) {
        this.imgCaracterisiticasProduto = imgCaracterisiticasProduto;
    }
}
