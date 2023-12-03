import java.util.Scanner;

public class LobbyController {
    private Lobby lobby;
    private LobbyView lobbyView;

    public LobbyController(Lobby lobby, LobbyView lobbyView) {
        this.lobby = lobby;
        this.lobbyView = lobbyView;
    }

    public void iniciarLobby() {
        Scanner scanner = new Scanner(System.in);

        // Loop principal do lobby
        while (true) {
            lobbyView.exibirMenu();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Opção: Ingressar na partida
                    ingressarNaPartida();
                    break;
                case 2:
                    // Opção: Iniciar modo dupla
                    iniciarModoDupla();
                    break;
                case 3:
                    // Opção: Sair do lobby
                    System.out.println("Saindo do lobby. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void ingressarNaPartida() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do jogador:");
        String nomeJogador = scanner.nextLine();
        Usuario jogador = new Usuario(nomeJogador, nomeJogador, nomeJogador, nomeJogador, nomeJogador, 0, 0);

        lobby.joinGame(jogador);
    }

    private void iniciarModoDupla() {
        lobby.iniciarModoDupla();
    }
}
