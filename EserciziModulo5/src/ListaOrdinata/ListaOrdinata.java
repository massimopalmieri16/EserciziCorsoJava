package ListaOrdinata;

import java.util.Arrays;
import static Utils.MergeSortArray.mergeSort;
import static Utils.RicercaBinariaArray.ricercaBinaria;

public class ListaOrdinata {
	int[] array = new int[0];

	public void insert(int numero){
		array = Arrays.copyOf(array,array.length + 1);

		// versione lenta
		//array[array.length - 1] = numero;
		//array = mergeSort(array);

		// versione ottimizzata
		for(int i = 0; i < array.length; i ++) {
			if(array[i] > numero || i >= array.length - 1) {
				for(int j = array.length - 1; j > i; j --){
					array[j] = array[j-1];
				}
				array[i] = numero;
				break;
			}
		}
	}

	public void remove(int numero){
		int[] arraytemp = new int[array.length - 1];
		int j = 0;
		for(int i = 0; i < array.length; i ++){
			if(array[i] != numero){
				arraytemp[j] = array[i];
				j ++;
			}
		}
		array = arraytemp;
	}

	public int getIndexof(int numero){
		return ricercaBinaria(array, numero, 0,array.length);
	}

	public int[] getArray() {
		return array;
	}
}
