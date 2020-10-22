package Esercizi;

public class CifrarioCesare {
	public static void main(String[] args) {
		int shift = -5;
		String stringa = "Ciao carissimo";

		System.out.println("Input: " + stringa + " Shift: " + shift);

		String out = cifrario(stringa, shift, false);
		System.out.println("Cifrata: " + out);

		out = cifrario(out, shift, true);
		System.out.println("Decifrata: " + stringa);
	}

	public static String cifrario(String stringa, int shift, boolean decifra) {
		String out = "";

		for (int i = 0; i < stringa.length() - 1; i ++){
			int ascii = (int) stringa.charAt(i);
			// Minuscole
			if(ascii >= 97 && ascii <= 122){
				if(decifra) ascii -= shift;
				if(!decifra) ascii += shift;
				if(ascii < 97) ascii += 26;
				if(ascii > 122) ascii -= 26;
			}
			// Maiuscole
			if(ascii >= 65 && ascii <= 90){
				if(decifra) ascii -= shift;
				if(!decifra) ascii += shift;
				if(ascii < 65) ascii += 26;
				if(ascii > 90) ascii -= 26;
			}
			out += (char)ascii;
		}
		return out;
	}
}
