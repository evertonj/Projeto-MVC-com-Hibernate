/*
 * AbastecimentoColumnModel.java
 *
 * Created on 29 de Novembro de 2006, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package view.table;

import java.awt.FontMetrics;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author aalano
 */
public class ProprietarioColumnModel extends DefaultTableColumnModel{
    private TableColumn criaColuna(int columnIndex, int largura,
            FontMetrics fm, boolean resizeable, String titulo) {
        int larguraTitulo = fm.stringWidth(titulo + " ");
        if (largura < larguraTitulo)
            largura = larguraTitulo;
        TableColumn col = new TableColumn(columnIndex);
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);
        if (!resizeable) {
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        col.setResizable(resizeable);
        return col;
    }
    /** Creates a new instance of TarefasColumnModel */
    public ProprietarioColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 10 * digito, fm, false, "Código"));
        addColumn(criaColuna(1, 15 * letra, fm, false, "Nome"));
        addColumn(criaColuna(2, 14 * letra, fm, false, "Fone"));
        addColumn(criaColuna(3, 14 * letra, fm, false, "CPF"));
        addColumn(criaColuna(4, 20 * letra, fm, false, "Email"));
        addColumn(criaColuna(5, 20 * digito, fm, false, "Rua"));
        addColumn(criaColuna(6, 10 * digito, fm, false, "Número"));
        addColumn(criaColuna(7, 15 * digito, fm, false, "Bairro"));
        addColumn(criaColuna(8, 11 * digito, fm, false, "CEP"));
        addColumn(criaColuna(9, 15 * digito, fm, false, "Cidade"));
        addColumn(criaColuna(10, 3* digito, fm, false, "Estado"));
        
    } 
}
