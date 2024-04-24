package br.com.fiap.motos.service;


import br.com.fiap.motos.dto.request.AcessorioRequest;
import br.com.fiap.motos.dto.response.AcessorioResponse;
import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AcessorioService implements ServiceDTO<Acessorio, AcessorioRequest, AcessorioResponse>{

    @Autowired
    private AcessorioRepository repo;

    @Override
    public Acessorio toEntity(AcessorioRequest r) {
        return Acessorio.builder()
                .nome( r.nome() )
                .preco( r.preco() )
                .build();
    }

    @Override
    public AcessorioResponse toResponse(Acessorio e) {

        return AcessorioResponse.builder()
                .id( e.getId() )
                .nome( e.getNome() )
                .preco( e.getPreco() )
                .build();
    }

    @Override
    public Collection<Acessorio> findAll() {
        return repo.findAll();
    }

    @Override
    public Collection<Acessorio> findAll(Example<Acessorio> example) {
        return repo.findAll( example );
    }

    @Override
    public Acessorio findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Acessorio save(Acessorio e) {
        return repo.save( e );
    }
}

