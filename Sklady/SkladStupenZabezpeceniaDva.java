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

public class SkladStupenZabezpeceniaDva extends Sklad {
	
	//final int zabezpecenie = 2;
	
	/**
	 * Konštruktor , pridanie vybraných chemikálií do skladu
	 * 
	 */
	
public SkladStupenZabezpeceniaDva(){
		
		this.Chemlist=ListCreator.createList();
		
		Chemlist.add(new Chemikalia(18291800, 10, "trimetylsilylbromacetat", "C5H11BrO2Si", false, 2, "kvapalne"));
		Chemlist.add(new Chemikalia(18397074, 14, "pereirin", "C19H26N20", true, 2, "plynne"));
		Chemlist.add(new Chemikalia(353366, 17, "fluoretan", "C2H5F", false, 2, "kvapalne"));
		Chemlist.add(new Chemikalia(19056269, 8, "chindekamin", "C30H38N4", false, 2, "kvapalne"));
		
		zabezpecenie="2";
	}

	
}
