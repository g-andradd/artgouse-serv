package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.models.TipoProduto;
import br.com.arthouseserv.repositories.TipoProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoProdutoService {


    private final TipoProdutoRepository tipoProdutoRepository;

    public TipoProdutoService(TipoProdutoRepository tipoProdutoRepository) {
        this.tipoProdutoRepository = tipoProdutoRepository;
    }

    public TipoProduto getTipoProduto(String nomeTipoProduto) {
        try {
            return tipoProdutoRepository.findTipoProdutoByNomeTipoProduto(nomeTipoProduto);

        }catch (Exception e){
            throw new ProdutosExceptions("Tipo produto não encontrado");
        }
    }
}
