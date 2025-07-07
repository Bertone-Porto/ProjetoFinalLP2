package gameforge;

//representa uma avaliação com nota e comentário opcional
public class Avaliacao {
    private int nota;
    private String comentario; // pode ser vazio ou null
    private Usuario autor;

    public Avaliacao(int nota, Usuario autor) {
        this.nota = nota;
        this.autor = autor;
    }

    /*public Avaliacao(int nota, String comentario, Usuario autor) {
        this.nota = nota;
        this.comentario = comentario;
        this.autor = autor;
    }*/

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Nota: " + nota +
                (comentario != null ? " | Comentário: " + comentario : "") +
                " | Autor: " + autor.getNome();
    }


}
