package Contatore;

public class Lampadina{
	private StatoLampadina stato = StatoLampadina.SPENTO;
	private int clickMax;

	Lampadina(int clickMax){
		this.clickMax = clickMax;
	}
	public StatoLampadina getStato(){
		return stato;
	}

	public void click() {

		if(clickMax >= 0){
			switch (stato) {
				case SPENTO:{
					stato = StatoLampadina.ACCESO;
					clickMax --;
					break;
				}
				case ACCESO:{
					stato = StatoLampadina.SPENTO;
					clickMax --;
					break;
				}
				case ROTTO:
					break;
			}
			if(clickMax == 0){
				stato = StatoLampadina.ROTTO;

			}
		}
	}
}



















/*public class Lampadina {
	private boolean stato;
	private boolean rotto;
	private int stato; // -1 rotto, 0 spenta, 1 accesa
	private int clickMax;

	public Lampadina(int clickMax){
		this.clickMax = clickMax;
		stato = 0;
	}

	public int getStato(){
		return stato;
	}

	public void click(){
		if(stato != -1) {
			if (stato == 1) {
				stato = 0;
			} else {
				stato = 1;
			}
			clickMax--;
			if(clickMax == 0)
				stato = -1;
		}
	}
}*/
