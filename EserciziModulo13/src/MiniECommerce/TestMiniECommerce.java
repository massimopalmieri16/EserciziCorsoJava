package MiniECommerce;

import com.google.gson.Gson;
import java.util.UUID;
import static spark.Spark.*;

public class TestMiniECommerce {
	public static void main(String[] args) {
		MiniECommerce miniECommerce = new MiniECommerce();
		Gson gson = new Gson();

		get("/listaProdotti", (req, res) -> new Gson().toJson(miniECommerce.listaProdotti()));

		post("/aggiungiProdotto", (req, res) -> {
			System.out.println("ricevuta richiesta aggiungiProdotto");
			Prodotto p = gson.fromJson(req.body(), Prodotto.class);
			//p.genId();

			return miniECommerce.aggiungiProdotto(p);
		});

		post("/eliminaProdotto", (req, res) -> {
			System.out.println("ricevuta richiesta aggiungiProdotto");
			UUID id = UUID.fromString(req.queryMap().get("id").value());
			for (Prodotto prodotto : miniECommerce.listaProdotti()) {
				if(prodotto.getId().equals(id)){
					miniECommerce.eliminaProdotto(prodotto);
					return true;
				}
			}
			res.status(404);
			return "Prodotto non trovato";
		});

		post("/acquistaProdotto", (req, res) -> {
			System.out.println("ricevuta richiesta acquistaProdotto");
			UUID id = UUID.fromString(req.queryMap().get("id").value());
			int quantita = req.queryMap().get("quantita").integerValue();
			for (Prodotto prodotto : miniECommerce.listaProdotti()) {
				if(prodotto.getId().equals(id)){
					if(miniECommerce.acquistaProdotto(prodotto, quantita)){
						return true;
					}else{
						res.status(400);
						return "Quantita non disponibile";
					}
				}
			}
			res.status(404);
			return "Prodotto non trovato";
		});
	};
}
