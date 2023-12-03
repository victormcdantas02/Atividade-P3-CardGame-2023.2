public class BoosterPlusController extends BoosterController {
    private BoosterPlusModel boosterPlusModel;
    private BoosterPlusView boosterPlusView;

    public BoosterPlusController(BoosterPlusModel boosterPlusModel, BoosterPlusView boosterPlusView) {
        super(boosterPlusModel, boosterPlusView);
        this.boosterPlusModel = boosterPlusModel;
        this.boosterPlusView = boosterPlusView;
    }

    public void gerarEExibirCartaUnica() {
        Carta cartaUnica = boosterPlusModel.gerarCartaUnica();
        boosterPlusView.exibirCartaUnica(cartaUnica);
    }
}
