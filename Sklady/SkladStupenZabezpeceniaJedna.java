package Sklady;

import Controler.ListCreator;
import Model.Chemikalia;

/**
 * 
 *@author Vladimír Veèerek
 *@version 1.3
 *
 *Objekt typu sklad zo špecifickov vlastnostou 
 */

public class SkladStupenZabezpeceniaJedna extends Sklad {
	
	
	//zaplnenie % int
	
	//konstruktor
	
	/**
	 * Konštruktor , pridanie vybraných chemikálií do skladu
	 * 
	 */
	
	public SkladStupenZabezpeceniaJedna(){
		
		this.Chemlist=ListCreator.createList();
		
		Chemlist.add(new Chemikalia(18991985, 10, "butylbromacetat", "C6H11BrO2", false, 1, "tuhe"));
		Chemlist.add(new Chemikalia(330541, 25, "diuron", "C9H10Cl2N2O2", false, 1, "plynne"));
		Chemlist.add(new Chemikalia(18244956, 17, "metyltrivinylsilan", "C7H12Si", false, 1, "kvapalne"));
		Chemlist.add(new Chemikalia(203805, 25, "fanalen", "C13H10", true, 1, "kvapalne"));
		

		zabezpecenie="1";
	}
	
	
	
	
	
}
