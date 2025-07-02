package gameforge;
//Usuário administrador: pode gerenciar postagens e usuários

public class UsuarioAdmin extends Usuario{
    public UsuarioAdmin(String nome, PerfilUsuario perfil) {
        super(nome, perfil);
    }

    @Override
    public void mostrarPermissoes() {
        // exibe permissões do administrador
    }

    // métodos administrativos adicionais (remover post, etc.)
}
