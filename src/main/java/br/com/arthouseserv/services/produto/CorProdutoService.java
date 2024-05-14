package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.CorProdutoDTO;
import br.com.arthouseserv.dto.CoresCadastroDTO;
import br.com.arthouseserv.dto.CoresDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.mappers.CorProdutoMapper;
import br.com.arthouseserv.models.CorProduto;
import br.com.arthouseserv.repositories.CorProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorProdutoService {

    private final CorProdutoRepository corProdutoRepository;
    private final CorProdutoMapper corProdutoMapper;

    public CorProdutoService(CorProdutoRepository corProdutoRepository, CorProdutoMapper corProdutoMapper) {
        this.corProdutoRepository = corProdutoRepository;
        this.corProdutoMapper = corProdutoMapper;
    }

    public CorProduto buscarCoresProduto(Integer idCorProduto) {
        return corProdutoRepository.findById(idCorProduto).orElseThrow(() -> new ProdutosExceptions("Cor do produto não encontrado"));
    }

    public CorProduto buscarCoresProdutoByNome(String nomeCorProduto) {
        try {
            return corProdutoRepository.findCorProdutoByNomeCorProduto(nomeCorProduto);
        } catch (Exception e) {
            throw new ProdutosExceptions("Cor do produto não encontrado");
        }
    }


    public List<CoresDTO> buscarListaCores() {
        return corProdutoRepository.buscarCores();
    }

    public void saveImageCores(Integer idCores, MultipartFile imagem) throws IOException {
        var cores = buscarCoresProduto(idCores);
        cores.setImgCorProduto(imagem.getBytes());
        corProdutoRepository.save(cores);
    }

    public List<CoresCadastroDTO> buscarListaCoresCadastro() {
        return corProdutoRepository.buscarCoresCadastro();
    }
}
