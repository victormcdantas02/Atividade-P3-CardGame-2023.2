public class ArenaController {
    private Arena arena;
    private ArenaView arenaView;

    public ArenaController(Arena arena, ArenaView arenaView) {
        this.arena = arena;
        this.arenaView = arenaView;
    }

    public void realizarTurno(int jogador) {
        arena.turno(jogador);
        arenaView.exibirEstadoAtual(arena);
    }
}
