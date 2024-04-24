package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.CaracteristicaRequest;
import br.com.fiap.motos.dto.request.FabricanteRequest;
import br.com.fiap.motos.dto.response.CaracteristicaResponse;
import br.com.fiap.motos.dto.response.FabricanteResponse;
import br.com.fiap.motos.entity.Caracteristica;
import br.com.fiap.motos.entity.Fabricante;
import br.com.fiap.motos.service.CaracteristicaService;
import br.com.fiap.motos.service.FabricanteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/fabricante")
public class FabricanteResource {


    @Autowired
    private FabricanteService service;

    @GetMapping
    public Collection<FabricanteResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public FabricanteResponse findById(@PathVariable Long id) {
        Fabricante fabricante = service.findById(id);
        return service.toResponse(fabricante);
    }

    @Transactional
    @PostMapping
    public FabricanteResponse save(@RequestBody FabricanteRequest fabricante) {
        Fabricante save = service.save(service.toEntity(fabricante));
        return service.toResponse(save);
    }

}
