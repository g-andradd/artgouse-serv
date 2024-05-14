package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.CaracteristicaProdutoDTO;
import br.com.arthouseserv.dto.CaracteristicasCadastroDTO;
import br.com.arthouseserv.dto.CaracteristicasDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.mappers.CaracteristicaProdutoMapper;
import br.com.arthouseserv.models.CaracteristicaProduto;
import br.com.arthouseserv.repositories.CaracteristicaProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaracteriticaProdutoService {

    private final CaracteristicaProdutoRepository caracteristicaProdutoRepository;
    private final CaracteristicaProdutoMapper caracteristicaProdutoMapper;

    public CaracteriticaProdutoService(CaracteristicaProdutoRepository caracteristicaProdutoRepository, CaracteristicaProdutoMapper caracteristicaProdutoMapper) {
        this.caracteristicaProdutoRepository = caracteristicaProdutoRepository;
        this.caracteristicaProdutoMapper = caracteristicaProdutoMapper;
    }

    public CaracteristicaProduto buscarCaracteristicasProduto(Integer idCaracteristicasProduto) {

        return caracteristicaProdutoRepository.findById(idCaracteristicasProduto).orElseThrow(() -> new ProdutosExceptions("Caracteristicas do produto não foi encontrada!"));
    }

    public CaracteristicaProduto buscarCaracteristicasProdutoByNome(String nomeCaracteristicasProduto) {
        try {
            return caracteristicaProdutoRepository.findCaracteristicaProdutoByNomeCaracterisiticasProduto(nomeCaracteristicasProduto);
        } catch (Exception e) {
            throw new ProdutosExceptions("Caracteristicas do produto não foi encontrada!");
        }

    }

    public List<CaracteristicasDTO> buscarListaCaracteristicas() {
        return caracteristicaProdutoRepository.buscarCaracteristicas();
    }

    public void saveImageCaracteristicas(Integer idCaracteristicas, MultipartFile imagem) throws IOException {
        var caracteristicas = buscarCaracteristicasProduto(idCaracteristicas);
        caracteristicas.setImgCaracterisiticasProduto(imagem.getBytes());
        caracteristicaProdutoRepository.save(caracteristicas);
    }

    public List<CaracteristicasCadastroDTO> buscarListaCaracteristicasCadastro() {
        return caracteristicaProdutoRepository.buscarCaracteristicasCadastro();
    }
}
