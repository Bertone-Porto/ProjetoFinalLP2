public class ContaBancaria {
    private String titular;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String titular, String numeroConta){
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public String getTitular(){
        return titular;
    }
    public String getNumeroConta(){
        return numeroConta;
    }
    public double getSaldo(){
        return saldo;
    }

    public void depositar(double valor){
        if(valor < 0){
            System.out.println("Não pode valor negativo!");
        } else {
            saldo += valor;
        }
    }

    public void sacar(double valor){
        double taxa = 1.50;
        if(saldo >= (valor + taxa)){
            saldo -= (valor + taxa);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void exibirDados(){
        System.out.printf("Titular: %s, Número da conta: %s, Saldo: $d", titular, numeroConta, saldo);
    }


}
