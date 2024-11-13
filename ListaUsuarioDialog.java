import javax.swing.*;
import java.awt.*;

public class ListaUsuarioDialog extends JDialog {

    public ListaUsuarioDialog(JFrame principal) {
        super(principal, "Lista de Usuários", true);
        setSize(750, 650);
        setLayout(new BorderLayout());

        add(new JLabel("Lista de Usuários", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JTextArea("Exemplo de lista de usuários..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> setVisible(false));
        add(btnFechar, BorderLayout.SOUTH);

        setLocationRelativeTo(principal);
    }
}
