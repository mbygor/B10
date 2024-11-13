

import java.util.Scanner;

public class Cardapio {

    private static final int LIM_REG = 100;
    private static final String[][] produtos = new String[LIM_REG][4];
    private static final String[][] clientes = new String[LIM_REG][10];
    private static int totalProdutos = 0;
    private static int totalClientes = 0;
    private static Scanner entradaDados = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = entradaDados.nextInt();
            entradaDados.nextLine();

            switch (opcao) {
                case 1:
                    menuCadastroProduto();
                    break;
                case 2:
                    menuCadastroCliente();
                    break;
                case 3:
                    imprimirCardapio();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Cadastro de Produtos");
        System.out.println("2. Cadastro de Clientes");
        System.out.println("3. Imprimir Cardápio");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuCadastroProduto() {
        System.out.println("\nCadastro de Produtos:");
        System.out.println("1. Incluir Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Excluir Produto");
        System.out.println("4. Consultar Produto");
        System.out.print("Escolha uma opção: ");
        int opcao = entradaDados.nextInt();
        entradaDados.nextLine();

        switch (opcao) {
            case 1:
                incluirProduto();
                break;
            case 2:
                alterarProduto();
                break;
            case 3:
                excluirProduto();
                break;
            case 4:
                consultarProduto();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void incluirProduto() {
        if (totalProdutos >= LIM_REG) {
            System.out.println("Cadastro de produtos cheio.");
            return;
        }

        String codigo;
        do {
            System.out.print("Código (6 caracteres alfanuméricos): ");
            codigo = entradaDados.nextLine().toUpperCase();
            if (codigo.length() != 6) {
                System.out.println("Código inválido! Deve conter exatamente 6 caracteres.");
            }
        } while (codigo.length() != 6);

        String produto;
        do {
            System.out.print("Produto (min 3, max 60 caracteres): ");
            produto = entradaDados.nextLine().toUpperCase();
            if (produto.length() < 3 || produto.length() > 60) {
                System.out.println("Descrição do produto inválida!");
            }
        } while (produto.length() < 3 || produto.length() > 60);

        double preco;
        do {
            System.out.print("Preço (formato 0.00): ");
            preco = entradaDados.nextDouble();
            entradaDados.nextLine();

            if (preco < 0) {
                System.out.println("O preço deve ser positivo.");
            }
        } while (preco < 0);

        String ativo;
        do {
            System.out.print("Ativo (true para ativo, false para desativado): ");
            ativo = entradaDados.nextLine().toUpperCase();
            if (!ativo.equals("TRUE") && !ativo.equals("FALSE")) {
                System.out.println("Valor inválido! Informe true ou false.");
            }
        } while (!ativo.equals("TRUE") && !ativo.equals("FALSE"));

        produtos[totalProdutos][0] = codigo;
        produtos[totalProdutos][1] = produto;
        produtos[totalProdutos][2] = ativo;
        produtos[totalProdutos][3] = String.format("%.2f", preco);
        totalProdutos++;

        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void alterarProduto() {
        System.out.print("Digite o código do produto a alterar: ");
        String codigo = entradaDados.nextLine().toUpperCase();

        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro.");
            return;
        }

        System.out.println("Alterar Produto (deixe em branco para manter o valor original):");

        String novoProduto;
        do {
            System.out.print("Novo Produto (min 3, max 60 caracteres): ");
            novoProduto = entradaDados.nextLine().toUpperCase();
            if (!novoProduto.isEmpty()) {
                if (novoProduto.length() < 3 || novoProduto.length() > 60) {
                    System.out.println("Descrição do produto inválida!");
                    novoProduto = null;
                }
            } else {
                novoProduto = produtos[indice][1];
            }
        } while (novoProduto == null);
        produtos[indice][1] = novoProduto;

        String novoPrecoStr;
        double novoPreco;
        do {
            System.out.print("Novo Preço (formato 0.00): ");
            novoPrecoStr = entradaDados.nextLine();
            if (!novoPrecoStr.isEmpty()) {
                novoPreco = Double.parseDouble(novoPrecoStr);
                if (novoPreco < 0) {
                    System.out.println("O preço deve ser positivo.");
                    novoPreco = -1;
                }
            } else {
                novoPreco = Double.parseDouble(produtos[indice][3]);
            }
        } while (novoPreco < 0);
        produtos[indice][3] = String.format("%.2f", novoPreco);

        String novoAtivo;
        do {
            System.out.print("Novo Ativo (true para ativo, false para desativado): ");
            novoAtivo = entradaDados.nextLine().toUpperCase();
            if (!novoAtivo.isEmpty()) {
                if (!novoAtivo.equals("TRUE") && !novoAtivo.equals("FALSE")) {
                    System.out.println("Valor inválido! Informe true ou false.");
                    novoAtivo = null;
                }
            } else {
                novoAtivo = produtos[indice][2];
            }
        } while (novoAtivo == null);
        produtos[indice][2] = novoAtivo;

        System.out.println("Produto alterado com sucesso.");
    }

    private static void excluirProduto() {
        System.out.print("Digite o código do produto a excluir: ");
        String codigo = entradaDados.nextLine().toUpperCase();

        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro.");
            return;
        }

        for (int i = indice; i < totalProdutos - 1; i++) {
            produtos[i] = produtos[i + 1];
        }
        totalProdutos--;
        System.out.println("Produto excluído com sucesso.");
    }

    private static void consultarProduto() {
        System.out.print("Digite o código do produto: ");
        String codigo = entradaDados.nextLine().toUpperCase();

        int indice = buscarProdutoPorCodigo(codigo);
        if (indice == -1) {
            System.out.println("Produto não existe no cadastro.");
            return;
        }

        System.out.println("Código: " + produtos[indice][0]);
        System.out.println("Produto: " + produtos[indice][1]);
        System.out.println("Ativo: " + produtos[indice][2]);
        System.out.println("Preço: R$" + produtos[indice][3]);
    }

    private static int buscarProdutoPorCodigo(String codigo) {
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][0].equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    private static void imprimirCardapio() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("CÓDIGO PRODUTO                                                                              VALOR");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][2].equals("TRUE")) {
                System.out.printf("%-7s %-80s %6s\n", produtos[i][0], produtos[i][1], produtos[i][3]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    private static void menuCadastroCliente() {
        System.out.println("\nCadastro de Clientes:");
        System.out.println("1. Incluir Cliente");
        System.out.println("2. Alterar Cliente");
        System.out.println("3. Excluir Cliente");
        System.out.println("4. Consultar Cliente");
        System.out.print("Escolha uma opção: ");
        int opcao = entradaDados.nextInt();
        entradaDados.nextLine();

        switch (opcao) {
            case 1:
                incluirCliente();
                break;
            case 2:
                alterarCliente();
                break;
            case 3:
                excluirCliente();
                break;
            case 4:
                consultarCliente();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void incluirCliente() {
        if (totalClientes >= LIM_REG) {
            System.out.println("Cadastro de clientes cheio.");
            return;
        }

        String nome;
        do {
            System.out.print("Nome completo (min 6, max 60 caracteres): ");
            nome = entradaDados.nextLine().toUpperCase();
            if (nome.length() < 6 || nome.length() > 60) {
                System.out.println("Nome inválido!");
            }
        } while (nome.length() < 6 || nome.length() > 60);

        String cpf;
        do {
            System.out.print("CPF (11 caracteres numéricos): ");
            cpf = entradaDados.nextLine();
            if (cpf.length() != 11 || !cpf.matches("[0-9]+")) {
                System.out.println("CPF inválido!");
            }
        } while (cpf.length() != 11 || !cpf.matches("[0-9]+"));

        clientes[totalClientes][0] = nome;
        clientes[totalClientes][1] = cpf;
        totalClientes++;

        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void alterarCliente() {
        System.out.print("Digite o CPF do cliente a alterar: ");
        String cpf = entradaDados.nextLine();

        int indice = buscarClientePorCPF(cpf);
        if (indice == -1) {
            System.out.println("Cliente não existe no cadastro.");
            return;
        }

        String novoNome;
        do {
            System.out.print("Novo Nome (min 6, max 60 caracteres): ");
            novoNome = entradaDados.nextLine().toUpperCase();
            if (!novoNome.isEmpty()) {
                if (novoNome.length() < 6 || novoNome.length() > 60) {
                    System.out.println("Nome inválido!");
                    novoNome = null;
                }
            } else {
                novoNome = clientes[indice][0];
            }
        } while (novoNome == null);
        clientes[indice][0] = novoNome;

        System.out.println("Cliente alterado com sucesso.");
    }

    private static void excluirCliente() {
        System.out.print("Digite o CPF do cliente a excluir: ");
        String cpf = entradaDados.nextLine();

        int indice = buscarClientePorCPF(cpf);
        if (indice == -1) {
            System.out.println("Cliente não existe no cadastro.");
            return;
        }

        for (int i = indice; i < totalClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }
        totalClientes--;
        System.out.println("Cliente excluído com sucesso.");
    }

    private static void consultarCliente() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = entradaDados.nextLine();

        int indice = buscarClientePorCPF(cpf);
        if (indice == -1) {
            System.out.println("Cliente não existe no cadastro.");
            return;
        }

        System.out.println("Nome: " + clientes[indice][0]);
        System.out.println("CPF: " + clientes[indice][1]);
    }

    private static int buscarClientePorCPF(String cpf) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientes[i][1].equals(cpf)) {
                return i;
            }
        }
        return -1;
    }
}
