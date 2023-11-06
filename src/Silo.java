public class Silo {
    private int sementes;

    public int getContarSemente() {
        return sementes;
    }

    public void addSeed() {
        sementes++;
    }

    public void addSementes(int quantidade) {
        sementes += quantidade;
    }

    public void showSilo() {
        System.out.println("Silo: " + sementes + " sementes");
    }
}