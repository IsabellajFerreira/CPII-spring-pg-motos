package br.com.fiap.motos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CaracteristicaRequest(

        @Valid
        @NotNull(message = "O atributo veiculo é obrigatório")
        AbstractRequest veiculo,


        @Size(min = 3, max = 30)
        @NotNull(message = "O nome é obrigatório")
        String nome,

        @Size(min = 3, max = 20)
        @NotNull(message = "A descriçao é obrigatória")
        String descricao


) {
}
