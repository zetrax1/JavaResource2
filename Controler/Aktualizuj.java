package Controler;


import javafx.scene.control.TextField;

/**
 * 
 * @author Vladimír Veèerek
 * Trieda urèená na aktualizáciu množstva objednaných látok 
 */

public class Aktualizuj extends TextField implements SledovatelObjednavky{


	/**
	 * Atribúty triedy
	 */
	
	private int pocet=0;
	private Controller controller;
	

	/**
	 * Funkcia pre zistenie a nastavenie aktualneho poètu objednávok
	 */
	
	public void upovedom() {
		pocet = controller.zistiPocetObjednavok();
		setText(Integer.toString(pocet));
		setEditable(false);
		
	}
	

	/**
	 * Konštruktor 
	 * @param controller 
	 */
	
	public Aktualizuj(Controller controller) {
		super();
		this.controller =controller;
		setPromptText("0"); 
		setEditable(false);
	}

}
