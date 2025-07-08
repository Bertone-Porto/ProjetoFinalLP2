package gameforge.service;

import gameforge.model.*;
import gameforge.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//classe principal que gerencia a execução do programa, menus e dados
public class Sistema {
    private Usuario usuarioLogado; //atributo para controlar quem está logado
    private Usuario ADM;
    private List<Usuario> usuarios;
    private Scanner scanner; // O scanner agora é um atributo da classe
    private List<Post> posts;


    //construtor para inicializar o estado do sistema
    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.usuarioLogado = null; //começa sem ninguém logado
        this.posts = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // --- CRIAÇÃO DO USUÁRIO ADMIN HARDCODED ---
        //cria um perfil simples para o admin
        PerfilUsuario perfilAdmin = new PerfilUsuario("Administrador do Sistema", "N/A", "Servidor");
        //cria o objeto UsuarioAdmin com login e senha definidos
        Usuario admin = new UsuarioAdmin("Admin", "admin", "admin", perfilAdmin);
        //adiciona o admin à lista de usuários do sistema
        this.usuarios.add(admin);
        this.ADM = admin;
        //System.out.println(">>> Conta de administrador padrão foi criada. <<<");
    }

    public Usuario getADM(){
        return this.ADM;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    //o único main do projeto estará aqui
    public static void main(String[] args) {
        Sistema gameForge = new Sistema();
        gameForge.executar(); //o main chama o método principal de execução
    }

    //método principal que controla o fluxo do aplicativo
    public void executar() {

        //Loop do menu principal (Login)
        while (true) {
            exibirMenuPrincipal();
            String entrada = scanner.nextLine(); //lê a entrada como String

            // valida antes de converter
            if (Validador.isStringInteiroValido(entrada)) {
                int opcao = Integer.parseInt(entrada);
                switch (opcao) {
                    case 1:
                        executarLogin();
                        break;
                    case 2:
                        executarCadastroDeUsuario();
                        break;
                    case 3:
                        System.out.println("Saindo do sistema... Até logo!");
                        scanner.close();
                        return;
                    default:
                        System.out.println(" Opção inválida.");
                }
            } else {
                System.out.println(" Erro: Por favor, digite apenas um número para a opção.");
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--- BEM-VINDO AO GAMEFORGE ---");
        System.out.println("1. Fazer Login");
        System.out.println("2. Criar Novo Usuário");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }


    //lida com o processo de login do usuário.
    private void executarLogin() {
        System.out.println("\n--- LOGIN ---");
        System.out.print("Digite seu nickname: ");
        String nickname = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        //busca o usuário pelo nickname
        for (Usuario u : this.usuarios) {
            if (u.getNickname().equalsIgnoreCase(nickname)) {
                //se encontrou, tenta autenticar a senha
                if (u.autenticar(senha)) {
                    this.usuarioLogado = u;
                    System.out.println("Login bem-sucedido! Bem-vindo(a), " + u.getNome() + "!");
                    menuUsuarioLogado(); //entra no menu do usuário logado
                    return; //sai do método de login após deslogar
                }
            }
        }

        //se o loop terminar e não encontrar/autenticar
        System.out.println("Erro: Nickname ou senha inválidos.");
    }


    //exibe o menu de ações para um usuário que está logado.
    private void menuUsuarioLogado() {
        while (this.usuarioLogado != null) {
            System.out.println("\n--- MENU DE USUÁRIO: @" + this.usuarioLogado.getNickname() + " ---");
            System.out.println("1. Criar Post");
            System.out.println("2. Procurar Post");
            System.out.println("3. Ver Meus Posts Favoritos"); // NOVA OPÇÃO
            System.out.println("4. Deslogar");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine(); //lê a entrada como String

            // MUDANÇA AQUI: Valida antes de converter
            if (Validador.isStringInteiroValido(entrada)) {
                int opcao = Integer.parseInt(entrada);
                switch (opcao) {
                    case 1:
                        executarCriacaoDePost();
                        break;
                    case 2:
                        escolherTipoDeBusca();
                        break;
                    case 3:
                        executarVerFavoritos();
                        break;
                    case 4:
                        System.out.println("Deslogando...");
                        this.usuarioLogado = null;
                        break;
                    default:
                        System.out.println(" Opção inválida.");
                }
            } else {
                System.out.println(" Erro: Por favor, digite apenas um número para a opção.");
            }
        }
    }

    public void adicionarPost(Post post){
        posts.add(post);
    }

    //      Lida com todo o fluxo de criação de um novo post.
    private void executarCriacaoDePost() {
        System.out.println("\n--- Criar Novo Post ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("\nEscolha um gênero para o post:");
        for (int i = 0; i < Genero.values().length; i++) {
            System.out.println((i + 1) + ". " + Genero.values()[i].getDescricao());
        }

        System.out.print("Digite o número do gênero: ");
        int opcaoGenero = Integer.parseInt(scanner.nextLine());

        if (opcaoGenero < 1 || opcaoGenero > Genero.values().length) {
            System.out.println("Opção inválida. Post não criado.");
            return;
        }

    Genero generoEscolhido = Genero.values()[opcaoGenero - 1];

    Post novoPost = new Post(titulo, descricao, generoEscolhido, usuarioLogado);
    this.adicionarPost(novoPost);

    System.out.println("Post criado com sucesso!");
    }


    //exibe a lista de posts favoritados pelo usuário logado.
    private void executarVerFavoritos() {
        System.out.println("\n--- ⭐ Meus Posts Favoritos ---");

        Set<Post> favoritos = this.usuarioLogado.getPostsFavoritos();

        if (favoritos.isEmpty()) {
            System.out.println("Você ainda não favoritou nenhum post.");
        } else {
            int i = 1;
            for (Post post : favoritos) {
                System.out.println(i + ". " + post.getTitulo() + " (por @" + post.getAutor().getNickname() + ")");
                i++;
            }
        }
        System.out.print("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }

    /*
      MÉTODO DE BUSCA 1: Busca por Gênero.
      Pergunta ao usuário qual gênero ele quer, filtra a lista de posts
      e depois chama o método de exibição.
     */
    private void executarBuscaDePost() {
        System.out.println("\n--- Gêneros Disponíveis ---");
        for (int i = 0; i < Genero.values().length; i++) {
            System.out.println((i + 1) + ". " + Genero.values()[i].toString());
        }

        System.out.print("Escolha o número do gênero que deseja procurar: ");
        String entrada = scanner.nextLine();
        if (!Validador.isStringInteiroValido(entrada)) {
            System.out.println(" Opção inválida.");
            return;
        }
        int escolhaGenero = Integer.parseInt(entrada);

        if (escolhaGenero >= 1 && escolhaGenero <= Genero.values().length) {
            Genero generoEscolhido = Genero.values()[escolhaGenero - 1];

            // ETAPA 1: FILTRAR A LISTA PRIMEIRO
            List<Post> postsFiltrados = new ArrayList<>();
            for (Post post : this.posts) {
                if (post.getGenero() == generoEscolhido) {
                    postsFiltrados.add(post);
                }
            }

            // ETAPA 2: PREPARAR OS PARÂMETROS PARA O MÉTODO DE EXIBIÇÃO
            String tituloDaPagina = "Posts do Gênero '" + generoEscolhido.getDescricao() + "'";
            int paginaInicial = 0;

            // ETAPA 3: CHAMAR O MÉTODO GENÉRICO COM OS 3 PARÂMETROS CORRETOS
            exibirPaginaDePosts(postsFiltrados, tituloDaPagina, paginaInicial);

        } else {
            System.out.println(" Opção de gênero inválida.");
        }
    }

    /*
      MÉTODO DE BUSCA 2 (SOBRECARGA): Busca por palavra-chave.
      Recebe uma String como parâmetro.
     */
    private void executarBuscaDePost(String palavraChave){
        List<Post> postsFiltrados = new ArrayList<>();
        for (Post post : this.posts) {
            if (post.getTitulo().toLowerCase().contains(palavraChave.toLowerCase())) {
                postsFiltrados.add(post);
            }
        }
        String titulo = "Resultados da Busca por '" + palavraChave + "'";
        exibirPaginaDePosts(postsFiltrados, titulo, 0);
    }

    // --- MÉTODOS DE BUSCA ---
    private void escolherTipoDeBusca() {
        System.out.println("\n--- TIPO DE BUSCA ---");
        System.out.println("1. Buscar por Gênero");
        System.out.println("2. Buscar por Palavra-Chave no Título");
        System.out.print("Escolha uma opção: ");
        String entrada = scanner.nextLine();
        if (!Validador.isStringInteiroValido(entrada)) {
            System.out.println(" Opção inválida.");
            return;
        }
        int escolha = Integer.parseInt(entrada);

        if (escolha == 1) {
            executarBuscaDePost();
        } else if (escolha == 2) {
            System.out.print("Digite a palavra-chave para buscar no título: ");
            String palavraChave = scanner.nextLine();
            executarBuscaDePost(palavraChave);
        } else {
            System.out.println(" Opção inválida.");
        }
    }

    /*
     * MÉTODO REATORADO: Agora exibe qualquer lista de posts com paginação
      ele não faz mais a filtragem, apenas exibe os resultados que recebe
     postsParaExibir: A lista de posts já filtrada a ser exibida
      O título a ser mostrado no topo da página (ex: "Posts de RPG")
     */
    private void exibirPaginaDePosts(List<Post> postsParaExibir, String tituloPagina, int pagina) {
        // 1. Verifica se a busca inicial retornou algum resultado.
        if (postsParaExibir.isEmpty()) {
            System.out.println("\nNenhum post encontrado com os critérios da busca.");
            return; //volta para o menu anterior.
        }

        while (true) {
            System.out.println("\n--- " + tituloPagina + " (Página " + (pagina + 1) + ") ---");

            int inicio = pagina * 3;

            //pega os 3 posts da página atual da lista já filtrada
            List<Post> postsDaPagina = new ArrayList<>();
            for (int i = inicio; i < inicio + 3 && i < postsParaExibir.size(); i++) {
                postsDaPagina.add(postsParaExibir.get(i));
            }

            if (postsDaPagina.isEmpty()) {
                System.out.println("Não há mais posts para exibir nesta página.");
                //evita ficar preso em uma página vazia, retorna para a anterior.
                if (pagina > 0) {
                    pagina--;
                }
                continue;
            }

            //exibe os posts da página
            for (int i = 0; i < postsDaPagina.size(); i++) {
                System.out.println((i + 1) + ". " + postsDaPagina.get(i).getTitulo());
            }

            System.out.println("\n--- Opções ---");
            System.out.println("1. Ver detalhes de um post");
            System.out.println("2. Próxima página");
            System.out.println("3. Voltar ao menu de usuário");
            System.out.print("Escolha uma opção: ");

            //validação da entrada do usuário
            String entrada = scanner.nextLine();
            if (!Validador.isStringInteiroValido(entrada)) {
                System.out.println(" Opção inválida.");
                continue; // Pede a opção novamente
            }
            int escolhaAcao = Integer.parseInt(entrada);

            switch (escolhaAcao) {
                case 1:
                    System.out.print("Digite o número do post que deseja ver: ");
                    String entradaPost = scanner.nextLine();
                    if (Validador.isStringInteiroValido(entradaPost)) {
                        int numPost = Integer.parseInt(entradaPost);
                        if (numPost >= 1 && numPost <= postsDaPagina.size()) {
                            exibirDetalhesDoPost(postsDaPagina.get(numPost - 1));
                        } else {
                            System.out.println(" Número de post inválido.");
                        }
                    } else {
                        System.out.println(" Opção inválida.");
                    }
                    break;
                case 2:
                    pagina++;
                    break;
                case 3:
                    return; //sai deste método e volta para o menuUsuarioLogado
                default:
                    System.out.println(" Opção inválida.");
            }
        }
    }

    /*
      exibe os detalhes de um post específico e o menu de interação
     */
    private void exibirDetalhesDoPost(Post post) {
        while (true) {
            System.out.println("\n--- Detalhes do Post ---");
            // getters do objeto Post para mostrar os dados reais
            System.out.println("Título: " + post.getTitulo());
            System.out.println("Autor: @" + post.getAutor().getNickname());
            System.out.println("Gênero: " + post.getGenero().getDescricao());
            System.out.println("Descrição: " + post.getDescricao());
            System.out.println("Média das Avaliações: " + post.calcularMedia());
            System.out.println("️ Favoritado por: " + post.getQuantidadeFavoritos() + " usuário(s)."); //mostra quantos favoritos
            System.out.println("----------------------------------------------");
            System.out.println("1. Comentar neste post");
            System.out.println("2. Exibir comentarios do post");
            System.out.println("3. Avaliar este post");
            System.out.println("4. Favoritar este post");

            // --- LÓGICA CONDICIONAL DE ADMIN ---
            if (this.usuarioLogado instanceof UsuarioAdmin) {
                System.out.println("9. (Admin) Deletar este Post");
            }
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");


            int escolhaAcao = Integer.parseInt(scanner.nextLine());

            switch (escolhaAcao) {
                    case 1:
                        executarComentarioEmPost(post);
                        break;
                    case 2:
                        // a votação de comentários acontece DENTRO desta tela
                        menuInteracaoComentarios(post);
                        break;
                    case 3:
                        //esta opção avalia o POST, não um comentário
                        executarAvaliacaoDePost(post);
                        break;
                    case 4:
                        this.usuarioLogado.favoritarPost(post);
                        System.out.println(" Post favoritado com sucesso!");
                        break;
                    case 0:
                        return;
                     case 9:
                        // Checa novamente por segurança antes de executar a ação
                        if (this.usuarioLogado instanceof UsuarioAdmin) {
                            executarDeletarPost(post);
                            return; //retorna, pois o post não existe mais
                        }
                        break; // Se não for admin, cai no default
                    default:
                        System.out.println(" Opção inválida.");
                }
            }
        }

    /*
      Lida com a ação de um admin deletar o post que está sendo visualizado.
     */
    private void executarDeletarPost(Post postParaDeletar) {
        System.out.print("Tem certeza que deseja deletar o post '" + postParaDeletar.getTitulo() + "'? (s/n): ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            //remove o post da lista principal do sistema
            this.posts.remove(postParaDeletar);

            //remove o post das listas de favoritos de todos os usuários
            for (Usuario u : this.usuarios) {
                u.getPostsFavoritos().remove(postParaDeletar);
            }
            System.out.println(" Post deletado com sucesso.");
        } else {
            System.out.println("Ação cancelada.");
        }
    }

    /*
     exibe a lista de comentários e oferece opções de interação (votar).
     post: O post cujos comentários serão gerenciados.
     */
    private void menuInteracaoComentarios(Post post) {
        while (true) {
            // 1. Mostra todos os comentários primeiro, já formatados e ordenados.
            post.printarComentarios();

            //se não houver comentários, não há o que fazer.
            if (post.getComentarios().isEmpty()) {
                System.out.print("\nPressione Enter para voltar...");
                scanner.nextLine();
                return;
            }

            // 2. Oferece o menu de interação
            System.out.println("\n--- Ações de Comentário ---");
            System.out.println("1. Dar Upvote/Downvote em um comentário");

            // Opção condicional para o admin
            if (this.usuarioLogado instanceof UsuarioAdmin) {
                System.out.println("9. (Admin) Deletar um Comentário");
            }
            System.out.println("0. Voltar para os detalhes do post");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();
            if (!Validador.isStringInteiroValido(entrada)) {
                System.out.println(" Opção inválida.");
                continue;
            }
            int escolha = Integer.parseInt(entrada);

            switch (escolha) {
                case 1:
                    executarVotoEmComentario(post);
                    break;
                case 0:
                    return; // Volta para o menu anterior
                case 9:
                    if (this.usuarioLogado instanceof UsuarioAdmin) {
                        executarDeletarComentario(post);
                    } else {
                        System.out.println(" Opção inválida.");
                    }
                    break;
                default:
                    System.out.println(" Opção inválida.");
            }
        }
    }

    /*
      Lida com a ação de um admin deletar um comentário específico de um post.
     */
    private void executarDeletarComentario(Post post) {
        System.out.print("Digite o número do comentário (#) que deseja deletar: ");
        String entrada = scanner.nextLine();
        if (!Validador.isStringInteiroValido(entrada)) {
            System.out.println(" Número inválido.");
            return;
        }
        int numComentario = Integer.parseInt(entrada);

        if (numComentario >= 1 && numComentario <= post.getComentarios().size()) {
            //pega o comentário a ser deletado
            Comentario comentarioParaDeletar = post.getComentarios().get(numComentario - 1);

            System.out.print("Tem certeza que deseja deletar este comentário? (s/n): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("s")) {
                //chama o método da classe Post para remover o comentário de sua própria lista
                post.removerComentario(comentarioParaDeletar);
                System.out.println("✅ Comentário deletado com sucesso.");
            } else {
                System.out.println("Ação cancelada.");
            }
        } else {
            System.out.println(" Não existe um comentário com esse número.");
        }
    }

    private void executarAvaliacaoDePost(Post post) {
        for (Avaliacao avaliacao : post.getAvaliacoes()) {
            if (avaliacao.getAutor().equals(usuarioLogado)) {
                System.out.println(" Você já avaliou este post.");
                return;
            }
        }

        System.out.print("Digite uma nota de 1 a 5 para o post: ");
        String entrada = scanner.nextLine();
        if (Validador.isStringInteiroValido(entrada)) {
            int nota = Integer.parseInt(entrada);
            if (nota >= 1 && nota <= 5) {
                post.avaliar(nota, this.usuarioLogado);
                System.out.println(" Avaliação registrada com sucesso!");
            } else {
                System.out.println(" Nota inválida. Deve ser entre 1 e 5.");
            }
        } else {
            System.out.println(" Erro: Por favor, digite apenas um número.");
        }
    }

    public void adicionarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    //este método contém a lógica de criação do usuário
    public void executarCadastroDeUsuario() {
            System.out.println("\n=== Criar Novo Usuário ===");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            String nickname;
            while (true) {
                System.out.print("Nickname (único): ");
                nickname = scanner.nextLine();
                if (Validador.ehNicknameDisponivel(nickname, this.usuarios)) {
                    break;
                } else {
                    System.out.println(" Erro: Esse nickname já está em uso. Tente outro.");
                }
            }

            String senha;
            while (true) {
                System.out.print("Senha (mín. 6 caracteres): ");
                senha = scanner.nextLine();
                if (Validador.ehSenhaValida(senha)) {
                    break;
                } else {
                    System.out.println(" Erro: A senha deve ter pelo menos 6 caracteres.");
                }
            }

            System.out.print("Bio: ");
            String bio = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Localização: ");
            String localizacao = scanner.nextLine();

            PerfilUsuario perfil = new PerfilUsuario(bio, telefone, localizacao);
            Usuario novoUsuario = new UsuarioComum(nome, nickname, senha, perfil);

            this.adicionarUsuario(novoUsuario);
            System.out.println("\n Usuário '" + nickname + "' criado com sucesso! Agora você pode fazer login.");
    }

    private void executarComentarioEmPost(Post post) {
        System.out.println("\n--- Novo Comentário ---");
        System.out.print("Digite seu comentário: ");
        String texto = scanner.nextLine();

        if (texto.trim().isEmpty()) {
            System.out.println("Comentário vazio não permitido.");
            return;
        }

        Comentario comentario = new Comentario(usuarioLogado, texto);
        post.adicionarComentario(comentario);
        //this.posts.add(post);

        System.out.println("Comentário adicionado com sucesso!");
    }

    /*
     Gerencia a lógica de escolher um comentário e votar nele (Upvote/Downvote).
      post: O post que contém os comentários.
     */
    private void executarVotoEmComentario(Post post) {
        System.out.print("Digite o número do comentário em que deseja votar (ex: 1): ");
        String entradaComentario = scanner.nextLine();
        if (!Validador.isStringInteiroValido(entradaComentario)) {
            System.out.println(" Número inválido.");
            return;
        }
        int numComentario = Integer.parseInt(entradaComentario);

        if (numComentario < 1 || numComentario > post.getComentarios().size()) {
            System.out.println(" Não existe um comentário com esse número.");
            return;
        }

        //pega o comentário escolhido
        Comentario comentarioAlvo = post.getComentarios().get(numComentario - 1);

        System.out.print("O que você quer dar? (1 para Upvote, 2 para Downvote): ");
        String entradaVoto = scanner.nextLine();
        if (!Validador.isStringInteiroValido(entradaVoto)) {
            System.out.println(" Opção de voto inválida.");
            return;
        }
        int tipoVoto = Integer.parseInt(entradaVoto);

        if (tipoVoto == 1) {
            //passamos o usuário logado para o método
            comentarioAlvo.darUpvote(this.usuarioLogado);
            System.out.println(" Voto registrado!");
        } else if (tipoVoto == 2) {
            // passamos o usuário logado para o método
            comentarioAlvo.darDownvote(this.usuarioLogado);
            System.out.println(" Voto registrado!");
        } else {
            System.out.println(" Opção de voto inválida.");
        }
    }
}
