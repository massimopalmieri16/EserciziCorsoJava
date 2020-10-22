/*import java.util.Scanner;

public class InvertiStringa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        reverseString(a);
    }

    private static void reverseString(String s) {
        String[] split = s.split("");
        //System.out.println(split[1] + " " + split[0]);
        int strlenght = split.length;
        for(int i=0; i < strlenght; i ++){
            System.out.print(split[strlenght - i - 1]);
        }
    }
}*/

import java.util.Scanner;

public class InvertiStringa {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string:");
        String a = sc.nextLine();
        stringReverse(a);
    }

    static void stringReverse(String s) {
        //inserite qui il vostro codice
        char[] s_char = s.toCharArray();
        int strlenght = s_char.length;
        String out = "";
        for(int i=0; i < strlenght; i ++){
            out = out + (s_char[strlenght - i - 1]);
        }
        System.out.print("Output: " + out);
    }
}


