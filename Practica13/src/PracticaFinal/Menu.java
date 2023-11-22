package PracticaFinal;

import java.util.Scanner;

public class Menu {

	public static int compaPrimitiva;
	public static int compaReintegro;

	public static void main(String[] args) {

		Historial h = new Historial();
		
		int eleccion;

		int limitePartidas = 2;
		int contadorPartidas = 0;

		do {

			System.out.println("Elige una opcion:");
			System.out.println();

			System.out.println("1) Jugar");
			System.out.println("2) Ver Historial");
			System.out.println("3) Salir");

			eleccion = scannerInt();

			if (eleccion == 1) {
				
				h.jugarPartida();
				
				contadorPartidas++;

				int[] boletoRandom = Combinacion.primitivaRandom();
				int[] boletoManual = Combinacion.primitivaManual();

				int boletoReintegroRandom = Combinacion.reintegroRandom();
				int boletoReintegroManual = Combinacion.reintegroManual();



				compaPrimitiva = Combinacion.comparativaPrimitiva(boletoManual, boletoRandom);
				compaReintegro = Combinacion.comparativaReintegro(boletoReintegroManual, boletoReintegroRandom);

				


				System.out.println("Has acertado: "+compaPrimitiva+" numeros en la primitiva.");
				System.out.println("Has acertado: "+compaReintegro+" numero en el reintegro.");

				int premio = Combinacion.puntaje(compaPrimitiva, compaReintegro, h);
				
				h.premioGanado(premio);

			}else if(eleccion == 2) {

				System.out.println(h.toString());

			}else if(eleccion == 3) {

				break;

			}else {


				System.out.println("Opcion no valida");

			}


			if (contadorPartidas >= limitePartidas) {

				System.out.println("Has alcanzado el limite de partidas");

				eleccion = 3;


			}



		}	while(eleccion != 3); 






	}



	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();

		return s;

	}

}
