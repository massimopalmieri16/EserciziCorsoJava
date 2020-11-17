package SommaThread;

import java.util.Arrays;

public class SommaArrayThread {
	public int[] array;

	SommaArrayThread(int dimensioneArray){
		array = new int[dimensioneArray];
		for (int i = 0; i < array.length; i++) {
			array[i] = RandomRange.getRandomNumber(-10, 10);
		}
	}

	public int calcolaSomma(){
		int somma = 0;
		for (int i : array) {
			somma += i;
		}
		return somma;
	}

	public int calcolaSommaThread(){

		//ThreadSomma thread0 = new ThreadSomma(Arrays.copyOfRange(array, 0, array.length));
		ThreadSomma thread0 = new ThreadSomma(Arrays.copyOfRange(array, 0, array.length / 2));
		ThreadSomma thread1 = new ThreadSomma(Arrays.copyOfRange(array, array.length / 2, array.length));

		thread0.start();
		thread1.start();

		try{
			thread0.join();
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return thread0.getSomma() + thread1.getSomma();
	}
}
