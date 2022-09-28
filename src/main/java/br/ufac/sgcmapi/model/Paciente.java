package br.ufac.sgcmapi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    private String email;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private Date dataNascimento;
    
    @Enumerated(EnumType.STRING)
    private EGrupoSanguineo grupoSanguineo;
    
    @Column(nullable = false)
    private ESexo sexo;
    
    private String cep;
    
    private String endereco;
    
    private String cidade;
    
    private String estado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public EGrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }
    public void setGrupoSanguineo(EGrupoSanguineo grupoSaguineo) {
        this.grupoSanguineo = grupoSaguineo;
    }
    public ESexo getSexo() {
        return sexo;
    }
    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
