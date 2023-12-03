public class BoosterController {
     private Booster Booster;
     private BoosterView boosterView;
    
    public BoosterController(Booster booster, BoosterView boosterView) {
        this.Booster = booster;
         this.boosterView = boosterView;
     }
    
    public void gerarEExibirCartaAleatoria() {
          Carta cartaGerada = Booster.gerarCartaAleatoria();
          boosterView.exibirCartaGerada(cartaGerada);
     }
}
