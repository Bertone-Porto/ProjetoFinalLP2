import java.time.LocalDateTime;

public class Passagem {
    private double valor;
    private LocalDateTime horario;

    public Passagem (double valor,LocalDateTime horario){
        this.valor = valor;
        this.horario = horario;
    }

    public double getValor(){
        return valor;
    }
    public LocalDateTime getHorario(){
        return horario;
    }

}
