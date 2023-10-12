public interface State {
    Sinal getEstado();
    void efetuarTransicao();
    int getTempoTransicao();
    String getAcao();
}




