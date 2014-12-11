/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controller.Controller;
import static java.awt.Frame.MAXIMIZED_BOTH;
import view.principal.FrmPrincipal;

/**
 *
 * @author Everton Spindola
 */
public class Principal {

    public static void main(String[] args) {
        
        
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        new Controller(frmPrincipal);
        frmPrincipal.setExtendedState(MAXIMIZED_BOTH);
        frmPrincipal.setLocationRelativeTo(null);
        frmPrincipal.setVisible(true);
        
        
    }
}
