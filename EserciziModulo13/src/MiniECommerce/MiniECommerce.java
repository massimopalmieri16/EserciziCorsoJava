package MiniECommerce;

import java.util.*;

public class MiniECommerce {
	private ArrayList<Prodotto> prodotti;

	public MiniECommerce() {
		prodotti = new ArrayList<>();
	}

	public boolean aggiungiProdotto(Prodotto prodotto){
		for (Prodotto p : prodotti) {
			if(p.equals(prodotto)){
				p.incrQuantita(prodotto.getQuantita());
				return true;
			}
		}
		return prodotti.add(prodotto);
	}

	public boolean eliminaProdotto(Prodotto prodotto){
		return prodotti.remove(prodotto);
	}

	public List<Prodotto> listaProdotti(){
		return new ArrayList<Prodotto>(prodotti);
	}

	public boolean acquistaProdotto(Prodotto prodotto, int quantita){
		for (Prodotto p : prodotti) {
			if(p.equals(prodotto)){
				if(quantita <= p.getQuantita()){
					p.acquista(quantita);
					return true;
				}
			}
		}
		return false;
	}
}
