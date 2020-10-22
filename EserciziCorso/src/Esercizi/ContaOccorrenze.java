import java.util.Scanner;

public class ContaOccorrenze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter character a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        countOccurrences(a.charAt(0), b);
    }

    static void countOccurrences(char a, String b) {
        //inserite qui il vostro codice
        int length = b.length();
        int count = 0;
        char[] b_char = b.toCharArray();
        for(int i=0; i<length; i++){
            if(b_char[i] == a){
                count ++;
            }
        }
        System.out.print("Occurrences 1: " + count);
    }
}
