package PracticaFinal;

import java.util.Random;

public class PrimitivaPremiada {
	// VARIABLES AJUSTABLES
	final int limiteNum = 6;
	final int numMaxPrimitiva = 20;
	final int numMaxReintegro = 9;

	private int[] primitivaPremiada;
	private int reintegroPremiado;

	//CONSTRUCTOR DE PRIMITIVA RANDOM 
	public PrimitivaPremiada() {

		this.primitivaPremiada = new int [limiteNum];
		this.reintegroPremiado = 0;

	}


	// GETERS Y SETERS
	public int[] getPrimitivaPremiada() {
		return primitivaPremiada;
	}

	public void setPrimitivaPremiada(int[] primitivaPremiada) {
		this.primitivaPremiada = primitivaPremiada;
	}

	public int getReintegroPremiado() {
		return reintegroPremiado;
	}

	public void setReintegroPremiado(int reintegroPremiado) {
		this.reintegroPremiado = reintegroPremiado;
	}

	// METODO CREAR PRIMITIVA RANDOM 
	public int[] priPremiada() {

		for (int i = 0; i < primitivaPremiada.length; i++) {

			boolean numeroRepetido = false;

			int numAnhadir = numeroAleatorio();

			for(int j = 0; j < i; j++) {

				if (numAnhadir == primitivaPremiada[j]) {

					i--;
					numeroRepetido = true;
					break;

				}

			}

			if (!numeroRepetido) {

				primitivaPremiada[i] = numAnhadir;

			}

		}

		return primitivaPremiada;

	}
	// METODO PARA REINTEGRO RANDOM 
	public int reinPremiado() {

		int min = 0;
		int max = numMaxReintegro;

		Random rn = new Random();
		reintegroPremiado = rn.nextInt(max - min + 1) + min;

		return reintegroPremiado;


	}
    //METODO PARA QUE TE DE NUMEROS ALEATORIOS
	public int numeroAleatorio() {

		int min = 1;

		int max = numMaxPrimitiva;

		Random rn = new Random();

		return rn.nextInt(max - min + 1) + min;

	}

}
