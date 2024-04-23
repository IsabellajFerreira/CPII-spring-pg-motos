package br.com.fiap.motos.service;


import br.com.fiap.motos.dto.request.TipoVeiculoRequest;
import br.com.fiap.motos.dto.request.VeiculoRequest;
import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.entity.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoService repo;

    @Autowired
    private FabricanteService fabricanteService;

    @Autowired
    private TipoVeiculoService tipoVeiculoService;


    @Override
    public Veiculo toEntity(VeiculoRequest r) {
        var fabricante = fabricanteService.findById( r.fabricante().id() );
        var tipoVeiculo = tipoVeiculoService.findById( r.tipoVeiculo().id() );
        return Veiculo.builder()
                .fabricante( fabricante )
                .nome( r.nome() )
                .anoDeFabricacao( r.anoDeFabricacao() )
                .cor( r.cor())
                .preco( r.preco())
                .tipoVeiculo( tipoVeiculo )
                .build();
    }

    @Override
    public ChefeResponse toResponse(Chefe e) {
        return ChefeResponse.builder()
                .id( e.getId() )
                .unidade( unidadeService.toResponse( e.getUnidade() ) )
                .inicio( e.getInicio() )
                .fim( e.getFim() )
                .substituto( e.getSubstituto() )
                .usuario( usuarioService.toResponse( e.getUsuario() ) )
                .build();
    }

    @Override
    public List<Chefe> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Chefe> findAll(Example<Chefe> example) {
        return repo.findAll( example );
    }

    @Override
    public Chefe findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Chefe save(Chefe e) {
        return repo.save( e );
    }
}

}
