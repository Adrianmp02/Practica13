package PracticaFinal;

public class Historial {

	private int partidasJugadas;
	private int partidasGanadas;
	private String premioTotal;

	public Historial () {

		this.partidasJugadas = 0;
		this.partidasGanadas = 0;

	}

	public int jugarPartida() {
		//TODO

		return partidasJugadas;
	}

	public int partidaGanada() {
		//TODO
		if (Combinacion.puntaje() != null) {
			
			partidasGanadas++;
			
		}

		return partidasGanadas;
	}

	public String premioGanado() {

		if (Combinacion.puntaje() != null) {

			this.premioTotal = Combinacion.puntaje();

		}

		return premioTotal;
		
	}

	public String toString() {
		
		return "Has jugadado: "+jugarPartida()+"partidas. \nHas sido premiado en: "+partidaGanada()+ "partidas. \n"+premioGanado();
		
	}
	






}
