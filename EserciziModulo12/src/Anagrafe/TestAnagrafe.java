package Anagrafe;

import java.time.LocalDate;

public class TestAnagrafe {
	public static void main(String[] args) {
		Anagrafe anagrafe = new Anagrafe();
		Persona p1 = new Persona("Mario", "Rossi", LocalDate.of(1950,5,4), "CF1", "via 1");
		Persona p2 = new Persona("Marco", "Rossi", LocalDate.of(1975,10,7), "CF2", "via 2");
		Persona p3 = new Persona("Matteo", "Rossi", LocalDate.of(1995,6,8), "CF3", "via 3");
		Persona p4 = new Persona("Mario", "Rosso", LocalDate.of(1972,6,9), "CF4", "via 4");
		System.out.println(anagrafe.aggiungiPersona(p1));
		System.out.println(anagrafe.rimuoviPersona("CF1"));
		System.out.println(anagrafe.aggiungiPersona(p1));
		System.out.println(anagrafe.aggiungiPersona(p2));
		System.out.println(anagrafe.aggiungiPersona(p3));
		System.out.println(anagrafe.aggiungiPersona(p4));
		System.out.println(anagrafe.getPersoneNome("Marco").toString());
		System.out.println(anagrafe.getNAnziani(2).toString());
		System.out.println(anagrafe.getIndirizziNomi("Mario").toString());
		System.out.println(anagrafe.aggiungiFiglio(p1, p2));
		System.out.println(anagrafe.aggiungiFiglio(p1, p3));
		System.out.println(anagrafe.aggiungiFiglio(p4, p1));
		System.out.println(anagrafe.getFigliNome("Mario").toString());
	}
}
