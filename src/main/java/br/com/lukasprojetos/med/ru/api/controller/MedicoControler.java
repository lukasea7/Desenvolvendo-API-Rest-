package br.com.lukasprojetos.med.ru.api.controller;


import br.com.lukasprojetos.med.ru.api.medico.DadosCadastroMedico;
import br.com.lukasprojetos.med.ru.api.medico.DadosListagemMedico;
import br.com.lukasprojetos.med.ru.api.medico.Medico;
import br.com.lukasprojetos.med.ru.api.medico.MedicoReposritory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
       return reposritory.findAll(paginacao).map(DadosListagemMedico::new);
    }

}
