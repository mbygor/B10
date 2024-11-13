import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa {
    public static void main(String[] args) {
        new JanelaSistema();
    }
}

class JanelaSistema extends JFrame {
    private final String versaoSistema = "12.1.2024";
    private String nomeUsuario = "denys.silva";
    private String dataAcesso;

    public JanelaSistema() {
        configurarJanela();
        configurarMenu();
        configurarAreaTrabalho();
        adicionarRodape();
        setVisible(true);
    }

    private void configurarJanela() {
        setTitle("Sistema Pessoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Centraliza a janela
        definirDataAcesso();
    }

    private void configurarMenu() {
        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) { }

            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        menuCadastro.add(new JMenuItem("Usuários"));
        menuCadastro.add(new JMenuItem("Pessoas"));
        menuVisualizacao.add(new JMenuItem("Lista de usuários"));
        menuVisualizacao.add(new JMenuItem("Lista de pessoas"));

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        getContentPane().add(BorderLayout.NORTH, menuPrincipal);
    }

    private void configurarAreaTrabalho() {
        JTextArea areaTrabalho = new JTextArea();
        getContentPane().add(BorderLayout.CENTER, areaTrabalho);
    }

    private void adicionarRodape() {
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel(new Rodape(versaoSistema, nomeUsuario, dataAcesso).getTextoRodape());
        painelRodape.add(labelRodape);
        getContentPane().add(BorderLayout.SOUTH, painelRodape);
    }

    private void definirDataAcesso() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        dataAcesso = dateFormat.format(new Date());
    }
}

class Rodape {
    private String versao;
    private String usuario;
    private String dataAcesso;

    public Rodape(String versao, String usuario, String dataAcesso) {
        this.versao = versao;
        this.usuario = usuario;
        this.dataAcesso = dataAcesso;
    }

    public String getTextoRodape() {
        return "Versão: " + versao + "               Usuário: " + usuario + "               Data de acesso: " + dataAcesso;
    }
}
