package br.com.lukasprojetos.med.ru.api.controller;


import br.com.lukasprojetos.med.ru.api.medico.DadosCadastroMedico;
import br.com.lukasprojetos.med.ru.api.medico.DadosListagemMedico;
import br.com.lukasprojetos.med.ru.api.medico.Medico;
import br.com.lukasprojetos.med.ru.api.medico.MedicoReposritory;
import br.com.lukasprojetos.med.ru.api.medicos.DadosAtualizarMecisos;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("medicos")
public class MedicoControler {
    @Autowired
    private MedicoReposritory reposritory;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        reposritory.save(new Medico(dados));

    }
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
       return reposritory.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMecisos dados ){
        var medico  = reposritory.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);


    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = reposritory.getReferenceById(id);
        medico.excluir();


    }

}
