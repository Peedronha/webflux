package com.webflux.webflux.entity;

import com.webflux.webflux.dto.UsuarioDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "USUARIO", schema = "public")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq_generator")
    @SequenceGenerator(name = "usuario_seq_generator", sequenceName = "USUARIO_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    @Column(name = "sobre_nome")
    private String lastName;

    @Column(name= "data_nascimento")
    private LocalDate birthDate;

    @Column(length = 11)
    private String cpf;

    private String email;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nome, String sobreNome, LocalDate dataNascimento, String cpf, String email) {
        this.id = id;
        this.name = nome;
        this.lastName = sobreNome;
        this.birthDate = dataNascimento;
        this.cpf = cpf;
        this.email = email;
    }

    public UsuarioEntity(UsuarioDTO dto) {
        this.id = dto.getId();
        this.name = dto.getNome();
        this.lastName = dto.getSobreNome();
        this.birthDate = dto.getDataNascimento();
        this.cpf = dto.getCpf();
        this.email = dto.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
