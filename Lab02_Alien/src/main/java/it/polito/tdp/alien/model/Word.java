package it.polito.tdp.alien.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe contenente parole aliene e traduzione in italiano
 * 
 * @author Simona
 *
 */
public class Word {

	String ParolaAliena;
	List<String> Traduzione;

	public Word(String parolaAliena, String traduzione) {
		super();
		ParolaAliena = parolaAliena;
		Traduzione = new LinkedList<>();
		Traduzione.add(traduzione);
	}

	public String getParolaAliena() {
		return ParolaAliena;
	}

	public void setParolaAliena(String parolaAliena) {
		ParolaAliena = parolaAliena;
	}

	public List<String> getTraduzione() {
		return Traduzione;
	}

	public void setTraduzione(String traduzione) {
		Traduzione.add(traduzione);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Word) {
			Word c = (Word) o;

			if (this.ParolaAliena.toLowerCase().equals(c.getParolaAliena().toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public String getLista() {
		String s = null;
		for (String c : Traduzione) {
			if (s == null) {
				s = c;

			} else {
				s += "; " + c;
			}
		}
		return s;
	}

}
