package br.com.lukasprojetos.med.ru.api.domain.pacientes;

import br.com.lukasprojetos.med.ru.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
