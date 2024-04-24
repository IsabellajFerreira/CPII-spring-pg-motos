package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.TipoVeiculoRequest;
import br.com.fiap.motos.dto.response.TipoVeiculoResponse;
import br.com.fiap.motos.entity.TipoVeiculo;
import br.com.fiap.motos.service.TipoVeiculoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;



@RestController
@RequestMapping(value = "/tipo-de-veiculo")
public class TipoVeiculoResource {


    @Autowired
    private TipoVeiculoService service;

    @GetMapping
    public Collection<TipoVeiculoResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public TipoVeiculoResponse findById(@PathVariable Long id) {
        TipoVeiculo tipoVeiculo = service.findById(id);
        return service.toResponse(tipoVeiculo);
    }

    @Transactional
    @PostMapping
    public TipoVeiculoResponse save(@RequestBody TipoVeiculoRequest tipoVeiculo) {
        TipoVeiculo save = service.save(service.toEntity(tipoVeiculo));
        return service.toResponse(save);
    }


}
