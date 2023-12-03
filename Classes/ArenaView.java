public class ArenaView {
    public void exibirEstadoAtual(Arena arena) {
        exibirVidaDosJogadores(arena);
        exibirCampo(arena);
        exibirMao(arena);
        exibirManaMaxima(arena);
    }

    private void exibirVidaDosJogadores(Arena arena) {
        System.out.println("Vida do Jogador 1: " + arena.getPontosVidaJogador1());
        System.out.println("Vida do Jogador 2: " + arena.getPontosVidaJogador2());
    }

    private void exibirCampo(Arena arena) {
        exibirCampoDoJogador("Campo do Jogador 1", arena.campoJogador1());
        exibirCampoDoJogador("Campo do Jogador 2", arena.campoJogador2());
    }

    private void exibirCampoDoJogador(String nomeJogador, Carta[][] campo) {
        System.out.println(nomeJogador + ":");
        for (int linha = 0; linha < campo.length; linha++) {
            for (int coluna = 0; coluna < campo[linha].length; coluna++) {
                Carta carta = campo[linha][coluna];
                if (carta != null) {
                    System.out.print(carta.getNome() + " ");
                } else {
                    System.out.print("[Vazio] ");
                }
            }
            System.out.println(); 
        }
    }

    private void exibirMao(Arena arena) {
        exibirMaoDoJogador("Mão do Jogador 1", arena.getMaoJogador1());
        exibirMaoDoJogador("Mão do Jogador 2", arena.getMaoJogador2());
    }

    private void exibirMaoDoJogador(String nomeJogador, Carta[] mao) {
        System.out.println(nomeJogador + ":");
        for (int i = 0; i < mao.length; i++) {
            Carta carta = mao[i];
            if (carta != null) {
                System.out.print(carta.getNome() + " ");
            } else {
                System.out.print("[Vazio] ");
            }
        }
        System.out.println(); 
    }

    private void exibirManaMaxima(Arena arena) {
        System.out.println("Mana Máxima do Jogador 1: " + arena.getManaMaximaJogador1());
        System.out.println("Mana Máxima do Jogador 2: " + arena.getManaMaximaJogador2());
    }

    private void exibirCemiterio(Arena arena, int jogador) {
        Carta[] cemiterio = (jogador == 1) ? arena.getCemiterioJogador1() : arena.getCemiterioJogador2();
        System.out.println("Cemitério do Jogador " + jogador + ":");
        for (Carta carta : cemiterio) {
            if (carta != null) {
                System.out.print(carta.getNome() + " ");
            }
        }
        System.out.println();
    }

    public void exibirInformacoesCartaSelecionada(Carta carta) {
        if (carta != null) {
            System.out.println("Detalhes da Carta Selecionada:");
            System.out.println("Nome: " + carta.getNome());
            System.out.println("Ataque: " + carta.getAtaque());
            System.out.println("Defesa: " + carta.getDefesa());
        } else {
            System.out.println("Nenhuma carta selecionada.");
        }
    }

    public void exibirMensagemJogo(String mensagem) {
        System.out.println("Mensagem do Jogo: " + mensagem);
    }
}
