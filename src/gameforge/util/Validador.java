package gameforge.util;

import gameforge.model.*;
import java.util.List;

//classe para validar processos como login, se é permitido excluir post, comentários, etc
public class Validador {

    /*
      verifica se a senha atende aos critérios de segurança (tamanho mínimo)
      a senha a ser validada
      return true se a senha for válida, false caso contrário
     */
    public static boolean ehSenhaValida(String senha) {
        return senha != null && senha.length() >= 6;
    }

    /*
      verifica se um nickname já existe na lista de usuários
      nickname a ser verificado
      a lista completa de usuários do sistema
      return true se o nickname estiver disponível, false se já estiver em uso
     */
    public static boolean ehNicknameDisponivel(String nickname, List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getNickname().equalsIgnoreCase(nickname)) {
                return false; //nckname já existe, portanto não está disponível
            }
        }
        return true; //percorreu todos e não encontrou, está disponível
    }

    /**
     Verifica se uma String contém apenas dígitos numéricos
     A String a ser verificada
     return true se a string for um número inteiro válido, false caso contrário
     */
    public static boolean isStringInteiroValido(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false; //não é válido se for nulo ou vazio
        }
        //percorre cada caractere da string
        for (char c : s.toCharArray()) {
            //se encontrar qualquer caractere que não seja um dígito...
            if (!Character.isDigit(c)) {
                return false; // ...a string não é um inteiro válido.
            }
        }
        return true; //se percorreu tudo e só encontrou dígitos, é válido.
    }
}
