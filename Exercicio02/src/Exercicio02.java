/*2.
Acrescente ao programa o método dividir dê um significado ao seu
método dividir para o Retângulo Faça a chamada para esse novo
método
*/

import java.util.Scanner;
public class Exercicio02 {
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