/*Ler um número inteiro n e mais dois números (inferior e superior) que
 formam um intervalo. Ao final, imprimir uma
 mensagem informando se está antes, dentro ou depois do intervalo.*/

import java.util.Scanner;

public class Exercicio10 {
    public static void main(String [] args){
        int n, inferior, superior;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número infeiro:");
        n = teclado.nextInt();

        System.out.println("Digite o valor inferior do intervalo:");
        inferior = teclado.nextInt();

        System.out.println("Digite o valor superior do intervalo:");
        superior = teclado.nextInt();

        if(n < inferior){
            System.out.println("Está antes do intervalo!");
        } else if(n > superior){
            System.out.println("Está depois do intervalo");
        } else {
            System.out.println("Está dentro do intervalor!");
        }


    }
}
