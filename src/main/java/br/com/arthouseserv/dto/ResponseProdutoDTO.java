package br.com.arthouseserv.dto;

import java.util.List;

public record ResponseProdutoDTO(String tipoProduto,
                                 List<String> caracteristicasProduto,
                                 List<String> coresProduto, String statusProduto, String descricao) {
}
