package Controler;


/**
 * 
 * @author Vladim�r Ve�erek
 * Trieda ktor� overuje pou��vatela 
 */

public class OverPrihlasenie {
	
	/**
	 * Funkcia overuj�ca u��vatela na z�klade prihlasovac�ch �dajov
	 * @param meno String meno 
	 * @param heslo
	 * @return boolean true ak je pou�ivatel overen�
	 */
	
public boolean overPrihlasenie(String meno,String heslo){
		
		if(meno.length()>0 && heslo.length()>0){
			
			return true;
		}
		else
			return false;
	 
	}
	

}
