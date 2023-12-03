import java.util.Scanner;

public class DeckView {
    private Scanner scanner;

    public DeckView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String obterNomeDoDeck() {
        System.out.print("Digite o nome do deck: ");
        return scanner.nextLine();
    }

    public int obterOpcaoDoMenu() {
        System.out.println("1. Adicionar carta ao deck");
        System.out.println("2. Remover carta do deck");
        System.out.println("3. Visualizar cartas do deck");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String obterNomeDaCarta() {
        System.out.print("Digite o nome da carta: ");
        return scanner.nextLine();
    }
}
