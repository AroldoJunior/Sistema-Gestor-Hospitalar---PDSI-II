package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class telaPrincipalMaster extends JFrame implements ActionListener {
    
    JLabel labelMenu;
    JTable tableLista;
    JTextPane sombraTable, menuPane, menuPane2;
    JButton bCadastrar, bListar, bAlterar, bExcluir, bSair;
    
    public telaPrincipalMaster() {
        
        Container c = this.getContentPane();
        c.setLayout(null);
        
        tableLista = new JTable();
        tableLista.setBounds(10, 10, 900, 543);
        tableLista.setBackground(Color.WHITE);
        tableLista.setBorder(new LineBorder(Color.BLACK));
        add(tableLista);
        
        sombraTable = new JTextPane();
        sombraTable.setBounds(15, 15, 900, 543);
        sombraTable.setBackground(Color.GRAY);
        sombraTable.setEditable(false);
        add(sombraTable);
        
        bCadastrar = new JButton();
        bCadastrar.setText("CADASTRAR");
        bCadastrar.setBounds(993, 84, 220, 40);
        bCadastrar.setBackground(Color.decode("#B0C4DE"));
        bCadastrar.setBorder(new LineBorder(Color.BLACK));
        bCadastrar.addActionListener(this);
        bCadastrar.setFocusPainted(false);
        bCadastrar.setForeground(Color.BLACK);
        add(bCadastrar);

        bAlterar = new JButton();
        bAlterar.setText("ALTERAR");
        bAlterar.setBounds(993, 154, 220, 40);
        bAlterar.setBackground(Color.decode("#B0C4DE"));
        bAlterar.setBorder(new LineBorder(Color.BLACK));
        bAlterar.setFocusPainted(false);
        bAlterar.addActionListener(this);
        bAlterar.setForeground(Color.BLACK);
        add(bAlterar);
        
        bExcluir = new JButton();
        bExcluir.setText("EXCLUIR");
        bExcluir.setBounds(993, 224, 220, 40);
        bExcluir.setBackground(Color.decode("#B0C4DE"));
        bExcluir.setBorder(new LineBorder(Color.BLACK));
        bExcluir.setFocusPainted(false);
        bExcluir.addActionListener(this);
        bExcluir.setForeground(Color.BLACK);
        add(bExcluir);
        
        bSair = new JButton();
        bSair.setText("Sair");
        bSair.setForeground(Color.WHITE);
        bSair.setBounds(993, 470, 220, 40);
        bSair.setBackground(Color.decode("#FF6347"));
        bSair.setBorder(new LineBorder(Color.BLACK));
        bSair.setFocusPainted(false);
        bSair.addActionListener(this);
        add(bSair);
        
        labelMenu = new JLabel();
        labelMenu.setText("MENU");
        labelMenu.setBounds(1068, 30, 100, 50);
        labelMenu.setFont(labelMenu.getFont().deriveFont(20.0f));
        add(labelMenu);
        
        menuPane = new JTextPane();
        menuPane.setBounds(964, 20, 280, 523);
        menuPane.setBackground(Color.WHITE);
        menuPane.setBorder(new LineBorder(Color.BLACK));
        menuPane.setEditable(false);
        add(menuPane);
        
        menuPane2 = new JTextPane();
        menuPane2.setBounds(954, 10, 300, 543);
        menuPane2.setBackground(Color.WHITE);
        menuPane2.setBorder(new LineBorder(Color.BLACK));
        menuPane2.setEditable(false);
        add(menuPane2);
 
        
        
        setTitle("Tala Principal - Gerência");
        setSize(1300, 600);
        getContentPane().setBackground(Color.decode("#cce6ff"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == bCadastrar){
            telaCadastroFunc telacadastrofunc = new telaCadastroFunc();
            
        }
        
        if(e.getSource() == bAlterar){
            telaAlterarFunc telaalterarfunc = new telaAlterarFunc();
            
        }
        
        if(e.getSource() == bSair){
            telaLoginMaster telalloginmaster = new telaLoginMaster();
            dispose();
            
        }
        
    }

}
