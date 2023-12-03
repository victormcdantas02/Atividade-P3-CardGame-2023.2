public class PassePremiumView {
    public void exibirStatus(PassePremium passePremiumModel) {
        System.out.println("Status do Passe Premium:");
        System.out.println("Nível: " + passePremiumModel.getNivel());
    }

    public void exibirConclusaoPasse() {
        System.out.println("Parabéns! Você concluiu o Passe Premium.");
    }
}
