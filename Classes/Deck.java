import java.util.ArrayList;
import java.util.List;

public class Deck {
    private String nome;
    private int quantCartas;
    private boolean disponibilidade;
    private List<Carta> cartas;

    public Deck(String nome) {
        this.nome = nome;
        this.quantCartas = quantCartas;
        this.disponibilidade = false;
        this.cartas = new ArrayList<>();
    }

    public void compraDeBooster(Usuario usuario) {

    }

    //Metodo GET
    public String getNome(){
        return nome;
    }
    public int quantidadeDeCartas(){
        return quantCartas;
    }
    public boolean disponibilidade(){
        return disponibilidade;
    }
    public List<Carta> getCartas(){
        return cartas;
    }

    //Metodo SET
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setQuantidadeDeCartas(int quantCartas){
        this.quantCartas = quantCartas;
    }
    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }
    public void setCartas(List<Carta> cartas){
        this.cartas = cartas;
    }
}