package br.com.lukasprojetos.med.ru.api.domain.usuario;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;


@Table(name = "usuarios")
@Entity(name = "Usuarios")
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String sennha;


    public Usuario(Long id, String login, String sennha) {
        this.id = id;
        this.login = login;
        this.sennha = sennha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSennha() {
        return sennha;
    }

    public void setSennha(String sennha) {
        this.sennha = sennha;
    }
}
