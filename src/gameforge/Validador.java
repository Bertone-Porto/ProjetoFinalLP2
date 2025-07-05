package gameforge;

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
}
