/*
7.
No projeto Utilidades, crie uma classe Data para representar uma
data Para criar uma
data é obrigatório informar dia, mês e ano Crie, também, três métodos
•
ehValida que deverá retornar true se os valores de dia, mês e ano formarem
uma data válida ou false caso contrário
•
ehBissexto que deverá retornar true se o ano for bissexto ou false caso
contrário
•
imprime() que deverá imprimir a data com o separador default ou com um
separador definido pelo usuário Caso a data seja inválida, o método deverá
imprimir "
 */

import java.util.Scanner;

public class Exercicio07 {
    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o dia: ");
        int dia = teclado.nextInt();
        System.out.println("Digte o mes: ");
        int mes = teclado.nextInt();
        System.out.println("Digite o ano: ");
        int ano = teclado.nextInt();

        Data data = new Data(dia, mes, ano);

        if (data.ehValida()) {
            System.out.println("A data é válida");
        } else {
            System.out.println("A data é inválida");
        }

        if (data.ehBissexto()) {
            System.out.println("O ano é bissexto");
        } else {
            System.out.println("O ano não é bissexto");
        }

        data.imprime();
        data.imprime("-");


    }
}
