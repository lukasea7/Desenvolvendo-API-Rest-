package med._con.api.medico;


import jakarta.validation.constraints.NotNull;
import med._con.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
