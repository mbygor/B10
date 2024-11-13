import javax.swing.*;
import java.awt.*;

public class ListaPessoaDialog extends JDialog {

    public ListaPessoaDialog(JFrame principal) {
        super(principal, "Lista de Pessoas", true);
        setSize(750, 650);
        setLayout(new BorderLayout());

        add(new JLabel("Lista de Pessoas", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JTextArea("Exemplo de lista de pessoas..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> setVisible(false));
        add(btnFechar, BorderLayout.SOUTH);

        setLocationRelativeTo(principal);
    }
}
