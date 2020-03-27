
package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.Dictionary;
import it.polito.tdp.alien.model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Dictionary dictionary;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnTranslate;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnClear;

	@FXML
	void doTranslate(ActionEvent event) {
		this.txtResult.clear();
		String input = this.txtParola.getText();

		if (input.matches("[a-zA-Z\\s]*") == true) {
			String parola;
			String traduzione = "";
			if (input.contains(" ")) {
				StringTokenizer st = new StringTokenizer(input, " ");
				if (st.countTokens() == 2) {
					parola = st.nextToken();
					traduzione = st.nextToken();

					this.dictionary.addWord(parola, traduzione);
				} else {
					this.txtResult.setText("Non inserire lo spazio dopo la parola che vuoi tradurre");
				}

			} else if (this.dictionary.size() != 0) {
				parola = input;
				if (this.dictionary.translateWord(parola) == null) {
					this.txtResult.setText("La parola non è stata inserita nel vocabolario");
				}

				this.txtResult.setText("La traduzioe di " + parola.toUpperCase() + " è/sono: "
						+ this.dictionary.translateWord(parola).toUpperCase());
			} else {
				this.txtResult.setText("Prima di tradurre devi inserire delle parole nel vocabolario");
			}
		} else {
			this.txtResult.setText("Devi inserire solo caratteri alfabetici");
		}
		this.txtParola.clear();
	}

	@FXML
	void doClear(ActionEvent event) {
		this.txtResult.clear();
		this.dictionary.clear();
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

	}
}
