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

        return true;
    }

    public void moverSementes(Fazendeiro jogador, int escolha) {
        
    }
}
