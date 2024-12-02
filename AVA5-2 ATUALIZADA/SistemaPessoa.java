
import java.awt.*;
import javax.swing.*;

public class SistemaPessoa {

    public static void main(String[] args) {
        new SistemaPessoa().iniciarSistema();
    }

    public void iniciarSistema() {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            public void menuDeselected(javax.swing.event.MenuEvent e) {
            }

            public void menuCanceled(javax.swing.event.MenuEvent e) {
            }
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        JTextArea areaTrabalho = new JTextArea();
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel(
                "Versão: " + ConfiguracoesSistema.VERSAO_SISTEMA
                + "    Usuário: " + ConfiguracoesSistema.NOME_USUARIO
                + "    Data de acesso: " + ConfiguracoesSistema.DATA_ACESSO
        );
        painelRodape.add(labelRodape);

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        itemMenuCadastroUsuarios.addActionListener(e -> new CadastroUsuarios(principal).exibir());
        itemMenuCadastroPessoas.addActionListener(e -> new CadastroPessoas(principal).exibir());
        itemMenuVisualizacaoListaUsuarios.addActionListener(e -> new ListaUsuarios(principal).exibir());
        itemMenuVisualizacaoListaPessoas.addActionListener(e -> new ListaPessoas(principal).exibir());

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
