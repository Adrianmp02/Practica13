package PracticaFinal;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Combinacion {

	public static int[] primitivaManual() {

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

			miPrimitiva[i] = numeroAñadir;

		}



		Arrays.sort(miPrimitiva);

		return miPrimitiva;

	}

	public static int reintegroManual(){

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

	public static int[] primitivaRandom(){

		int [] primitivaR = new int [6];

		for (int i = 0; i < primitivaR.length; i++) {

			boolean numeroRepetido = false;

			int numeroAñadir = numeroAleatorio();

			for (int j = 0; j < i; j++) {

				if (numeroAñadir == primitivaR[j]) {

					i--;			
					numeroRepetido = true;
					break;

				}

			}

			if(!numeroRepetido) {

				primitivaR[i] = numeroAñadir;	

			}


		}

		return primitivaR;

	}

	public static int reintegroRandom () {
		int min = 0;
		int max = 9;

		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
	}

	public static int numeroAleatorio(){
		int min = 1;
		int max = 20;

		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
	}

	public static int comparativaPrimitiva(int[] boletoManual, int[] boletoRandom) {

		int contadorPrimitiva = 0;

		for (int i = 0; i < boletoManual.length; i++) {

			for (int j = 0; j < boletoRandom.length; j++) {

				if (boletoManual[i] == boletoRandom[j]) {

					contadorPrimitiva++;

				}

			}


		}

		return contadorPrimitiva;

	}

	public static int comparativaReintegro(int reintegroManual, int reintegroRandom) {

		int contadorReintegro = 0;

		if (reintegroManual== reintegroRandom) {

			contadorReintegro++;

		}

		return contadorReintegro;

	}

	public static int puntaje(int aciertoPrimitiva, int aciertoReintegro, Historial h) {

		if(aciertoReintegro == 1) {

			if (aciertoPrimitiva > 3) {

				h.partidaGanada();

			}

			if (aciertoPrimitiva == 4) {

				return 1001;

			}else if(aciertoPrimitiva == 5) {

				return 10001;

			}else if(aciertoPrimitiva == 6) {

				return 1000001;

			} 

		}else if(aciertoReintegro != 1) {

			if (aciertoPrimitiva > 3) {

				h.partidaGanada();

			}

			if (aciertoPrimitiva == 4) {

				return 1000;

			}else if(aciertoPrimitiva == 5) {

				return 10000;

			}else if(aciertoPrimitiva == 6) {

				return 1000000;

			} 
		}

		return 0;
	}




	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int miNum = sc.nextInt();

		return miNum;

	}






}
