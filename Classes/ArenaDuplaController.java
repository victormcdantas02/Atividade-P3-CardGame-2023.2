import java.util.Random;
import java.util.Scanner;

public class ArenaDuplaController {
    private ArenaDupla arenaDupla;
    private ArenaDuplaView arenaDuplaView;
    private Scanner scanner;

    public ArenaDuplaController(ArenaDupla arenaDupla, ArenaDuplaView arenaDuplaView) {
        this.arenaDupla = arenaDupla;
        this.arenaDuplaView = arenaDuplaView;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarPartida() {
        int primeiroJogador = arenaDupla.inicio();
        arenaDuplaView.exibirInformacoesArena(arenaDupla);

        int rodada = 1;
        while (true) {
            System.out.println("Rodada " + rodada);
            realizarTurno(primeiroJogador);
            arenaDuplaView.exibirInformacoesArena(arenaDupla);

            if (verificarFimDeJogo()) {
                break;
            }

            rodada++;
        }
    }

    private void realizarTurno(int jogador) {
        sacarCartas(jogador);
        arenaDuplaView.exibirInformacoesArena(arenaDupla);

        System.out.println("Turno do Jogador " + jogador);
        arenaDupla.turno(jogador);
        arenaDuplaView.exibirInformacoesArena(arenaDupla);

        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    private void sacarCartas(int jogador) {
        if (jogador == 1) {
            arenaDupla.sacarCartas(arenaDupla.getJogador1());
        } else if (jogador == 2) {
            arenaDupla.sacarCartas(arenaDupla.getJogador2());
        } else if (jogador == 3) {
            arenaDupla.sacarCartas(arenaDupla.getJogador3());
        } else if (jogador == 4) {
            arenaDupla.sacarCartas(arenaDupla.getJogador4());
        } else {
            throw new IllegalArgumentException("Número de jogador inválido.");
        }
    }

    private boolean verificarFimDeJogo() {
        //Ainda Não conseguir fazer esse método
        return false;
    }
}
