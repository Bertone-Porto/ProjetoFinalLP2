/*Ler dois números inteiros (a e b) e imprimir os pares no intervalo a..b,
 além da soma e da média desses números.
 Caso a seja maior que b, imprima os números pares no intervalo b..a.
*/

import java.util.Scanner;
public class Exercicio12 {
    public static void main (String [] args){
        int a, b, inicio, fim;
        int soma = 0;
        int quantidade=0, media, i;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a:");
        a = teclado.nextInt();

        System.out.println("Digite b:");
        b = teclado.nextInt();

        if (a < b){
            inicio = a;
            fim = b;
        } else {
            inicio = b;
            fim = a;
        }


        for(i = inicio ;i <= fim ;i++){
            if(i % 2 == 0){
                System.out.printf("Par: %d\n", i);
                soma += i;
                quantidade++;
            }
        }
        if (quantidade > 0){
            media = soma / quantidade;
            System.out.printf("Soma dos pares: %d\n", soma);
            System.out.printf("Média dos pares: %d\n", media);
        } else {
            System.out.println("Não há pares");
        }

    }
}
