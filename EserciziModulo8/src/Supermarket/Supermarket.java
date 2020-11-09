package Supermarket;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Supermarket {
	Queue<Cliente> coda;

	public Supermarket() {
		//coda = new ArrayDeque<>();
		coda = new PriorityQueue<>();
	}

	public void aggiungiCliente(Cliente cliente){
		coda.offer(cliente);
	}

	public Cliente serviCliente(){
		return coda.poll();
	}

	public int numeroClienti(){
		return coda.size();
	}

	public Cliente prossimoCliente(){
		return coda.peek();
	}
}
