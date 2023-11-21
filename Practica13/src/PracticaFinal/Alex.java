package PracticaFinal;

public class Alex {
	
	//Alex
		public static String puntaje() {
			int comparacion = 4;
			int reintegro = 5;
			
			if(reintegro == 1) {
				if (comparacion == 4) {
					return "Has ganado : 1.001 €";
				}else if(comparacion == 5) {
					return "Has ganado : 10.001 €";
				}else if(comparacion == 6) {
					return "Has ganado : 1.000.001 €";
				} 
				
			}else if(reintegro != 1) {
				if (comparacion == 4) {
					return "Has ganado : 1.000 €";
				}else if(comparacion == 5) {
					return "Has ganado : 10.000 €";
				}else if(comparacion == 6) {
					return "Has ganado : 1.000.000 €";
				} 
			}
				
			return null;
			
			
		}
}
