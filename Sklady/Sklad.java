package Sklady;

import java.util.ArrayList;
import java.util.LinkedList;

import Model.Chemikalia;
import javafx.fxml.Initializable;


/**
 * 
 *@author Vladimír Veèerek
 *@version 1.3
 *@since   2017-04-17
 *Trieda Sklad slúi ako materská trieda presklady rôznych stupnov 
 */
public abstract class Sklad {
	
	protected final int kapacita=100; //ton
	protected LinkedList<Chemikalia> Chemlist;
	protected  String zabezpecenie;
	
	/*
	public boolean najdiChemikaliu(int id){
		
	
	}*/
	
	//zisti aktualny pocet chemikalii v danom sklade
	public int zistiPocetChem(){
		return this.Chemlist.size();
	}
	
	/**
	 * Funkcia ktorá zráta hmotnos skupenstva v aktualnom sklade
	 * @param skupenstvo String skupenstvo
	 * @return Int hmotnos Chemikálie na sklade
	 */
	
	public int zistiHmotnost(String skupenstvo){								// spoèíta hmotnos zadaného skupenstva
		
		int hmotnost=0;
		Chemikalia chemikalia;
		
		if(!Chemlist.isEmpty()){
			
			for(int i= 0; i<Chemlist.size();i++ ){
				chemikalia=Chemlist.get(i);
				if(chemikalia.getSkupenstov().equals(skupenstvo)){
					hmotnost+=chemikalia.getHmot();
				}
			}
			return hmotnost;	
		}
			else {
				return 0;
			}
	}
	
	public String zabezpecenie(){													// vráti zabezpeèenie 
		return this.zabezpecenie;
	}
	
	public LinkedList<Chemikalia> getlist(){										// vráti Chemlist
		return this.Chemlist;
	}
	
	/**
	 * Funkcia overí èi sa chemikália nachádza na sklade
	 * @param id int id chemikálie
	 * @return Boolean true ak sa chemikália nachádza na sklade
	 */
	
	public boolean zistiId(int id){													// overí vıskyt chemikálie
		Chemikalia chemikalia;
		
		for(int i=0; i<Chemlist.size();i++){
			chemikalia=Chemlist.get(i);
			if(chemikalia.getID()==id){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Funkcia overí èi sa chemikália nachádza na sklade aspoò v zadanom mnostve
	 * @param hmotnost int id chemikálie , int hmotnos 
	 * @param id chemikálie id
	 * @return Boolean true ak sa chemikália nachádza na sklade
	 */
	
	public boolean zistiHmotnosID(int hmotnost, int id){								//overí vıskyt chemikálie v dostatoènom mnostve
		Chemikalia chemikalia;
		
		for(int i=0;i<Chemlist.size();i++){
			chemikalia=Chemlist.get(i);
			
			if(chemikalia.getID()==id && chemikalia.getHmot()>=hmotnost){
				return true;
			}
		}
		return false;
	}
	
}


