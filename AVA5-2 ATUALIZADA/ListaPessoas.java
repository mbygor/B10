
import java.awt.*;
import javax.swing.*;

public class ListaPessoas {

    private final JFrame principal;

    public ListaPessoas(JFrame principal) {
        this.principal = principal;
    }

    public void exibir() {
        exibir("Lista de Pessoas");
    }

    public void exibir(String titulo) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea("Exemplo de lista de pessoas..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
