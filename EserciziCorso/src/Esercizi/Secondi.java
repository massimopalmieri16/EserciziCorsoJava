import java.util.Scanner;

public class Secondi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("Inserire numero di secondi (0 per uscire)");
            int secondi = sc.nextInt();
            if(secondi == 0) break;
            stampasecondi(secondi);
        }

    }
    public static void stampasecondi(double secondi) {
        double minuti = secondi / 60;
        double ore = minuti / 60;
        double giorni = ore / 24;

        System.out.println("Giorni: " + giorni + " Ore: " + ore + " Minuti: " + minuti + " Secondi: " + secondi);

    }
}
