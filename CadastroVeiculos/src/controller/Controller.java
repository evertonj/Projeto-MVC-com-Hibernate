/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Controller implements ActionListener{
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
        this.cdProp.getBtSalvar().addActionListener(this);
        this.cdProp.getBtAtualizar().addActionListener(this);
        this.cdProp.getBtCancelar().addActionListener(this);
        this.cdProp.getBtFechar().addActionListener(this);
        this.cdProp.getBtExcluir().addActionListener(this);
        this.cdProp.getBtNovo().addActionListener(this);
        this.cdProp.getBtPesquisar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.frmPrincipal.getCdProp()) {
           this.cdProp.setVisible(true);
       }
       if(e.getSource() == this.cdProp.getBtSalvar()) {
           System.out.println("Passou!!!");
           carregarDadosAddProp();
           ProprietarioBO propBO = new ProprietarioBO();
           try {
               propBO.adicionar(this.prop);
               this.cdProp.dispose();
           } catch (SQLException ex) {
               Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
}
