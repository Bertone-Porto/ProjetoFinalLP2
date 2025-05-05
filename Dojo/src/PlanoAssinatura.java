public class PlanoAssinatura {
    private String plano;
    private int limiteAssinantes;
    private int totalAssinantes;
    private double valor;

    public PlanoAssinatura(String plano, int limiteAssinantes, double valor){
        this.plano = plano;
        this.limiteAssinantes = limiteAssinantes;
        this.totalAssinantes = 0;
        this.valor = valor;
    }

    public String getPlano(){
        return this.plano;
    }
    public int getLimiteAssinantes(){
        return this.limiteAssinantes;
    }
    public int getTotalAssinantes(){
        return this.totalAssinantes;
    }
    public double getValor(){
        return this.valor;
    }

    public void adicionarAssinante(){
        if(totalAssinantes < limiteAssinantes){
            totalAssinantes++;
        } else {
            System.out.println("Não é possível adicionar mais assinantes!");
        }
    }

    public void ofertarDesconto(double desconto){

        if(desconto < 0){
            System.out.println("Desconto inválido");
        } else if(desconto <= valor*0.5){
            valor -= desconto;
        }else{
            System.out.println("Desconto inválido!");
        }
    }

    public void exibirDados(){
        System.out.printf("Nome do plano: %s, Quantidade de assinantes: %d, Valor: R$%f", plano, totalAssinantes, valor);
    }


}
