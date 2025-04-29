/*Lerumnúmerodealunosn.Emseguida,lerasnotasdosnalunoseimprimir,aofinal,amédiadaturma.*/



import java.util.Scanner;
public class Exercicio13
{
    public static void main(String[] args) {
        int alunos, aux;
        float nota, media;
        float somaNotas = 0;

        Scanner teclado = new Scanner(System.in);
        System.out.println("Qtd de alunos: ");
        alunos = teclado.nextInt();
        aux = alunos;
        while (alunos != 0){
            System.out.println("Nota: ");
            nota = teclado.nextFloat();
            somaNotas += nota;

            alunos -= 1;
        }

        media = somaNotas/aux;
        System.out.printf("Média da turma: %f\n", media);
    }
}