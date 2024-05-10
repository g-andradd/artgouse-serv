package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.CoresCadastroDTO;
import br.com.arthouseserv.dto.CoresDTO;
import br.com.arthouseserv.models.CorProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorProdutoRepository extends JpaRepository<CorProduto,Integer> {


    @Query(" SELECT new br.com.arthouseserv.dto.CoresDTO(cp.idCorProduto," +
            "cp.nomeCorProduto,cp.imgCorProduto) " +
            "FROM CorProduto cp")
    List<CoresDTO> buscarCores();

    CorProduto findCorProdutoByNomeCorProduto(String nomeCorProduto);

    @Query(" SELECT new br.com.arthouseserv.dto.CoresCadastroDTO(cp.idCorProduto," +
            "cp.nomeCorProduto) " +
            "FROM CorProduto cp")
    List<CoresCadastroDTO> buscarCoresCadastro();



}
