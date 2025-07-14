package med._con.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med._con.api.domain.consulta.DadosAgendamentoConsulta;
import med._con.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){

     return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));


    }
}
