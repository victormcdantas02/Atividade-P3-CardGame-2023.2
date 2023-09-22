import java.util.Random;

public class Booster {
    private Carta[] cartas; // Cartas dentro do booster

    public Booster() {
        this.cartas = new Carta[12]; // Um booster contém 12 cartas
    }

    public void abrir() {
        Random random = new Random();

        for (int i = 0; i < cartas.length; i++) {
            // Gerar uma carta aleatória com base na probabilidade de raridade
            Carta cartaAleatoria = gerarCartaAleatoria(random.nextDouble());

            // Adicionar a carta ao booster
            cartas[i] = cartaAleatoria;
        }
    }

    private Carta gerarCartaAleatoria(double probabilidade) {
        // Verificar a probabilidade e determinar a raridade da carta
        if (probabilidade <= Raridade.EPICA.getProbabilidade()) {
            return gerarCartaRara();
        } else if (probabilidade <= Raridade.MUITO_RARA.getProbabilidade()) {
            return gerarCartaMuitoRara();
        } else if (probabilidade <= Raridade.RARA.getProbabilidade()) {
            return gerarCartaRara();
        } else if (probabilidade <= Raridade.INCOMUM.getProbabilidade()) {
            return gerarCartaIncomum();
        } else {
            return gerarCartaComum();
        }
    }

    private Carta gerarCartaComum() {
        // Lógica para gerar uma carta comum
        // ...

        return cartaComum;
    }

    private Carta gerarCartaIncomum() {
        // Lógica para gerar uma carta incomum
        // ...

        return cartaIncomum;
    }

    private Carta gerarCartaRara() {
        // Lógica para gerar uma carta rara
        // ...

        return cartaRara;
    }

    private Carta gerarCartaMuitoRara() {
        // Lógica para gerar uma carta muito rara
        // ...

        return cartaMuitoRara;
    }

    private Carta gerarCartaEpica() {
        // Lógica para gerar uma carta épica
        // ...

        return cartaEpica;
    }
}

