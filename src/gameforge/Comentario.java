package gameforge;

import java.util.List;

//Comentários abertos em um post (tipo fórum).

public class Comentario implements Avaliavel{
    private Usuario autor;
    private String texto;
    private int upVote;
    private int downVote;

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
}
