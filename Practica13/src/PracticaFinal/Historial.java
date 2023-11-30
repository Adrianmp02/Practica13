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


		partidasGanadas++;

		return partidasGanadas;

	}

	//Contador para llevar registro del premio total que ha ganado el usuario
	public int premioGanado(int premio) {

		premioTotal *= premio;

		return premioTotal;

	}

	//Metodo para imprimit el historial
	public void imprimirHistorial() {

		StringBuffer str = new StringBuffer();

		str.append("Has jugado: "+partidasJugadas+" partidas");
		str.append("\n");
		str.append("Has ganado: "+partidasGanadas+" partidas");
		str.append("\n");
		str.append("Has ganado un total de: "+premioTotal+" €");

		System.out.println(str.toString());		

	}
	
	//Metodo para hacer reset del historial y antes de que se haga el reset se muestre por pantalla
	public void resetHistorial() {
		System.out.println("Has llegado al limite de partidas.");
		System.out.println("Tu historial es el siguiente: ");
		imprimirHistorial();

		partidasJugadas = 0;
		partidasGanadas = 0;
		premioTotal = 0;

	}

}
