/*
6.
Em um novo projeto ( crie uma classe Sequencia para representar uma
sequência de números inteiros A classe deverá ter atributos para representar o início
e o fim da sequência Crie um método para imprimir a sequência de números do início
até o fim, inclusive A impressão da sequência pode ser de 1 em 1 (valor default) ou de
p em p Exemplos
•
Sequência de 2 a 6 2 3 4 5 6
•
Sequência de 2 a 10 com p= 2 2 4 6 8 10
•
Sequência de 0 a 15 com p= 3 0 3 6 9 12 15
•
Sequência de 0 a 10 com p= 4 0 4 8
 */

import java.util.Scanner;
public class Exercicio06 {
    public static void main (String[] args){
        int passo;
        Sequencia s1 = new Sequencia();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o inicio da sequência:");
        s1.setInicio(teclado.nextInt());
        System.out.println("Digite o fim da sequência:");
        s1.setFim(teclado.nextInt());
        s1.imprimirSequencia();

        System.out.println("Digite um passo personalizado: ");
        passo = teclado.nextInt();

        s1.imprimirSequencia(passo);

    }
}
