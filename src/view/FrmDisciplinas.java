/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DisciplinaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Disciplina;

/**
 *
 * @author sala308b
 */
public class FrmDisciplinas extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmAluno
     */
    public FrmDisciplinas() {
        initComponents();
        popularDisciplinas();
    }

    public void editarDisciplina(){
       int row = tblDisciplinas.getSelectedRow();
       
       String id = tblDisciplinas.getModel().getValueAt(row, 0).toString();
       String nome = tblDisciplinas.getModel().getValueAt(row, 1).toString();
       
       txtId.setText(id);
       txtNome.setText(nome);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplinas = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administrração de Disciplinas");

        jLabel1.setText("ID");

        txtNome.setName("txtNome"); // NOI18N

        txtId.setText("0");
        txtId.setEnabled(false);
        txtId.setName("txtId"); // NOI18N

        jLabel2.setText("NOME");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDisciplinas.setName("tblDisciplinas"); // NOI18N
        tblDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisciplinasMouseClicked(evt);
            }
        });
        tblDisciplinas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDisciplinasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisciplinas);

        btnNovo.setText("NOVO");
        btnNovo.setName("btnNovo"); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("SALVAR");
        btnSalvar.setName("btnSalvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.setName("btnExcluir"); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.setName("btnPesquisar"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalvar)
                            .addComponent(btnExcluir)
                            .addComponent(btnPesquisar))
                        .addGap(185, 191, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        txtId.setText("0");
        txtNome.setText("");
        
        txtNome.setFocusable(true);
      
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisciplinasMouseClicked
        // TODO add your handling code here:
        this.editarDisciplina();
    }//GEN-LAST:event_tblDisciplinasMouseClicked

    private void tblDisciplinasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDisciplinasKeyReleased
        // TODO add your handling code here:
        this.editarDisciplina();
    }//GEN-LAST:event_tblDisciplinasKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt( txtId.getText() );
        String nome = txtNome.getText();
        
        Disciplina disciplina = new Disciplina();
        disciplina.setId(id);
        disciplina.setNome(nome);
        
        if( JOptionPane.showConfirmDialog(
                                         null, 
                                         "Confirma atualizar ou incluir nova disciplina ?", 
                                         "Confirmação",                                                                                   
                                         JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE) == 0){
            if ( id == 0) {
                if ( new DisciplinaDAO().incluir(disciplina) ){
                     JOptionPane.showMessageDialog(null, "Disciplina incluída com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar incluir a disciplina.");
                }

            } else {
                if ( new DisciplinaDAO().atualizar(disciplina) ){
                    JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso.");
                } else {
                   JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar a disciplina."); 
                }
            }  
            
                   
        } else {
            
            JOptionPane.showMessageDialog(null, "Operação de inclusão ou atualização cancelada.");
        }
      
        
        
        
        popularDisciplinas();
        btnNovo.doClick();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt( txtId.getText() );
        Disciplina disciplina = new Disciplina();
        disciplina.setId(id);
        if ( new DisciplinaDAO().excluir(disciplina) ){
            JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir disciplina.");
        }
        
        popularDisciplinas();
    }//GEN-LAST:event_btnExcluirActionPerformed

    public void popularDisciplinas(){

     
      DefaultTableModel dtm = (DefaultTableModel) tblDisciplinas.getModel();
      dtm.setNumRows(0);
      dtm.setColumnCount(0);

      String[] colunas = { "ID", "NOME" };
      dtm.setColumnIdentifiers(colunas);
                 
      DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
      disciplinaDAO.listar().forEach( ( d ) -> {
              int id = d.getId();
              String[] linha = { String.valueOf(id) , d.getNome()  };
              dtm.addRow(linha);
      });
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDisciplinas;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
