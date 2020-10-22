import java.util.Scanner;

public class Anagramma {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string a:");
        String a = sc.nextLine();
        System.out.print("Enter string b:");
        String b =sc.nextLine();
        anagrams(a, b);
    }

    static void anagrams(String a, String b) {
        char[] a_char = a.toCharArray();
        char[] b_char = b.toCharArray();
        int strlength = b_char.length;
        boolean[] b_bool = new boolean[strlength];

        if(a_char.length != b_char.length){
            System.out.print("Non anagrammi");
        }else{
            int count = 0;
            for(int i=0; i < strlength; i ++){
                for(int j=0; j < strlength; j++){
                    if(a_char[i] == b_char[j] && !b_bool[j]){
                        b_bool[j] = true;
                        count ++;
                        break;
                    }
                }
            }
            printArray(b_bool);
            if(count == strlength){
                System.out.print("Anagrammi");
            }else{
                System.out.print("Non anagrammi");
            }
        }

    }
    public static void printArray(boolean[] arrayInt) {
        System.out.print("[");
        for(int i=0; i < arrayInt.length; i ++){
            System.out.print(arrayInt[i]);
            if(i != arrayInt.length - 1) System.out.print(",");

        }
        System.out.println("]");
    }

}
