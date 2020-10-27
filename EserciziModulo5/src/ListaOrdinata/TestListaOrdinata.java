package ListaOrdinata;

import java.util.Arrays;

public class TestListaOrdinata {
	public static void main(String[] args) {
		ListaOrdinata listaOrdinata = new ListaOrdinata();
		listaOrdinata.insert(5);
		System.out.println(Arrays.toString(listaOrdinata.getArray()));
		listaOrdinata.insert(2);
		System.out.println(Arrays.toString(listaOrdinata.getArray()));
		listaOrdinata.insert(7);
		System.out.println(Arrays.toString(listaOrdinata.getArray()));
		listaOrdinata.insert(3);
		System.out.println(Arrays.toString(listaOrdinata.getArray()));
		listaOrdinata.insert(-5);
		System.out.println(Arrays.toString(listaOrdinata.getArray()));

		System.out.println(listaOrdinata.getIndexof(7));

		listaOrdinata.remove(-5);
		System.out.println(Arrays.toString(listaOrdinata.getArray()));

	}
}
