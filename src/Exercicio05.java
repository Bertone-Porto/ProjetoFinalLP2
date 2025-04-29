/*Leia uma variável t com um tempo qualquer em segundos e imprima esse valor em hora,minuto e segundo.*/

import java.util.Scanner;
public class Exercicio05 {
    public static void main(String [] args){
        int t, horas, minutos, segundos;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o tempo em segundos:");
        t = teclado.nextInt();

        horas = t / 3600;
        minutos = (t % 3600)/60;
        segundos = t % 60;

        System.out.printf("%dh:%dm:%ds\n",horas, minutos, segundos );
    }
}
