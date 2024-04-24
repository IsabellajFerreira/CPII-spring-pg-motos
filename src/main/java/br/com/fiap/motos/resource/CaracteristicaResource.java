package br.com.fiap.motos.resource;

import br.com.fiap.motos.dto.request.CaracteristicaRequest;
import br.com.fiap.motos.dto.response.CaracteristicaResponse;
import br.com.fiap.motos.entity.Caracteristica;
import br.com.fiap.motos.service.CaracteristicaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping(value = "/caracteristica")
public class CaracteristicaResource {


    @Autowired
    private CaracteristicaService service;

    @GetMapping
    public Collection<CaracteristicaResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public CaracteristicaResponse findById(@PathVariable Long id) {
        Caracteristica caracteristica = service.findById(id);
        return service.toResponse(caracteristica);
    }
    @Transactional
    @PostMapping
    public CaracteristicaResponse save(@RequestBody CaracteristicaRequest caracteristica) {
        Caracteristica save = service.save(service.toEntity(caracteristica));
        return service.toResponse(save);
    }

}

