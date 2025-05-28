package br.com.lukasprojetos.med.ru.api.medico;

import br.com.lukasprojetos.med.ru.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email,
                                  String crm, Especialidade especialidade,
                                  DadosEndereco endereco) {
}
