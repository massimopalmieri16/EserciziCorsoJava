package Iterabile;

import java.util.Arrays;

public class ListaDiInteri implements Iterabile, Lista{
	private int[] listaDiInteri;
	private int index;

	ListaDiInteri(int[] listaDiInteri){
		this.listaDiInteri = listaDiInteri;
		index = 0;
	}
	ListaDiInteri(){
		this.listaDiInteri = new int[0];
		index = 0;
	}

	@Override
	public Object next() {
		if(index >= listaDiInteri.length) return null;
		return listaDiInteri[index ++];
	}

	@Override
	public boolean hasNext() {
		return index < listaDiInteri.length;
	}

	@Override
	public void reset() {
		index = 0;
	}

	@Override
	public int get(int i) {
		return listaDiInteri[i];
	}

	@Override
	public boolean contains(Object o) {
		for(int i:listaDiInteri){
			if(i == (int) o) return true;
		}
		return false;
	}

	@Override
	public int size() {
		return listaDiInteri.length;
	}

	@Override
	public void add(Object o) {
		listaDiInteri = Arrays.copyOf(listaDiInteri,listaDiInteri.length + 1);
		listaDiInteri[listaDiInteri.length - 1] = (int) o;
	}

	@Override
	public boolean remove(int i_remove) {
		if(i_remove >= listaDiInteri.length) return false;
		int[] arraytemp = new int[listaDiInteri.length - 1];
		int j = 0;
		for(int i = 0; i < listaDiInteri.length; i ++){
			if(i != i_remove){
				arraytemp[j] = listaDiInteri[i];
				j ++;
			}
		}
		listaDiInteri = arraytemp;
		return true;
	}

	@Override
	public void clear() {
		listaDiInteri = new int[0];
		index = 0;
	}
}
