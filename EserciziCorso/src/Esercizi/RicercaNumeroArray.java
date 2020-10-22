package Esercizi;

import java.util.Scanner;

public class RicercaNumeroArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.println(trova(array, n, 0, array.length));
	}

	public static int trova (int [] array, int n, int inizio, int fine){

		int centro = inizio + (fine - inizio) / 2;

		if(centro == inizio || centro == fine) return -1;
		if(array[centro] == n ){
			return centro;
		}else {
			if (array[centro] > n) {
				return trova(array, n, inizio, centro);
			}else {
				return trova(array, n, centro, fine);
			}
		}
	}
}
