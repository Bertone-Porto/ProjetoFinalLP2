package buildshare;

public class EquipamentoOfensivo extends Equipamento{
    public EquipamentoOfensivo(String nome, int poder){
        super(nome, poder);
        this.tipo = TipoEquipamento.Ofensivo;
    }
    //tipos = ofensivo
}
