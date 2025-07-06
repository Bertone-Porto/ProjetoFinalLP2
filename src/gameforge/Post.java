package gameforge;

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
     * Construtor da classe Post.
     * É chamado pela classe Sistema quando um usuário cria um novo post.
     * Inicializa os dados essenciais e as coleções para evitar erros.
     *
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

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public Set<Usuario> getFavoritadoPor() {
        return favoritadoPor;
    }

    public void printarComentarios(){
        for(int i = 0; i < comentarios.size(); i++){
            System.out.println(comentarios.get(i).toString());
        }
    }


    //implementações da interface Avaliavel
    @Override
    public void avaliar(int nota, Usuario avaliador) {
        avaliacoes.add(new Avaliacao(nota, avaliador)); // adicionar Avaliacao com nota simples (sem comentário)
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


}
