import java.util.HashMap;
import java.util.Map;

import java.lang.Thread;

public class Semaforo {
	public State estadoSemaforo = new Vermelho(this, Sinal.VERMELHO);
	
	private String numTombamento = null;

	public Map<Sinal, Integer> transicao = new HashMap<Sinal,Integer>();
	
	public Semaforo(String numTombamento) {
        this.numTombamento = numTombamento;
        // tempo de transicao em segundos
        transicao.put(Sinal.VERMELHO,3);
        transicao.put(Sinal.AMARELO,1);
        transicao.put(Sinal.VERDE,5);
	}
	
	public String getNumTombamento() {
		return numTombamento;
	}

	public void setNumTombamento(String numTombamento) {
		this.numTombamento = numTombamento;
	}


	public void changeState(State newState) {
		this.estadoSemaforo = newState;
	}
	
	public Sinal getEstadoAtual() {
		return estadoSemaforo.getEstado();
	}
	
	
	public void setup(Sinal estagio, int novo_tempo_transicao) {
		this.transicao.put(estagio,novo_tempo_transicao);
	}
	
	public void exibir() {
		Sinal estadoAtual = getEstadoAtual();
		System.out.println(" vermelho  ( " + (estadoAtual == Sinal.VERMELHO?"X":" ") + " )");
		System.out.println(" amarelo   ( " + (estadoAtual == Sinal.AMARELO?"X":" ") + " )");
		System.out.println(" verde     ( " + (estadoAtual == Sinal.VERDE?"X":" ") + " )");
	}
	
	
	public void showVisorRegressivo() {
		for (int i = transicao.get(getEstadoAtual()); i >0 ; i--) {
			System.out.println(i + " segundo(s)");
			try {
				// 1000 milisegundos equivale a 1 segundo
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void start() {
		this.start(10);
	}

	public void start(int time_in_seconds) {
		while(time_in_seconds > 0) {
			System.out.println("Tempo restante da simulacao: " + time_in_seconds + " segundos");
			System.out.println( getEstadoAtual() + " : " + transicao.get(getEstadoAtual()) + " segundos.");
			exibir();
			time_in_seconds -= transicao.get(getEstadoAtual());
			showVisorRegressivo();
		    estadoSemaforo.efetuarTransicao();
			System.out.println();
			
		}
		
	}
	
	public String toString() {
		String s = "";
		s += "Numero Tombamento: " + numTombamento + "\n";
		s += "Tempo de permanencia em cada estagio:\n";
		s += Sinal.VERMELHO + " : " + transicao.get(Sinal.VERMELHO) + " segundos\n";
		s += Sinal.AMARELO + " : " + transicao.get(Sinal.AMARELO) + " segundos\n";
		s += Sinal.VERDE + " : " + transicao.get(Sinal.VERDE) + " segundos\n";
		return s;
	}
	

}
