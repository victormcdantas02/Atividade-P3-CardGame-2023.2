<<<<<<< HEAD
public enum Raridade {
=======
import java.util.Random;

public class Raridade {
    public enum Enumerate{
>>>>>>> 1fbf22bd2aa7b441c09c151f873a553bab4ec136
    COMUM(80),
    INCOMUM(15),
    RARA(4),
    MUITO_RARA(0.8),
    EPICA(0.2);

    private final double probabilidade;

<<<<<<< HEAD
    private Raridade(double probabilidade) {
=======
    private Enumerate(double probabilidade) {
>>>>>>> 1fbf22bd2aa7b441c09c151f873a553bab4ec136
        this.probabilidade = probabilidade;
    }

    public double getProbabilidade() {
        return probabilidade;
<<<<<<< HEAD
    }
}
=======
        }
    }
}
>>>>>>> 1fbf22bd2aa7b441c09c151f873a553bab4ec136
