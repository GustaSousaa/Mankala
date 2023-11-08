package armazem;

public class Semente {
    private int quantidade;

    public Semente(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarSemente() {
        quantidade++;
    }

    public void removerSemente() {
        if (quantidade > 0) {
            quantidade--;
        }
    }
}