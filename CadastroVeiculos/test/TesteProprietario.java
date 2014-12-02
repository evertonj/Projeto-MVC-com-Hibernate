/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ProprietarioDAOMySQL;
import model.vo.Endereco;
import model.vo.Proprietario;
import org.junit.Test;
import static org.junit.Assert.*;

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
        try {
            dao.adicionar(new Proprietario("Everton", "8428-7330", "05902761905", "evertonspindola@gmail.com")
                    ,new Endereco("88512180", "Jorge Neves Vieira", "93", "Santo Antonio", "SC", "Lages"));
        } catch (SQLException ex) {
            Logger.getLogger(TesteProprietario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
