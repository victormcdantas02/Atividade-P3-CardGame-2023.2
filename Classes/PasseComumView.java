public class PasseComumView {
    public void exibirStatus(PasseComum passeComum) {
        System.out.println("----- Passe de Batalha Comum -----");
        System.out.println("Nível: " + passeComum.getNivel());
        System.out.println("Status: " + (passeComum.isTerminado() ? "Concluído" : "Em andamento"));
    }

    public void exibirPremiacaoEntregue(Carta carta) {
        System.out.println("Parabéns! Você recebeu a seguinte carta:");
        System.out.println("Nome: " + carta.getNome());
        System.out.println("Tipo: " + carta.getTipo());
    }

    public void exibirConclusaoPasse() {
        System.out.println("Parabéns! Você concluiu o Passe de Batalha Comum.");
    }

    public void exibirMensagemErroInventarioCheio() {
        System.out.println("Erro: Não foi possível adicionar a carta ao inventário. O inventário pode estar cheio.");
    }
}
