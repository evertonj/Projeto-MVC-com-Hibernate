/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.bo.ProprietarioBO;
import model.bo.VeiculoBO;
import model.vo.Endereco;
import model.vo.EnumTipoVeiculo;
import model.vo.Proprietario;
import model.vo.Veiculo;
import verificacao.Redimensionar;
import verificacao.SomenteNumero;
import view.principal.FrmPrincipal;
import view.proprietario.DlgCadastroProprietarios;
import view.table.ProprietarioColumnModel;
import view.table.ProprietarioTableModel;
import view.table.VeiculoColumnModel;
import view.table.VeiculoTableModel;
import view.veiculo.DlgCadastroVeiculo;
import webService.WebServiceCep;

/**
 *
 * @author aalano
 */
public class Controller implements ActionListener, FocusListener{

    private FrmPrincipal frmPrincipal;
    private DlgCadastroProprietarios cdProp;
    private DlgCadastroVeiculo cdVeiculo;
    private Proprietario prop;
    private Veiculo veiculo;
    

    public Controller(FrmPrincipal frmPrincipal) {
        this.frmPrincipal = frmPrincipal;
        this.cdProp = new DlgCadastroProprietarios(frmPrincipal, true);
        this.cdVeiculo = new DlgCadastroVeiculo(frmPrincipal, true);
        this.frmPrincipal.getCdProp().addActionListener(this);
        this.frmPrincipal.getCdVeiculo().addActionListener(this);
        this.frmPrincipal.getSair().addActionListener(this);
        this.cdProp.getBtSalvar().addActionListener(this);
        this.cdProp.getBtAtualizar().addActionListener(this);
        this.cdProp.getBtCancelar().addActionListener(this);
        this.cdProp.getBtFechar().addActionListener(this);
        this.cdProp.getBtExcluir().addActionListener(this);
        this.cdProp.getBtNovo().addActionListener(this);
        this.cdProp.getBtPesquisar().addActionListener(this);
        this.cdProp.getBtPesquisarCEP().addActionListener(this);
        this.cdProp.getTfId().addFocusListener(this);
        this.cdVeiculo.getBtAtualizar().addActionListener(this);
        this.cdVeiculo.getBtCancelar().addActionListener(this);
        this.cdVeiculo.getBtExcluir().addActionListener(this);
        this.cdVeiculo.getBtNovo().addActionListener(this);
        this.cdVeiculo.getBtPesquisar().addActionListener(this);
        this.cdVeiculo.getBtSalvar().addActionListener(this);
        this.cdVeiculo.getTfID().addFocusListener(this);
        this.cdVeiculo.getBtFechar().addActionListener(this);
        this.configurarTabelaProp();
        this.configurarTabelaVeic();
        this.carregarDadosTipoEdeVeiculo();
        this.cdProp.getTfCPF().setDocument(new SomenteNumero());
        this.cdProp.getTfTelefone().setDocument(new SomenteNumero());
        this.cdProp.getTfNumero().setDocument(new SomenteNumero());
        this.cdProp.getTfCEP().setDocument(new SomenteNumero());
        this.cdVeiculo.getTfValor().setDocument(new SomenteNumero());
        ImageIcon icone = criarImageIcon("/img/ferrari.jpg", "");
        this.frmPrincipal.getLbLogo().setIcon(icone);
        this.cdVeiculo.getTfDataCadastro().setText(
                new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmPrincipal.getCdProp()) {
            this.cdProp.setSize(Redimensionar.redimensionarTela());
            this.cdProp.setLocationRelativeTo(null);
            this.cdProp.setVisible(true);
        }
        
        if (e.getSource() == this.frmPrincipal.getCdVeiculo()) {
            this.cdVeiculo.setSize(Redimensionar.redimensionarTela());
            this.cdVeiculo.setLocationRelativeTo(null);
            this.cdVeiculo.setVisible(true);
        }
        if (e.getSource() == this.frmPrincipal.getSair()) {
            System.exit(0);
        }

        if (e.getSource() == this.cdProp.getBtSalvar()) {
            carregarDadosAddProp();
            ProprietarioBO propBO = new ProprietarioBO();
            try {
                propBO.adicionar(this.prop);
                JOptionPane.showMessageDialog(cdProp, "Proprietário cadastrado com sucesso!");
                limparCamposProp();
                cdProp.getBtSalvar().setEnabled(false);
                //    this.cdProp.dispose();
                prop = null;
                configurarTabelaProp();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         if (e.getSource() == this.cdVeiculo.getBtSalvar()) {
             carregarDadosAddVeic();
            VeiculoBO veiculoBO = new VeiculoBO();
            try {
                veiculoBO.adicionar(this.veiculo);
                JOptionPane.showMessageDialog(cdVeiculo, "Veículo cadastrado com sucesso!");
                limparCamposVeic();
                cdVeiculo.getBtSalvar().setEnabled(false);
                //    this.cdProp.dispose();
                veiculo = null;
                configurarTabelaVeic();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (e.getSource() == this.cdProp.getBtPesquisar()) {
            Long idProp = Long.valueOf(cdProp.getTfId().getText());
            try {
                this.prop = new ProprietarioBO().recuperar(idProp);
                if (prop != null) {
                    setarDadosProp();
                    cdProp.getTfId().setEnabled(false);
                    cdProp.getBtSalvar().setEnabled(false);
                    return;
                }
                JOptionPane.showMessageDialog(cdProp, "Proprietário não encontrado tente outro código!");
            } catch (NullPointerException | SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

         if (e.getSource() == this.cdVeiculo.getBtPesquisar()) {
            Long idVeiculo = Long.valueOf(cdVeiculo.getTfID().getText());
            try {
                this.veiculo = new VeiculoBO().recuperar(idVeiculo);
                if (veiculo != null) {
                    setarDadosVeic();
                    cdVeiculo.getTfID().setEnabled(false);
                    cdVeiculo.getBtSalvar().setEnabled(false);
                    return;
                }
                JOptionPane.showMessageDialog(cdVeiculo, "Veículo não encontrado tente outro código!");
            } catch (NullPointerException | SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == this.cdProp.getBtAtualizar()) {
            carregarDadosAlterarProp();
            try {
                new ProprietarioBO().alterar(prop);
                limparCamposProp();
                JOptionPane.showMessageDialog(cdProp, "Dados alterados com sucesso!!!");
                cdProp.getTfId().setEnabled(true);
                configurarTabelaProp();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.cdProp.getBtFechar()) {
            carregarDadosTipoEdeVeiculo();
            cdProp.dispose();
        }

        if (e.getSource() == this.cdVeiculo.getBtAtualizar()) {
            carregarDadosAlterarVeic();
            try {
                new VeiculoBO().alterar(veiculo);
                limparCamposVeic();
                JOptionPane.showMessageDialog(cdProp, "Dados alterados com sucesso!!!");
                cdVeiculo.getTfID().setEnabled(true);
                configurarTabelaVeic();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        
        if (e.getSource() == this.cdProp.getBtFechar()) {
            limparCamposProp();
            cdProp.dispose();
        }
        
        if (e.getSource() == this.cdVeiculo.getBtFechar()) {
            limparCamposVeic();
            cdVeiculo.dispose();
        }
        
        if (e.getSource() == this.cdProp.getBtExcluir()) {
            try {
                new ProprietarioBO().remover(prop);
                limparCamposProp();
                JOptionPane.showMessageDialog(cdProp, "Removido com sucesso!");
                cdProp.getTfId().setEnabled(true);
                configurarTabelaProp();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == this.cdVeiculo.getBtExcluir()) {
            try {
                new VeiculoBO().remover(veiculo);
                limparCamposVeic();
                JOptionPane.showMessageDialog(cdVeiculo, "Removido com sucesso!");
                cdVeiculo.getTfID().setEnabled(true);
                configurarTabelaVeic();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == this.cdProp.getBtCancelar()) {
            limparCamposProp();
            cdProp.getTfId().setEnabled(true);
        }

         if (e.getSource() == this.cdVeiculo.getBtCancelar()) {
            limparCamposVeic();
            cdVeiculo.getTfID().setEnabled(true);
        }
         
         if (e.getSource() == cdProp.getBtNovo()) {
            limparCamposProp();
            cdProp.getBtSalvar().setEnabled(true);
            cdProp.getTfId().setEnabled(true);
        }
         
         if (e.getSource() == cdVeiculo.getBtNovo()) {
            limparCamposVeic();
            cdVeiculo.getBtSalvar().setEnabled(true);
            cdVeiculo.getTfID().setEnabled(true);
        }
        
        if (e.getSource() == this.cdProp.getBtPesquisarCEP()) {
            String cep = cdProp.getTfCEP().getText();
            if (cep.length() == 8) {
                if (!carregarEnderecoWebService(cep)) {
                    JOptionPane.showMessageDialog(cdProp, "Endereço não encontrado. Ou sem conexão com a internet!");
                }
                return;
            }
            if (cep.length() > 8) {
                cdProp.getTfCEP().setText(cep.substring(0, 7));
                if (!carregarEnderecoWebService(cep)) {
                    JOptionPane.showMessageDialog(cdProp, "Endereço não encontrado. Ou sem conexão com a internet!");
                }
                return;
            }
            if (cep.length() != 8) {
                JOptionPane.showMessageDialog(cdProp, "O CEP deve conter 8 números.");
            }
        }

        
    }

    private void carregarDadosAddProp() {
        this.prop = new Proprietario(cdProp.getTfNome().getText(),
                cdProp.getTfTelefone().getText(),
                cdProp.getTfCPF().getText(),
                cdProp.getTfEmail().getText()
        );
        prop.setEndereco(new Endereco(cdProp.getTfCEP().getText(),
                cdProp.getTfLogradouro().getText(),
                cdProp.getTfNumero().getText(),
                cdProp.getTfBairro().getText(),
                cdProp.getTfEstado().getText(),
                cdProp.getTfCidade().getText()));
    }

    private void carregarDadosAlterarProp() {
        this.prop = new Proprietario(
                Long.valueOf(cdProp.getTfId().getText()),
                cdProp.getTfNome().getText(),
                cdProp.getTfTelefone().getText(),
                cdProp.getTfCPF().getText(),
                cdProp.getTfEmail().getText()
        );
        prop.setEndereco(new Endereco(cdProp.getTfCEP().getText(),
                cdProp.getTfLogradouro().getText(),
                cdProp.getTfNumero().getText(),
                cdProp.getTfBairro().getText(),
                cdProp.getTfEstado().getText(),
                cdProp.getTfCidade().getText()));
    }

    private void setarDadosProp() {
        cdProp.getTfId().setText(String.valueOf(prop.getId()));
        cdProp.getTfNome().setText(prop.getNome());
        cdProp.getTfTelefone().setText(prop.getFone());
        cdProp.getTfCPF().setText(prop.getCpf());
        cdProp.getTfEmail().setText(prop.getEmail());
        cdProp.getTfBairro().setText(prop.getEndereco().getBairro());
        cdProp.getTfCEP().setText(prop.getEndereco().getCep());
        cdProp.getTfCidade().setText(prop.getEndereco().getCidade());
        cdProp.getTfNumero().setText(prop.getEndereco().getNumero());
        cdProp.getTfEstado().setText(prop.getEndereco().getEstado());
        cdProp.getTfLogradouro().setText(prop.getEndereco().getLogradouro());

    }

    public void limparCamposProp() {
        cdProp.getTfBairro().setText(null);
        cdProp.getTfCEP().setText(null);
        cdProp.getTfCPF().setText(null);
        cdProp.getTfCidade().setText(null);
        cdProp.getTfEmail().setText(null);
        cdProp.getTfEstado().setText(null);
        cdProp.getTfId().setText(null);
        cdProp.getTfLogradouro().setText(null);
        cdProp.getTfNome().setText(null);
        cdProp.getTfNumero().setText(null);
        cdProp.getTfTelefone().setText(null);
        cdProp.getBtSalvar().setEnabled(true);

    }

    private void limparCamposVeic(){
        cdVeiculo.getTfDataCadastro().setText(null);
        cdVeiculo.getTfID().setText(null);
        cdVeiculo.getTfMarca().setText(null);
        cdVeiculo.getTfModelo().setText(null);
        cdVeiculo.getTfValor().setText(null);
        cdVeiculo.getSpAno().setValue(0);
        cdVeiculo.getCbProprietario().setSelectedIndex(-1);
        cdVeiculo.getCbTipo().setSelectedIndex(-1);
        cdVeiculo.getBtSalvar().setEnabled(true);
    }
    
    private boolean carregarEnderecoWebService(String cep) {
        WebServiceCep enderecoEncontrado = WebServiceCep.searchCep(cep);
        if (enderecoEncontrado.wasSuccessful()) {
            cdProp.getTfLogradouro().setText(enderecoEncontrado.getLogradouro());
            cdProp.getTfBairro().setText(enderecoEncontrado.getBairro());
            cdProp.getTfCidade().setText(enderecoEncontrado.getCidade());
            cdProp.getTfEstado().setText(enderecoEncontrado.getUf());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == cdProp.getTfId()) {
            cdProp.getTfId().setDocument(new SomenteNumero());
        }
        
        
        if (e.getSource() == cdVeiculo.getTfID()) {
            cdVeiculo.getTfID().setDocument(new SomenteNumero());
            carregarDadosTipoEdeVeiculo();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }

    private void carregarDadosAddVeic() {
        this.veiculo = new Veiculo(cdVeiculo.getTfMarca().getText(),
                cdVeiculo.getTfModelo().getText(),
                Integer.valueOf(cdVeiculo.getSpAno().getValue().toString()),
                Double.valueOf(cdVeiculo.getTfValor().getText()),
                Calendar.getInstance(),
                (Proprietario) cdVeiculo.getCbProprietario().getSelectedItem(),
                (EnumTipoVeiculo) cdVeiculo.getCbTipo().getSelectedItem()
        );
    }

    private void carregarDadosAlterarVeic() {
        this.veiculo = new Veiculo(
                Long.valueOf(cdVeiculo.getTfID().getText()),
                cdVeiculo.getTfMarca().getText(),
                cdVeiculo.getTfModelo().getText(),
                Integer.valueOf(cdVeiculo.getSpAno().getValue().toString()),
                Double.valueOf(cdVeiculo.getTfValor().getText()),
                Calendar.getInstance(),
                (Proprietario) cdVeiculo.getCbProprietario().getSelectedItem(),
                (EnumTipoVeiculo) cdVeiculo.getCbTipo().getSelectedItem()
        );
    }

    private void setarDadosVeic(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cdVeiculo.getTfID().setText(String.valueOf(veiculo.getId()));
        cdVeiculo.getTfMarca().setText(veiculo.getMarca());
        cdVeiculo.getTfModelo().setText(veiculo.getModelo());
        cdVeiculo.getTfValor().setText(String.valueOf(veiculo.getValor()));
        cdVeiculo.getTfDataCadastro().setText(new SimpleDateFormat("dd/MM/yyyy").format(veiculo.getDataCadastro().getTime()));
        cdVeiculo.getSpAno().setValue(veiculo.getAnoDeFabricacao());
        cdVeiculo.getCbProprietario().setSelectedItem(veiculo.getPropriatario());
        cdVeiculo.getCbTipo().setSelectedItem(veiculo.getTipoVeiculo());
    }

    private void carregarDadosTipoEdeVeiculo(){
            cdVeiculo.getCbTipo().setModel(new DefaultComboBoxModel<>(EnumTipoVeiculo.values()));
            cdVeiculo.getCbTipo().setSelectedIndex(-1);
        List<Proprietario> lista = null;
            try {
                lista = new ProprietarioBO().listarParaTabela();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            cdVeiculo.getCbProprietario().setModel(new DefaultComboBoxModel(lista.toArray()));
            cdVeiculo.getCbProprietario().setSelectedIndex(-1);    
            
    }
    
    private void configurarTabelaProp() {
        try {
            this.setListaProprietarios(new ProprietarioBO().listarParaTabela());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        cdProp.getJTabela().setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = cdProp.getJTabela().getFontMetrics(cdProp.getJTabela().getFont());
        cdProp.getJTabela().setColumnModel(new ProprietarioColumnModel(fm));
        cdProp.getJTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void setListaProprietarios(java.util.List<Proprietario> proprietarios) {
        cdProp.getJTabela().setModel(new ProprietarioTableModel(proprietarios));
    }
    
    private void configurarTabelaVeic() {
        try {
            this.setListaVeiculos(new VeiculoBO().listarTodos());
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        cdVeiculo.getJTabela().setAutoCreateColumnsFromModel(false);
        java.awt.FontMetrics fm = cdVeiculo.getJTabela().getFontMetrics(cdProp.getJTabela().getFont());
        cdVeiculo.getJTabela().setColumnModel(new VeiculoColumnModel(fm));
        cdVeiculo.getJTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void setListaVeiculos(java.util.List<Veiculo> veiculos) {
        cdVeiculo.getJTabela().setModel(new VeiculoTableModel(veiculos));
    }
    
    public ImageIcon criarImageIcon(String caminho, String descricao) {
        java.net.URL imgURL = getClass().getResource(caminho);
        if (imgURL != null) {
            return new ImageIcon(imgURL, descricao);
        } else {
            System.err.println("Não foi possível carregar o arquivo de imagem: " + caminho);
            return null;
        }
    }
}
