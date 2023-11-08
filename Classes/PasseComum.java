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
    public void entregarPremiacao() {
        if (!terminado) {
            Booster booster = new Booster();
             // Crie uma instância do Booster para gerar uma carta aleatória
             Booster boosterPasseComum = new Booster();

             // Gere uma carta aleatória diretamente do Booster
             Inventario cartaAleatoria = boosterPasseComum.gerarCartaAleatoria();
 
             // Acesse o inventário do usuário e adicione a carta gerada
             Inventario inventarioUsuario = usuario.getInventario();
             boolean adicionadaComSucesso = inventarioUsuario.adicionarCarta(cartaAleatoria);
        }
    }

    @Override
    public void progresso() {
        // Uma vitória aumenta um nível no passe de batalha
        nivel++;
        System.out.println("Você ganhou uma vitória! Nível do passe: " + nivel);

        if (nivel >= premiacoes.length) {
            System.out.println("Passe de batalha concluído. Você não ganhará mais premiações.");
            setTerminado(true);
        } else {
            entregarPremiacao();
        }
    }
}

