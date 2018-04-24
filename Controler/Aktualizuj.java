package Controler;


import javafx.scene.control.TextField;

/**
 * 
 * @author Vladim�r Ve�erek
 * Trieda ur�en� na aktualiz�ciu mno�stva objednan�ch l�tok 
 */

public class Aktualizuj extends TextField implements SledovatelObjednavky{


	/**
	 * Atrib�ty triedy
	 */
	
	private int pocet=0;
	private Controller controller;
	

	/**
	 * Funkcia pre zistenie a nastavenie aktualneho po�tu objedn�vok
	 */
	
	public void upovedom() {
		pocet = controller.zistiPocetObjednavok();
		setText(Integer.toString(pocet));
		setEditable(false);
		
	}
	

	/**
	 * Kon�truktor 
	 * @param controller 
	 */
	
	public Aktualizuj(Controller controller) {
		super();
		this.controller =controller;
		setPromptText("0"); 
		setEditable(false);
	}

}
