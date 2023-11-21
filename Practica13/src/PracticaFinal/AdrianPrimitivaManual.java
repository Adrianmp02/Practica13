package PracticaFinal;

import java.util.Arrays;
import java.util.Scanner;


public class AdrianPrimitivaManual {

	public static int[] primitiva() {
		//Creo el array para ir guardando los numeros
		int[] miPrimitiva = new int[6];
		int numeroAñadir;

		//Se pide los numeros por pantalla al usuario
		System.out.println("Dime los 6 números del boleto.");

		for (int i = 0; i < miPrimitiva.length; i++) {

			numeroAñadir = scannerInt();

			//Comprobamos que el numero pedido esta entre los valores que queremos
			while(numeroAñadir < 1 || numeroAñadir > 20) {

				System.out.println("El numero no es valido, introduce otro distinto.");
				numeroAñadir = scannerInt();

			}

			//Comprobamos que el numero pedido no esta repetido, si es asi se pide de nuevo
			for (int j = 0; j < i; j++) {

				if (miPrimitiva[j] == numeroAñadir) {

					System.out.println("El numero ya esta introducido, introduce uno distinto.");
					numeroAñadir = scannerInt();
					break;

				}

			}
			if(i < 6) {
			miPrimitiva[i] = numeroAñadir;
			}
		}



		Arrays.sort(miPrimitiva);

		return miPrimitiva;

	}

	public static int reintegro(){

		System.out.println("Dime el reintegro.");

		int miReintegro = scannerInt();

		if(miReintegro < 0 || miReintegro > 9) {

			System.out.println("Reintegro no valido, introduce otro distinto.");
			miReintegro = scannerInt();

			while(miReintegro < 0 || miReintegro > 9) {

				System.out.println("Reintegro no valido, introduce otro distinto.");
				miReintegro = scannerInt();

			}
		}

		return miReintegro;
	}





	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int miNum = sc.nextInt();

		return miNum;

	}


























}
