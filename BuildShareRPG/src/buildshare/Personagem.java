package buildshare;

public class Personagem {
    private String nome;
    private Jogo jogo;

    public Personagem(Jogo jogo, String nome) {
        this.jogo = jogo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
