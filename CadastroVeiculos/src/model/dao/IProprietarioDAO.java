/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import model.vo.Endereco;
import model.vo.Proprietario;

/**
 *
 * @author Everton Spindola
 */
public interface IProprietarioDAO {
    public void adicionar(Proprietario p, Endereco e) throws SQLException;
    public void alterar(Proprietario p, Endereco e) throws SQLException;
    public Proprietario recuperar(int id)throws SQLException;
    public List<Proprietario> listarTodos()throws SQLException;
    public void remover(Proprietario p)throws SQLException;
}
