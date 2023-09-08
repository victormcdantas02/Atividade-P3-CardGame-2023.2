public class Loja {
    
    private String numeroCartao;
   

    private String codigoVerificador;

    public Loja(String numeroCartao, String codigoVerificador) {
        this.numeroCartao = numeroCartao;
        this.codigoVerificador = codigoVerificador;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }
    
    public void compraDeBooster(Usuario usuario, int cardcoins) {    
        if (usuario.getCardcoins() >= cardcoins) {
            usuario.setCardcoins(cardcoins);
            System.out.println("Compra de booster bem-sucedida para o usuário: " + usuario.getUser());
       }
       else{
        System.out.println("Cartões insuficientes. Não é possível comprar um booster para o usuário: " + usuario.getUser());
       }  
    }
} 
