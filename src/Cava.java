public class Cava {
    private int sementes;

    public Cava(int sementes) {
        this.sementes = sementes;
    }

    public int getContarSemente() {
        return sementes;
    }

    public void addSeed() {
        sementes++;
    }

    public int removerSementes() {
        int sementesRemovidas = sementes;
        sementes = 0;
        return sementesRemovidas;
    }

    public void showCava(int numeroCava) {
        System.out.println("Cava " + numeroCava + ": " + sementes + " sementes");
    }
}