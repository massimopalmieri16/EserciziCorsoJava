package SommaThread;

import java.util.Arrays;

public class TestSommaThread {
	public static void main(String[] args) {
		SommaArrayThread sommaThread = new SommaArrayThread(10000000);
		//System.out.println(Arrays.toString(sommaThread.array));
		System.out.println(sommaThread.calcolaSomma());
		System.out.println(sommaThread.calcolaSommaThread());
	}
}
