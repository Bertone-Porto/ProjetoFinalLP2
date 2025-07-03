package gameforge;
import java.util.List;
import java.util.Set;

//Classe abstrata representando um usuário da plataforma

public abstract class Usuario {
    protected String nome;
    protected PerfilUsuario perfil;
    protected List<Post> postsCriados;
    protected Set<Post> postsFavoritos;

    public Usuario(String nome, PerfilUsuario perfil) {
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public abstract void mostrarPermissoes();
}
