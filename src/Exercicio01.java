/*Leia duas variáveis inteiras e imprima a soma, subtração, multiplicação e divisão entre elas.*/

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        int n1, n2;
        int soma, subtracao, multiplicacao, divisao;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite n1: ");
        n1 = teclado.nextInt();

        System.out.println("Digite n2: ");
        n2 = teclado.nextInt();

        soma = n1 + n2;
        subtracao = n1 - n2;
        multiplicacao = n1 * n2;
        divisao = n1 / n2;

        System.out.printf("Soma: %d\n", soma);
        System.out.printf("Subtração: %d\n", subtracao);
        System.out.printf("Multiplicação: %d\n", multiplicacao);
        System.out.printf("Divisão: %d\n", divisao);

    }
}
