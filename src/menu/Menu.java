package menu;
import estrutura.Jogo;
import java.util.Scanner;
import fazenda.Fazendeiro;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Menu:");
            System.out.println("1. Iniciar jogo");
            System.out.println("2. Como jogar");
            System.out.println("3. Finalizar programa");
            System.out.print("Escolha uma opção: ");
            
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Escolha o nome do Primeiro a jogar: ");
                    Scanner nome = new Scanner(System.in);
                    String nomeJogador1 = nome.nextLine();
                    System.out.println("Escolha o nome do Segundo a jogar: ");
                    String nomeJogador2 = nome.nextLine();
                    //nome.close();
                    iniciarJogo(nomeJogador1, nomeJogador2);
                    break;
                case 2:
                    comoJogar();
                    break;
                case 3:
                    System.out.println("Programa finalizado.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
            }

        } while (escolha != 3);

        scanner.close();
    }

    public static void iniciarJogo(String nomeJogador1, String nomeJogador2) {
        Scanner scanJogo = new Scanner(System.in);
        Jogo jogo = new Jogo(nomeJogador1, nomeJogador2);
        System.out.println("Jogo iniciado.");;
        while (jogo.isGameOver() == false) {
            System.out.println("Vez do jogador: " + jogo.getJogadorAtual().getNome());
            mostrarTabuleiro(jogo);
            System.out.println("Selecione a cava que deseja (1 - 6): ");
            int cava = scanJogo.nextInt();
            if(jogo.ValidarJogada(cava)){
                jogo.jogada(cava - 1);
            }
        }
        mostrarTabuleiro(jogo);
        System.out.println("\n\nFim de jogo!");
        Fazendeiro vencedor = jogo.getWinner();
        mostrarTabuleiro(jogo);
        if(vencedor.getNome() == "Empate"){
            System.out.println("Empate!!\n\n");
        }else{
            System.out.println("O vencedor é: " + vencedor.getNome() + " com " + vencedor.getSilo().getSementesNoSilo() + " pontos, Parabens!!\n\n");
        }

    }


    public static void comoJogar() {
        System.out.println("Regras do Jogo Mancala:");
        System.out.println("1. O jogo Mancala é jogado em um tabuleiro com 2 fileiras de 6 cavas cada.");
        System.out.println("2. Cada cava inicialmente contém uma quantidade igual de sementes.");
        System.out.println("3. Os jogadores alternam suas jogadas, escolhendo uma cava não vazia da sua fileira.");
        System.out.println("4. Ao escolher uma cava, as sementes são distribuídas uma a uma nas cavas subsequentes no sentido anti-horário.");
        System.out.println("5. Se a última semente cair na Silo do jogador, ele ganha outra jogada.");
        System.out.println("6. Se a última semente cair em uma cava vazia do jogador, ele captura todas as sementes na cava oposta.");
        System.out.println("7. O jogo termina quando todas as cavas de um jogador estiverem vazias.");
        System.out.println("8. O jogador com mais sementes no seu Mancala vence.");
        System.out.println("Bom Jogo :D");
        System.out.println("");
    }

    public static void mostrarTabuleiro(Jogo jogo){
        Fazendeiro jogadorAtual = jogo.getJogadorAtual();
        Fazendeiro oponente = jogo.getOponente();
        String tabuleiroOponente = String.format("|    |  %d | %d | %d | %d | %d | %d |    |", oponente.getCava(5).getContarSementes(), oponente.getCava(4).getContarSementes(), oponente.getCava(3).getContarSementes(), oponente.getCava(2).getContarSementes(), oponente.getCava(1).getContarSementes(), oponente.getCava(0).getContarSementes());
        String tabuleiroMeio = String.format("|  %d |------------------------| %d  |", oponente.getSilo().getSementesNoSilo(), jogadorAtual.getSilo().getSementesNoSilo());
        String tabuleiroJogador = String.format("|    |  %d | %d | %d | %d | %d | %d |    |", jogadorAtual.getCava(0).getContarSementes(), jogadorAtual.getCava(1).getContarSementes(), jogadorAtual.getCava(2).getContarSementes(), jogadorAtual.getCava(3).getContarSementes(), jogadorAtual.getCava(4).getContarSementes(), jogadorAtual.getCava(5).getContarSementes());
        System.out.println(tabuleiroOponente);
        System.out.println(tabuleiroMeio);
        System.out.println(tabuleiroJogador);
    }
}
