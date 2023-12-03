public class LobbyView {
    public void exibirMensagemLobbyCheio() {
        System.out.println("Lobby cheio. Não é possível ingressar na partida.");
    }

    public void exibirInicioPartida(Usuario jogador1, Usuario jogador2) {
        System.out.println("Iniciando partida entre " + jogador1.getNome() + " e " + jogador2.getNome());
    }

    public void exibirMensagemModoDupla() {
        System.out.println("Não há jogadores suficientes para o modo de dupla.");
    }

    public void exibirEquipes(Usuario[] equipe1, Usuario[] equipe2) {
        System.out.println("Equipe 1:");
        exibirJogadores(equipe1);

        System.out.println("Equipe 2:");
        exibirJogadores(equipe2);
    }

    private void exibirJogadores(Usuario[] jogadores) {
        for (Usuario jogador : jogadores) {
            if (jogador != null) {
                System.out.println(jogador.getNome());
            }
        }
    }

    public void exibirMenu() {
    }
}
