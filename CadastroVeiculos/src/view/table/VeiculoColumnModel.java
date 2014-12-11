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
public class VeiculoColumnModel extends DefaultTableColumnModel{
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
    public VeiculoColumnModel(FontMetrics fm) {
        int digito = fm.stringWidth("0");
        int letra = fm.stringWidth("M");
        addColumn(criaColuna(0, 10 * digito, fm, false, "Código"));
        addColumn(criaColuna(1, 12 * letra, fm, false, "Tipo"));
        addColumn(criaColuna(2, 9 * letra, fm, false, "Marca"));
        addColumn(criaColuna(3, 14 * letra, fm, false, "Modelo"));
        addColumn(criaColuna(4, 5 * letra, fm, false, "Ano"));
        addColumn(criaColuna(5, 12 * letra, fm, true, "Valor"));
        addColumn(criaColuna(6, 30 * letra, fm, true, "Proprietário"));
        addColumn(criaColuna(7, 12 * letra, fm, true, "Data Cadastro"));
    } 
}
