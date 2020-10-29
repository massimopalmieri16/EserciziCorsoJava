package Biblioteca;
import static Utils.MergeSortArray.mergeSort;

public class Biblioteca {
	int[] libri;

	Biblioteca(int[] libri){
		this.libri = mergeSort(libri);
	}

	public boolean esisteLibro(int libroinput){
		for (int i:libri) {
			if(i == libroinput) return true;
		}
		return false;
	}

	public int[] getIndiciLibriOrdinati(){
		return libri;
	}
}
