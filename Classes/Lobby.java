public class Lobby {
    
    private Usuario[] jogadores;
    private int numJogadores;
    
   
    public Usuario[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Usuario[] jogadores) {
        this.jogadores = jogadores;
  
    public int getNumJogadores() {
        return numJogadores;
    }

    public void setNumJogadores(int numJogadores) {
        this.numJogadores = numJogadores;

    public Lobby(int maxJogadores) {
        jogadores = new Usuario[maxJogadores];
        numJogadores = 0;
    }   
}