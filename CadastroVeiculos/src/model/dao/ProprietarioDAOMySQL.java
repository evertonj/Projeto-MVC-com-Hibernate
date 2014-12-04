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
import model.vo.Proprietario;

/**
 *
 * @author Everton Spindola
 */
public class ProprietarioDAOMySQL implements IDAO<Proprietario>{
    
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("veiculosapp");
      EntityManager manager = factory.createEntityManager();
    
    @Override
    public void adicionar(Proprietario t) {
        manager.getTransaction().begin();
        manager.persist(t);
        manager.getTransaction().commit();
    }

    

    @Override
    public Proprietario recuperar(Long id) {
        return manager.find(Proprietario.class, id);
    }

    @Override
    public List<Proprietario> listarTodos() {
        Query query = manager.createNamedQuery("Proprietario.findAll");
        return query.getResultList();
    }

    

//    @Override
//    public void adicionar(Proprietario p, Endereco e) throws SQLException {
//        manager.getTransaction().begin();
//        manager.persist(p);
//        manager.persist(e);
//        manager.getTransaction().commit();
//        manager.close();
//        factory.close();
//    }
//
//    @Override
//    public void alterar(Proprietario p, Endereco e) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    

    @Override
    public void alterar(Proprietario t) throws SQLException {
        manager.getTransaction().begin();
        manager.merge(t);
        manager.getTransaction().commit();
    }

    @Override
    public void remover(Proprietario t) throws SQLException {
        manager.getTransaction().begin();
        manager.remove(t);
        manager.getTransaction().commit();
    }
}
