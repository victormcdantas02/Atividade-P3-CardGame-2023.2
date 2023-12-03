public class PassePremium extends Progresso{
    private int nivel;

    public PassePremium() {
        super();
        this.nivel = 0;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public void entregarPremiacao(Usuario user) {
        if (nivel % 5 == 0) {
            // Prêmio especial (booster especial) a cada 5 níveis
            BoosterPlusModel boosterEspecial = new BoosterPlusModel();
            Carta cartaEspecial = boosterEspecial.gerarCartaAleatoria();
            
            Inventario inventarioUsuario = user.getInventario();
            boolean adicionadaComSucesso = inventarioUsuario.adicionarCarta(cartaEspecial);

            if (adicionadaComSucesso) {
                System.out.println("Carta especial adicionada ao inventário do jogador: " + cartaEspecial.getNome());
            } else {
                System.out.println("Não foi possível adicionar a carta especial ao inventário. O inventário pode estar cheio.");
            }
        } else {
            
            Booster boosterComum = new Booster();
            Carta cartaComum = boosterComum.gerarCartaAleatoria();
            
            Inventario inventarioUsuario = user.getInventario();
            boolean adicionadaComSucesso = inventarioUsuario.adicionarCarta(cartaComum);

            if (adicionadaComSucesso) {
                System.out.println("Carta comum adicionada ao inventário do jogador: " + cartaComum.getNome());
            } else {
                System.out.println("Não foi possível adicionar a carta comum ao inventário. O inventário pode estar cheio.");
            }
        }
    }

    @Override
    public void progresso(Usuario user) {
        nivel += 2;
        user.setNivel(nivel);
        System.out.println("Você ganhou duas vitórias! Nível do passe: " + nivel);

        if (user.getNivel()>= premiacoes.length) {
            System.out.println("Passe de batalha concluído. Você não ganhará mais premiações.");
            nivel = 0;
        } else {
            entregarPremiacao(user);
        }
    }

    public boolean isTerminado() {
        return false;
    }
}
