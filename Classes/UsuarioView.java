public class UsuarioView {
    public void exibirStatus(Usuario usuarioModel) {
        System.out.println("Status do Usuário:");
        System.out.println("Nome: " + usuarioModel.getNome());
        System.out.println("Nível: " + usuarioModel.getNivel());
        System.out.println("Card Coins: " + usuarioModel.getCardCoins());
        System.out.println("Idade: " + usuarioModel.getIdade());
        System.out.println("Sexo: " + usuarioModel.getSexo());
        System.out.println("E-mail: " + usuarioModel.getEmail());
    }

    public void exibirDecks(Usuario usuarioModel) {
        System.out.println("Decks do Usuário:");
        Deck[] decks = usuarioModel.getDecks();
        for (int i = 0; i < decks.length; i++) {
            if (decks[i] != null) {
                System.out.println("Deck " + (i + 1) + ": " + decks[i].getNome());
            }
        }
    }
}
