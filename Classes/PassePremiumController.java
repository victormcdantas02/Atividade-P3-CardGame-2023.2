public class PassePremiumController {
    private PassePremium passePremium;
    private PassePremiumView passePremiumView;

    public PassePremiumController(PassePremium passePremium, PassePremiumView passePremiumView) {
        this.passePremium = passePremium;
        this.passePremiumView = passePremiumView;
    }

    public void iniciarPassePremium(Usuario usuario) {
        if (!passePremium.isTerminado()) {
            passePremium.progresso(usuario);

            // Exiba o status atual do passe premium
            passePremiumView.exibirStatus(passePremium);

            // Verifique se o passe premium foi concluído
            if (passePremium.isTerminado()) {
                // Entregue a premiação final
                passePremium.entregarPremiacao(usuario);
                passePremiumView.exibirConclusaoPasse();
            }
        } else {
            System.out.println("O Passe Premium já foi concluído.");
        }
    }
}
