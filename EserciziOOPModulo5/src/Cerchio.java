public class Cerchio {
	private double raggio;

	public Cerchio(double input){
		raggio = input;
	}

	public double circonferenza(){
		return raggio * 2 * Math.PI;
	}

	public double area(){
		return raggio * raggio * Math.PI;
	}
}

class TestCerchio{
	public static void main(String[] args) {
		Cerchio cerchio1 = new Cerchio(50.5);
		System.out.println("Circonferenza: " + cerchio1.circonferenza());
		System.out.println("Area: " + cerchio1.area());
	}
}
