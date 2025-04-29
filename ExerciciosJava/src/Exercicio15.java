/*Ler caracteres até que o usuário digite '.' (ponto).
Ao final imprimir: a quantidade de vogais,
a quantidade de dígitos e aquantidade dos demais caracteres.*/

import java.util.Scanner;

public class Exercicio15 {
    public static void main(String [] args){
        int vogais = 0, digitos = 0, outros = 0;
        char caractere;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite caracteres ('.' para encerrar):");

        do{
            caractere = teclado.next().charAt(0);
            if (caractere != '.'){
                if(caractere == 'a' || caractere == 'e' || caractere == 'i' ||
                   caractere == 'o' || caractere == 'u' ||
                   caractere == 'A' || caractere == 'E' || caractere == 'I' ||
                   caractere == 'O' || caractere == 'U'){
                    vogais++;
                } else if(caractere >= '0' && caractere <= '9'){
                    digitos++;
                } else{
                    outros++;
                }
            }
        }while (caractere != '.');
        System.out.printf("Vogais: %d\n", vogais);
        System.out.printf("Dígitos: %d\n", digitos);
        System.out.printf("Outros: %d\n", outros);


    }

}
