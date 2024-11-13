import javax.swing.*;
import java.awt.*;

public class CadastroUsuarioDialog extends JDialog {

    public CadastroUsuarioDialog(JFrame principal) {
        super(principal, "Cadastro de Usuários", true);
        setSize(600, 300);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Usuários", SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        JRadioButton radioAtivo = new JRadioButton();
        painelCampos.add(radioAtivo);

        JPanel painelBotoes = PainelBotoesUtil.criarPainelBotoes(this);

        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
        setLocationRelativeTo(principal);
    }
}