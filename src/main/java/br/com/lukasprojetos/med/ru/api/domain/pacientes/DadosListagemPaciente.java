package br.com.lukasprojetos.med.ru.api.domain.pacientes;

public record DadosListagemPaciente(Long id , String nome, String email, String cpf) {


    public DadosListagemPaciente(Paciente paciente){

        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }


    }

