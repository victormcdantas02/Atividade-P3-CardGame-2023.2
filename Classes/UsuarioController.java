public class UsuarioController {
    private Usuario usuario;
    private UsuarioView usuarioView;

    public UsuarioController(Usuario usuario, UsuarioView usuarioView) {
        this.usuario = usuario;
        this.usuarioView = usuarioView;
    }

    public void exibirStatus() {
        usuarioView.exibirStatus(usuario);
    }

    public void exibirDecks() {
        usuarioView.exibirDecks(usuario);
    }
}
