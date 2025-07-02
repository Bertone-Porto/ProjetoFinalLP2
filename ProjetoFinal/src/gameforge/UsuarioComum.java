package gameforge;
//Usuário comum: pode postar, comentar, avaliar e favoritar

public class UsuarioComum extends Usuario{
    public UsuarioComum(String nome, PerfilUsuario perfil) {
        super(nome, perfil);
    }

    @Override
    public void mostrarPermissoes() {
        // exibe permissões do usuário comum
    }

}
