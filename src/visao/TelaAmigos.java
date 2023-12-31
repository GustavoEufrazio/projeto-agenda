
package visao;

import dao.Banco;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Contato;

public class TelaAmigos extends javax.swing.JFrame {

   DefaultTableModel tmContato = new DefaultTableModel(null, new String[]{"matricula", "nome", "email"});
   
   List<Contato> contatos;
   
   ListSelectionModel lsmContato;
   
    public TelaAmigos() {
        initComponents();
    }
    
    public void LimparCampos(){
        txtMatricula.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtMatricula.requestFocus();
    }
    
   @SuppressWarnings("empty-statement")
    public void mostraPesquisa(List<Contato> contatos){
    
        while(tmContato.getRowCount() >0){
            tmContato.removeRow(0);
        }
        
        if(contatos.size() == 0){
        
            JOptionPane.showMessageDialog(null, "Nenhum contato cadastrado");
        } else{
        
            String[] linha = new String[] {null, null, null};
            
            for(int i = 0; i < contatos.size(); i++){
            
                tmContato.addRow(linha);
                
                tmContato.setValueAt(contatos.get(i).getMatricula(), i, 0);
                tmContato.setValueAt(contatos.get(i).getNome(), i, 1);
                tmContato.setValueAt(contatos.get(i).getEmail(), i, 2);
            }
        }
    }
    public void ListarContatos() throws Exception {
        
        Banco dao = new Banco();
        
        contatos = dao.getLista("%" + txtPesquisa.getText() + "%");
        
        mostraPesquisa(contatos);
    }
   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnAlterarRegistro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mn = new javax.swing.JMenu();
        mnConsultaNome = new javax.swing.JMenuItem();
        mnConsultaCodigo = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda de Amigos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jLabel1.setText("Matricula:");

        jLabel2.setText("Nome:");

        jLabel3.setText("E-mail");

        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyPressed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        btnSalvar.setText("Salvar no banco");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        btnLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLimparKeyPressed(evt);
            }
        });

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnAlterarRegistro.setText("Alterar");
        btnAlterarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail)
                    .addComponent(txtNome)
                    .addComponent(txtMatricula)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(btnSalvar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAlterarRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnAlterarRegistro))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar2.setText("Limpar");
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisa)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(btnLimpar2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnLimpar2)))
        );

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setBackground(new java.awt.Color(204, 204, 204));
        jTable2.setModel(tmContato);
        jTable2.setGridColor(new java.awt.Color(102, 102, 102));
        jTable2.setName(""); // NOI18N
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setHeaderValue("Matricula");
            jTable2.getColumnModel().getColumn(1).setHeaderValue("Nome");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("Email");
        }

        jButton1.setText("Finalizar Aplicação");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        mn.setText("Consultas");

        mnConsultaNome.setText("por Nome");
        mnConsultaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsultaNomeActionPerformed(evt);
            }
        });
        mn.add(mnConsultaNome);

        mnConsultaCodigo.setText("por Matrícula");
        mnConsultaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsultaCodigoActionPerformed(evt);
            }
        });
        mn.add(mnConsultaCodigo);

        jMenuBar1.add(mn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        txtMatricula.setText("");
        txtNome.setText("");
        txtEmail.setText("");
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Contato c = new Contato();
            c.setMatricula(txtMatricula.getText());
            c.setNome(txtNome.getText());
            c.setEmail(txtEmail.getText());

            Banco dao = new Banco();
            dao.adicionarContato(c);
            JOptionPane.showMessageDialog(null, "Dados inclusos com sucesso!");

            LimparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void txtMatriculaKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNome.requestFocus();

        }
    }

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEmail.requestFocus();

        }    }

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSalvar.requestFocus();

        }
    }

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnSalvar.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            btnLimpar.requestFocus();
        }
    }

    private void btnLimparKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLimpar.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            btnSalvar.requestFocus();
        }
    }

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {
        txtPesquisa.setText("");
    }

    private void mnConsultaNomeActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            Banco banco = new Banco();
            Contato c = new Contato();
            c = banco.consultarNome(JOptionPane.showInputDialog("Informe o nome a ser pesquisado: "));
            txtMatricula.setText(c.getMatricula());
            txtNome.setText(c.getNome());
            txtEmail.setText(c.getEmail());
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    private void mnConsultaCodigoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Banco banco = new Banco();
            Contato c = new Contato();
            c = banco.consultarMatricula(JOptionPane.showInputDialog("Informe a matricula a ser pesquisado: "));
            txtMatricula.setText(c.getMatricula());
            txtNome.setText(c.getNome());
            txtEmail.setText(c.getEmail());
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Banco banco = new Banco();
            banco.excluirContato( JOptionPane.showInputDialog("Informe a matrícula a ser excluída"));
            JOptionPane.showMessageDialog(null, "Registro excluído com sucesso");
            LimparCampos();

           
        } catch (SQLException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void btnAlterarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRegistroActionPerformed
        try{
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja realizar alteração no registro?", "Atenção",JOptionPane.YES_NO_OPTION);
            if(opcao==JOptionPane.YES_OPTION){
            Contato c = new Contato();
            c.setMatricula(txtMatricula.getText());
            c.setNome(txtNome.getText());
            c.setEmail(txtEmail.getText());
            Banco banco = new Banco();
            banco.alterarContato(c);
            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso?");
            } else{
                JOptionPane.showMessageDialog(null,"Alteração não realizada");
            }
        } catch(Exception e){
            e.getMessage();
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try{
            ListarContatos();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro no campo de pesquisa" + e);
        }
    }
   public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAmigos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAmigos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAmigos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAmigos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    

    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAmigos().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btnAlterarRegistro;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenu mn;
    private javax.swing.JMenuItem mnConsultaCodigo;
    private javax.swing.JMenuItem mnConsultaNome;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    
}
