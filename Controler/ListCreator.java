package Controler;


import java.util.LinkedList;


/**
 * 
 * @author Vladimír Veèerek
 * Trieda pre generovanie LinkedListov
 */

public class ListCreator {

	
	//genericka metoda
	
	/**
	 * generická metóda ,slúži na vytvorenie LinkedListov
	 * @param <T> druh objektu
	 * @return  LinkedList();
	 */
	public static <T> LinkedList<T> createList(){
		return new LinkedList();
	}
}
