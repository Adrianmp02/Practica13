package PracticaFinal;

import java.util.Scanner;

public class Menu {

	//Atributos
	public static int compaPrimitiva;
	public static int compaReintegro;
	public static int contadorPartidas = 0;

	
	public static void iniciar() {

		//Creamos historial
		Historial h = new Historial();

		Combinacion c = new Combinacion();

		//variable de valores que pedimos por pantalla
		int eleccion;

		//Limite de partidas que queremos y contador para llevar la cuenta
		int limitePartidas = 10;

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

				c.generarBoleto(limitePartidas, h);

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
