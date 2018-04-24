package Controler;


/**
 * 
 * @author Vladimír Veèerek
 * Trieda ktorá overuje pouívatela 
 */

public class OverPrihlasenie {
	
	/**
	 * Funkcia overujúca uívatela na základe prihlasovacích údajov
	 * @param meno String meno 
	 * @param heslo
	 * @return boolean true ak je pouivatel overenı
	 */
	
public boolean overPrihlasenie(String meno,String heslo){
		
		if(meno.length()>0 && heslo.length()>0){
			
			return true;
		}
		else
			return false;
	 
	}
	

}
