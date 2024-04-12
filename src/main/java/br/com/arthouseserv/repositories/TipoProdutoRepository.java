package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.TipoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto,Integer> {

    TipoProduto findTipoProdutoByNomeTipoProduto(String nomeTipoProduto);


}
