package View.telasMaster;

import Controller.blindagensLoginMaster;
import Controller.conectaBanco;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.border.LineBorder;

public final class telaLoginMaster implements ActionListener {

    conectaBanco bd = new conectaBanco();

    private JFrame frame;
    private JLabel login, senha, sgh, sgh2, logo;
    private JPanel panel, eita, eita2;
    private JTextField textLogin;
    private JPasswordField textSenha;
    private JSeparator separadorLogin, separadorSenha, separadorSgh;
    private JButton bLogar, bVoltar;
    blindagensLoginMaster blindagem = new blindagensLoginMaster();

    // Construtor //
    public telaLoginMaster() {

        gui();

    }

    // Tela Login - GerÃªncia //                     
    public void gui() {

        bVoltar = new JButton("<-");
        bVoltar.setBounds(10, 10, 40, 35);
        bVoltar.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bVoltar.setFocusPainted(false);
        bVoltar.addActionListener(this);
        bVoltar.setBackground(Color.WHITE);
        bVoltar.setBorder(new LineBorder(Color.BLACK));

        sgh = new JLabel("SGH");
        sgh.setBounds(25, 70, 110, 100);
        sgh.setFont(new Font("Urbandub", Font.PLAIN, 48));
        sgh.setForeground(Color.WHITE);

        separadorSgh = new JSeparator();
        separadorSgh.setBounds(135, 95, 2, 50);
        separadorSgh.setBorder(new LineBorder(Color.WHITE));

        sgh2 = new JLabel("Sistema Gestor Hospitalar");
        sgh2.setBounds(145, 70, 300, 100);
        sgh2.setFont(new Font("Urbandub", Font.PLAIN, 18));
        sgh2.setForeground(Color.WHITE);

        ImageIcon icon = new ImageIcon("imgs/sghLogo.png");
        //ImageIcon icon2 = new ImageIcon("sghLogin.png");

        icon.setImage(icon.getImage().getScaledInstance(500, 450, 100));
        //icon2.setImage(icon2.getImage().getScaledInstance(300, 150, 80))

        logo = new JLabel(icon);
        logo.setBounds(372, 18, 458, 430);

        login = new JLabel("LOGIN:");
        login.setBounds(20, 190, 100, 30);
        login.setFont(new Font("Century Gothic", Font.BOLD, 14));
        login.setForeground(Color.WHITE);

        separadorLogin = new JSeparator();
        separadorLogin.setBounds(20, 250, 355, 2);
        separadorLogin.setBorder(new LineBorder(Color.WHITE));

        senha = new JLabel("SENHA:");
        senha.setBounds(20, 300, 100, 30);
        senha.setFont(new Font("Century Gothic", Font.BOLD, 14));
        senha.setForeground(Color.WHITE);

        separadorSenha = new JSeparator();
        separadorSenha.setBounds(20, 360, 355, 2);
        separadorSenha.setBorder(new LineBorder(Color.WHITE));

        textLogin = new JTextField();
        textLogin.setBounds(20, 220, 354, 25);
        textLogin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        textLogin.setForeground(Color.WHITE);
        textLogin.setBackground(Color.decode("#005c99"));
        textLogin.setBorder(new LineBorder(Color.decode("#005c99")));
        textLogin.setCaretColor(Color.WHITE);

        textSenha = new JPasswordField();
        textSenha.setBounds(20, 330, 354, 25);
        textSenha.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        textSenha.setForeground(Color.WHITE);
        textSenha.setBackground(Color.decode("#005c99"));
        textSenha.setBorder(new LineBorder(Color.decode("#005c99")));
        textSenha.setCaretColor(Color.WHITE);

        bLogar = new JButton("ENTRAR");
        bLogar.setBounds(100, 400, 200, 40);
        bLogar.setFont(new Font("Century Gothic", Font.BOLD, 14));
        bLogar.setFocusPainted(false);
        bLogar.addActionListener(this);
        bLogar.setBackground(Color.WHITE);
        bLogar.setBorder(new LineBorder(Color.BLACK));

        eita = new JPanel();
        eita.setBackground(Color.decode("#005c99"));
        eita.setBounds(0, 0, 400, 500);

        eita2 = new JPanel();
        eita2.setBackground(Color.decode("#e6eeff"));
        eita2.setBounds(400, 0, 400, 500);

        panel = new JPanel();
        panel.setBackground(Color.decode("#cce6ff"));
        panel.setLayout(null);

        panel.add(bVoltar);
        panel.add(sgh);
        panel.add(separadorSgh);
        panel.add(sgh2);
        panel.add(logo);
        panel.add(login);
        panel.add(textLogin);
        panel.add(separadorLogin);
        panel.add(senha);
        panel.add(textSenha);
        panel.add(separadorSenha);
        panel.add(bLogar);
        panel.add(eita);
        panel.add(eita2);

        frame = new JFrame();
        frame.setTitle("Login - Gerencia");
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(panel);

    }

    // FunÃ§Ã£o que executa o login //
    public boolean login(String login, String senha) throws SQLException {

        boolean certo = false;

        bd.connection();
        bd.executaSQL("SELECT * FROM funcmaster");

        if (bd.rs.first()) {

            String s = bd.rs.getString("usuario");
            String l = bd.rs.getString("senha");

            if (login.equals(s) && senha.equals(l)) {

                certo = true;

            } else {

            }
        }

        return certo;
    }

    // AÃ§Ãµes //
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bLogar) {

            try {

                String usu = textLogin.getText();
                String sen = textSenha.getText();

                boolean resposta = login(usu, sen);

                if (resposta == true && blindagem.blingadegens(usu, sen)) {

                    telaPrincipalMaster tela = new telaPrincipalMaster();
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, "login não realizado!\n Favor conferir o usuario e senha digitado!");
                }
            } catch (SQLException ex) {
                System.out.println("Ocorreu erro ao conectar");
            }

        }

        if (e.getSource() == bVoltar) {

            frame.dispose();
            telaEscolha telaescolha = new telaEscolha();

        }

    }

    // Main //
    public static void main(String args[]) {

        telaLoginMaster telaLoginMaster = new telaLoginMaster();

    }

}
