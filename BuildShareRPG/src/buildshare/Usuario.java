package buildshare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario {
    private String nome;
    private List<Build> buildsCriadas = new ArrayList<>();
    private Set<Build> buildsFavoritas = new HashSet<>();

    public Usuario(String nome){
        this.nome = nome;
    }
    public void criarBuild(Build build){
        buildsCriadas.add(build);
    }
    public void favoritar(Build build){
        buildsFavoritas.add(build);
        build.adicionarFavoritador(this);
    }
    public String getNome(){
        return nome;
    }
    public List<Build> getBuildsCriadas(){
        return buildsCriadas;
    }
}
