package gameforge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();


        // Criar 5 usuários
        Usuario u1 = new UsuarioComum("Alice", "alice", "senha123",
            new PerfilUsuario("Gamer de RPG", "1111-1111", "São Paulo"));
        sistema.adicionarUsuario(u1);
        
        Usuario u2 = new UsuarioComum("Bob", "bob", "senha123",
            new PerfilUsuario("Amante de FPS", "2222-2222", "Rio de Janeiro"));
        sistema.adicionarUsuario(u2);

        Usuario u3 = new UsuarioComum("Carol", "carol", "senha123",
            new PerfilUsuario("Indie developer", "3333-3333", "Curitiba"));
        sistema.adicionarUsuario(u3);

        Usuario u4 = new UsuarioComum("David", "david", "senha123",
            new PerfilUsuario("Streamer casual", "4444-4444", "Salvador"));
        sistema.adicionarUsuario(u4);

        Usuario u5 = new UsuarioComum("Eve", "eve", "senha123",
            new PerfilUsuario("Crítica de jogos", "5555-5555", "Porto Alegre"));
        sistema.adicionarUsuario(u5);

        // Criar 5 posts
        Post p1 = new Post("Aventura Épica", "RPG com mundos paralelos", Genero.RPG, u1);
        sistema.adicionarPost(p1);

        Post p2 = new Post("Tiroteio Total", "FPS futurista com gravidade zero", Genero.FPS, u2);
        sistema.adicionarPost(p2);

        Post p3 = new Post("Fazendinha Cósmica", "Fazenda no espaço", Genero.SANDBOX, u3);
        sistema.adicionarPost(p3);

        Post p4 = new Post("Puzzle Dimensional", "Quebra-cabeças com física", Genero.PUZZLE, u4);
        sistema.adicionarPost(p4);

        Post p5 = new Post("Xadrez de Dupla", "Duas partidas de Xadrez onde os jogadores alternam entre as duplas", Genero.ESTRATEGIA, u5);
        sistema.adicionarPost(p5);

        
        // Simular interações entre os usuários
        List<Usuario> usuarios = List.of(u1, u2, u3, u4, u5);
        List<Post> posts = List.of(p1, p2, p3, p4, p5);

        for (Usuario u : usuarios) {
            for (Post p : posts) {
                if (!p.getAutor().equals(u)) {
                    p.adicionarComentario(new Comentario(u, "Comentário automático do " + u.getNickname()));
                    p.adicionarAvaliacao(new Avaliacao((int)(Math.random() * 5) + 1, u));
                }
            }
        }

        // Mostrar resultados
        for (Post p : posts) {
            System.out.println("\n--- Post: " + p.getTitulo() + " ---");
            System.out.println("Autor: @" + p.getAutor().getNickname());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Gênero: " + p.getGenero().getDescricao());
            System.out.println("Média de Avaliações: " + p.calcularMedia());
            System.out.println("Comentários:");
            p.printarComentarios();
        }
    }
}
package gameforge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();


        // Criar 5 usuários
        Usuario u1 = new UsuarioComum("Alice", "alice", "senha123",
            new PerfilUsuario("Gamer de RPG", "1111-1111", "São Paulo"));
        sistema.adicionarUsuario(u1);
        
        Usuario u2 = new UsuarioComum("Bob", "bob", "senha123",
            new PerfilUsuario("Amante de FPS", "2222-2222", "Rio de Janeiro"));
        sistema.adicionarUsuario(u2);

        Usuario u3 = new UsuarioComum("Carol", "carol", "senha123",
            new PerfilUsuario("Indie developer", "3333-3333", "Curitiba"));
        sistema.adicionarUsuario(u3);

        Usuario u4 = new UsuarioComum("David", "david", "senha123",
            new PerfilUsuario("Streamer casual", "4444-4444", "Salvador"));
        sistema.adicionarUsuario(u4);

        Usuario u5 = new UsuarioComum("Eve", "eve", "senha123",
            new PerfilUsuario("Crítica de jogos", "5555-5555", "Porto Alegre"));
        sistema.adicionarUsuario(u5);

        // Criar 5 posts
        Post p1 = new Post("Aventura Épica", "RPG com mundos paralelos", Genero.RPG, u1);
        sistema.adicionarPost(p1);

        Post p2 = new Post("Tiroteio Total", "FPS futurista com gravidade zero", Genero.FPS, u2);
        sistema.adicionarPost(p2);

        Post p3 = new Post("Fazendinha Cósmica", "Fazenda no espaço", Genero.SANDBOX, u3);
        sistema.adicionarPost(p3);

        Post p4 = new Post("Puzzle Dimensional", "Quebra-cabeças com física", Genero.PUZZLE, u4);
        sistema.adicionarPost(p4);

        Post p5 = new Post("Xadrez de Dupla", "Duas partidas de Xadrez onde os jogadores alternam entre as duplas", Genero.ESTRATEGIA, u5);
        sistema.adicionarPost(p5);

        
        // Simular interações entre os usuários
        List<Usuario> usuarios = List.of(u1, u2, u3, u4, u5);
        List<Post> posts = List.of(p1, p2, p3, p4, p5);

        for (Usuario u : usuarios) {
            for (Post p : posts) {
                if (!p.getAutor().equals(u)) {
                    p.adicionarComentario(new Comentario(u, "Comentário automático do " + u.getNickname()));
                    p.adicionarAvaliacao(new Avaliacao((int)(Math.random() * 5) + 1, u));
                }
            }
        }

        // Mostrar resultados
        for (Post p : posts) {
            System.out.println("\n--- Post: " + p.getTitulo() + " ---");
            System.out.println("Autor: @" + p.getAutor().getNickname());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Gênero: " + p.getGenero().getDescricao());
            System.out.println("Média de Avaliações: " + p.calcularMedia());
            System.out.println("Comentários:");
            p.printarComentarios();
        }
    }
}
