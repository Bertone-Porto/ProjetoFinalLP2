package gameforge.model;
//Informações pessoais do usuário. Associado 1:1 com Usuario

public class PerfilUsuario {
    private String bio;
    private String telefone;
    private String localizacao;

    public PerfilUsuario(String bio, String telefone, String localizacao) {
        this.bio = bio;
        this.telefone = telefone;
        this.localizacao = localizacao;
    }

    public String getBio() {
        return bio;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    @Override
    public String toString() {
        return "Bio: " + bio + "\nTelefone: " + telefone + "\nLocalização: " + localizacao;
    }

}
