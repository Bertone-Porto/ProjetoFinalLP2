package gameforge.model;

import java.util.Collections;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Set;

//Comentários abertos em um post (tipo fórum).

public class Comentario implements Avaliavel, Comparable<Comentario>{
    private Usuario autor;
    private String texto;
    private Set<Usuario> usuariosQueDeramUpvote;
    private Set<Usuario> usuariosQueDeramDownvote;
    private LocalDateTime dataCriacao;

    public Comentario(Usuario autor, String texto){
        this.autor = autor;
        this.texto = texto;
        this.usuariosQueDeramUpvote = new HashSet<>();
        this.usuariosQueDeramDownvote = new HashSet<>();
        this.dataCriacao = LocalDateTime.now();
    }

    /*
     registra um upvote de um usuário
      se o usuário já deu upvote, o voto é removido (toggle)
     se deu downvote antes, o downvote é removido e o upvote é adicionado
     */
    public void darUpvote(Usuario usuario) {
        if (usuario == null) return;

        //um usuário não pode dar upvote e downvote ao mesmo tempo.
        this.usuariosQueDeramDownvote.remove(usuario);

        //o método add() do Set retorna 'false' se o usuário já estava na lista.
        //usamos isso para criar a lógica de "toggle": se o upvote já existia, remove.
        if (!this.usuariosQueDeramUpvote.add(usuario)) {
            this.usuariosQueDeramUpvote.remove(usuario);
        }
    }

    /*
      Registra um downvote de um usuário.
     */
    public void darDownvote(Usuario usuario) {
        if (usuario == null) return;

        // Um usuário não pode dar upvote e downvote ao mesmo tempo.
        this.usuariosQueDeramUpvote.remove(usuario);

        if (!this.usuariosQueDeramDownvote.add(usuario)) {
            this.usuariosQueDeramDownvote.remove(usuario);
        }
    }

    // --- GETTERS PARA AS CONTAGENS ---
    public int getUpvotes() {
        return this.usuariosQueDeramUpvote.size();
    }

    public int getDownvotes() {
        return this.usuariosQueDeramDownvote.size();
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
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
    
    public boolean equals(Comentario outro){
        if (this==outro){return true;}
        if (outro==null){return false;}
        return this.texto.equals(outro.texto);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");

        String infoAutor = "@" + this.autor.getNickname() + " em " + this.dataCriacao.format(formatter) + ":";
        String textoFormatado = "  " + this.texto;
        // Mostra as contagens separadas, como você pediu.
        String placarVotos = "  [ ⬆️ Upvotes: " + getUpvotes() + " | ⬇️ Downvotes: " + getDownvotes() + " ]";

        return infoAutor + "\n" + textoFormatado + "\n" + placarVotos;
    }
}
