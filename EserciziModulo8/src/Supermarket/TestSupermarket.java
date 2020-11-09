package Supermarket;

public class TestSupermarket {
	public static void main(String[] args) {
		Supermarket supermarket = new Supermarket();
		supermarket.aggiungiCliente(new Cliente(1, "Mario", "Cognome", 20));
		supermarket.aggiungiCliente(new Cliente(2, "Luigi", "Cognome", 50));
		supermarket.aggiungiCliente(new Cliente(3, "Andrea", "Cognome", 30));
		supermarket.aggiungiCliente(new Cliente(4, "Andrea", "Cognome", 70));
		System.out.println(supermarket.serviCliente().toString());
		System.out.println(supermarket.serviCliente().toString());
		System.out.println(supermarket.serviCliente().toString());
		System.out.println(supermarket.serviCliente().toString());
	}
}
