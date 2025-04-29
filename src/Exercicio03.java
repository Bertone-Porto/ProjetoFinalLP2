/*Leia o salário e o percentual de aumento. Em seguida, aplique o
percentual de aumento sobre o salário e imprima o novo salário.
 */

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String [] args){
        float salario, aumento, novoSalario;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite salário:");
        salario = teclado.nextFloat();

        System.out.println("Digite o aumento percentual:");
        aumento = teclado.nextFloat();
        novoSalario = salario;
        novoSalario += salario * (aumento/100);

        System.out.printf("Novo salário: %f", novoSalario);

    }
}
