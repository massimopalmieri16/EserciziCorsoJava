package ClassificaSerieA;

public class MergeSortSquadre {
	public static Squadra[] mergeSort (Squadra[] array, int numSquadre) {

		if(array.length == 1)
			return array;

		int centro = numSquadre/2;

		Squadra[] sinistra = split(array, 0, centro);
		Squadra[] destra = split(array, centro, numSquadre);
		sinistra = mergeSort(sinistra,sinistra.length);
		destra = mergeSort(destra,destra.length);


		return merge(destra, sinistra);
	}

	private static Squadra[] split(Squadra[] arr, int inizio, int fine){
		Squadra[] splittato = new Squadra[fine-inizio];
		int j = 0;
		for(int i=inizio; i<fine; i++){
			splittato[j] = arr[i];
			j++;
		}
		return splittato;
	}

	private static Squadra[] merge(Squadra[] destra, Squadra[] sinistra){
		Squadra[] array = new Squadra[destra.length + sinistra.length];
		int i = 0;
		int j = 0;
		while(i< sinistra.length && j< destra.length){
			if(sinistra[i].punteggio > destra[j].punteggio){
				array[i+j] = sinistra[i];
				i++;
			}else{
				array[i+j] = destra[j];
				j++;
			}
		}

		while (i < sinistra.length){
			array[i+j] = sinistra[i];
			i++;
		}

		while (j < destra.length){
			array[i+j] = destra[j];
			j++;
		}
		return array;

	}
}
