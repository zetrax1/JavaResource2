package transport;

/**
 * 
 *@author Vladim�r Ve�erek
 *@version 1.4
 *
 *Trieda ,�pecializovan� vozidlo
 */

public class Kamion extends Vozidlo implements Nosnost {
	
	
	public Kamion() {
		this.nosnost=10;
	}

	
	/**
	 * 
	 *Preta�enie 
	 */
	@Override
	public void nastavNosnost(int num) {
		this.nosnost=num;
	}
	
}
