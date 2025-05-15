public class Catraca {
    private String id;
    private boolean status;
    private int qtdPassagens;
    private double totalPago;
    private Passagem ultimaPassagem;

    public Catraca(String id){
        this.id = id;
        this.status = false;
        this.qtdPassagens = 0;
        this.totalPago = 0;
        this.ultimaPassagem = null;
    }

    public void desbloquear(){
        status = true;
    }

    public void registrarPassagem(Passagem passagem){
        if(status){
            qtdPassagens++;
            totalPago += passagem.getValor();
            ultimaPassagem = passagem;
            status = false;
        }
    }
    public void bloquear(){
        status = false;
    }

    public void exibirStatus(){
        System.out.printf("id: %s | status: %s | total de passagens: %d | total pago: $%d | horario da ultima: %s%n", id, status ? "desbloqueada" : "bloqueada", qtdPassagens, totalPago,(ultimaPassagem != null) ? ultimaPassagem.getHorario().toString() : "nenhum");
    }


}
