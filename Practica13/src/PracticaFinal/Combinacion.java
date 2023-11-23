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

		//Se ordena el Array
		Arrays.sort(miPrimitiva);

		return miPrimitiva;

	}
	
	//Pedimos por pantalla el reintegro que queremos
	public static int reintegroManual(){

		System.out.println("Dime el reintegro.");

		int miReintegro = scannerInt();
		
		//Si no esta dentro de los parametros que pedimos se solicita uno nuevo
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

	//Genera un array de 6 posiciones con numeros distintos (no se repiten)
	public static int[] primitivaRandom(){

		int [] primitivaR = new int [6];

		for (int i = 0; i < primitivaR.length; i++) {

			//Flag para que si un numero se repite
			boolean numeroRepetido = false;

			int numeroAñadir = numeroAleatorio();
			
			//Se comprueba que en el array no hay un numero igual
			for (int j = 0; j < i; j++) {
				
				//Si hay igual se cambia la flag a true
				if (numeroAñadir == primitivaR[j]) {

					i--;			
					numeroRepetido = true;
					break;

				}

			}
			
			//Si la flag es false, guarda el numero. (Si es true, vuelve al loop)
			if(!numeroRepetido) {

				primitivaR[i] = numeroAñadir;	

			}

		}

		return primitivaR;

	}

	//Genera un reintegro aleatorio
	public static int reintegroRandom () {
		
		int min = 0;
		int max = 9;

		Random rn = new Random();
		return rn.nextInt(max - min + 1) + min;
		
	}

	//Metodo para generar numeros aleatorios
	public static int numeroAleatorio(){
		
		//Numero minimo que genera aleatorio
		int min = 1;
		//Numero maximo que genera aleatorio
		int max = 20;

		Random rn = new Random();
		
		return rn.nextInt(max - min + 1) + min;
		
	}

	//Se compara la primitiva manual que ingresa con la aleatoria y devuelve los aciertos que ha tenido el usuario
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

	//Se compara el reintegro y devuelve 1 si ha hacertado o 0 si no
	public static int comparativaReintegro(int reintegroManual, int reintegroRandom) {

		if (reintegroManual== reintegroRandom) {

			return 1;

		}

		return 0;
		
	}

	//Se compara los aciertos y dependiendo los aciertos devuelve el premio que ha conseguido el usuario
	public static int puntaje(int aciertoPrimitiva, int aciertoReintegro, Historial h) {

		if(aciertoReintegro == 1) {

			//Se guarda en el historial una partida ganada si el usuario a acertado mas de 3
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

	//Scanner
	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int miNum = sc.nextInt();

		return miNum;

	}

}
