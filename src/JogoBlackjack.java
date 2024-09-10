import java.util.Scanner;

public class JogoBlackjack {
    private Baralho baralho;
    private Jogador jogador;
    private Jogador dealer;
    private Scanner scanner;

    public JogoBlackjack() {
        baralho = new Baralho();
        jogador = new Jogador("Jogador");
        dealer = new Jogador("Dealer");
        scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Bem-vindo ao Blackjack!");
            System.out.println("1. Iniciar novo jogo");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            System.out.println("");

            switch (escolha) {
                case 1:
                    novoJogo();
                    break;
                case 2:
                    continuar = false;
                    System.out.println("Obrigado por jogar!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println("");
        }
    }

    private void novoJogo() {
        jogador.getMao().clear();
        dealer.getMao().clear();
        baralho = new Baralho();

        // Deal initial cards
        jogador.addCarta(baralho.distribuirCarta());
        jogador.addCarta(baralho.distribuirCarta());
        dealer.addCarta(baralho.distribuirCarta());
        dealer.addCarta(baralho.distribuirCarta());

        // Show initial hands
        System.out.println("Mão do Jogador: " + jogador.getMao());
        System.out.println("Mão do Dealer: " + dealer.getMao().get(0) + " e [carta oculta]");

        // Player's turn
        boolean jogadorContinua = true;
        while (jogadorContinua) {
            System.out.println("");
            System.out.println("1. Pedir carta");
            System.out.println("2. Parar");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            System.out.println("");

            switch (escolha) {
                case 1:
                    jogador.addCarta(baralho.distribuirCarta());
                    System.out.println("Mão do Jogador: " + jogador.getMao());
                    if (jogador.Estouro()) {
                        System.out.println("Você estourou! Dealer vence.");
                        return;
                    }
                    break;
                case 2:
                    jogadorContinua = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        // Dealer's turn
        while (dealer.ValorMao() < 17) {
            dealer.addCarta(baralho.distribuirCarta());
        }
        System.out.println("Mão do Dealer: " + dealer.getMao());

        // Determine winner
        if (dealer.Estouro() || jogador.ValorMao() > dealer.ValorMao()) {
            System.out.println("-----------------------------");
            System.out.println("-      Jogador vence!       -");
            System.out.println("-----------------------------");

        } else if (jogador.ValorMao() < dealer.ValorMao()) {
            System.out.println("-----------------------------");
            System.out.println("-       Dealer vence!       -");
            System.out.println("-----------------------------");
        } else {
            System.out.println("Empate!");
        }
    }

    public static void main(String[] args) {
        JogoBlackjack jogo = new JogoBlackjack();
        jogo.iniciarJogo();
    }
}