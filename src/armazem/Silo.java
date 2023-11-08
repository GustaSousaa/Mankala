package armazem;

public class Silo {
    private Semente sementes;

    public Silo() {
        this.sementes = new Semente(0);
    }

    public int getSementesNoSilo() {
        return sementes.getQuantidade();
    }

    public void adicionarSemente() {
        this.sementes.adicionarSemente();
    }
    
    public void addSementes(int quantidade) {
        for (int i = 0; i < quantidade; i++){
            this.sementes.adicionarSemente();
        }
    }
 
    public void showSilo() {
        System.out.println("Silo: " + sementes + " sementes");
    }
}