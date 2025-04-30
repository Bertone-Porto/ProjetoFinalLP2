public class Retangulo {
    private int x, y, largura, altura;

    public Retangulo(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public void mover(int novoX, int novoY){
        this.x = novoX;
        this.y = novoY;
    }

    public void redimensionar(float sx, float sy){
        if(sx > 0 && sy > 0){
            this.largura = (int)(sx / 100 * largura);
            this.altura = (int)(sy / 100 * altura);
        }
    }

    public void desenhar(){
        System.out.printf("Retângulo na posição: (%d, %d), largura: %d, altura: %d\n", x, y, largura, altura);
    }

}
