
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    
    public AcessoAplicativo() {
        setTitle("Acesso ao aplicativo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        painel.add(new JLabel("Usuário:"));
        campoUsuario = new JTextField(20);
        painel.add(campoUsuario);
        
        painel.add(new JLabel("Senha:"));
        campoSenha = new JPasswordField(20);
        painel.add(campoSenha);
        
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        painel.add(botaoCancelar);
        
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                
                if (usuario.equals("denys.silva") && senha.equals("Teste@2024")) {
                    JOptionPane.showMessageDialog(null, "Acesso confirmado!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
                }
            }
        });
        painel.add(botaoConfirmar);
        
        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AcessoAplicativo().setVisible(true);
            }
        });
    }
}
