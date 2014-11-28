/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Everton Spindola
 */
public class Conexao {
        public Conexao(String nomeBase, String usuario, String senha) {
        this.nomeBase = nomeBase;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    private Connection conn;
    
    public void abrir() throws SQLException {
        String url = "jdbc:mysql://localhost/"+nomeBase;
        conn = DriverManager.getConnection(url, usuario, senha);
    }
    
    public void fechar() throws SQLException {
        conn.close();
    }
    
    public Connection getConn() {
        return conn;
    }
    
    private String nomeBase;
    private String usuario;
    private String senha;

    /**
     * @return the nomeBase
     */
    public String getNomeBase() {
        return nomeBase;
    }

    /**
     * @param nomeBase the nomeBase to set
     */
    public void setNomeBase(String nomeBase) {
        this.nomeBase = nomeBase;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
