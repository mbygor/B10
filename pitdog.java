
import java.util.Scanner;

public class pitdog {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Menu
            System.out.println("Bem-vindo ao Cardápio PitDog!");
            System.out.println("Escolha um produto:");
            System.out.println("1. Cachorro Quente Simples - R$ 5,00");
            System.out.println("2. Cachorro Quente Duplo - R$ 8,00");
            System.out.println("3. Cachorro Quente com Cheddar - R$ 6,00");
            System.out.println("4. Cachorro Quente com Bacon - R$ 7,00");
            System.out.println("5. Cachorro Quente Especial - R$ 10,00");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            // Exibir descrição com switch case
            switch (opcao) {
                case 1:
                    System.out.println("Cachorro quente simples com salsicha e molho.");
                    break;
                case 2:
                    System.out.println("Dois cachorros quentes simples juntos.");
                    break;
                case 3:
                    System.out.println("Cachorro quente com queijo cheddar.");
                    break;
                case 4:
                    System.out.println("Cachorro quente com pedaços de bacon.");
                    break;
                case 5:
                    System.out.println("Cachorro quente com todos os adicionais.");
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println(); // Linha em branco para melhor visualização
        } while (opcao != 0);

        scanner.close();
    }
}
