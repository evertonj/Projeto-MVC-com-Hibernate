/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Everton Spindola
 * @param <T>
 */
public interface IDAO<T> {
    public void adicionar(T t) throws SQLException;
    public void alterar(T t)throws SQLException;
    public T recuperar(int id)throws SQLException;
    public List<T> listarTodos()throws SQLException;
    public void remover(T t)throws SQLException;
}
