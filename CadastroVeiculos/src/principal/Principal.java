/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ProprietarioDAOMySQL;
import model.dao.VeiculoDAOMySQL;
import model.vo.Endereco;
import model.vo.EnumTipoVeiculo;
import model.vo.Proprietario;
import model.vo.Veiculo;

/**
 *
 * @author Everton Spindola
 */
public class Principal {
    public static void main(String[] args) {
          ProprietarioDAOMySQL dao = new ProprietarioDAOMySQL();
          VeiculoDAOMySQL daoVeiculo = new VeiculoDAOMySQL();
        Proprietario prop = new Proprietario("Everton", "8428-7330", "05902761905", 
                "evertonspindola@gmail.com");
        Endereco end = new Endereco("88512180", "Jorge Neves Vieira", "93", "Santo Antonio", "SC", "Lages");
       prop.setEndereco(end);
//        dao.adicionar(prop);
//        
//        Proprietario teste = dao.recuperar(1L);
//        System.out.println("Prop: "+teste.getNome());
//        
//        for (Proprietario arg : dao.listarTodos()) {
//            System.out.println("Rua: "+arg.getEndereco().getLogradouro());
//        }
//        
//        Endereco end1 = new Endereco("88506040", "Vergilio Ramos", "88", "Guadalupe", "SC", "Lages");
//        
//        prop.setEndereco(end1);
//        try {
//            dao.alterar(prop);
//        } catch (SQLException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        try {
//            dao.remover(prop);
//        } catch (SQLException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Proprietario prop1 = dao.recuperar(2L);
        System.out.println("ID Prop: "+ prop1.getId());
        Veiculo veiculo = new Veiculo("Ford", "Escort", 2003, 11.500, Calendar.getInstance(), prop1, EnumTipoVeiculo.Automóvel);
        try {
            daoVeiculo.adicionar(veiculo);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
