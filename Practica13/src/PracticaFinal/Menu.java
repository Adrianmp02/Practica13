package PracticaFinal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

	//Atributos
	public static int compaPrimitiva;
	public static int compaReintegro;

	//Main
	public static void main(String[] args) {

		//Creamos historial
		Historial h = new Historial();

		//variable de valores que pedimos por pantalla
		int eleccion;

		//Limite de partidas que queremos y contador para llevar la cuenta
		int limitePartidas = 10;
		int contadorPartidas = 0;

		//Pedimos por pantalla los datos que necesitamos al usuario
		do {
			
			System.out.println("==========================");
			System.out.println("|| Elige una opcion:    ||");
			System.out.println("||----------------------||");
			System.out.println("|| 1) Jugar             ||");
			System.out.println("|| 2) Ver Historial     ||");
			System.out.println("|| 3) Salir             ||");
			System.out.println("==========================");
			
			eleccion = scannerInt();

			if (eleccion == 1) {

				//Llamamos al metodo jugarPartida del historial para guardar la partida jugada
				h.jugarPartida();

				//Se añade +1 al contador de partida
				contadorPartidas++;

				//Se guardan en variables los numeros de primitiva Manual y Aleatorio
				int[] boletoRandom = Combinacion.primitivaRandom();
				int[] boletoManual = Combinacion.primitivaManual();

				//Se guardan en variables los numeros de reintegro Manual y Aleatorio
				int boletoReintegroRandom = Combinacion.reintegroRandom();
				int boletoReintegroManual = Combinacion.reintegroManual();
				
				System.out.println("=============================");
				System.out.println("╔═══════════════════════════╗");
				System.out.println("║                           ║");
				System.out.println("║     ╔═══╗                 ║");
				System.out.println("║     ║   ║ LA PRIMITIVA    ║");
				System.out.println("║     ╚   ╝                 ║");
				System.out.println("║                           ║");
				System.out.println("║       "+contadorPartidas+". APUESTA(S)       ║");
				System.out.println("╠═══════════════════════════╣");
				System.out.println("║                           ║");
				
				System.out.print("║    1. ");
				for (int i = 0; i < boletoManual.length; i++) {
					
					System.out.print(String.format("%02d", boletoManual[i]));
					System.out.print(" ");
					
				}
				
				System.out.print("  ║");
				System.out.println();
				
				System.out.println("║                           ║");
				System.out.println("║      REINTEGRO: "+boletoReintegroManual+"         ║");
				System.out.println("║                           ║");
				System.out.println("╠═══════════════════════════╣");
				System.out.println("║                           ║");
				System.out.println("║                 1,00 EUR  ║");
				System.out.println("║                           ║");
				System.out.println("║  "+ LocalDate.now()+"               ║");
				System.out.println("║                           ║");
				System.out.println("╚═══════════════════════════╝");
				System.out.println("=============================");
				
				
				
				
				
				
				//Comparamos la primitiva Manual y Aleatoria / Reintegro Manual y Aleatorio
				compaPrimitiva = Combinacion.comparativaPrimitiva(boletoManual, boletoRandom);
				compaReintegro = Combinacion.comparativaReintegro(boletoReintegroManual, boletoReintegroRandom);

				//Indicamos al usuario cuantos aciertos en la primitiva ha tenido y si ha acertado el reintegro
				System.out.println("Has acertado: "+compaPrimitiva+" numeros en la primitiva.");
				System.out.println("Has acertado: "+compaReintegro+" numero en el reintegro.");
				
				//Si ha acertado mas de 3 de guarda el premio para llevar un registro en el historial
				int premio = Combinacion.puntaje(compaPrimitiva, compaReintegro, h);

				//Se muestra por pantalla al usuario el premio que se ha ganado
				System.out.println("Has ganado: "+premio+" €");
				
				h.premioGanado(premio);

			//Se muestra por pantalla el historial
			}else if(eleccion == 2) {

				System.out.println(h.toString());

			//Se sale del juego
			}else if(eleccion == 3) {

				break;

			//Indica que no es valido si el usuario elige cualquier opcion distinta a 1, 2 o 3 y se vuelve a pedir
			}else {

				System.out.println("Opcion no valida, introduzca otra distinta");

			}

			//Si el usuario alcanza el limite de partidas el programa se para
			if (contadorPartidas >= limitePartidas) {

				System.out.println("Has alcanzado el limite de partidas");

				eleccion = 3;

			}

			//Si el usuario elige la opcion 3 el programa se para
		}	while(eleccion != 3); 

	}
	


	//Scanner
	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();

		return s;

	}

}
