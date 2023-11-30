package PracticaFinal;

import java.util.Random;

public class PrimitivaPremiada {

	final int limiteNum = 6;
	final int numMaxPrimitiva = 20;
	final int numMaxReintegro = 9;
	
	private int[] primitivaPremiada;
	private int reintegroPremiado;
	
	public PrimitivaPremiada() {
		
		this.primitivaPremiada = new int [limiteNum];
		this.reintegroPremiado = 0;
		
	}
	
	
	
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
	
	public int reinPremiado() {
		
		int min = 0;
		int max = numMaxReintegro;
		
		Random rn = new Random();
		reintegroPremiado = rn.nextInt(max - min + 1) + min;
		
		return reintegroPremiado;
		
		
	}
	
	public int numeroAleatorio() {
		
		int min = 1;
		
		int max = numMaxPrimitiva;
		
		Random rn = new Random();
		
		return rn.nextInt(max - min + 1) + min;
		
	}
	
}
