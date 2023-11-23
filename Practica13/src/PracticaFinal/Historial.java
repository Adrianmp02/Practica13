package PracticaFinal;

public class Historial {

	//Atributos
	private int partidasJugadas;
	private int partidasGanadas;
	private int premioTotal;
	
	//Constructor
	public Historial () {

		this.partidasJugadas = 0;
		this.partidasGanadas = 0;
		this.premioTotal = 0;
		
	}

	//Contador para llevar recuento de las partidas jugadas
	public int jugarPartida() {
		
		partidasJugadas++;

		return partidasJugadas;
		
	}

	//Contador para llevar recuento de las partidas ganadas
	public int partidaGanada() {
		

		partidasGanadas = partidasGanadas + 1;

		return partidasGanadas;
		
	}

	//Contador para llevar registro del premio total que ha ganado el usuario
	public int premioGanado(int premio) {
		
		premioTotal = premioTotal + premio;
		
		return premioTotal;

	}

	//Retornamos por pantalla el historial que queremos que vea el usuario
	public String toString() {

		return "Has jugadado: "+partidasJugadas+" partidas. \nHas sido premiado en: "+partidasGanadas+ " partidas. \nHas ganado un total de: "+premioTotal+" €";

	}

}
