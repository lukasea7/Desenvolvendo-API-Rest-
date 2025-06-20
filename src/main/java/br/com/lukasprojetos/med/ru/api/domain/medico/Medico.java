package br.com.lukasprojetos.med.ru.api.domain.medico;

import br.com.lukasprojetos.med.ru.api.domain.endereco.Endereco;
import br.com.lukasprojetos.med.ru.api.domain.medicos.DadosAtualizarMecisos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter

@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(){

    }

    public Medico(DadosCadastroMedico dados) {
        this.ativo =true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizarInformacoes(DadosAtualizarMecisos dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInderecoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
