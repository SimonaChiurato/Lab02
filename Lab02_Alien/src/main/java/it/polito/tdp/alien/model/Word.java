package it.polito.tdp.alien.model;

/**
 * Classe contenente parole aliene e traduzione in italiano
 * 
 * @author Simona
 *
 */
public class Word {

	String ParolaAliena;
	String Traduzione;

	public Word(String parolaAliena, String traduzione) {
		super();
		ParolaAliena = parolaAliena;
		Traduzione = traduzione;
	}

	public String getParolaAliena() {
		return ParolaAliena;
	}

	public String getTraduzione() {
		return Traduzione;
	}

	public void setParolaAliena(String parolaAliena) {
		ParolaAliena = parolaAliena;
	}

	public void setTraduzione(String traduzione) {
		Traduzione = traduzione;
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

}
