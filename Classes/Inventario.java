public class Inventario {
    private String[] cartas; 
    private Usuario usuario; // Referência para o objeto de usuário

    public Inventario(Usuario usuario) {
        cartas = new String[200];
        this.usuario = usuario; // Armazena uma referência para o objeto de usuário
    }

    public String[] getCartas() {
        return cartas;
    }

    public int getNivelUsuario() {
        return usuario.getNivel(); // Obtém o nível do usuário a partir do objeto de usuário
    }

    public double getCardcoins() {
        return usuario.getCardcoins(); // Obtém a quantidade de cardcoins do usuário a partir do objeto de usuário
    }
    
}
