package Esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class MatriceQuadrata {
    public static void main(String[] args) {

        int[][] data = {{8,7,6}, {10,11,12}, {30,31,32}};

        System.out.println(sommaDiagonaleLtoR(data));
        printArray2D(data);
        System.out.println(sommaDiagonaleRtoL(data));
    }

    public static int sommaDiagonaleLtoR(int[][] data) {
        int somma = 0;

        for(int i=0; i < data.length; i++){
            somma += data[i][i];
        }
        return somma;
    }
    public static int sommaDiagonaleRtoL(int[][] data) {
        // inverto array
        int numappo;
        for(int i = 0; i < data.length - 1; i ++){
            for(int j = 0; j < data[0].length - 1; j ++){
                numappo = data[i][data.length - j - 1];
                data[i][data.length - j - 1] = data[i][j];
                data[i][j] = numappo;
            }
        }
        printArray2D(data);
        return sommaDiagonaleLtoR(data);
    }
    public static void printArray2D(int[][] arrayInt) {
        for(int i = 0; i < arrayInt.length; i ++) {
            System.out.print("[");
            for (int j = 0; j < arrayInt.length; j++) {
                System.out.print(arrayInt[i][j]);
                if (j != arrayInt.length - 1) System.out.print(",");

            }
            System.out.println("]");
        }
    }
}
