package gameforge.model;
//Usuário administrador: pode gerenciar postagens e usuários

public class UsuarioAdmin extends Usuario{
    public UsuarioAdmin(String nome, String nickname, String senha, PerfilUsuario perfil) {
        super(nome, nickname, senha, perfil);
    }

    @Override
    public void mostrarPermissoes() {
        System.out.println("Permissões: tudo do usuário comum + deletar posts/comentários.");
    }

    // métodos administrativos adicionais (remover post, etc.)
}
