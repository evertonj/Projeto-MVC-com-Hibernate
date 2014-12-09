/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


/**
 *
 * @author Everton Spindola
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Veiculo.finAll", query = "SELECT v FROM Veiculo v")
})
public class Veiculo {

    public Veiculo() {
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_veiculo")
    private Long id;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "anoDeFabricacao")
    private int anoDeFabricacao;
    
    @Column(name = "valor")
    private double valor;
    
    @Column(name = "dataCadastro")
    private Calendar dataCadastro;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private Proprietario proprietario;
    
    @Column(name = "tipoVeiculo")
    private EnumTipoVeiculo tipoVeiculo;

    public Veiculo(Long id, String marca, String modelo, int anoDeFabricacao, double valor, Calendar dataCadastro, Proprietario proprietario, EnumTipoVeiculo tipoVeiculo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.proprietario = proprietario;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Veiculo(String marca, String modelo, int anoDeFabricacao, double valor, Calendar dataCadastro, Proprietario proprietario, EnumTipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.proprietario = proprietario;
        this.tipoVeiculo = tipoVeiculo;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the anoDeFabricacao
     */
    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    /**
     * @param anoDeFabricacao the anoDeFabricacao to set
     */
    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the dataCadastro
     */
    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the proprietario
     */
    public Proprietario getPropriatario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setPropriatario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * @return the tipoVeiculo
     */
    public EnumTipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    /**
     * @param tipoVeiculo the tipoVeiculo to set
     */
    public void setTipoVeiculo(EnumTipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    
    
}
