package br.com.fiap.motos.dto.response;

import lombok.Builder;

import java.time.Year;

@Builder
public record VeiculoResponse(

        Long id,
        String nome,
        String modelo,
        Year anoDeFabricacao,
        TipoVeiculoResponse tipo,
        String cor,
        FabricanteResponse fabricante,
        Double preco,
        String palavraDeFeito,
        Short cilindradas
) {
}
