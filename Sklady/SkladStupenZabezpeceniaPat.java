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

public class SkladStupenZabezpeceniaPat  extends Sklad {

	//final int zabezpecenie = 5;
	
	/**
	 * Konštruktor , pridanie vybraných chemikálií do skladu
	 * 
	 */
	
	public SkladStupenZabezpeceniaPat() {
		this.Chemlist=ListCreator.createList();
		Chemlist.add(new Chemikalia(18390551, 10, "litiumpikrat", "C6H3N3O7", true, 5, "tuhe"));
		Chemlist.add(new Chemikalia(152476, 12, "sulfalen", "C11H12N4O3S", false, 5, "tuhe"));
		Chemlist.add(new Chemikalia(190261, 17, "ovalen", "C32H14", false, 5, "plynne"));
		Chemlist.add(new Chemikalia(334883, 4, "diazometan", "CH2N2", false, 5, "plynne"));
		
		zabezpecenie="5";
	}

}
