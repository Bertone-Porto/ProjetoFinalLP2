package gameforge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //teste de criação de usuário comentado abaixo
        /*
        List<Usuario> usuarios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Criar Novo Usuário ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Nickname (único): ");
        String nickname = sc.nextLine();

        boolean nicknameEmUso = false;
        for (Usuario u : usuarios) {
            if (u.getNickname().equalsIgnoreCase(nickname)) {
                nicknameEmUso = true;
                break;
            }
        }

        if (nicknameEmUso) {
            System.out.println("Erro: nickname já está em uso.");
            return;
        }

        System.out.print("Senha (mín. 6 caracteres): ");
        String senha = sc.nextLine();

        if (senha.length() < 6) {
            System.out.println("Erro: a senha deve ter pelo menos 6 caracteres.");
            return;
        }

        System.out.print("Bio: ");
        String bio = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Localização: ");
        String localizacao = sc.nextLine();

        PerfilUsuario perfil = new PerfilUsuario(bio, telefone, localizacao);

        Usuario novoUsuario = new UsuarioComum(nome, nickname, senha, perfil);
        usuarios.add(novoUsuario);

        System.out.println("\nUsuário criado com sucesso!");
        System.out.println(novoUsuario);*/
    }
}
