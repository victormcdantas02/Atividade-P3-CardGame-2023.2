public class PasseComumController {
    private PasseComum passeComum;
    private PasseComumView passeComumView;

    public PasseComumController(PasseComum passeComum, PasseComumView passeComumView) {
        this.passeComum = passeComum;
        this.passeComumView = passeComumView;
    }

    public void iniciarPasseComum(Usuario usuario) {
        // Verifique se o passe não está terminado antes de iniciar
        if (!passeComum.isTerminado()) {
            // Simule uma vitória para avançar no passe
            passeComum.progresso(usuario);

            // Exiba o status atual do passe
            passeComumView.exibirStatus(passeComum);

            // Verifique se o passe foi concluído
            if (passeComum.isTerminado()) {
                // Entregue a premiação final
                passeComum.entregarPremiacao(usuario);
                passeComumView.exibirConclusaoPasse();
            }
        } else {
            System.out.println("O Passe de Batalha Comum já foi concluído.");
        }
    }
}
