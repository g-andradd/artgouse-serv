package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.models.StatusProduto;
import br.com.arthouseserv.repositories.StatusProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusProdutoService {

    private final StatusProdutoRepository statusProdutoRepository;

    public StatusProdutoService(StatusProdutoRepository statusProdutoRepository) {
        this.statusProdutoRepository = statusProdutoRepository;
    }

    public StatusProduto getStatusProdutoByNome(String nomeStatusProduto) {
        try {
            return statusProdutoRepository.findStatusProdutoByNomeStatusProduto(nomeStatusProduto);

        }catch (Exception e){
            throw new ProdutosExceptions(" Status de Produto não existente !");
        }
    }
}
