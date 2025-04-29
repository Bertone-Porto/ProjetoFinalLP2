/*Altere o tipo das duas variáveis do exercício 1 para ponto flutuante.*/

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        float n1, n2;
        float soma, subtracao, multiplicacao, divisao;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite n1: ");
        n1 = teclado.nextFloat();

        System.out.println("Digite n2: ");
        n2 = teclado.nextFloat();

        soma = n1 + n2;
        subtracao = n1 - n2;
        multiplicacao = n1 * n2;
        divisao = n1 / n2;

        System.out.printf("Soma: %f\n", soma);
        System.out.printf("Subtração: %f\n", subtracao);
        System.out.printf("Multiplicação: %f\n", multiplicacao);
        System.out.printf("Divisão: %f\n", divisao);
    }
}
