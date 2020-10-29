package MinMaxRicorsivo;

public class MinMaxRicorsivo {
	public static void main(String[] args) {
		int[] arraynumeri = {5,0,4,9,2,3,-5,-3};
		System.out.println(Min(arraynumeri,0));
		System.out.println(Max(arraynumeri,0));
	}

	private static int Min(int[] input, int index){
		if(index == input.length - 1)
			return input[index];

		return Math.min(input[index], Min(input, index + 1));
	}
	private static int Max(int[] input, int index){
		if(index == input.length - 1)
			return input[index];

		return Math.max(input[index], Max(input, index + 1));
	}
}
