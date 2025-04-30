/*5.
Implemente a classe Circulo
a)
Crie um nova classe com o nome Circulo no mesmo projeto onde está a classe
Retangulo
b)
Defina os atributos
c)
Defina dois construtores
d)
Defina os métodos de acesso
e)
Defina os demais métodos (os mesmos métodos da classe Retângulo)
f)
Leia do usuário os valores de x, y e raio e crie um objeto da classe Circulo Em
seguida, chame alguns métodos da classe Circulo para o objeto criado*/

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args){

        int x, y, largura, altura;
        Scanner teclado = new Scanner(System.in);

        //fazendo o retângulo
        Retangulo r = new Retangulo();

        System.out.println("Digite x do retangulo:");
        r.setX(teclado.nextInt());
        System.out.println("Digite y do retangulo:");
        r.setY(teclado.nextInt());
        System.out.println("Digite largura do retangulo:");
        r.setLargura(teclado.nextInt());
        System.out.println("Digite altura do retalngulo:");
        r.setAltura(teclado.nextInt());
        r.desenhar();

        System.out.println("Dividindo o retângulo...");
        r.dividir();
        r.desenhar();

        r.mover(25, 40);
        System.out.println("(retângulo) Digite escala de largura (%): ");
        float rx = teclado.nextFloat();
        System.out.println("(retângulo) Digite a escala de altura (%):");
        float ry = teclado.nextFloat();
        r.redimensionar(rx, ry);
        r.desenhar();

        //fazendo o circulo
        Circulo c = new Circulo();

        System.out.println("Digite x do circulo:");
        c.setX(teclado.nextInt());
        System.out.println("Digite y do circulo:");
        c.setY(teclado.nextInt());
        System.out.println("Digite o raio:");
        c.setRaio(teclado.nextInt());
        c.desenhar();

        System.out.println("Dividindo o circulo...");
        c.dividir();
        c.desenhar();

        c.mover(25, 40);
        System.out.println("(circulo) Digite escala de raio (%):");
        float escala = teclado.nextFloat();
        c.redimensionar(escala);
        c.desenhar();



    }
}
