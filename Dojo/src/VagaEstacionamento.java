public class VagaEstacionamento {
    private String idVaga;
    private String tipoVaga;
    private double valorHora;
    private boolean statusVaga;

    public VagaEstacionamento(String idVaga, String tipoVaga, double valorHora){
        this.idVaga = idVaga;
        this.tipoVaga = tipoVaga;
        this.valorHora = valorHora;
        this.statusVaga = false;
    }

    public String getIdVaga(){
        return idVaga;
    }
    public String getTipoVaga(){
        return tipoVaga;
    }
    public double getValorHora(){
        return valorHora;
    }
    public boolean getStatusVaga(){
        return statusVaga;
    }

    public void ocuparVaga(String tipoVeiculo){
        if(statusVaga || tipoVaga != tipoVeiculo){
            System.out.println("Não permitido ocupar a vaga");
        }else{
            statusVaga = true;
        }
    }

    public double liberarVaga(int tempoHoras){
        if (!statusVaga){
            System.out.println("A vaga já está livre");
            return 0;
        }
        statusVaga = false;
        return tempoHoras * valorHora;
    }

    public void exibirInformacoes(){
        String status = statusVaga ? "Ocupada" : "livre";
        System.out.printf("Identificador da vaga: %s | Tipo da vaga: %s | Status da vaga: %b | Valor por hora: %f", idVaga, tipoVaga, statusVaga, valorHora);
    }




}
