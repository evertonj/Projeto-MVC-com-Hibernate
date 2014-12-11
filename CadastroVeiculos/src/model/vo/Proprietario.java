/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



/**
 *
 * @author Everton Spindola
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Proprietario.findAll", query = "SELECT p FROM Proprietario p")
})
public class Proprietario {

    @Id
    @GeneratedValue
    @Column(name = "id_proprietario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "fone")
    private String fone;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    public Proprietario() {
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proprietario other = (Proprietario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
   // @OneToOne
   // @JoinColumn(name = "id_endereco")
    @Embedded
    private Endereco endereco;

    public Proprietario(Long id, String nome, String fone, String cpf, String email){
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
        this.email = email;
    }

    public Proprietario(String nome, String fone, String cpf, String email) {
        this.nome = nome;
        this.fone = fone;
        this.cpf = cpf;
        this.email = email;
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
