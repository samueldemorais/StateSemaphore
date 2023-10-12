public class Amarelo implements State{
    private Semaforo semaforo;
    public Sinal sinal;
    
    public Amarelo(Semaforo semaforo, Sinal sinal) {
        this.semaforo = semaforo;
    }
    
    public Sinal getEstado() {
         return Sinal.AMARELO;
    }
    
    public void efetuarTransicao() {
        semaforo.changeState(new Vermelho(semaforo, Sinal.VERMELHO));
    }
    
    public int getTempoTransicao() {
        return semaforo.transicao.get(sinal);
    }

    public String getAcao() {
        return sinal.name().toLowerCase();
    }
    
}
