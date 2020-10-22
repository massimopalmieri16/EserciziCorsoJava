import java.util.Scanner;

public class Tabellina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Waiting for input...");
        int n = sc.nextInt();
        int[] out = new int[10];

        tabellina(n, out);

    }

    public static void tabellina(int n, int[] out) {
        for(int i=1; i <= 10; i ++){
            out[i - 1] = n * i;
        }
        printArray(out);
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
