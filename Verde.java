public  class Verde implements State {
    private Semaforo semaforo;
    public Sinal sinal;
    
    public Verde(Semaforo semaforo, Sinal sinal) {
        this.semaforo = semaforo;
    }
    
    public Sinal getEstado() {
        return Sinal.VERDE;
    }
    
    public void efetuarTransicao() {
        semaforo.changeState(new Amarelo(semaforo, Sinal.AMARELO));
    }
    
    public int getTempoTransicao() {
        return semaforo.transicao.get(sinal);
    }

    public String getAcao() {
        return sinal.name().toLowerCase();
    }
    
}
