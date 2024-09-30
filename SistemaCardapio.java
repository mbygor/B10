import java.util.ArrayList;
import java.util.Scanner;

// Classe Produto representando os produtos do cardápio
class Produto {
    private String codigo;
    private String descricao;
    private boolean ativo;
    private double preco;

    public Produto(String codigo, String descricao, boolean ativo, double preco) {
        this.codigo = codigo;
        this.descricao = descricao.toUpperCase();
        this.ativo = ativo;
        this.preco = preco;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public double getPreco() {
        return preco;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: O preço deve ser positivo.");
        }
    }

    @Override
    public String toString() {
        return String.format("%-6s %-60s %10.2f", codigo, descricao, preco);
    }
}

// Classe Cardapio que armazena e gerencia os produtos
class Cardapio {
    private ArrayList<Produto> produtos;

    public Cardapio() {
        this.produtos = new ArrayList<>();
    }

    // Método para adicionar produto
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Método para remover produto
    public void removerProduto(String codigo) {
        produtos.removeIf(p -> p.getCodigo().equals(codigo));
    }

    // Método para exibir o cardápio (somente produtos ativos)
    public void exibirCardapio() {
        System.out.println("\n======= Cardápio Pitdog =======");
        System.out.println("CÓDIGO PRODUTO                                                         VALOR");
        System.out.println("----------------------------------------------------------------------------");
        for (Produto produto : produtos) {
            if (produto.isAtivo()) {
                System.out.println(produto.toString());
            }
        }
        System.out.println("----------------------------------------------------------------------------\n");
    }

    // Método para alterar produto
    public void alterarProduto(String codigo, double novoPreco, boolean novoStatus) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produto.setPreco(novoPreco);
                produto.setAtivo(novoStatus);
                System.out.println("Produto alterado com sucesso.");
                return;
            }
        }
        System.out.println("Erro: Produto não encontrado.");
    }

    // Método para consultar produto pelo código
    public Produto consultarProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        System.out.println("Erro: Produto não encontrado.");
        return null;
    }
}

public class SistemaCardapio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();

        // Adicionando produtos iniciais
        cardapio.adicionarProduto(new Produto("CM0157", "Cachorro Quente no Molho (Pão, Salsicha e Molho)", true, 7.50));
        cardapio.adicionarProduto(new Produto("CM0150", "Cachorro Quente no Molho (Completo)", true, 9.20));
        cardapio.adicionarProduto(new Produto("SC0020", "Suco de Laranja Garrafa de 350ml", true, 6.25));
        cardapio.adicionarProduto(new Produto("RF0015", "Refrigerante Lata 269ml Pepsi Cola", true, 3.80));

        boolean executar = true;
        while (executar) {
            System.out.println("Sistema de Cardápio - PitDog");
            System.out.println("1. Exibir Cardápio");
            System.out.println("2. Adicionar Produto");
            System.out.println("3. Alterar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("5. Consultar Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    cardapio.exibirCardapio();
                    break;
                case 2:
                    System.out.print("Código do Produto (6 caracteres): ");
                    String codigo = scanner.nextLine();
                    System.out.print("Descrição do Produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    cardapio.adicionarProduto(new Produto(codigo, descricao, true, preco));
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 3:
                    System.out.print("Código do Produto para alterar: ");
                    String codigoAlterar = scanner.nextLine();
                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();
                    System.out.print("Ativo (true/false): ");
                    boolean ativo = scanner.nextBoolean();
                    cardapio.alterarProduto(codigoAlterar, novoPreco, ativo);
                    break;
                case 4:
                    System.out.print("Código do Produto para excluir: ");
                    String codigoExcluir = scanner.nextLine();
                    cardapio.removerProduto(codigoExcluir);
                    System.out.println("Produto excluído com sucesso!");
                    break;
                case 5:
                    System.out.print("Código do Produto para consultar: ");
                    String codigoConsultar = scanner.nextLine();
                    Produto produto = cardapio.consultarProduto(codigoConsultar);
                    if (produto != null) {
                        System.out.println(produto.toString());
                    }
                    break;
                case 6:
                    executar = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
