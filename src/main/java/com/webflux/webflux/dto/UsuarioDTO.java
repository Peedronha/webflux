package com.webflux.webflux.dto;


import com.webflux.webflux.entity.UsuarioEntity;

import java.time.LocalDate;

public class UsuarioDTO {

    private Long id;

    private String nome;

    private String sobreNome;

    private LocalDate dataNascimento;

    private String cpf;

    private String email;

    public UsuarioDTO(UsuarioEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getName();
        this.sobreNome = entity.getLastName();
        this.dataNascimento = entity.getBirthDate();
        this.cpf = entity.getCpf();
        this.email = entity.getCpf();
    }

    public UsuarioDTO() {
    }

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

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
