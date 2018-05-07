/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import BancoDeDados.zc_Banco_de_Dados;
import Implementação.ModeloTabelaListar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;

/**
 *
 * @author CABRUTO
 */
public class ba_Lista_Funcionario extends javax.swing.JFrame {
    
     zc_Banco_de_Dados bd = new zc_Banco_de_Dados();

    /**
     * Creates new form Tela
     * 
     * 
     */
    
  
    public ba_Lista_Funcionario() {
        
        initComponents();
        bd.connection();

        preencherTabela("select * from funcionario");
        
    }
    
    
     public void preencherTabela(String SQL) {

        ArrayList dados = new ArrayList();

        String[] colunas = new String[]{"Nome", "Cpf", "Rg", "Cargo", "Senha", "Numcell", "Email"};

        bd.executaSQL(SQL);

        try {
            bd.rs.first();
        } catch (SQLException ex) {
          
        }
        
        
        try {
            do {

                try {
                    dados.add(new Object[]{bd.rs.getInt("id"),
                        bd.rs.getString("Nome"),
                        bd.rs.getString("Cpf"),
                        bd.rs.getString("Rg"),
                        bd.rs.getString("Senha"),
                        bd.rs.getString("NumCell"),
                        bd.rs.getString("email"),});
                } catch (SQLException ex) {
                   
                }

            } while (bd.rs.next());
        } catch (SQLException ex) {
            
        }

        //tabela = new JTable(modelo);
        ModeloTabelaListar mod = new ModeloTabelaListar(dados, colunas);

        JTabela.setModel(mod);

        JTabela.getColumnModel().getColumn(0).setPreferredWidth(80);
        JTabela.getColumnModel().getColumn(1).setPreferredWidth(150);
        JTabela.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTabela.getColumnModel().getColumn(3).setPreferredWidth(150);
        JTabela.getColumnModel().getColumn(4).setPreferredWidth(150);
        JTabela.getColumnModel().getColumn(5).setPreferredWidth(200);
        JTabela.getColumnModel().getColumn(6).setPreferredWidth(250);

        JTabela.getTableHeader().setReorderingAllowed(false);
        JTabela.setAutoResizeMode(JTabela.AUTO_RESIZE_OFF);
        JTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabela = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("Buscar:");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        JTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,null,null,"@"},
               
               
            },
            new String [] {
                "Nome", "Cpf", "Rg", "Cargo", "Senha", "Numcell", "Email"
            }
        ));
        jScrollPane1.setViewportView(JTabela);

        jButton2.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ba_Lista_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ba_Lista_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ba_Lista_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ba_Lista_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ba_Lista_Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable JTabela;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
