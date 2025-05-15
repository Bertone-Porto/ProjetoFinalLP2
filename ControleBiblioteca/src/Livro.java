public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String statusLeitura;
    private int avaliacao;


    public Livro(String titulo, String autor, int anoPublicacao, String statusLeitura, int avaliacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.statusLeitura = statusLeitura;
        this.avaliacao = avaliacao;
    }

    public void setStatusLeitura(String statusLeitura) {
        this.statusLeitura = statusLeitura;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getStatusLeitura() {
        return statusLeitura;
    }

    public int getAvaliacao() {
        return avaliacao;
    }
}
