package MinMaxRicorsivo;

public class MinMaxRicorsivo {
	public static void main(String[] args) {
		int[] arraynumeri = {5,0,4,9,2,3,-5,-3};
		Min(arraynumeri,0);
	}

	private static int Min(int[] input, int n){
		// if size = 0 means whole array
		// has been traversed
		if(n == 1)
			return input[0];

		return Math.min(input[n-1], Min(input, n-1));
	}
}
