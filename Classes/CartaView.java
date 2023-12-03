public class CartaView {
    public void exibirDetalhesCarta(Carta carta) {
        System.out.println("Detalhes da Carta:");
        System.out.println("Nome: " + carta.getNome());
        System.out.println("Imagem: " + carta.getImagem());
        System.out.println("Tipo: " + carta.getTipo());
        System.out.println("Raridade: " + carta.getRaridade());
        System.out.println("Ataque: " + carta.getAtaque());
        System.out.println("Defesa: " + carta.getDefesa());
        System.out.println("Custo: " + carta.getCusto());
        System.out.println("Pode Atacar: " + (carta.podeAtacar() ? "Sim" : "Não"));
        System.out.println("Quantidade no Deck: " + carta.getQuantidade());
        System.out.println("Valor em CardCoins: " + carta.getValorEmCardCoins());

        HabilidadeC habilidade = carta.getHabilidade();
        if (habilidade != null) {
            System.out.println("Habilidade: ");
        } else {
            System.out.println("Habilidade: Nenhuma");
        }
    }
}
