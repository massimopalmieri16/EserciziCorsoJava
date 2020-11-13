package CarSharing;

public class Parcheggio {
	private String posizioneParcheggio;
	private int numPostiTotali;
	private int numPostiOccupati;

	public Parcheggio(String posizioneParcheggio, int numPostiTotali) {
		this.posizioneParcheggio = posizioneParcheggio;
		this.numPostiTotali = numPostiTotali;
		numPostiOccupati = 0;
	}

	public boolean occupaPosto(){
		if(numPostiTotali > numPostiOccupati){
			numPostiOccupati ++;
			return true;
		}else{
			return false;
		}
	}

	public void liberaPosto(){
		numPostiOccupati --;
	}

	public String getPosizioneParcheggio(){
		return posizioneParcheggio;
	}
}
