/*Ler notas de alunos até que o usuário digite -1.
Ao final imprimir aquantidade de alunos,
a média da turma, a maior nota e a menor nota.*/
import java.util.Scanner;
public class Exercicio14
{
    public static void main(String[] args) {
        int alunos = 0, aux;
        float nota, media;
        float somaNotas = 0, maiorNota = -10, menorNota = 100;

        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Nota: ");
            nota = teclado.nextFloat();

            if(nota != -1) {
                somaNotas += nota;
                alunos++;
                if (nota >= maiorNota) {
                    maiorNota = nota;
                }
                if (nota <= menorNota) {
                    menorNota = nota;
                }
            }


        }while(nota != -1);

        media = somaNotas/alunos;
        System.out.printf("Média da turma: %f\n", media);
        System.out.printf("Quantidade de alunos: %d\n", alunos);
        System.out.printf("Maior nota: %f\n", maiorNota);
        System.out.printf("Menor nota: %f\n", menorNota);
    }
}