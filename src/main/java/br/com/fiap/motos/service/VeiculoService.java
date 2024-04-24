package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.VeiculoRequest;
import br.com.fiap.motos.dto.response.VeiculoResponse;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Collection;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse>{
    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private FabricanteService fabricanteService;

    @Autowired
    private TipoVeiculoService tipoVeiculoService;


    @Override
    public Veiculo toEntity(VeiculoRequest r) {
        var fabricante = fabricanteService.findById( r.fabricante().id() );
        var tipo = tipoVeiculoService.findById( r.tipo().id() );
        return Veiculo.builder()
                .fabricante( fabricante )
                .nome( r.nome() )
                .anoDeFabricacao( r.anoDeFabricacao() )
                .cor( r.cor())
                .preco( r.preco())
                .cilindradas( r.cilindradas())
                .modelo(r.modelo())
                .palavraDeEfeito(r.palavraDeEfeito())
                .tipo( tipo )
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo e) {

        var fabricante = fabricanteService.toResponse(e.getFabricante());
        var tipo = tipoVeiculoService.toResponse(e.getTipo());
        return VeiculoResponse.builder()
                .id( e.getId() )
                .nome(e.getNome())
                .modelo(e.getModelo())
                .anoDeFabricacao(e.getAnoDeFabricacao())
                .tipo( tipo)
                .cor(e.getCor())
                .fabricante(fabricante)
                .preco(e.getPreco())
                .palavraDeFeito(e.getPalavraDeEfeito())
                .cilindradas(e.getCilindradas())
                .build();
    }

    @Override
    public Collection<Veiculo> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Veiculo> findAll(Example<Veiculo> example) {
        return repo.findAll( example );
    }

    @Override
    public Veiculo findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Veiculo save(Veiculo e) {
        return repo.save( e );
    }
}


