import java.util.Random;

public class BoosterPlus {
    public Carta gerarCartaUnica() {
        Random random = new Random();
        double valorAleatorio = random.nextDouble() * 100;

        if (valorAleatorio <= 1.0) { // 1% de probabilidade de ser única
            return new CartaUnique("NomeUnica", "ImagemUnica", "TipoUnica", Raridade.EPICA, null, 1, 1, 1, 1);
        } else {
            return null; // Não é uma carta única
        }
    }
}