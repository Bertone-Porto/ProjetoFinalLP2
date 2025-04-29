/*6.
Leia a distância percorrida por um carro,o tempo gasto e a quantidade de gasolina consumida.
Em seguida, imprima a velocidade média(KM/h) e o consumo de combustível(Km/l).
.*/

import java.util.Scanner;

public class Exercicio06 {
    public static void main(String [] args){
        float distancia, tempo, gasolina, velocidadeMedia, consumo;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a distância percorrida, em km:");
        distancia = teclado.nextFloat();

        System.out.println("Digito tempo gasto, em horas:");
        tempo = teclado.nextFloat();

        System.out.println("Digite a quantidade de gasolina consumida, em litros:");
        gasolina = teclado.nextFloat();

        velocidadeMedia = distancia / tempo;
        consumo = distancia / gasolina;

        System.out.printf("Velocidade média: %f km/h\n", velocidadeMedia);
        System.out.printf("Consumo de combustível: %f km/l\n", consumo);
    }
}
