package FormaGeometrica;

public class Test {
	public static void main(String[] args) {
		FormaGeometrica quadrato1 = new Quadrato(5);
		FormaGeometrica quadrato2 = new Quadrato(5);
		FormaGeometrica rettangolo1 = new Rettangolo(5,6);
		FormaGeometrica rettangolo2 = new Rettangolo(10,6);

		System.out.println("Area " + quadrato1.toString() + " " + quadrato1.getArea());
		System.out.println("Perimetro " + quadrato1.toString() + " " + quadrato1.getPerimetro());
		System.out.println("Area " + rettangolo1.toString() + " " + rettangolo1.getArea());
		System.out.println("Perimetro " + rettangolo1.toString() + " " + rettangolo1.getPerimetro());

		System.out.println(quadrato1.equals(quadrato2));
		System.out.println(rettangolo1.equals(rettangolo2));
	}
}
