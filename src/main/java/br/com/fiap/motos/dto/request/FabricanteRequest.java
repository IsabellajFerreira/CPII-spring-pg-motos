package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FabricanteRequest(

        @Size(min = 3, max = 30)
        @NotNull(message = "O nome é obrigatório")
        String nome,
        @NotNull(message = "O nome é obrigatório")
        String nomeFantasia
) {
}
