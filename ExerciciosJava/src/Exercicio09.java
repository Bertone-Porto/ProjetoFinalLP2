/*Ler um número real x e imprimi-lo arredondando seu valor para mais ou para menos. Se a parte decimal for menor que 0.
5 arredonda para menos. Se for maior ou igual a 0. 5 arredonda para mais.*/

import java.util.Scanner;

public class Exercicio09 {
    public static void main (String [] args){
        float x;
        int inteiro, arredondado;
        float parteDecimal;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite um número real:");
        x = teclado.nextFloat();

        inteiro = 0;
        float acumulador = 0;

        while (acumulador+1 <= x){
            acumulador += 1;
            inteiro++;
        }

        parteDecimal = x - inteiro;

        if(parteDecimal < 0.5f){
            arredondado = inteiro;
        } else {
            arredondado = inteiro + 1;
        }
        System.out.printf("Valor arredondado: %d\n", arredondado);



    }
}
