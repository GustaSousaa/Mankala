import java.util.ArrayList;
import java.util.List;

public class Fazenda {
    private List<Cava> cavasDoJogador1;
    private List<Cava> cavasDoJogador2;
    private Silo siloDoJogador1;
    private Silo siloDoJogador2;

    public Fazenda() {
        cavasDoJogador1 = new ArrayList<>();
        cavasDoJogador2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            cavasDoJogador1.add(new Cava(4));
            cavasDoJogador2.add(new Cava(4));
        }
        siloDoJogador1 = new Silo();
        siloDoJogador2 = new Silo();
    }

    public List<Cava> getCavasDoJogador1() {
        return cavasDoJogador1;
    }

    public List<Cava> getCavasDoJogador2() {
        return cavasDoJogador2;
    }

    public Silo getSiloDoJogador1() {
        return siloDoJogador1;
    }

    public Silo getSiloDoJogador2() {
        return siloDoJogador2;
    }

    public void mostrarFazenda() {
        System.out.println("Fazenda do Jogador 1:");
        for (int i = 0; i < 6; i++) {
            cavasDoJogador1.get(i).showCava(i + 1);
        }
        siloDoJogador1.showSilo();

        System.out.println("\nFazenda do Jogador 2:");
        for (int i = 0; i < 6; i++) {
            cavasDoJogador2.get(i).showCava(i + 1);
        }
        siloDoJogador2.showSilo();
    }

    public boolean validarCava(Fazendeiro jogador, int escolha) {
        if (jogador == jogador1) {
            return (escolha >= 1 && escolha <= 6 && cavasDoJogador1.get(escolha - 1).getContarSemente() > 0);
        } else {
            return (escolha >= 1 && escolha <= 6 && cavasDoJogador2.get(escolha - 1).getContarSemente() > 0);
        }
    }

    public void moverSementes(Fazendeiro jogador, int escolha) {
        List<Cava> cavas = (jogador == jogador1) ? cavasDoJogador1 : cavasDoJogador2;
        Cava cavaEscolhida = cavas.get(escolha - 1);
        int sementes = cavaEscolhida.getContarSemente();
        cavaEscolhida.removerSementes();

        for (int i = 0; i < sementes; i++) {
            int posicaoAtual = (escolha - 1 + i) % 6;
            if (jogador == jogador1 && posicaoAtual == 5) {
                // Se a última semente cair no próprio silo, o jogador ganha outra jogada.
                jogador.getSilo().addSeed();
            } else {
                cavas.get(posicaoAtual).addSeed();
            }
        }

        // Capturar sementes, se aplicável
        int ultimaPosicao = (escolha - 1 + sementes - 1) % 6;
        if (jogador == jogador1 && ultimaPosicao >= 0 && ultimaPosicao <= 5 && cavas.get(ultimaPosicao).getContarSemente() == 1) {
            int oposta = 5 - ultimaPosicao;
            if (cavasDoJogador2.get(oposta).getContarSemente() > 0) {
                int sementesCapturadas = cavasDoJogador2.get(oposta).removerSementes();
                jogador1.getSilo().adicionarSementes(sementesCapturadas);
            }
        } else if (jogador == jogador2 && ultimaPosicao >= 0 && ultimaPosicao <= 5 && cavasDoJogador1.get(ultimaPosicao).getContarSemente() == 1) {
            int oposta = 5 - ultimaPosicao;
            if (cavasDoJogador1.get(oposta).getContarSemente() > 0) {
                int sementesCapturadas = cavasDoJogador1.get(oposta).removerSementes();
                jogador2.getSilo().adicionarSementes(sementesCapturadas);
            }
        }
    }
}
