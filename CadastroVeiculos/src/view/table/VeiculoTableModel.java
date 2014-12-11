/*
 * AbastecimentoTableModel.java
 *
 * Created on 29 de Novembro de 2006, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package view.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.vo.Veiculo;

/**
 *
 * @author aalano
 *
 * Esta classe permite a exibição dos dados de uma List<Aluno>
 * em um JTable.
 */
public class VeiculoTableModel extends AbstractTableModel {

    private List<Veiculo> veiculos;
    //private List<Setor> setoresFiltrados;
    private boolean ordenarPorNome = true;

    /**
     * Creates a new instance of TarefasTableModel
     *
     * @param veiculo
     */
    public VeiculoTableModel(List<Veiculo> veiculo) {
        this.veiculos = veiculo;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = veiculos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return veiculo.getId();
            case 1:
                return veiculo.getTipoVeiculo();
            case 2:
                  return veiculo.getMarca();
            case 3:
                return veiculo.getModelo();
            case 4:
                return veiculo.getAnoDeFabricacao();
            case 5:
                return veiculo.getValor();
            case 6:
                return veiculo.getPropriatario();
            case 7:
                return veiculo.getDataCadastro();
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return veiculos.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    public Veiculo getValoresVeiculo(int rowIndex) {
        return veiculos.get(rowIndex);
    }

    public boolean isOrdenarPorNome() {
        return ordenarPorNome;
    }

    public void setOrdenarPorNome(boolean ordenarPorNome) {
        this.ordenarPorNome = ordenarPorNome;
    }
}
