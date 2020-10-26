public class Colore {
	int r,g,b;
	public static final Colore BLACK = new Colore(0,0,0);
	public static final Colore WHITE = new Colore(255,255,255);

	public Colore(int r, int g, int b){
		setRgb(r,g,b);
	}
	public void setRgb(int r, int g, int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
