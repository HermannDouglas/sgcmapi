package br.ufac.sgcmapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String nomeUsuario;

    @Column(nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    private String senha;

    @Column(nullable = false)
    private boolean ativo = true;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EPapel papel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    // public void setSenha(String senha) {
    //     this.senha = senha;
    // }

    public void setSenha(String senha) {
        setSenha(senha, true);
    }

    public void setSenha(String senha, boolean encriptar) {
        if (senha != null && encriptar) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            senha = passwordEncoder.encode(senha);
        }
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public EPapel getPapel() {
        return papel;
    }
    
    public void setPapel(EPapel papel) {
        this.papel = papel;
    }
    
}
