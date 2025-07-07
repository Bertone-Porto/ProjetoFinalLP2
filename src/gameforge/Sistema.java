package gameforge;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//classe principal que gerencia a execução do programa, menus e dados
public class Sistema {
    private Usuario usuarioLogado; //atributo para controlar quem está logado
    private List<Usuario> usuarios;
    private Scanner scanner; // O scanner agora é um atributo da classe
    private List<Post> posts;


    //construtor para inicializar o estado do sistema
    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.usuarioLogado = null; //começa sem ninguém logado
        this.posts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
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
            int opcao = Integer.parseInt(scanner.nextLine());

            if (opcao == 1) {
                executarLogin();
            } else if (opcao == 2) {
                executarCadastroDeUsuario();
            } else if (opcao == 3) {
                System.out.println("Saindo do sistema... Até logo!");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
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
            System.out.println("2. Procurar Post por Gênero");
            System.out.println("3. Deslogar");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1: //criação post aqui
                    executarCriacaoDePost();
                    break;
                case 2: //procura post aqui
                    executarBuscaDePost();
                    break;
                case 3://deslogar
                    System.out.println("Deslogando...");
                    this.usuarioLogado = null;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }


    //      Lida com todo o fluxo de criação de um novo post.
    //      (A ser implementado)
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
        posts.add(novoPost);

        System.out.println("Post criado com sucesso!");
    }


    //      lida com o fluxo de busca de posts por gênero.
    private void executarBuscaDePost() {
        System.out.println("\n--- Gêneros Disponíveis ---");
        for (int i = 0; i < Genero.values().length; i++) {
            System.out.println((i + 1) + ". " + Genero.values()[i].toString());
        }

        System.out.print("Escolha o número do gênero que deseja procurar: ");
        int escolhaGenero = Integer.parseInt(scanner.nextLine());

        if (escolhaGenero >= 1 && escolhaGenero <= Genero.values().length) {
            Genero generoEscolhido = Genero.values()[escolhaGenero - 1];
            //inicia a navegação na primeira página (página 0)
            exibirPaginaDePosts(generoEscolhido, 0);
        } else {
            System.out.println(" Opção de gênero inválida.");
        }
    }

    /*
      exibe uma página de resultados e o menu de navegação
      genero O gênero que está sendo buscado
      pagina O número da página atual (começando em 0)
     */
    private void exibirPaginaDePosts(Genero genero, int pagina) {
        // 1. filtra a lista principal de posts para pegar apenas os do gênero escolhido
        List<Post> postsFiltrados = new ArrayList<>();
        for (Post post : this.posts) {
            if (post.getGenero() == genero) {
                postsFiltrados.add(post);
            }
        }

        // 2.verifica se a busca retornou algum resultado
        if (postsFiltrados.isEmpty()) {
            System.out.println("\nNenhum post encontrado para o gênero '" + genero.getDescricao() + "'.");
            return; // Volta para o menu anterior.
        }

        while (true) {
            System.out.println("\n--- Exibindo Posts de '" + genero.getDescricao() + "' (Página " + (pagina + 1) + ") ---");

            int inicio = pagina * 3;

            //pega os 3 posts da página atual
            List<Post> postsDaPagina = new ArrayList<>();
            for (int i = inicio; i < inicio + 3 && i < postsFiltrados.size(); i++) {
                postsDaPagina.add(postsFiltrados.get(i));
            }

            if (postsDaPagina.isEmpty()) {
                System.out.println("Não há mais posts para exibir nesta página.");
                pagina--; //volta para a página anterior
                continue; //recomeça o loop na página anterior
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

            int escolhaAcao = Integer.parseInt(scanner.nextLine());

            switch (escolhaAcao) {
                case 1:
                    System.out.print("Digite o número do post que deseja ver: ");
                    int numPost = Integer.parseInt(scanner.nextLine());
                    if (numPost >= 1 && numPost <= postsDaPagina.size()) {
                        //passa o objeto Post de verdade para o método de detalhes
                        exibirDetalhesDoPost(postsDaPagina.get(numPost - 1));
                    } else {
                        System.out.println(" Número de post inválido.");
                    }
                    break;
                case 2:
                    pagina++;
                    break;
                case 3:
                    return;
                default:
                    System.out.println(" Opção inválida.");
            }
        }
    }

    /*
      exibe os detalhes de um post específico e o menu de interação
      postPlaceholder: nome do post selecionado.
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
            System.out.println("----------------------------------------------");
            System.out.println("1. Comentar neste post");
            System.out.println("2. Exibir comentarios do post");
            System.out.println("3. Avaliar este post");
            System.out.println("4. Voltar para a lista de posts");
            System.out.print("Escolha uma opção: ");

            int escolhaAcao = Integer.parseInt(scanner.nextLine());

            switch (escolhaAcao) {//falta implementar essa parte toda
                case 1:
                    executarComentarioEmPost(post);
                    break;

                case 2:
                    post.printarComentarios();
                    break;

                case 3:
                    executarAvaliacaoDePost(post);
                    break;

                case 4:
                    return; //sai deste método e volta para a tela de paginação de posts

                default:
                    System.out.println(" Opção inválida.");
            }
        }
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

        this.usuarios.add(novoUsuario);
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
        this.posts.add(post);

        System.out.println("Comentário adicionado com sucesso!");
    }

    private void executarAvaliacaoDePost(Post post) {
        for (Avaliacao avaliacao : post.getAvaliacoes()) {
            if (avaliacao.getAutor().equals(usuarioLogado)) {
                System.out.println("Você já votou nesse post.");
                return; //nao permite avaliar duas vezes
            }
        }

        System.out.println("\n--- Avaliar Post ---");
        System.out.print("Digite uma nota de 1 a 5: ");

        int nota;
        try {
            nota = Integer.parseInt(scanner.nextLine());
            if (nota < 1 || nota > 5) {
                System.out.println("Nota inválida. Avaliação cancelada.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite apenas números de 1 a 5.");
            return;
        }

        Avaliacao avaliacao = new Avaliacao(nota, usuarioLogado);
        post.adicionarAvaliacao(avaliacao);

        System.out.println("Avaliação registrada com sucesso!");
    }




}
