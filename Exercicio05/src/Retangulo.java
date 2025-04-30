public class Retangulo {
    private int x, y, largura, altura;

    public Retangulo(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public Retangulo(){
        this.x = 0;
        this.y = 0;
        this.largura = 0;
        this.altura = 0;
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

    public void dividir(){
        this.largura /= 2;
        this.altura /= 2;
    }


    public void desenhar(){
        System.out.printf("Retângulo na posição: (%d, %d), largura: %d, altura: %d\n", x, y, largura, altura);
    }

    //get set X
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }

    //get sex Y
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }

    //get set largura
    public int getLargura(){
        return largura;
    }
    public void setLargura(int largura){
        this.largura = largura;
    }

    //get set altura
    public int getAltura(){
        return altura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }


}
