package buildshare;

import java.util.ArrayList;
import java.util.List;

public class Comentario implements Avaliavel{
    private String texto;
    private List<Integer> avaliacoes = new ArrayList<>();

    public Comentario(String texto) {
        this.texto = texto;
    }

    @Override
    public void avaliar(int nota){

    }

    @Override
    public void avaliar(int nota, String comentario){

    }

    @Override
    public double calcularMedia(){

    }




}
