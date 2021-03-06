package Utils;

public class MergeSortArray {
	public static int[] mergeSort (int[] array) {

		if(array.length == 1)
			return array;

		int centro = array.length/2;

		int[] sinistra = split(array, 0, centro);
		int[] destra = split(array, centro, array.length);
		sinistra = mergeSort(sinistra);
		destra = mergeSort(destra);


		return merge(destra, sinistra);
	}

	private static int[] split(int[] arr, int inizio, int fine){
		int[] splittato = new int[fine-inizio];
		int j = 0;
		for(int i=inizio; i<fine; i++){
			splittato[j] = arr[i];
			j++;
		}
		return splittato;
	}

	private static int[] merge(int[] destra, int[] sinistra){
		int[] array = new int[destra.length + sinistra.length];
		int i = 0;
		int j = 0;
		while(i< sinistra.length && j< destra.length){
			if(sinistra[i] < destra[j]){
				array[i+j] = sinistra[i];
				i++;
			}else{
				array[i+j] = destra[j];
				j++;
			}
		}

		while (i< sinistra.length){
			array[i+j] = sinistra[i];
			i++;
		}

		while (j< destra.length){
			array[i+j] = destra[j];
			j++;
		}
		return array;

	}
}
