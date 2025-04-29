/*
Ler um caractere op representando uma operação aritmética (+, -, *, /)
e em seguida dois números reais a e b. Imprimir a expressão matemática e o resultado.
*/

import java.util.Scanner;

public class Exercicio11 {
    public static void main (String [] args){
        float a, b, resultado = 0;
        char op;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a operação (+, -, *, /):");
        String opStr = teclado.next();
        op = opStr.charAt(0);

        System.out.println("Digite o primeiro número:");
        a = teclado.nextFloat();

        System.out.println("Digite o segundo número:");
        b = teclado.nextFloat();

        if (op == '+') {
            resultado = a + b;
        } else if (op == '-') {
            resultado = a - b;
        } else if (op == '*') {
            resultado = a * b;
        } else if (op == '/') {
            resultado = a / b;
        }

        System.out.println(a + " " + op + " " + b + " = " + resultado);





    }
}
