package Controler;


/**
 * 
 * @author Vladimír Večerek
 * Trieda ktorá overuje používatela 
 */

public class OverPrihlasenie {
	
	/**
	 * Funkcia overujúca užívatela na základe prihlasovacích údajov
	 * @param meno String meno 
	 * @param heslo
	 * @return boolean true ak je použivatel overený
	 */
	
public boolean overPrihlasenie(String meno,String heslo){
		
		if(meno.length()>0 && heslo.length()>0){
			
			return true;
		}
		else
			return false;
	 
	}
	

}
