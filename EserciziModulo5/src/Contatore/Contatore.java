package Contatore;

public class Contatore {

	private int valore;

	public Contatore(){
		this.valore = 0;
	}

	public Contatore(int init){
		this.valore = init;
	}

	public void incrementa(){
		valore ++;
	}

	public int getValore(){
		return valore;
	}

	public void reset(){
		valore = 0;
	}

	public void setValore(int input){
		valore = input;
	}
}

class testContatore{
	public static void main(String[] args){
		Contatore contatore = new Contatore(5);

		System.out.println("Valore contatore: " + contatore.getValore());
		contatore.reset();
		System.out.println("Valore contatore: " + contatore.getValore());
		contatore.setValore(10);
		System.out.println("Valore contatore: " + contatore.getValore());
		contatore.incrementa();
		System.out.println("Valore contatore: " + contatore.getValore());
	}
}
