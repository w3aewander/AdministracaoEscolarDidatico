/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DisciplinaDAO;
import controller.ProfessorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Disciplina;
import model.Professor;

/**
 *
 * @author sala308b
 */
public class FrmProfessores extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmProfessores
     */
    public FrmProfessores() {
        initComponents();
        popularProfessores();
        popularDisciplinas();
        limparListaDisciplinas();
    }

    private void limparListaDisciplinas() {
        DefaultListModel dlm = new DefaultListModel();
        dlm.clear();
        lstDisciplinas.setModel(dlm);
    }

    private void popularDisciplinas() {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cboDisciplinas.getModel();

        dcm.removeAllElements();

        //DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        new DisciplinaDAO().listar().forEach((d) -> {
            String id = String.valueOf(d.getId());
            String nome = d.getNome();

            dcm.addElement(id + "-" + nome);
        });

    }

    private void popularProfessores() {
        ProfessorDAO professorDAO = new ProfessorDAO();
        //Cria um modelo de dados para a tabela professores
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnCount(0); //apaga as colunas
        dtm.setNumRows(0); //apaga as linhas 

        //configura o cabeçalho das colunas da tabela.
        String[] colunas = {"ID", "NOME"};
        dtm.setColumnIdentifiers(colunas);

        //pega a lista de professoeres
        //para popular a tabela professores
        professorDAO.listar().forEach((p) -> {

            String id = String.valueOf(p.getId());
            String nome = p.getNome();

            String[] linha = {id, nome};
            dtm.addRow(linha);

        });
        tblProfessores.setModel(dtm);
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
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cboDisciplinas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDisciplinas = new javax.swing.JList<>();
        btnIncluirDisciplina = new javax.swing.JButton();
        btnRemoverDisciplina = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDisponibilidade = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProfessores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Professores");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID");

        txtId.setName("txtId"); // NOI18N

        jLabel2.setText("Nome");

        txtNome.setName("txtNome"); // NOI18N

        cboDisciplinas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboDisciplinas.setName("cboDesciplinas"); // NOI18N

        jLabel3.setText("Disciplinas disponíveis");

        jLabel4.setText("Disciplinas que o professor ministra");

        lstDisciplinas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstDisciplinas.setName("lstDisciplinas"); // NOI18N
        lstDisciplinas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lstDisciplinasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(lstDisciplinas);

        btnIncluirDisciplina.setText("Incluir");
        btnIncluirDisciplina.setName("btnInbcluirDisciplina"); // NOI18N
        btnIncluirDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirDisciplinaActionPerformed(evt);
            }
        });

        btnRemoverDisciplina.setText("Remover");
        btnRemoverDisciplina.setName("btnRemoverDisciplina"); // NOI18N
        btnRemoverDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverDisciplinaActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");

        txtDisponibilidade.setColumns(20);
        txtDisponibilidade.setRows(5);
        txtDisponibilidade.setName("txtDisponibilidade"); // NOI18N
        jScrollPane3.setViewportView(txtDisponibilidade);

        jLabel5.setText("Disponibilidade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIncluirDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverDisciplina))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluirDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnSalvar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnExcluir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNovo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnPesquisar)))))
                .addGap(23, 23, 23))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIncluirDisciplina, btnRemoverDisciplina});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnExcluir, btnNovo, btnPesquisar, btnSalvar});

        tblProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "JAVA"},
                {"2", "PHP 8"},
                {"3", null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOME"
            }
        ));
        tblProfessores.setName("tblProfessores"); // NOI18N
        tblProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfessoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProfessores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        txtId.setText("0");
        txtNome.setText("");

        limparListaDisciplinas();

        txtDisponibilidade.setText("");
    }//GEN-LAST:event_btnNovoActionPerformed

    private void lstDisciplinasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lstDisciplinasFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lstDisciplinasFocusGained

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        List<Disciplina> disciplinas = null;
        
        ;

        if (txtId.getText().equals("0")) {
           disciplinas = new ArrayList<Disciplina>(); 
           Professor professor = new Professor();
       
            DefaultListModel dlm = (DefaultListModel) lstDisciplinas.getModel();
            int qtdeDisciplinas = dlm.getSize();

            
            for (int i = 0; i < qtdeDisciplinas; i++) {
                Disciplina disciplina = new Disciplina();
                //pega as linha da lista de disciplinas
                Object linha = dlm.getElementAt(i);

                //Divide a linha usando o delimitador "-" para
                //obter o id e nome da disciplina
                String id = linha.toString().split("-")[0];
                String nome = linha.toString().split("-")[1];

                //setar o id e nome para criar o objeto disciplina
                disciplina.setId(Integer.parseInt(id));
                disciplina.setNome(nome);

                //incluir a disciplina na lista
                disciplinas.add(disciplina);

            }

            
            professor.setNome(txtNome.getText());
            professor.setDisponibilidade(txtDisponibilidade.getText());
            professor.setDisciplinas(disciplinas);
          
             
            
            if (new ProfessorDAO().incluir(professor)) {

                JOptionPane.showMessageDialog(null, "Professor incluido com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar incluir o professor.");
            }

        } else {
                
            disciplinas = new ArrayList<Disciplina>(); 
            Professor professor = new Professor();
            
            
            DefaultListModel dlm = (DefaultListModel) lstDisciplinas.getModel();
            
            int qtdeDisciplinas = dlm.getSize();

            for (int i = 0; i < qtdeDisciplinas; i++) {
                
           
                Disciplina disciplina = new Disciplina();
                //pega as linha da lista de disciplinas
                Object linha = dlm.getElementAt(i);

                //Divide a linha usando o delimitador "-" para
                //obter o id e nome da disciplina
                String id = linha.toString().split("-")[0];
                String nome = linha.toString().split("-")[1];

                //setar o id e nome para criar o objeto disciplina
                disciplina.setId(Integer.parseInt(id));
                disciplina.setNome(nome);

                //incluir a disciplina na lista
                disciplinas.add(disciplina);

            }
            professor.setId( Integer.parseInt(txtId.getText() ));
            professor.setNome(txtNome.getText()); 
            professor.setDisponibilidade(txtDisponibilidade.getText());
            professor.setDisciplinas(disciplinas);

            if (new ProfessorDAO().atualizar(professor)) {
 

                JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar o professor.");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnIncluirDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirDisciplinaActionPerformed
        // TODO add your handling code here:
        DefaultListModel dlm = (DefaultListModel) lstDisciplinas.getModel();
        dlm.addElement(cboDisciplinas.getModel().getSelectedItem().toString());
    }//GEN-LAST:event_btnIncluirDisciplinaActionPerformed

    private void btnRemoverDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverDisciplinaActionPerformed
        // TODO add your handling code here:
        DefaultListModel dlm = (DefaultListModel) lstDisciplinas.getModel();
        int indice = lstDisciplinas.getSelectedIndex();
        dlm.remove(indice);

        //dlm.Element( cboDisciplinas.getModel().getSelectedItem().toString()) ;        
    }//GEN-LAST:event_btnRemoverDisciplinaActionPerformed

    private void editarProfessor() {
        int row = tblProfessores.getSelectedRow();

        String id = tblProfessores.getValueAt(row, 0).toString();
        String nome = tblProfessores.getValueAt(row, 1).toString();

        txtId.setText(id);
        txtNome.setText(nome);

        DefaultListModel dlm = new DefaultListModel();
        new ProfessorDAO().obterDisciplinas(Integer.parseInt(id)).forEach((p) -> {
            dlm.addElement(p.getId() + "-" + p.getNome());
        });

        lstDisciplinas.setModel(dlm);

    }

    private void tblProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfessoresMouseClicked
        // TODO add your handling code here:
        editarProfessor();
    }//GEN-LAST:event_tblProfessoresMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    
        Professor professor = new Professor();
        int id = Integer.parseInt(txtId.getText());
        professor.setId( id  );
        
        if ( lstDisciplinas.getModel().getSize() > 0 ){
            new ProfessorDAO().excluirDisciplinas( professor.getId() );
        }
         
        if ( new ProfessorDAO().excluir( professor.getId() ) ) {
            JOptionPane.showMessageDialog(null, "Dados do professor excluídos com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir dados do professor.");
            
        }

        popularProfessores();
    }//GEN-LAST:event_btnExcluirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnIncluirDisciplina;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemoverDisciplina;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboDisciplinas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstDisciplinas;
    private javax.swing.JTable tblProfessores;
    private javax.swing.JTextArea txtDisponibilidade;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
