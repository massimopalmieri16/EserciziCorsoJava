package Esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class MinMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numbers (comma-separated):");
		String a = sc.nextLine();
		int[] values = parseNumbers(a);
		Arrays.sort(values);
		printArray(values);
	}

	static int[] parseNumbers(String s) {
		String[] str_split = s.split(",");
		int[] num = new int[str_split.length];
		for (int i = 0; i < str_split.length; i++) {
			num[i] = Integer.parseInt(str_split[i]);
		}
		return num;
	}

	public static void printArray(int[] arrayInt) {
		System.out.print("[");
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.print(arrayInt[i]);
			if (i != arrayInt.length - 1) System.out.print(",");

		}
		System.out.println("]");
	}

	public static void printArray(String[] arrayInt) {
		System.out.print("[");
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.print(arrayInt[i]);
			if (i != arrayInt.length - 1) System.out.print(",");

		}
		System.out.println("]");
	}
}
