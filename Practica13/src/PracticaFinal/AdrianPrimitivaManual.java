package PracticaFinal;

import java.util.Scanner;

public class AdrianPrimitivaManual {


	public static void  primitiva () {

		Integer[] miPrimitiva = new Integer[6];
		int numPedir = 1;
		for (int i = 0; i < miPrimitiva.length; i++) {

			if (miPrimitiva[i] == null) {

				System.out.println("Dime el "+numPedir+"º que quieres.");

				int numMio = scannerInt();

				if (numMio >= 1 && numMio <= 20) {

					miPrimitiva[i] = numMio;

				}else {

					System.out.println("Numero no disponible, introduce otro.");
					numMio = scannerInt();

					while (numMio < 1 || numMio > 20) {

						System.out.println("Numero no disponible, introduce otro.");
						numMio = scannerInt();

					}
					
				}

			}

			numPedir++;


		}
































	}




	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int miNum = sc.nextInt();

		return miNum;

	}


























}
