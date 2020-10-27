package Forme;

public class Quadrato {
	private int lato;
	Colore colore = Colore.BLACK;

	public Quadrato(int input){
		lato = input;
	}

	public int perimetro(){
		return lato * 4;
	}

	public void stampaQuadrato(){
		for(int row = 0; row < lato; row ++){
			for(int col = 0; col < lato; col ++) {
				if (row == 0 || row == lato - 1 || col == 0 || col == lato - 1) {
					System.out.print("*  ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
	}
}

class testQuadrato{
	public static void main(String[] args) {
		Quadrato quadrato1 = new Quadrato(10);
		quadrato1.stampaQuadrato();
	}
}
