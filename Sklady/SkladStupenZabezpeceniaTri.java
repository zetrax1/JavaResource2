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

public class SkladStupenZabezpeceniaTri  extends Sklad{

	//final int zabezpecenie = 3;
	
	/**
	 * Konštruktor , pridanie vybraných chemikálií do skladu
	 * 
	 */
	
	public SkladStupenZabezpeceniaTri(){
		this.Chemlist=ListCreator.createList();
		
		Chemlist.add(new Chemikalia(18296441, 10, "valtrat", "C22H30O8", false, 3, "tuhe"));
		Chemlist.add(new Chemikalia(154938, 9, "karmustin", "C5H9C12N3O2", true, 3, "plynne"));
		Chemlist.add(new Chemikalia(350129, 17, "sulbentin", "C17H18N2S2", false, 3, "tuhe"));
		Chemlist.add(new Chemikalia(19216569, 15, "prazozin", "C19H21N5O4", true, 3, "kvapalne"));
		
		zabezpecenie="3";
	}
	
}
