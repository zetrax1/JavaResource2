package transport;

/**
 * 
 *@author Vladimír Veèerek
 *@version 1.4
 *
 *Trieda ,špecializované vozidlo
 */

public class Kamion extends Vozidlo implements Nosnost {
	
	
	public Kamion() {
		this.nosnost=10;
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
