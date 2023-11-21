package PracticaFinal;

public class Alex {
	
	//Alex
		public static String puntaje() {
			
			if(Adrian.comparativaReintegro() == 1) {
				if (Adrian.comparativaNum() == 4) {
					return "Has ganado : 1.001 €";
				}else if(Adrian.comparativaNum() == 5) {
					return "Has ganado : 10.001 €";
				}else if(Adrian.comparativaNum() == 6) {
					return "Has ganado : 1.000.001 €";
				} 
				
			}else if(Adrian.comparativaReintegro() != 1) {
				if (Adrian.comparativaNum() == 4) {
					return "Has ganado : 1.000 €";
				}else if(Adrian.comparativaNum() == 5) {
					return "Has ganado : 10.000 €";
				}else if(Adrian.comparativaNum() == 6) {
					return "Has ganado : 1.000.000 €";
				} 
			}	
			return null;
		}
}
