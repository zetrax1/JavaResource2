package Controler;


import java.util.LinkedList;


/**
 * 
 * @author Vladim�r Ve�erek
 * Trieda pre generovanie LinkedListov
 */

public class ListCreator {

	
	//genericka metoda
	
	/**
	 * generick� met�da ,sl��i na vytvorenie LinkedListov
	 * @param <T> druh objektu
	 * @return  LinkedList();
	 */
	public static <T> LinkedList<T> createList(){
		return new LinkedList();
	}
}
