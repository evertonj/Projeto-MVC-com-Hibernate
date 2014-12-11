/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.vo.Veiculo;

/**
 *
 * @author Everton Spindola
 */
public class VeiculoDAOMySQL implements IDAO<Veiculo>{
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("veiculosapp");
    EntityManager manager = factory.createEntityManager();
    @Override
    public void adicionar(Veiculo t) throws SQLException {
        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
    }

    @Override
    public void alterar(Veiculo t) throws SQLException {
        manager.getTransaction().begin();
        manager.merge(t);
        manager.getTransaction().commit();
    }

    @Override
    public Veiculo recuperar(Long id) throws SQLException {
        return manager.find(Veiculo.class, id);
    }

    @Override
    public List<Veiculo> listarTodos() throws SQLException {
        Query query = manager.createNamedQuery("Veiculo.findAll");
        return query.getResultList();
    }

    @Override
    public void remover(Veiculo t) throws SQLException {
        manager.getTransaction().begin();
        manager.remove(manager.getReference(Veiculo.class, t.getId()));
        manager.getTransaction().commit();
    }
    
}
