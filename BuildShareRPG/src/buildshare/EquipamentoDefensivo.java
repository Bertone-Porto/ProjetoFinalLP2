package buildshare;

public class EquipamentoDefensivo extends Equipamento{
    public EquipamentoDefensivo(String nome, int poder) {
        super(nome, poder);
        this.tipo = TipoEquipamento.DEFENSIVO;
    }
    //tipo = defensivo
}
