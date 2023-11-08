package armazem;

public class Cava {
    
    private Semente sementes;

    public Cava(int quantidadeSementes) {
        this.sementes = new Semente(quantidadeSementes);
    }

    public int getContarSementes() {
        int qtdSementes = this.sementes.getQuantidade(); 
        return qtdSementes;
    }

    public void adicionarSemente() {
        this.sementes.adicionarSemente();
    }

    public void removerSementes(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            if (this.sementes.getQuantidade() > 0) {
                this.sementes.removerSemente();
            }
        }
    }

    public void setSementes(int quantidade) {
        this.sementes = new Semente(quantidade);
    }

    public void showCava(int numeroCava) {
        System.out.println("Cava " + numeroCava + ": " + this.sementes.getQuantidade() + " sementes");
    }
    
}



