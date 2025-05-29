package br.com.lukasprojetos.med.ru.api.controller;


import br.com.lukasprojetos.med.ru.api.medico.DadosCadastroMedico;
import br.com.lukasprojetos.med.ru.api.medico.Medico;
import br.com.lukasprojetos.med.ru.api.medico.MedicoReposritory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoControler {
    @Autowired
    private MedicoReposritory reposritory;



    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        reposritory.save(new Medico(dados));


    }
}
