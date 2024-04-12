package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.StatusProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusProdutoRepository extends JpaRepository<StatusProduto,Integer> {

    StatusProduto findStatusProdutoByNomeStatusProduto(String nomeStatusProduto);
}
