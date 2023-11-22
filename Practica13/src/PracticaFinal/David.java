package PracticaFinal;

import java.util.Random;

public class David {
	

	//David 
	public static int[] primitivaRandom(){
		int [] primitivaR = new int [6];
		
		for (int n = 0; n < primitivaR.length; n++) {
			primitivaR[n] = numeroAleatorio();
		}
		
		return primitivaR;

	}
	public static int primitivaReintegro () {
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
}
