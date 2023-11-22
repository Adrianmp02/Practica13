package PracticaFinal;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {


	public static void main(String[] args) {

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
				//TODO jugar
				contadorPartidas++;

				int[] boleto1 = Combinacion.primitivaManual();
				
				int boleto1Reintegro = Combinacion.reintegroManual();
				
				System.out.println("Tu combinacion es: "+Arrays.toString(boleto1));
				System.out.println("Tu reintegro es: "+boleto1Reintegro);

			}else if(eleccion == 2) {
				//TODO historial




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
