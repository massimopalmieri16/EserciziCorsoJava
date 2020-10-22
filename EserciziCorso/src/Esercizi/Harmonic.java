public class Harmonic {
    public static void main(String[] args) {
        System.out.println(harmonicSum(0) == (0));
        System.out.println(harmonicSum(1) == (1));
        System.out.println(harmonicSum(2) == (3./2));
        System.out.println(harmonicSum(20) == (55835135./15519504));
    }

    private static double harmonicSum(int n) {
        //inserite qui il vostro codice
        double out = 0;
        for(double i = 1; i <= n; i++){
            //System.out.println("out " + out + "i " + i);
            out = out + 1 / i;
            //System.out.println(out);
        }
        //System.out.println(out);
        return out;
    }
}
