package PracticaFinal;


public class Adrian {

	private static int miPrimitiva[] = new int [6];
	private static int primitivaRandom[] = new int [6];



	public static int comparativaNum() {

		int contadorIguales = 0;

		for (int i = 0; i < miPrimitiva.length; i++) {

			for (int j = 0; j < primitivaRandom.length; j++) {

				if (miPrimitiva[i] == primitivaRandom[j]) {

					contadorIguales++;

				}

			}

		}

		return contadorIguales;

	}

	public static int comparativaReintegro() {
		
		int contadorReintegro = 0;
		
		int reintegroMio = 1;
		int reintegroAleatorio = 5;
		
		
		if (reintegroMio == reintegroAleatorio) {
			
			contadorReintegro++;
			
			
		}
		
		return contadorReintegro;
	}











}
