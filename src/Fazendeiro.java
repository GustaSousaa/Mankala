import java.util.List;


public class Fazendeiro {

    private String nome;
    private List<Cava> cavas;
    private Silo silo;

    public Fazendeiro(String nome, List<Cava> cavas, Silo silo) {
        this.nome = nome;
        this.cavas = cavas;
        this.silo = silo;
    }

    public String getNome() {
        return nome;
    }

    public List<Cava> getCavas() {
        return cavas;
    }

    public Silo getSilo() {
        return silo;
    }

    public int getSeedsRemaining() {
        int sementesRestantes = 0;
        for (Cava cava : cavas) {
            sementesRestantes += cava.getContarSemente();
        }
        return sementesRestantes;
    }
}