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

public class SkladStupenZabezpeceniaStyri extends Sklad {

	//final int zabezpecenie = 4;
	
	/**
	 * Konštruktor , pridanie vybraných chemikálií do skladu
	 * 
	 */
	
	public SkladStupenZabezpeceniaStyri() {
		this.Chemlist = ListCreator.createList();
		Chemlist.add(new Chemikalia(18297988, 8, "fenyldihexylfosfan", "C18H31P", false, 4, "tuhe"));
		Chemlist.add(new Chemikalia(151633, 35, "aziridin", "C2H5N", false, 4, "plynne"));
		Chemlist.add(new Chemikalia(154427, 7, "tioguanin", "C5H5N5S", false, 4, "tuhe"));
		Chemlist.add(new Chemikalia(339435, 5, "karbutamid", "C11H17N3O3S", false, 4, "tuhe"));
		
		zabezpecenie="4";
	}
}
