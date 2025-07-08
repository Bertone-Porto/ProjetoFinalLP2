package gameforge.model;


//representa uma avaliação com nota e comentário opcional
public class Avaliacao implements Comparable<Avaliacao>{
    private int nota;
    private String comentario; // pode ser vazio ou null
    private Usuario autor;

    public Avaliacao(int nota, Usuario autor) {
        this.nota = nota;
        this.autor = autor;
    }

    public Avaliacao(int nota, String comentario, Usuario autor) {
        this.nota = nota;
        this.comentario = comentario;
        this.autor = autor;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public Usuario getAutor() {
        return autor;
    }

    public int compareTo(Avaliacao outro){
        return this.autor.compareTo(outro.autor);
    }

    public boolean equals(Avaliacao outro){
        if (this==outro){return true;}
        if (outro==null){return false;}
        return this.autor.equalsIgnoreCase(outro.autor);
    }

    @Override
    public String toString() {
        return "Nota: " + nota +
                (comentario != null ? " | Comentário: " + comentario : "") +
                " | Autor: " + autor.getNome();
    }


}
