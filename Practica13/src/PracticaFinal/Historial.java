package PracticaFinal;

public class Historial {

	private int partidasJugadas;
	private int partidasGanadas;
	private int premioTotal;
	
	public Historial () {

		this.partidasJugadas = 0;
		this.partidasGanadas = 0;
		this.premioTotal = 0;
		
	}

	public int jugarPartida() {
		
		partidasJugadas++;

		return partidasJugadas;
		
	}

	public int partidaGanada() {
		

		partidasGanadas = partidasGanadas + 1;

		return partidasGanadas;
		
	}

	public int premioGanado(int premio) {
		
		premioTotal = premioTotal + premio;
		
		return premioTotal;

	}

	public String toString() {

		return "Has jugadado: "+partidasJugadas+" partidas. \nHas sido premiado en: "+partidasGanadas+ " partidas. \n"+premioTotal;

	}







}
