package br.com.fiap.motos.resource;


import br.com.fiap.motos.dto.request.AcessorioRequest;
import br.com.fiap.motos.dto.response.AcessorioResponse;
import br.com.fiap.motos.entity.Acessorio;
import br.com.fiap.motos.service.AcessorioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/acessorio")
public class AcessorioResource {

    @Autowired
    private AcessorioService service;

    @GetMapping
    public Collection<AcessorioResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public AcessorioResponse findById(@PathVariable Long id) {
        Acessorio acessorio = service.findById(id);
        return service.toResponse(acessorio);
    }

    @Transactional
    @PostMapping
    public AcessorioResponse save(@RequestBody AcessorioRequest acessorio) {
        Acessorio save = service.save(service.toEntity(acessorio));
        return service.toResponse(save);
    }


}
