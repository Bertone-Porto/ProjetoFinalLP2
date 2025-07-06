package gameforge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Classe abstrata representando um usuário da plataforma

public abstract class Usuario {
    protected String nome;
    protected String senha;
    protected String nickname; // nome único (@)
    protected PerfilUsuario perfil;
    protected List<Post> postsCriados;
    protected Set<Post> postsFavoritos;

    public Usuario(String nome, String nickname, String senha, PerfilUsuario perfil) {
        this.nome = nome;
        this.nickname = nickname;
        this.senha = senha;
        this.perfil = perfil;

        this.postsCriados = new ArrayList<>();
        this.postsFavoritos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public String getNickname() {
        return nickname;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public boolean autenticar(String senhaDigitada) {
        //compara a senha armazenada com a senha fornecida
        return this.senha.equals(senhaDigitada);
    }

    public abstract void mostrarPermissoes();

    @Override
    public String toString() {
        return "Usuário: " + nickname + " (" + nome + ")\n" + perfil.toString();
    }
}
