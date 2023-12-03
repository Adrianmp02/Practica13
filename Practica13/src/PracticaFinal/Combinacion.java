package PracticaFinal;

public class Combinacion {

	//Se comparan ambas primitivas y devulve un contador con el numero de aciertos
	public int comparativaPrimitiva(int[] boletoUsuario, int[] boletoPremiado) {

		int contador = 0;

		for(int i = 0; i < boletoUsuario.length; i++) {

			for(int j = 0; j < boletoPremiado.length; j++) {

				if (boletoUsuario[i] == boletoPremiado[j]) {

					contador++;

				}

			}

		}

		return contador;

	}

	//Comparamos el reintegro, si se acierta devuelve 1, si no 0
	public int comparativaReintegro(int boletoUsuario, int boletoPremiado) {

		if (boletoUsuario == boletoPremiado) {

			return 1;

		}

		return 0;

	}

	//Dependiendo los aciertos se genera el premio y si se tiene +3 de aciertos se cuenta como partida Ganada y se guarda en historial
	public int puntaje(int aciertoPrimitiva, int aciertoReintegro, Historial h) {

		int acierto = 0;
		
		if(aciertoReintegro == 1) {

			acierto = 1;
			
			//Se guarda en el historial una partida ganada si el usuario a acertado mas de 3
			if (aciertoPrimitiva > 3) {

				h.partidaGanada();

			}

			if (aciertoPrimitiva == 4) {

				acierto += 1000;
				return acierto;

			}else if(aciertoPrimitiva == 5) {

				acierto += 10000;
				return acierto;

			}else if(aciertoPrimitiva == 6) {

				acierto += 1000000;
				return acierto;

			} 

		}else if(aciertoReintegro != 1) {

			if (aciertoPrimitiva > 3) {

				h.partidaGanada();

			}

			if (aciertoPrimitiva == 4) {
				
				acierto = 1000;
				return acierto;

			}else if(aciertoPrimitiva == 5) {
				
				acierto = 10000;
				return acierto;

			}else if(aciertoPrimitiva == 6) {

				acierto = 1000000;
				return acierto;

			} 

		}

		return acierto;

	}

}
