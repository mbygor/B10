
import java.awt.*;
import javax.swing.*;

public class BotoesCadastro {

    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    public JPanel criar() {
        return criar("Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair");
    }

    public JPanel criar(String... labelsPersonalizados) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = (labelsPersonalizados.length > 0) ? labelsPersonalizados : new String[]{"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}
