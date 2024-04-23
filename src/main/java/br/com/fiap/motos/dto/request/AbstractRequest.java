package br.com.fiap.motos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AbstractRequest(

        @Positive(message = "Id deve ser um número positivo")
        @NotNull(message = "O id é campo obrigatório")
        Long id
) {
}
