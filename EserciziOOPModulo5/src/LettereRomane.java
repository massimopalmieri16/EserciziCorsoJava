public enum LettereRomane {
	M(1000),D(500),C(100),L(50),X(10),V(5),I(1);
	private int numerodecimale;

	LettereRomane(int numerodecimale){
		this.numerodecimale = numerodecimale;
	}

	public int toInt(){
		return numerodecimale;
	}
}
