package Generics;

public class LinkedList <T> {
	private Elemento first;

	private class Elemento <T>{
		private T valore;
		private Elemento prossimo;

		Elemento(T valore, Elemento<T> prossimo){
			this.valore = valore;
			this.prossimo = prossimo;
		}
	}

	public void addFirst(T value){
		first = new Elemento(value,first);
	}
	public void removeFirst(){
		first = first.prossimo;
	}
}
