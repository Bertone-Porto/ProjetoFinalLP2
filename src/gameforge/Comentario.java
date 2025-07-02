package gameforge;

import java.util.List;

//Comentários abertos em um post (tipo fórum).

public class Comentario implements Avaliavel{
    private Usuario autor;
    private String texto;
    private List<Integer> avaliacoes;
}
