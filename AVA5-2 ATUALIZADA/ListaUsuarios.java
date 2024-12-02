
import java.awt.*;
import javax.swing.*;

public class ListaUsuarios {

    private final JFrame principal;

    public ListaUsuarios(JFrame principal) {
        this.principal = principal;
    }

    public void exibir() {
        exibir("Lista de Usuários");
    }

    public void exibir(String titulo) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea("Exemplo de lista de usuários..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
