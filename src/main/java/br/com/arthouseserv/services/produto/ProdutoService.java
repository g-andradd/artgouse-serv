package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.*;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.mappers.ProdutoMapper;
import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.models.StatusProduto;
import br.com.arthouseserv.models.TipoProduto;
import br.com.arthouseserv.repositories.ProdutoRepository;
import br.com.arthouseserv.repositories.StatusProdutoRepository;
import br.com.arthouseserv.repositories.TipoProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final TipoProdutoService tipoProdutoService;
    private final ProdutoMapper produtoMapper;
    private final CaracteriticaProdutoService caracteriticaProdutoService;
    private final CaracteristicaProdutoProdutoService caracteristicaProdutoProdutoService;
    private final CorProdutoProdutoService corProdutoProdutoService;
    private final CorProdutoService corProdutoService;
    private final StatusProdutoService statusProdutoService;
    private final CalculoRolosService calculoRolosService;
    private final StatusProdutoRepository statusProdutoRepository;
    private final TipoProdutoRepository tipoProdutoRepository;

    public ProdutoService(ProdutoRepository produtoRepository, TipoProdutoService tipoProdutoService,
                          ProdutoMapper produtoMapper, CaracteriticaProdutoService caracteriticaProdutoService,
                          CaracteristicaProdutoProdutoService caracteristicaProdutoProdutoService,
                          CorProdutoProdutoService corProdutoProdutoService,
                          CorProdutoService corProdutoService, StatusProdutoService statusProdutoService, CalculoRolosService calculoRolosService, StatusProdutoRepository statusProdutoRepository, TipoProdutoRepository tipoProdutoRepository) {
        this.produtoRepository = produtoRepository;
        this.tipoProdutoService = tipoProdutoService;
        this.produtoMapper = produtoMapper;
        this.caracteriticaProdutoService = caracteriticaProdutoService;
        this.caracteristicaProdutoProdutoService = caracteristicaProdutoProdutoService;
        this.corProdutoProdutoService = corProdutoProdutoService;
        this.corProdutoService = corProdutoService;
        this.statusProdutoService = statusProdutoService;
        this.calculoRolosService = calculoRolosService;
        this.statusProdutoRepository = statusProdutoRepository;
        this.tipoProdutoRepository = tipoProdutoRepository;
    }

    public Produto cadastroProdutos(MultipartFile multipartFile, ResponseProdutoDTO responseProdutoDTO) throws IOException {

        var tipoProduto = tipoProdutoService.getTipoProduto(responseProdutoDTO.tipoProduto());
        var statusProduto = statusProdutoService.getStatusProdutoByNome(responseProdutoDTO.statusProduto());
        var retornoProdutoSalvo = saveProduto(produtoMapper.produtoDTOToEntity(multipartFile,tipoProduto,statusProduto, responseProdutoDTO.descricao()));

        responseProdutoDTO.caracteristicasProduto().forEach(x -> {
            var caracteristicasProduto = caracteriticaProdutoService.buscarCaracteristicasProdutoByNome(x);
            caracteristicaProdutoProdutoService.saveCaracteristicaProdutoProduto(retornoProdutoSalvo, caracteristicasProduto);
        });

        responseProdutoDTO.coresProduto().forEach(x -> {
            var corProduto = corProdutoService.buscarCoresProdutoByNome(x);
            corProdutoProdutoService.saveCoresProdutoProduto(corProduto, retornoProdutoSalvo);
        });
        return retornoProdutoSalvo;
    }


    public byte[] downloadProdutoById(Integer idProduto) {
        return buscarProduto(idProduto).getContProduto();
    }


    public Produto buscarProduto(Integer idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutosExceptions("Produto não foi encontrado !!"));
    }


    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Page<ProdutosDTO> buscarProdutosPagebleFiltro(FiltroProdutoDTO filtroProdutoDTO, Integer pages, Integer size) {
        Pageable page = PageRequest.of(pages, size);
        var cores = filtroProdutoDTO.cores().isEmpty() ? null : filtroProdutoDTO.cores();
        var caracteristicas = filtroProdutoDTO.caracteristicas().isEmpty() ? null : filtroProdutoDTO.caracteristicas();
        var ordenacao = logicaOrdenacao(filtroProdutoDTO);
        return produtoRepository.getProdutosFiltro(cores, caracteristicas, page, ordenacao.primeiroNumeroOrdenacao(), ordenacao.segundoNumeroOrdenacao());
    }

    public OrdenacaoDTO logicaOrdenacao(FiltroProdutoDTO filtroProdutoDTO) {
        if (filtroProdutoDTO.ordenacao() == 0) {
            return new OrdenacaoDTO(2, 3);
        } else {
            return new OrdenacaoDTO(1, 3);
        }
    }

    public List<CaracteristicasDTO> listarCaracteristicas() {
        return caracteriticaProdutoService.buscarListaCaracteristicas();
    }

    public List<CoresDTO> listarCores() {
        return corProdutoService.buscarListaCores();
    }

    public void salvarImageCaracteristicas(Integer idCaracteristicas, MultipartFile imagem) throws IOException {
        caracteriticaProdutoService.saveImageCaracteristicas(idCaracteristicas, imagem);
    }

    public void salvarImageCores(Integer idCores, MultipartFile imagem) throws IOException {
        corProdutoService.saveImageCores(idCores, imagem);
    }


    public String calculoQuantidadeRolos(ResponseCalculoQuantidade responseCalculoQuantidade) {
        var larguraEmMetro = responseCalculoQuantidade.getLargura().divide(BigDecimal.valueOf(100));
        var alturaEmMetro = responseCalculoQuantidade.getAltura().divide(BigDecimal.valueOf(100));

        var soma = calculoRolosService.calculoRolos(larguraEmMetro, alturaEmMetro);
        return "Será nescessario ".concat(String.valueOf(soma)).concat(" rolos");

    }

    public ProdutoIdDTO buscaProdutoPorId(Integer idProduto){
        return produtoRepository.buscaProdutoPorId(idProduto);
    }

    public List<TipoProduto> buscarTodosTipoProdutos(){
        return tipoProdutoRepository.findAll();
    }

    public List<StatusProduto> buscarStatusTipoProdutos(){
        return statusProdutoRepository.findAll();
    }
}
