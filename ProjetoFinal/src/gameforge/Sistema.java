package gameforge;
import java.util.List;

//Classe principal que gerencia a execução do programa
public class Sistema {
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.executar();
    }

    public void executar() {
        //menu principal: criar usuário, login, modo demonstração
    }

    //métodos auxiliares (buscar usuário, criar post, etc.)
}
