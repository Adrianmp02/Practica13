package PracticaFinal;

import java.util.Arrays;
import java.util.Scanner;

public class PrimitivaUsuario {

	//Variables Ajustables
	final int limiteNum = 6;
	final int numMaxPremio = 20;
	final int numMaxReintegro = 9;
	
	//Atributos
	private int[] primitiva;
	private int reintegro;
	
	//Constructor por defecto
	public PrimitivaUsuario() {
		
		this.primitiva = new int[limiteNum];
		this.reintegro = 0;
		
	}
	
	//Getters
	public int[] getPrimitiva() {
		return primitiva;
	}

	public int getReintegro() {
		return reintegro;
	}

	//Pedimos al usuario su numero de primitiva
	public int[] generarPrimitivaUsuario() {
		
		System.out.println("Dime los "+limiteNum+" de la primitiva que quieres.");
		int numAnhadir;
		
		for (int i = 0; i < primitiva.length; i++) {
			
			numAnhadir = scannerInt();
			
			while(numAnhadir < 1 || numAnhadir > numMaxPremio) {
				
				System.out.println("El numero no es valido, introduce otro distinto.");
				numAnhadir = scannerInt();
				
			}
			
			for(int j = 0; j < i; j++) {
				
				if (primitiva[j] == numAnhadir) {
					
					System.out.println("El numero ya esta introducido, ingresa otro distinto.");
					numAnhadir = scannerInt();
					break;
					
				}
				
			}
			
			primitiva[i] = numAnhadir;
			
		}
		
		Arrays.sort(primitiva);
		
		return primitiva;
		
	}
	
	//Pedimos al usuario su reintegro
	public int reintegroUsuario() {
		
		System.out.println("Dime el reintegro que quieres.");
		
		int anhadirReintegro = scannerInt();
		
		while(anhadirReintegro < 0 || anhadirReintegro > numMaxReintegro) {
			
			System.out.println("Reintegro no valido, introduce otro distinto.");
			anhadirReintegro = scannerInt();
			
		}
		
		reintegro = anhadirReintegro;
		
		return reintegro;
		
	}
	
	
	//Scanner NO TOCAR
	public int scannerInt() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		return n;
		
	}
	
}
