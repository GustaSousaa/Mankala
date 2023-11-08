package fazenda;
import java.util.ArrayList;
import java.util.List;

import armazem.Silo;
import armazem.Cava;

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

    public void semear(int index, Fazendeiro jogadorAtual, Fazendeiro jogadorOponente) {
        Fazendeiro jogadorPonto = jogadorAtual;
        List<Cava> cavaListaAtual = jogadorAtual.getCavas();
        int indexCavaAtual = index;
        int quantidadeSementes = cavaListaAtual.get(index).getContarSementes();
        cavaListaAtual.get(index).removerSementes(quantidadeSementes);
        while (quantidadeSementes > 0) {
            quantidadeSementes = quantidadeSementes - 1;
            indexCavaAtual = (indexCavaAtual + 1);
            //entrada no silo
            if (indexCavaAtual > 5) {
                quantidadeSementes = quantidadeSementes - 1;
                jogadorPonto.getSilo().adicionarSemente();
                if (jogadorPonto == jogadorAtual) {
                    jogadorPonto = jogadorOponente;
                } else {
                    jogadorPonto = jogadorAtual;
                }
                indexCavaAtual = 0;
                if (cavaListaAtual == this.cavasDoJogador1) {
                    cavaListaAtual = this.cavasDoJogador2;
                } else {
                    cavaListaAtual = this.cavasDoJogador1;
                } 
            }
            if (quantidadeSementes >= 0){
            cavaListaAtual.get(indexCavaAtual).adicionarSemente();
            }
        }

        if (indexCavaAtual == 0 && quantidadeSementes < 0){         //finalizou no silo
            jogadorAtual.setSemearNovamente(true);
        }else if (cavaListaAtual.get(indexCavaAtual).getContarSementes() == 1){         //finalizou em casa vazia
            jogadorAtual.setRoubarSementes(true, (indexCavaAtual));
        }

        
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

