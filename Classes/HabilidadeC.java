<<<<<<< HEAD
public enum HabilidadeC {
    LAPADA("Lapada"),
    ESQUIVA("Esquiva"),
    PROVOCAR("Provocar"),
    CAMUFLAR("Camuflar"),
    RESISTIR("Resistir");

    private final String descricao;

    HabilidadeC(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
=======
public class HabilidadeC{
    public enum HabilidadeCart {
        Lapada,
        Esquiva,
        Atirar, 
        Provocar, // aumenta a chance de erro do proximo ataque aumenta
        Camuflar, // uma possibilade de conseguir se camuflar e o inimigo não lhe atacar
        Resistir; // pode reduzir a % do dano inimigo
    }
>>>>>>> 1fbf22bd2aa7b441c09c151f873a553bab4ec136
}