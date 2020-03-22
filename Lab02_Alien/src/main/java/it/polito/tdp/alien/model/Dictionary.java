package it.polito.tdp.alien.model;

import java.util.*;

/**
 * Classe contenente tutte le Word Aliene
 * 
 * @author Simona
 *
 */
public class Dictionary {

	List<Word> dictionary;

	public Dictionary() {
		dictionary = new ArrayList<>();
	}

	public void addWord(String parolaAliena, String traduzione) {
		for (Word s : dictionary) {
			if (parolaAliena.equals(s.getParolaAliena())) {
				s.setTraduzione(traduzione);
				return;
			}
		}
		Word w = new Word(parolaAliena, traduzione);
		dictionary.add(w);
	}

	public String translateWord(String alienWord) {
		for (Word s : dictionary) {
			if (alienWord.toLowerCase().equals(s.getParolaAliena().toLowerCase())) {
				return s.getLista();
			}
		}
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.dictionary.size();
	}

	public void clear() {
		this.dictionary.clear();

	}
}
