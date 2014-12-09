/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.sql.SQLException;
import java.util.List;
import model.dao.IDAO;
import model.dao.VeiculoDAOMySQL;
import model.vo.Veiculo;

/**
 *
 * @author Everton Spindola
 */
public class VeiculoBO implements IDAO<Veiculo>{
    IDAO<Veiculo> idao;
    public VeiculoBO() {
        idao = new VeiculoDAOMySQL();
    }

    @Override
    public void adicionar(Veiculo t) throws SQLException {
        if(verificarDados(t))
           idao.adicionar(t);
    }

    @Override
    public void alterar(Veiculo t) throws SQLException {
        if (verificarDados(t))
            idao.alterar(t);
    }

    @Override
    public Veiculo recuperar(Long id) throws SQLException {
        return idao.recuperar(id);
    }

    @Override
    public List<Veiculo> listarTodos() throws SQLException {
       return idao.listarTodos();
    }

    @Override
    public void remover(Veiculo t) throws SQLException {
        idao.remover(t);
    }

    public boolean verificarDados(Veiculo t) {
        return !t.getModelo().isEmpty() && !t.getMarca().isEmpty();
    }
    
    
    
}
