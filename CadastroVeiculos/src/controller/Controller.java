/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bo.ProprietarioBO;
import model.vo.Endereco;
import model.vo.Proprietario;
import model.vo.Veiculo;
import view.principal.FrmPrincipal;
import view.proprietario.DlgCadastroProprietarios;
import view.veiculo.DlgCadastroVeiculo;

/**
 *
 * @author aalano
 */
public class Controller implements ActionListener, KeyListener {

    private FrmPrincipal frmPrincipal;
    private DlgCadastroProprietarios cdProp;
    private DlgCadastroVeiculo cdVeiculo;
    private Proprietario prop;
    private Veiculo veiculo;
    private Endereco endereco;

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
        this.cdProp.getTfCEP().addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmPrincipal.getCdProp()) {
            this.cdProp.setVisible(true);
        }
        if (e.getSource() == this.frmPrincipal.getSair()) {
            System.exit(0);
        }

        if (e.getSource() == this.cdProp.getBtSalvar()) {
            System.out.println("Passou!!!");
            carregarDadosAddProp();
            ProprietarioBO propBO = new ProprietarioBO();
            try {
                propBO.adicionar(this.prop);
                JOptionPane.showMessageDialog(cdProp, "Proprietário cadastrado com sucesso!");
                limparCampos();
                this.cdProp.dispose();
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
                    return;
                }
                JOptionPane.showMessageDialog(cdProp, "Proprietário não encontrado tente outro código!");
            } catch (NullPointerException | SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == this.cdProp.getBtAtualizar()) {
            carregarDadosAlterarProp();
            try {
                new ProprietarioBO().alterar(prop);
                limparCampos();
                JOptionPane.showMessageDialog(cdProp, "Dados alterados com sucesso!!!");
                cdProp.getTfId().setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.cdProp.getBtFechar()) {
            cdProp.dispose();
        }

        if (e.getSource() == this.cdProp.getBtExcluir()) {
            try {
                new ProprietarioBO().remover(prop);
                limparCampos();
                JOptionPane.showMessageDialog(cdProp, "Removido com sucesso!");
                cdProp.getTfId().setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource() == this.cdProp.getBtCancelar()){
            limparCampos();
            cdProp.getTfId().setEnabled(true);
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
        cdProp.getTfBairro().setText(prop.getEndereco().getBairro());
        cdProp.getTfCEP().setText(prop.getEndereco().getCep());
        cdProp.getTfCidade().setText(prop.getEndereco().getCidade());
        cdProp.getTfNumero().setText(prop.getEndereco().getNumero());
        cdProp.getTfEstado().setText(prop.getEndereco().getEstado());
        cdProp.getTfLogradouro().setText(prop.getEndereco().getLogradouro());

    }

    public void limparCampos() {
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

    }

    @Override
    public void keyTyped(KeyEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == this.cdProp.getTfCEP()) {
            System.out.println("teste");
        }
    }
}
