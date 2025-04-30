/*4.
Altere o exercício 3 e crie métodos de acesso para a classe
Retangulo Use esses métodos de acesso para alterar os atributos
do retângulo
 */

import java.util.Scanner;
public class Exercicio04 {
    public static void main(String[] args) {

        int x, y, largura, altura;
        Scanner teclado = new Scanner(System.in);

        Retangulo r = new Retangulo(0, 0, 0, 0);

        System.out.println("Digite x:");
        r.setX(teclado.nextInt());

        System.out.println("Digite y:");
        r.setY(teclado.nextInt());

        System.out.println("Digite largura:");
        r.setLargura(teclado.nextInt());

        System.out.println("Digite altura:");
        r.setAltura(teclado.nextInt());

        r.desenhar();

        System.out.println("Dividindo o retângulo...");
        r.dividir();

        r.desenhar();

        r.mover(25, 40);

        System.out.println("Digite escala de largura (%): ");
        float sx = teclado.nextFloat();

        System.out.println("Digite a escala de altura (%):");
        float sy = teclado.nextFloat();

        r.redimensionar(sx, sy);

        r.desenhar();
    }
}