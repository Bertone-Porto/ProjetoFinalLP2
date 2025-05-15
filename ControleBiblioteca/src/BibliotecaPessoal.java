public class BibliotecaPessoal {
    private String id;
    private Livro[] livros;
    private int totalLidos;

    public BibliotecaPessoal(String id, int capacidade) {
        this.id = id;
        this.livros = new Livro[capacidade];
        this.totalLidos = 0;
    }

    public void adicionarLivro(String titulo, String autor, int ano, String status ){
        for(int i = 0; i< livros.length;i++){
            if(livros[i] != null && livros[i].getTitulo().equals(titulo) && livros[i].getAutor().equals(autor)){
                System.out.println("já cadastrado");
                return;
            }
        }

        for(int i = 0; i <livros.length; i++){
            if(livros[i] == null){
                System.out.println("livro cadastrado com sucesso");
                livros[i] = new Livro(titulo, autor, ano, status, 0);
                return;
            }
        }
    }

    public void removerLivro(String titulo){
        for(int i = 0; i<livros.length;i++){
            if(livros[i] != null && livros[i].getTitulo().equals(titulo)){
                if(livros[i].getStatusLeitura().equals("lido")) {
                    totalLidos--;
                }
                System.out.println("titulo removido");
                livros[i] = null;
                return;
            }
        }
        System.out.println("titulo não encontrado");
    }

    public void marcarComoLido(String titulo){
        for(int i = 0; i<livros.length;i++) {
            if (livros[i] != null && livros[i].getTitulo().equals(titulo)) {
                if(livros[i].getStatusLeitura().equals("lido")){
                    System.out.println("já marcado como lido");
                }else {
                    livros[i].setStatusLeitura("lido");
                    totalLidos++;
                    System.out.println("marcado como lido");
                }
                return;
            }
        }
    }

    public void avaliarLivro(String titulo, int avaliacao){
        for(int i = 0; i<livros.length;i++) {
            if (livros[i] != null && livros[i].getTitulo().equals(titulo)) {
                livros[i].setAvaliacao(avaliacao);
                if(livros[i].getStatusLeitura().equals("não lido")){
                    livros[i].setStatusLeitura("lido");
                }
                System.out.println("titulo avaliado");
                return;
            }
        }
        System.out.println("titulo não existe");
    }

    public void exibirResumo(){
        System.out.printf("id: %s\n", id);
        for(int i = 0; i<livros.length;i++) {
            if (livros[i] != null) {
                System.out.printf("livro de titulo: %s | autor: %s | ano: %d | status: %s | avaliação: %d\n", livros[i].getTitulo(), livros[i].getAutor(), livros[i].getAnoPublicacao(), livros[i].getStatusLeitura(), livros[i].getAvaliacao());
            }
        }
        System.out.printf("total de livros lidos: %d\n", totalLidos);
    }

}
