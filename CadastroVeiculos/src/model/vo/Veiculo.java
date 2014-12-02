/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Everton Spindola
 */
@Entity
public class Veiculo {

    public Veiculo() {
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id_veiculo")
    private int id;
    
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
    
    @OneToOne
    @JoinColumn(name = "veiculo_proprietario")
    private Proprietario propriatario;
    
    @Column(name = "tipoVeiculo")
    private EnumTipoVeiculo tipoVeiculo;

    public Veiculo(int id, String marca, String modelo, int anoDeFabricacao, double valor, Calendar dataCadastro, Proprietario propriatario, EnumTipoVeiculo tipoVeiculo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.propriatario = propriatario;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Veiculo(String marca, String modelo, int anoDeFabricacao, double valor, Calendar dataCadastro, Proprietario propriatario, EnumTipoVeiculo tipoVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.propriatario = propriatario;
        this.tipoVeiculo = tipoVeiculo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the propriatario
     */
    public Proprietario getPropriatario() {
        return propriatario;
    }

    /**
     * @param propriatario the propriatario to set
     */
    public void setPropriatario(Proprietario propriatario) {
        this.propriatario = propriatario;
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
