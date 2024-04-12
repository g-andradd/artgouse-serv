package br.com.arthouseserv.dto;

import java.util.List;

public record ResponseProdutoDTO(String tipoProdutoDTO,
                                 List<String> caracteristicasProdutoDTO,
                                 List<String> coresProdutoDTO, String statusProduto, String descricao) {
}
