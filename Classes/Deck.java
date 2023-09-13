import java.util.ArrayList;
import java.util.List;

public class Deck {
    private String nome;
    private int quantidadeCartas;
    private boolean disponibilidade;
    private List<Carta> cartas;

    public Deck(String nome) {
        this.nome = nome;
        this.quantidadeCartas = 0;
        this.disponibilidade = false;
        this.cartas = new ArrayList<>();
       }

    //Metodo GET
    public String getNome(){
        return nome;
    }
    public int quantidadeCartas(){
        return quantidadeCartas;
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
    public void setQuantidadeCartas(int quantidadeCartas){
        this.quantidadeCartas = quantidadeCartas;
    }
    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }
    public void setCartas(List<Carta> cartas){
        this.cartas = cartas;
    }
}