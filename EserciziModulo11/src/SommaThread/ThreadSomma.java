package SommaThread;

import java.util.Arrays;

public class ThreadSomma extends Thread {
	int[] array;
	int somma;

	ThreadSomma(int[] array){
		this.array = array;
		this.somma = 0;
	}

	@Override
	public void run() {
		//System.out.println(Arrays.toString(array));
		for (int i : array) {
			somma += i;
		}
	}

	public int getSomma() {
		return somma;
	}
}
