/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author Everton Spindola
 */

//@Entity
public class Endereco {

    public Endereco() {
    }
    
   
//    @Id
//    @GeneratedValue
//    @Column(name = "id_endereco")
//    private Long id;
    
 //   @Column(name = "cep")
    private String cep;
    
 //   @Column(name = "logradouro")
    private String logradouro;
    
 //   @Column(name = "numero")
    private String numero;
    
 //   @Column(name = "bairro")
    private String bairro;
    
//    @Column(name = "estado")
    private String estado;
    
 //   @Column(name = "cidade")
    private String cidade;

    public Endereco(String cep, String logradouro, String numero, String bairro, String estado, String cidade) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
    }

    

    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    

  
    
    
}
