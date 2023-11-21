package PracticaFinal;

import java.util.Scanner;

public class AdrianPrimitivaManual {


	public static void  primitiva () {

		Integer[] miPrimitiva = new Integer[6];

		

		for(int j = 0; j < miPrimitiva.length; j++) {

			int numPedir = 1;

			for (int i = 0; i < miPrimitiva.length; i++) {

				System.out.println("Dime el "+numPedir+"º que quieres");
				numPedir++;

				int numMio = scannerInt();

				if (numMio >= 1 && numMio <= 20) {

					if (miPrimitiva[i] == null) {

						miPrimitiva[i] = numMio;

					}

				}else {

					System.out.println("Numero no disponible elige otro.");

					numMio = scannerInt();

					while(numMio < 1 && numMio >20) {

						numMio = scannerInt();

					}

				}



			}












		}













	}




	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int miNum = sc.nextInt();

		return miNum;

	}


























}
