package br.com.fiap.motos.dto.response;

import lombok.Builder;

import java.util.Set;

@Builder
public record LojaResponse(

        Long id,

        String nome,

        Set<VeiculoResponse> veiculosComercializados
) {
}
