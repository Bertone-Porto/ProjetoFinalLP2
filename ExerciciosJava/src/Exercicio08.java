/*Leia duas variáveis com a quantidade de kWh consumidos em uma casa e o valor do kWh.
Em seguida, calcule o valor a ser pago, concedendo um desconto de 10% caso o consumo seja menor que 150kWh.*/

import java.util.Scanner;
public class Exercicio08 {
    static public void main (String [] args){
        float kwh, valorPorKwh, valorTotal;
        Scanner teclado = new Scanner (System.in);

        System.out.println("Digite a qyantidade de kwh consumidos:");
        kwh = teclado.nextFloat();

        System.out.println("Digite o valor do kwh:");
        valorPorKwh = teclado.nextFloat();

        valorTotal = kwh * valorPorKwh;

        if(kwh < 150){
            valorTotal -= valorTotal * 0.10f;
        }

        System.out.printf("Valor a ser pago: R$ %f\n", valorTotal);


    }
}
