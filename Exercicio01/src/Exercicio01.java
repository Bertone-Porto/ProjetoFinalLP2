/*Leia do usuário a posição (x, y) e
os valores de largura e altura. Em
seguida, crie um novo
Retângulo usando essas informações.
*/

import java.util.Scanner;
public class Exercicio01 {
    public static void main(String[] args) {

        int x, y, largura, altura;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite x:");
        x = teclado.nextInt();

        System.out.println("Digite y:");
        y = teclado.nextInt();

        System.out.println("Digite largura:");
        largura = teclado.nextInt();

        System.out.println("Digite altura:");
        altura = teclado.nextInt();

        Retangulo r = new Retangulo(x, y, largura, altura);
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
