package br.com.lukasprojetos.med.ru.api.domain.medicos;

import br.com.lukasprojetos.med.ru.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMecisos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
