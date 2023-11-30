package PracticaFinal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Combinacion {

	//Variables para cambiar el Nº max que puede tener el boleto, el Nº max de reintegro y el limite de Nº que puede tener el boleto
	final static int limiteNum = 6;
	final static int numMaxPremio = 20;
	final static int numMaxReintegro = 9;
	
	//Atributos
	private  int[] miPrimitiva;
	private  int miReintegro;

	private  int[] primitivaRandom;
	private  int reintegroRandom;
	
	//Constructor por defecto
	public Combinacion() {
		
		this.miPrimitiva = new int [limiteNum];
		this.miReintegro = 0;
		
		this.reintegroRandom = 0;
		this.primitivaRandom = new int [limiteNum];
		
	}

	//Metodo para pedir al usuario un numero de primtiva por pantalla
	public  int[] primitivaManual() {

		int numeroAñadir;

		//Se pide los numeros por pantalla al usuario
		System.out.println("Dime los "+limiteNum+" números del boleto.");

		for (int i = 0; i < miPrimitiva.length; i++) {

			numeroAñadir = scannerInt();

			//Comprobamos que el numero pedido esta entre los valores que queremos
			while(numeroAñadir < 1 || numeroAñadir > numMaxPremio) {

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

	//Pedimos por pantalla el reintegro que el usuario quiera
	public  int reintegroManual() {

		System.out.println("Dime el reintegro.");

		int anhadirReintegro = scannerInt();

			while(anhadirReintegro < 0 || anhadirReintegro > numMaxReintegro) {

				System.out.println("Reintegro no valido, introduce otro distinto.");
				anhadirReintegro = scannerInt();

			}

		miReintegro = anhadirReintegro;

		return miReintegro;

	}

	//Genera un numero de primitiva Random
	public  int[] primitivaRandom() {

		for (int i = 0; i < primitivaRandom.length; i++) {

			//Flag para que si un numero se repite
			boolean numeroRepetido = false;

			int numeroAnhadir = numeroAleatorio();

			//Se comprueba que en el array no hay un numero igual
			for (int j = 0; j < i; j++) {

				//Si hay igual se cambia la flag a true
				if (numeroAnhadir == primitivaRandom[j]) {

					i--;			
					numeroRepetido = true;
					break;

				}

			}

			//Si la flag es false, guarda el numero. (Si es true, vuelve al loop)
			if(!numeroRepetido) {

				primitivaRandom[i] = numeroAnhadir;	

			}

		}

		return primitivaRandom;

	}

	//Se compara la primitiva manual que ingresa el usuario con la Random y devuelve los aciertos
	public  int comparativaPrimitiva(int[] boletoManual, int[] boletoRandom) {

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

	//Se compara el reintegro del suario y el Random y devuelve 1 si se acerto 0 si no
	public  int comparativaReintegro(int boletoReintegroManual, int boletoReintegroRandom) {

		if (boletoReintegroManual == boletoReintegroRandom) {

			return 1;

		}

		return 0;

	}

	//Se compara los aciertos y dependiendo los aceirtos devuelve el premio que ha conseguido
	public  int puntaje(int aciertoPrimitiva, int aciertoReintegro, Historial h) {

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

	public void generarBoleto(int limitePartidas, Historial h) {

		//Llamamos al metodo jugarPartida del historial para guardar la partida jugada
		h.jugarPartida();

		//Se añade +1 al contador de partida
		Menu.contadorPartidas++;

		//Se guardan en variables los numeros de primitiva Manual y Aleatorio
		int[] boletoRandom = primitivaRandom();
		int[] boletoManual = primitivaManual();

		//Se guardan en variables los numeros de reintegro Manual y Aleatorio
		int boletoReintegroRandom = reintegroRandom();
		int boletoReintegroManual = reintegroManual();   

		System.out.println("=============================");
		System.out.println("╔═══════════════════════════╗");
		System.out.println("║                           ║");
		System.out.println("║     ╔═══╗                 ║");
		System.out.println("║     ║   ║ LA PRIMITIVA    ║");
		System.out.println("║     ╚   ╝                 ║");
		System.out.println("║                           ║");
		System.out.println("║       "+Menu.contadorPartidas+". APUESTA(S)       ║");
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
		Menu.compaPrimitiva = comparativaPrimitiva(boletoManual, boletoRandom);
		Menu.compaReintegro = comparativaReintegro(boletoReintegroManual, boletoReintegroRandom);

		//Indicamos al usuario cuantos aciertos en la primitiva ha tenido y si ha acertado el reintegro
		
		if (Menu.compaPrimitiva != 0) {
		
			
			if (Menu.compaPrimitiva==1) {
				System.out.println("Has acertado: "+Menu.compaPrimitiva+" numero en la primitiva.Enhorabuena");
			}
			else {
				System.out.println("Has acertado: "+Menu.compaPrimitiva+" numeros en la primitiva.Enhorabuena");
			}
		}
		else {
			System.out.println("No has acertado ningún número de la primitiva.");
		}

		if (Menu.compaReintegro==1) {
			System.out.println("Has acertado el número reintegro.Enhorabuena.");
		}
		else {
			System.out.println("No has acertado el número reintegro.");
		}


		//Si ha acertado mas de 3 de guarda el premio para llevar un registro en el historial
		int premio = puntaje(Menu.compaPrimitiva, Menu.compaReintegro, h);

		//Se muestra por pantalla al usuario el premio que se ha ganado
		System.out.println("Has ganado: "+premio+" €");

		h.premioGanado(premio);

	}

	//Genera un reintegro aleatorio
	public int reintegroRandom () {

		int min = 0;
		int max = numMaxReintegro;

		Random rn = new Random();
		reintegroRandom = rn.nextInt(max - min + 1) + min;

		return reintegroRandom;
	}

	//Metodo para generar numeros aleatorios
	public int numeroAleatorio(){

		//Numero minimo que genera aleatorio
		int min = 1;
		//Numero maximo que genera aleatorio
		int max = numMaxPremio;

		Random rn = new Random();

		return rn.nextInt(max - min + 1) + min;

	}

	//Scanner NO TOCAR
	public static int scannerInt() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int miNum = sc.nextInt();

		return miNum;

	}

}
