package med._con.api.controller;

import jakarta.validation.Valid;
import med._con.api.domain.usuario.DadosAutenticacao;
import med._con.api.domain.usuario.Usuario;
import med._con.api.infra.security.TokenService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLoging(@RequestBody @Valid DadosAutenticacao dados){

      var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
      var  authentication =  manager.authenticate(token);

      return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));

    }
}
