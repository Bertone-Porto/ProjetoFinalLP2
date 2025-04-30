public class Circulo {
    private int x, y, raio;

    //construtores
    public Circulo (int x, int y, int raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 1;
    }

    //get set x
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }

    //get set y
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }

    //get set raio
    public int getRaio(){
        return raio;
    }
    public void setRaio(int raio){
        this.raio = raio;
    }

    //metodos
    public void mover(int novoX, int novoY){
        this.x = novoX;
        this.y = novoY;
    }

    public void redimensionar(float escala){
        if(escala > 0){
            this.raio = (int)(escala / 100 * raio);
        }
    }

    public void dividir(){
        this.raio /= 2;
    }

    public void desenhar(){
        System.out.printf("Circulo na posição: (%d, %d), raio: %d\n", x, y, raio);
    }



}
