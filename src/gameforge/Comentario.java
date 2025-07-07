package gameforge;

import java.util.Collections;
import java.time.LocalDateTime;
import java.util.List;

//Comentários abertos em um post (tipo fórum).

public class Comentario implements Avaliavel, Comparable<Comentario>{
    private Usuario autor;
    private String texto;
    private int upVote;
    private int downVote;
    private LocalDateTime dataCriacao;

    public Comentario(Usuario autor, String texto){
        this.autor = autor;
        this.texto = texto;
        this.upVote = 0;
        this.downVote = 0;
        this.dataCriacao = LocalDateTime.now();
    }

    @Override
    public void avaliar(int nota, Usuario avaliador) {

    }

    /*@Override
    public void avaliar(int nota, String comentario, Usuario avaliador) {

    }*/

    @Override
    public double calcularMedia() {
        return 0;
    }

    public int compareTo(Comentario outro){
        return outro.dataCriacao.compareTo(this.dataCriacao);
    }

    public String toString(){
        return "Falta fazer o modelo do print.";
        /*Lógica do modelo de print dos comentarios. */
    }
}
