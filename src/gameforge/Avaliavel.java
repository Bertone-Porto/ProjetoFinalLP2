package gameforge;

//Interface para classes que podem ser avaliadas com nota.

public interface Avaliavel {
    void avaliar(int nota, Usuario avaliador);
    //void avaliar(int nota, String comentario, Usuario avaliador); // sobrecarga
    double calcularMedia();

}
