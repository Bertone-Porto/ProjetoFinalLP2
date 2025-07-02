package buildshare;

import java.util.ArrayList;
import java.util.List;

public abstract class Build implements Avaliavel{
    protected Usuario criador;
    private List<Equipamento> equipamentos = new ArrayList<>();
    private List<String> estategia = new ArrayList<>();
    private List<Comentario> comentarios = new ArrayList<>();
    private List<Integer> notas = new ArrayList<>();
    private List<String> justificativas = new ArrayList<>();
    private List<Usuario> favoritadaPor = new ArrayList<>();
    private EstrategiaDetalhada estrategiaDetalhada;

    public abstract void mostrarResumo();


    public void adicionarFavoritador(Usuario usuario){

    }
    public void adicionarComentario(Comentario comentario){

    }

    @Override
    public void avaliar(int nota){

    }

    @Override
    public void avaliar(int nota, String comentario){

    }

    public String getNomeCriador(){
        return criador != null ? criador.getNome() : "Desconhecido";
    }

    @Override
    public double calcularMedia() {
        return notas.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

}
