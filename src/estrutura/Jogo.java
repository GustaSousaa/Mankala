package estrutura;

import fazenda.Fazenda;
import fazenda.Fazendeiro;

public class Jogo {
    private Fazenda fazenda;
    private Fazendeiro jogadorAtual;
    private Fazendeiro jogador1;
    private Fazendeiro jogador2;

    public Jogo(String nomeJogador1, String nomeJogador2) {
        this.fazenda = new Fazenda();
        this.jogador1 = new Fazendeiro(nomeJogador1, this.fazenda.getCavasDoJogador1(),
                this.fazenda.getSiloDoJogador1());
        this.jogador2 = new Fazendeiro(nomeJogador2, this.fazenda.getCavasDoJogador2(),
                this.fazenda.getSiloDoJogador2());
        this.jogadorAtual = this.jogador1;
    }

    public void jogada(int cava) {
        int sementesInicial = this.jogadorAtual.getCava(cava).getContarSementes();
        this.fazenda.semear(cava, this.jogadorAtual, getOponente());
        if(this.jogadorAtual.getRoubarSementes()){
            roubarSementes(this.jogadorAtual.getCasaRoubar(), sementesInicial, (cava - 1));
            this.jogadorAtual.setRoubarSementes(false, 0);
        }
        if (this.jogadorAtual.getSemearNovamente()){
            this.jogadorAtual.setSemearNovamente(false);
        }else{
            passarVez();
        }
    }

    public void roubarSementes(int casaRoubar, int sementesInicial, int cava){
        int qtdRoubo;
        //Caso passe para o outro lado
        if (cava + sementesInicial > 5){
            qtdRoubo = this.getOponente().getCava(casaRoubar).getContarSementes() + this.jogadorAtual.getCava(5 - casaRoubar).getContarSementes();
            this.getOponente().getCava(casaRoubar).removerSementes(this.getOponente().getCava(casaRoubar).getContarSementes());
            this.jogadorAtual.getCava(5 - casaRoubar).removerSementes(this.getOponente().getCava(5 - casaRoubar).getContarSementes());
        }else{
            qtdRoubo = this.getOponente().getCava(5 - casaRoubar).getContarSementes() + this.jogadorAtual.getCava(casaRoubar).getContarSementes();
            this.getOponente().getCava(5 - casaRoubar).removerSementes(this.getOponente().getCava(5 - casaRoubar).getContarSementes());
            this.jogadorAtual.getCava(casaRoubar).removerSementes(this.getOponente().getCava(casaRoubar).getContarSementes());
        }
        this.jogadorAtual.getSilo().addSementes(qtdRoubo);
    }

    public void passarVez() {
        if (this.jogadorAtual == this.jogador1) {
            this.jogadorAtual = this.jogador2;
        } else {
            this.jogadorAtual = this.jogador1;
        }
    }

    public boolean ValidarJogada(int cava) {
        boolean valida = true;
        if (cava <= 0 || cava > 6) {
            valida = false;
        } else if (this.jogadorAtual.getCava(cava - 1).getContarSementes() == 0) {
            valida = false;
        }
        return valida;
    }

    public Fazendeiro getJogadorAtual() {
        return this.jogadorAtual;
    }

    public boolean isGameOver() {
        int i = 0;
        boolean fim = false;
        while ((fim == false && this.jogador1.getCava(i).getContarSementes() == 0)) {
            i++;
            if (i > 5) {
                fim = true;
            }
        }
        i = 0;
        while ((fim == false && this.jogador2.getCava(i).getContarSementes() == 0)) {
            i++;
            if (i > 5) {
                fim = true;
            }
        }
        return fim;
    }

    public void capturarCampo() {
        int count = 0;
        while(count == 0){
            this.jogadorAtual = getOponente();
            count = 0;
            for (int i = 0; i < 6; i++) {
                count += this.jogadorAtual.getCava(i).getContarSementes();
                this.jogadorAtual.getCava(i).setSementes(0);
            }
            
        }
        this.jogadorAtual.getSilo().addSementes(count);
    }

    public Fazendeiro getOponente() {
        if (this.jogadorAtual == this.jogador1) {
            return this.jogador2;
        } else {
            return this.jogador1;
        }
    }

    public Fazendeiro getWinner() {
        Fazendeiro vencedor;
        capturarCampo();
        if (this.jogador1.getSilo().getSementesNoSilo() > this.jogador2.getSilo().getSementesNoSilo()) {
            vencedor = this.jogador1;
        }else if (this.jogador1.getSilo().getSementesNoSilo() < this.jogador2.getSilo().getSementesNoSilo()){
            vencedor = this.jogador2;
        }else{
            vencedor = new Fazendeiro("Empate", null,null);
        }
        return vencedor;
    }
}