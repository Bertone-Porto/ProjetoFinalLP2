/*Leia uma variável n inteira. Em seguida, imprima uma mensagem informando se o número n é par ou ímpar.*/

import java.util.Scanner;

public class Exercicio07 {
    public static void main(String [] args){
        int n;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número inteiro:");
        n = teclado.nextInt();

        if (n % 2 == 0){
            System.out.println("O número é par.");
        } else {
            System.out.println("O número é ímpar");
        }
    }
}
