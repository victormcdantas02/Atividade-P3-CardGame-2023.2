import java.util.Random;

public class Booster {
    public Carta gerarCartaAleatoria(Inventario inventario) {
        Random random = new Random();
        double valorAleatorio = random.nextDouble() * 100;

        if (valorAleatorio <= Raridade.COMUM.getProbabilidade()) {
            return new Carta(false, "NomeComum", "ImagemComum", "TipoComum", Raridade.COMUM, null, 1, 1, 1, 1);
        } else if (valorAleatorio <= Raridade.INCOMUM.getProbabilidade()) {
            return new Carta(false, "NomeIncomum", "ImagemIncomum", "TipoIncomum", Raridade.INCOMUM, null, 2, 2, 2, 2);
        } else if (valorAleatorio <= Raridade.RARA.getProbabilidade()) {
            return new Carta(false, "NomeRara", "ImagemRara", "TipoRara", Raridade.RARA, null, 3, 3, 3, 3);
        } else if (valorAleatorio <= Raridade.MUITO_RARA.getProbabilidade()) {
            return new Carta(false, "NomeMuitoRara", "ImagemMuitoRara", "TipoMuitoRara", Raridade.MUITO_RARA, null, 4, 4, 4, 4);
        } else {
            return new Carta(false, "NomeUnica", "ImagemUnica", "TipoUnica", Raridade.EPICA, null, 5, 5, 5, 5);
        }
    }
}