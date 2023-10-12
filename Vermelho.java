public class Vermelho implements State{
    private Semaforo semaforo;
    public Sinal sinal;
    
    public Vermelho(Semaforo semaforo, Sinal sinal) {
        this.semaforo = semaforo;
        this.sinal = sinal;
    }
    
    public Sinal getEstado() {
        return Sinal.VERMELHO;
    }
    
    public void efetuarTransicao() {
        semaforo.changeState(new Verde(semaforo, Sinal.VERDE));
    }
    
    public int getTempoTransicao() {
        return semaforo.transicao.get(sinal);
    }

    public String getAcao() {
        return sinal.name().toLowerCase();
    }

}