package buildshare;

public abstract class Equipamento {
    private String nome;
    private int poder;
    private TipoEquipamento tipo;

    public Equipamento(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
    }
}
