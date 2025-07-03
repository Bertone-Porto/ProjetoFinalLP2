package gameforge;

import java.util.List;

//classe para validar processos como login, se é permitido excluir post, comentários, etc
public class Validador {


    //autenticar senha seria algo assim
    /*public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }*/
    public static void validarSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve ter pelo menos 6 caracteres.");
        }
    }

    public static void validarNicknameUnico(String nickname, List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getNickname().equalsIgnoreCase(nickname)) {
                throw new IllegalArgumentException("Nickname já está em uso.");
            }
        }
    }
}
