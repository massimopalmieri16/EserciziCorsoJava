package Anagrafe;

import java.util.*;
import java.util.stream.Collectors;

public class Anagrafe {
	private HashSet<Persona> persone;

	public Anagrafe() {
		persone = new HashSet<>();
	}

	public boolean aggiungiPersona(Persona p){
		if(!persone.contains(p)){
			return persone.add(p);
		}else {
			return false;
		}
	}

	public boolean aggiungiFiglio(Persona padre, Persona figlio){
		if(persone.contains(padre) && persone.contains(figlio)){
			return padre.aggiungiFiglio(figlio);
		}else {
			return false;
		}
	}

	public boolean rimuoviPersona(String codiceFiscale){
		Optional<Persona> p = persone.stream().filter(s -> s.getCF().equals(codiceFiscale)).findFirst();
		return p.filter(persona -> persone.remove(persona)).isPresent();
	}

	public List<Persona> getPersoneNome(String nome){
		return persone.stream().filter(n -> n.getNome().equals(nome) || n.getNome().startsWith(nome)).collect(Collectors.toList());
	}

	public List<Persona> getNAnziani(int num){
		return persone.stream().sorted(Comparator.comparing(p -> p.getData())).limit(num).collect(Collectors.toList());
	}

	public List<String> getIndirizziNomi(String nome){
		return persone.stream().filter(p -> p.getNome().equals(nome)).map(p -> p.getResidenza()).collect(Collectors.toList());
	}

	public List<Persona> getFigliNome(String nome){
		return persone.stream().filter(p -> p.getNome().equals(nome)).map(p -> p.getFigli()).flatMap(Collection::stream).collect(Collectors.toList());
	}
}
