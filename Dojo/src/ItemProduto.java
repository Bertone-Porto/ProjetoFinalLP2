public class ItemProduto {
    private String nomeProduto;
    private int quantidadeComprada;
    private double preco;
    private double subTotal;


    public ItemProduto(String nomeProduto, int quantidadeComprada, double preco){
        this.nomeProduto = nomeProduto;
        this.quantidadeComprada = quantidadeComprada;
        this.preco = preco;
        calcularSubtotal();
    }

    private void calcularSubtotal(){
        this.subTotal = quantidadeComprada * preco;
    }

    public void atualizarQuantidade(int novaQuantidade){
        if(novaQuantidade < 1){
            System.out.println("Não é permitido quantidade abaixo de 1");
        } else{
            quantidadeComprada = novaQuantidade;
            calcularSubtotal();
        }
    }

    public void atualizarPreco(double novoPreco){
        if(novoPreco <= 0.0){
            System.out.println("Não é permitido preço zerado ou negativo");
        }else {
            preco = novoPreco;
            calcularSubtotal();
        }
    }

    public void exibirInformacoes(){
        System.out.printf("Produto: %s | Quantidade: %d | Preço uni.: %f | Subtotal: %f", nomeProduto, quantidadeComprada, preco, subTotal);
    }


}
