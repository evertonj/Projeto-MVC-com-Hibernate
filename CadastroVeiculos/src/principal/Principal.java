/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ProprietarioDAOMySQL;
import model.vo.Endereco;
import model.vo.Proprietario;

/**
 *
 * @author Everton Spindola
 */
public class Principal {
    public static void main(String[] args) {
        ProprietarioDAOMySQL dao = new ProprietarioDAOMySQL();
        Proprietario prop = new Proprietario("Everton", "8428-7330", "05902761905", 
                "evertonspindola@gmail.com");
        Endereco end = new Endereco("88512180", "Jorge Neves Vieira", "93", "Santo Antonio", "SC", "Lages");
        prop.setEndereco(end);
        dao.adicionar(prop);
    }
}
