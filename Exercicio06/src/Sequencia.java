public class Sequencia {
    public int inicio, fim;

    //construtores
    public Sequencia(){
        this.inicio = 1;
        this.fim = 1;
    }
    public Sequencia (int inicio, int fim){
        this.inicio = inicio;
        this.fim = fim;
    }

    //get set inicio
    public int getInicio(){
        return inicio;
    }
    public void setInicio(int inicio){
        this.inicio = inicio;
    }

    //get set fim
    public int getFim(){
        return fim;
    }
    public void setFim(int fim){
        this.fim = fim;
    }

    //imprimir sequência sem passos
    public void imprimirSequencia(){
        System.out.println("Sequência de 1 em 1:");
        for (int i = inicio; i <= fim; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //imprimir sequência com passos
    public void imprimirSequencia(int passo){
        System.out.println("Sequência com passo " + passo + ":");
        for(int i = inicio; i <= fim; i += passo){
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
