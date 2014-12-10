/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.sql.SQLException;
import java.util.List;
import model.dao.IDAO;
import model.dao.ProprietarioDAOMySQL;
import model.vo.Proprietario;

/**
 *
 * @author Everton Spindola
 */
public class ProprietarioBO {
    
    IDAO<Proprietario> idao;
    public ProprietarioBO() {
        idao = new ProprietarioDAOMySQL();
    }
    
    public void adicionar(Proprietario prop) throws SQLException {
        if(verificarDados(prop))
           idao.adicionar(prop);
    }
    
    public Proprietario recuperar(Long idProp) throws SQLException {
        return idao.recuperar(idProp);
    }
    
    public void alterar(Proprietario prop) throws SQLException {
        if(verificarDados(prop))
            idao.alterar(prop);
    }
    
    public boolean verificarDados(Proprietario prop) {
        return !prop.getNome().isEmpty() && !prop.getCpf().isEmpty();
    }
    
    public List<Proprietario> listarParaTabela() throws SQLException {
        IDAO<Proprietario> iPropDAO = new ProprietarioDAOMySQL();
        return iPropDAO.listarTodos();
    }
    
     
    public void remover(Proprietario prop) throws SQLException {
        idao.remover(prop);
    }
}
