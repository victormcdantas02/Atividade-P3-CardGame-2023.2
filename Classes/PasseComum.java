public class PasseComum extends Progresso {
    public int nivel;
    public boolean terminado;

    public PasseComum() {
        super();
        this.nivel = 0;
        this.terminado = false;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    @Override
    public void entregarPremiacao(Usuario user) {
        if (!terminado) {
            Booster boosterPasseComum = new Booster();

             // Gere uma carta aleatória diretamente do Booster
             Carta cartaAleatoria = boosterPasseComum.gerarCartaAleatoria();
 
             // Acesse o inventário do usuário e adicione a carta gerada
             Inventario inventarioUsuario = user.getInventario();
             boolean adicionadaComSucesso = inventarioUsuario.adicionarCarta(cartaAleatoria);

             if (adicionadaComSucesso) {
                System.out.println("Carta adicionada ao inventário do jogador: " + cartaAleatoria.getNome());
            } else {
                System.out.println("Não foi possível adicionar a carta ao inventário. O inventário pode estar cheio.");
            }
        }
    }
    

    @Override
    public void progresso(Usuario user) {
        // Uma vitória aumenta um nível no passe de batalha
        nivel++;
        user.setNivel(nivel);
        System.out.println("Você ganhou uma vitória! Nível do passe: " + nivel);

        if (user.getNivel() >= premiacoes.length) {
            System.out.println("Passe de batalha concluído. Você não ganhará mais premiações.");
            setTerminado(true);
        } else {
            entregarPremiacao(user);
        }
    }
}

