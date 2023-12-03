public class CartaUniqueView {
    public void exibirDetalhesCartaUnique(CartaUnique cartaUnique) {
        System.out.println("Detalhes da Carta Unique:");
        System.out.println("Nome: " + cartaUnique.getNome());
        System.out.println("Imagem: " + cartaUnique.getImagem());
        System.out.println("Tipo: " + cartaUnique.getTipo());
        System.out.println("Raridade: " + cartaUnique.getRaridade());
        System.out.println("Ataque: " + cartaUnique.getAtaque());
        System.out.println("Defesa: " + cartaUnique.getDefesa());
        System.out.println("Custo: " + cartaUnique.getCusto());
        System.out.println("Pode Atacar: " + (cartaUnique.podeAtacar() ? "Sim" : "Não"));
        System.out.println("Quantidade no Deck: " + cartaUnique.getQuantidade());
        System.out.println("Valor em CardCoins: " + cartaUnique.getValorEmCardCoins());
        System.out.println("Primeira Habilidade: " + (cartaUnique.getHabilidade() != null ? cartaUnique.getHabilidade() : "Nenhuma"));
        System.out.println("Segunda Habilidade: " + (cartaUnique.getHabilidadeExtra() != null ? cartaUnique.getHabilidadeExtra() : "Nenhuma"));
    }
}
