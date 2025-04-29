/*Leia o raio de um círculo. Em seguida imprima o
 perímetro (2R) e a área (R2) do círculo com esse raio.*/


import java.util.Scanner;
public class Exercicio04 {
    public static void main(String [] args){
        float raio, perimetro, area;
        float pi = 3.1415f;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o raio:");
        raio = teclado.nextFloat();

        perimetro = 2*pi*raio;
        area = pi*raio * raio;

        System.out.printf("Perimetro: %f\n", perimetro);
        System.out.printf("Área: %f\n", area);


    }
}
