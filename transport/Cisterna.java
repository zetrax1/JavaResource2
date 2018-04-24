package transport;


/**
 * 
 *@author Vladimír Veèerek
 *@version 1.4
 *
 *Trieda ,špecializované vozidlo
 */

public class Cisterna extends Vozidlo implements Nosnost{

	
	public Cisterna() {
	this.nosnost = 5;
}

	
	/**
	 * 
	 *Pretaženie
	 */
	@Override
	public void nastavNosnost(int num) {
		this.nosnost=num;
		
	}
}
