import java.util.Scanner;

public class PariDispari {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number:");
        int number =sc.nextInt();
        checkEvenOdd(number);
    }

    private static void checkEvenOdd(int number) {
        //inserite qui il vostro codice
        if(number % 2 == 0){
            System.out.print("The number is even");
        }else{
            System.out.print("The number is odd");
        }
    }
}