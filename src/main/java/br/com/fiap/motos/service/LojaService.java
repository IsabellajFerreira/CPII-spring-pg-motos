package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.LojaRequest;
import br.com.fiap.motos.dto.request.TipoVeiculoRequest;
import br.com.fiap.motos.dto.response.LojaResponse;
import br.com.fiap.motos.dto.response.TipoVeiculoResponse;
import br.com.fiap.motos.dto.response.VeiculoResponse;
import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.entity.Veiculo;
import br.com.fiap.motos.repository.LojaRepository;
import br.com.fiap.motos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LojaService implements ServiceDTO<Loja, LojaRequest, LojaResponse> {

    @Autowired
    private LojaRepository repo;

    @Autowired
    private VeiculoService veiculoService;


    @Override
    public Loja toEntity(LojaRequest r) {
        return Loja.builder()
                .nome( r.nome() )
                .build();
    }

    @Override
    public LojaResponse toResponse(Loja e) {
        var veiculos = e.getVeiculosComercializados();
        if (Objects.isNull(veiculos)) return LojaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .veiculosComercializados(null)
                .build();
        var veiculosResponse = veiculos.stream().map(veiculoService::toResponse).collect(Collectors.toSet());
        return LojaResponse.builder()
                .id(e.getId())
                .veiculosComercializados(veiculosResponse)
                .nome(e.getNome())
                .build();
    }


    @Override
    public Collection<Loja> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Loja> findAll(Example<Loja> example) {
        return repo.findAll( example );
    }

    @Override
    public Loja findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Loja save(Loja e) {
        return repo.save( e );
    }
}
