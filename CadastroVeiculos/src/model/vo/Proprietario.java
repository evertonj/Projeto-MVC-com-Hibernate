/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Everton Spindola
 */
@Entity
@Table (name = "propritario")
public class Proprietario {
    private int id;
    private String nome;
    private String fone;
    private String cpf;
    private String email;
    private Endereco endereco;

    public Proprietario(int id, String nome, String fone, String cpf, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public Proprietario(String nome, String fone, String cpf, String email, Endereco endereco) {
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
