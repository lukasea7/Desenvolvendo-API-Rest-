package br.com.lukasprojetos.med.ru.api.domain.medico;

import br.com.lukasprojetos.med.ru.api.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome,
                                      String email, String crm,String telefone,
                                      Especialidade especialidade,
                                      Endereco endereco ) {

 public DadosDetalhamentoMedico(Medico medico){

     this(medico.getId(),
             medico.getNome(),
             medico.getEmail(),
             medico.getCrm(),
             medico.getTelefone(),
             medico.getEspecialidade(),
             medico.getEndereco());

 }

}
