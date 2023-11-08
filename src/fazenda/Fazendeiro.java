package fazenda;

import java.util.List;

import armazem.Cava;
import armazem.Silo;

public class Fazendeiro {

    private String nome;
    private List<Cava> cavas;
    private Silo silo;
    private boolean semearNovamente;
    private boolean roubarSementes;
    private int casaRoubar;

    public Fazendeiro(String nome, List<Cava> cavas, Silo silo) {
        this.nome = nome;
        this.cavas = cavas;
        this.silo = silo;
    }

    public String getNome() {
        return nome;
    }

    public boolean getSemearNovamente() {
        return this.semearNovamente;
    }

    public void setSemearNovamente(boolean novamente) {
        this.semearNovamente = novamente;
    }
    

    public void setRoubarSementes(boolean roubo, int casaRoubar) {
        this.roubarSementes = roubo;
        this.casaRoubar = casaRoubar;
    }
    
    public boolean getRoubarSementes() {
        return this.roubarSementes;
    }

    public int getCasaRoubar(){
        return this.casaRoubar;
    }

    public List<Cava> getCavas() {
        return cavas;
    }

    public Cava getCava(int index) {
        return this.cavas.get(index);
    }

    public Silo getSilo() {
        return silo;
    }

    public int getSeedsRemaining() {
        int sementesRestantes = 0;
        for (Cava cava : cavas) {
            sementesRestantes += cava.getContarSementes();
        }
        return sementesRestantes;
    }
}