public class NumeroRomano {
	String numeroromano;

	NumeroRomano(String numeroromano){
		this.numeroromano = numeroromano.toUpperCase();
	}

	public int getValore(){
		char[] charnumeroromano = numeroromano.toCharArray();
		int somma = 0;
		LettereRomane lettereRomane;
		LettereRomane lettereRomaneNext;
		for(int i = 0; i < charnumeroromano.length; i++){
			lettereRomane = LettereRomane.valueOf(String.valueOf(charnumeroromano[i]));


			switch (lettereRomane){
				case M:
				case D:{
					somma += lettereRomane.toInt();
					break;
				}
				case C:{
					if(i + 1 < charnumeroromano.length){
						lettereRomaneNext = LettereRomane.valueOf(String.valueOf(charnumeroromano[i + 1]));

						if(lettereRomaneNext == LettereRomane.D || lettereRomaneNext == LettereRomane.M){
							somma -= lettereRomane.toInt();
						}else {
							somma += lettereRomane.toInt();
						}
					}else{
						somma += lettereRomane.toInt();
					}
					break;
				}
				case L:{
					somma += lettereRomane.toInt();
					break;
				}
				case X:{
					if(i + 1 < charnumeroromano.length){
						lettereRomaneNext = LettereRomane.valueOf(String.valueOf(charnumeroromano[i + 1]));

						if(lettereRomaneNext == LettereRomane.C || lettereRomaneNext == LettereRomane.L){
							somma -= lettereRomane.toInt();
						}else {
							somma += lettereRomane.toInt();
						}
					}else{
						somma += lettereRomane.toInt();
					}
					break;
				}
				case V:{
					somma += lettereRomane.toInt();
					break;
				}
				case I:{
					if(i + 1 < charnumeroromano.length){
						lettereRomaneNext = LettereRomane.valueOf(String.valueOf(charnumeroromano[i + 1]));

						if(lettereRomaneNext != LettereRomane.I){
							somma -= lettereRomane.toInt();
						}else {
							somma += lettereRomane.toInt();
						}
					}else{
						somma += lettereRomane.toInt();
					}
					break;
				}
			}


			/*if(charnumeroromano[i] == 'M'){
				somma += LettereRomane.M.toInt();
			}
			if(charnumeroromano[i] == 'D'){
				somma += LettereRomane.D.toInt();
			}
			if(charnumeroromano[i] == 'C'){
				if(i + 1 < charnumeroromano.length && (charnumeroromano[i + 1] == 'D' || charnumeroromano[i + 1] == 'M')){
					somma -= LettereRomane.C.toInt();
				}else {
					somma += LettereRomane.C.toInt();
				}
			}
			if(charnumeroromano[i] == 'L'){
				somma += LettereRomane.L.toInt();
			}
			if(charnumeroromano[i] == 'X'){
				if(i + 1 < charnumeroromano.length && (charnumeroromano[i + 1] == 'C' || charnumeroromano[i + 1] == 'L')){
					somma -= LettereRomane.X.toInt();
				}else {
					somma += LettereRomane.X.toInt();
				}
			}
			if(charnumeroromano[i] == 'V'){
				somma += LettereRomane.V.toInt();
			}
			if(charnumeroromano[i] == 'I'){
				if(i + 1 < charnumeroromano.length && charnumeroromano[i + 1] != 'I'){
					somma -= LettereRomane.I.toInt();
				}else {
					somma += LettereRomane.I.toInt();
				}
			}*/

		}
		return somma;
	}
}
