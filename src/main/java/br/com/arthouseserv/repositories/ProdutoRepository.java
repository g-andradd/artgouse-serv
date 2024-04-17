package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.ProdutoIdDTO;
import br.com.arthouseserv.dto.ProdutosDTO;
import br.com.arthouseserv.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT new br.com.arthouseserv.dto.ProdutosDTO(p.idProduto,p.contProduto,sp.nomeStatusProduto,p.nomeProduto,p.descProduto) " +
            "FROM Produto p " +
            "LEFT JOIN CorProdutoProduto cpp " +
            "ON p.idProduto = cpp.produto.idProduto " +
            "LEFT JOIN cpp.coresProduto cp " +
            "LEFT JOIN CaracteristicaProdutoProduto crcpp " +
            "ON crcpp.produto.idProduto = p.idProduto " +
            "LEFT JOIN crcpp.caracteristicasProduto crcp " +
            "LEFT JOIN p.statusProduto sp " +
            "WHERE(:cores IS NULL OR cp.nomeCorProduto IN :cores) " +
            "AND(:caracteristicas IS NULL OR crcp.nomeCaracterisiticasProduto IN :caracteristicas) " +
            "GROUP BY p.idProduto,p.contProduto,sp.nomeStatusProduto,p.nomeProduto,p.descProduto " +
            "ORDER BY CASE " +
            "WHEN sp.idStatusProduto NOT IN (:ordenacaoUm,:ordenacaoDois) THEN 1 " +
            "WHEN sp.idStatusProduto = :ordenacaoUm THEN 2 " +
            "ELSE 3 " +
            "END ")
    Page<ProdutosDTO> getProdutosFiltro(List<String> cores, List<String> caracteristicas, Pageable pageable, Integer ordenacaoUm, Integer ordenacaoDois);

    @Query("SELECT new br.com.arthouseserv.dto.ProdutoIdDTO(p.idProduto,p.contProduto,p.nomeProduto,p.descProduto) FROM Produto p WHERE p.idProduto =:idProduto")
    ProdutoIdDTO buscaProdutoPorId(Integer idProduto);



}
