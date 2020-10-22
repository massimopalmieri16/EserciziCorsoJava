public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("c"));
        System.out.println(isPalindrome("ciic"));
        System.out.println(isPalindrome("aaaa"));
        System.out.println(!isPalindrome("absca"));
        System.out.println(!isPalindrome("abbaa"));
        System.out.println(isPalindrome("zzzzz"));
        System.out.println(isPalindrome("zzczz"));
        System.out.println(isPalindrome("aabbaa"));
    }

    private static boolean isPalindrome(String s) {
        //inserite qui il vostro codice
        String s_reverse = stringReverse(s);
        //System.out.println("s: " + s + "\ns_reverse: " + s_reverse);
        if(s.equals(s_reverse) == true) {
            return true;
        }else{
            return false;
        }
    }
    private static String stringReverse(String s) {
        //inserite qui il vostro codice
        char[] s_char = s.toCharArray();
        int strlength = s_char.length;
        String out = "";
        for(int i=0; i < strlength; i ++){
            out = out + (s_char[strlength - i - 1]);
        }
        return out;
    }
}
