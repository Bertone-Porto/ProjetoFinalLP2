package gameforge;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



//Representa uma ideia de jogo postada por um usuário

public class Post implements Avaliavel{
    private String titulo;
    private String descricao;
    private Genero genero;
    private Usuario autor;
    private List<Comentario> comentarios;
    private List<Avaliacao> avaliacoes;
    private Set<Usuario> favoritadoPor;

    /*
      Construtor da classe Post.
      É chamado pela classe Sistema quando um usuário cria um novo post.
      Inicializa os dados essenciais e as coleções para evitar erros.

     */
    public Post(String titulo, String descricao, Genero genero, Usuario autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.autor = autor;

        //inicializa as coleções como vazias para evitar NullPointerException
        this.comentarios = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        this.favoritadoPor = new HashSet<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Genero getGenero() {
        return genero;
    }

    public Usuario getAutor() {
        return autor;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void printarComentarios(){
        System.out.println("\n---  Comentários do Post: " + this.getTitulo() + " ---");

        if (this.comentarios.isEmpty()) {
            System.out.println(">> Nenhum comentário neste post ainda. <<");
        } else {
            //ordena os comentários do mais novo para o mais antigo
            Collections.sort(this.comentarios);

            for (Comentario comentario : this.comentarios) {
                System.out.println("---------------------------------");
                //chama o método toString()  em Comentario
                System.out.println(comentario.toString());
            }
            System.out.println("---------------------------------");
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public Set<Usuario> getFavoritadoPor() {
        return favoritadoPor;
    }

    //implementações da interface Avaliavel
    @Override
    public void avaliar(int nota, Usuario avaliador) {
        avaliacoes.add(new Avaliacao(nota, avaliador)); // adicionar Avaliacao com nota simples (sem comentário)
    }

    /*
      adiciona um usuário ao conjunto de usuários que favoritaram este post
      o usuário que favoritou o post
     */
    public void adicionarFavorito(Usuario usuario) {
        if (usuario != null) {
            this.favoritadoPor.add(usuario);
        }
    }

    /*@Override
    public void avaliar(int nota, String comentario, Usuario avaliador) {
        avaliacoes.add(new Avaliacao(nota, comentario, avaliador));// adicionar Avaliacao com nota + comentário
    }*/

    public void adicionarComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    @Override
    public double calcularMedia() {
        // calcular média das notas da lista de Avaliacoes
        if (avaliacoes.isEmpty()){
            return 0.0;
        }
        double soma = 0;
        for (Avaliacao a : avaliacoes){
            soma += a.getNota();
        }
        return soma/avaliacoes.size();
    }


    public int getQuantidadeFavoritos() {
        return this.favoritadoPor.size();
    }
}
