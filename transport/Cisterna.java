package transport;


/**
 * 
 *@author Vladim�r Ve�erek
 *@version 1.4
 *
 *Trieda ,�pecializovan� vozidlo
 */

public class Cisterna extends Vozidlo implements Nosnost{

	
	public Cisterna() {
	this.nosnost = 5;
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
