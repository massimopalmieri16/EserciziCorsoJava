public class StringCompare {

    public static void main(String[] args) {
        String a = "ciao come va ?";
        String b = "cIao come vA ?";
        String c = "ciao come va ";
        System.out.println("2".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIaoo come vA ?";
        c = "ciao come va a";
        System.out.println("1".equals(""+compareStrings(a, b, c)));
        a = "ciao come va ?";
        b = "cIao come va ?";
        c = "ciao come vA ?";
        System.out.println("3".equals(""+compareStrings(a, b, c)));
    }

    private static int compareStrings(String a, String b, String c) {
        //inserite il vostro codice qui
        int cont_equals = 0;
        boolean a_eq_b = a.equalsIgnoreCase(b);
        boolean a_eq_c = a.equalsIgnoreCase(c);
        boolean b_eq_c = b.equalsIgnoreCase(c);
        if(a_eq_b && b_eq_c){
            cont_equals = 3;
        }
        else if((a_eq_b && !a_eq_c && !b_eq_c) || (!a_eq_b && a_eq_c && !b_eq_c) || (!a_eq_b && !a_eq_c && b_eq_c)){
            cont_equals = 2;
        }
        else{
            cont_equals = 1;
        }

        return cont_equals;
    }
}
