/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.dao.ProprietarioDAOMySQL;
import model.vo.Endereco;
import model.vo.Proprietario;
import org.junit.Test;

/**
 *
 * @author Everton Spindola
 */
public class TesteProprietario {

    public TesteProprietario() {
    }

    @Test
    public void adicionaProprietario() {
          ProprietarioDAOMySQL dao = new ProprietarioDAOMySQL();
        Proprietario prop = new Proprietario("Everton", "8428-7330", "05902761905", 
                "evertonspindola@gmail.com");
        Endereco end = new Endereco("88512180", "Jorge Neves Vieira", "93", "Santo Antonio", "SC", "Lages");
       prop.setEndereco(end);
        dao.adicionar(prop);
    }
}
