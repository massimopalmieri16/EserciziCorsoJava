import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Waiting for input...");
        int n = sc.nextInt();

        System.out.println(printFibonacci(n));

    }

    public static int printFibonacci(int n) {
        int[] serie = new int[n + 1];
        for(int i=0; i <= n; i ++){
            if(i > 1){
                serie[i] = serie[i - 1] + serie[i - 2];
            }
            else if(i == 1)serie[i] = 1;

        }
        printArray(serie);
        return serie[n];
    }


    public static void printArray(int[] arrayInt) {
        System.out.print("[");
        for(int i=0; i < arrayInt.length; i ++){
            System.out.print(arrayInt[i]);
            if(i != arrayInt.length - 1) System.out.print(",");

        }
        System.out.println("]");
    }
}
