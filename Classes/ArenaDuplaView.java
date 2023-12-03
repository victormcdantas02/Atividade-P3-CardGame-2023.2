public class ArenaDuplaView{
    public void exibirInformacoesArena(ArenaDupla arenaDupla) {
        System.out.println("----- Informações da Arena Dupla -----");
        exibirJogadores(arenaDupla);
        exibirCampoDeJogo(arenaDupla);
        System.out.println("--------------------------------------");
    }

    private void exibirJogadores(ArenaDupla arenaDupla) {
        System.out.println("Jogadores:");
        System.out.println("1. " + arenaDupla.getJogador1().getNome());
        System.out.println("2. " + arenaDupla.getJogador2().getNome());
        System.out.println("3. " + arenaDupla.getJogador3().getNome());
        System.out.println("4. " + arenaDupla.getJogador4().getNome());
    }

    private void exibirCampoDeJogo(ArenaDupla arenaDupla) {
        System.out.println("\nCampo de Jogo:");
        exibirCampo(arenaDupla.campoJogador1(), "Jogador 1");
        exibirCampo(arenaDupla.campoJogador2(), "Jogador 2");
        exibirCampo(arenaDupla.getCampoJogador3(), "Jogador 3");
        exibirCampo(arenaDupla.getCampoJogador4(), "Jogador 4");
    }

    private void exibirCampo(Carta[][] campo, String nomeJogador) {
        System.out.println(nomeJogador + ":");
        for (int linha = 0; linha < campo.length; linha++) {
            for (int coluna = 0; coluna < campo[linha].length; coluna++) {
                Carta carta = campo[linha][coluna];
                if (carta != null) {
                    System.out.print(carta.getNome() + "\t");
                } else {
                    System.out.print("[Vazio]\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
