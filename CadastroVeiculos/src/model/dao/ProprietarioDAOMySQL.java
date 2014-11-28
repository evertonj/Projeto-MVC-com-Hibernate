/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.vo.Proprietario;

/**
 *
 * @author Everton Spindola
 */
public class ProprietarioDAOMySQL implements IDAO<Proprietario>{
    
    @Override
    public void adicionar(Proprietario t) {
        
    }

    @Override
    public void alterar(Proprietario t) {
    }

    @Override
    public Proprietario recuperar(int id) {
        return null;
    }

    @Override
    public List<Proprietario> listarTodos() {
        return null;
    }

    @Override
    public void remover(Proprietario t) {
    }
    
}
