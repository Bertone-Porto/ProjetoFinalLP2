package gameforge.model;

//Usuário comum: pode postar, comentar, avaliar e favoritar

public class UsuarioComum extends Usuario{
    public UsuarioComum(String nome, String nickname, String senha, PerfilUsuario perfil) {
        super(nome, nickname, senha, perfil);
    }

    @Override
    public void mostrarPermissoes() {
        System.out.println("Permissões: criar posts, comentar, favoritar, avaliar.");
    }

}
