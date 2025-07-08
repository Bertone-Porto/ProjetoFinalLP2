package gameforge.model;
//Gêneros de jogos possíveis nas ideias

public enum Genero {
        RPG("Role Playing Game"),
        FPS("First Person Shooter"),
        PUZZLE("Jogo de Quebra-Cabeça"),
        ESTRATEGIA("Estratégia Tática"),
        SANDBOX("Mundo Aberto"),
        AVENTURA("Exploração e Missões");

        private String descricao;

        private Genero(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }

}
