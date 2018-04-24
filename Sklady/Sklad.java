package Sklady;

import java.util.ArrayList;
import java.util.LinkedList;

import Model.Chemikalia;
import javafx.fxml.Initializable;


/**
 * 
 *@author Vladim�r Ve�erek
 *@version 1.3
 *@since   2017-04-17
 *Trieda Sklad sl��i ako matersk� trieda presklady r�znych stupnov 
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
	 * Funkcia ktor� zr�ta hmotnos� skupenstva v aktualnom sklade
	 * @param skupenstvo String skupenstvo
	 * @return Int hmotnos� Chemik�lie na sklade
	 */
	
	public int zistiHmotnost(String skupenstvo){								// spo��ta hmotnos� zadan�ho skupenstva
		
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
	
	public String zabezpecenie(){													// vr�ti zabezpe�enie 
		return this.zabezpecenie;
	}
	
	public LinkedList<Chemikalia> getlist(){										// vr�ti Chemlist
		return this.Chemlist;
	}
	
	/**
	 * Funkcia over� �i sa chemik�lia nach�dza na sklade
	 * @param id int id chemik�lie
	 * @return Boolean true ak sa chemik�lia nach�dza na sklade
	 */
	
	public boolean zistiId(int id){													// over� v�skyt chemik�lie
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
	 * Funkcia over� �i sa chemik�lia nach�dza na sklade aspo� v zadanom mno�stve
	 * @param hmotnost int id chemik�lie , int hmotnos� 
	 * @param id chemik�lie id
	 * @return Boolean true ak sa chemik�lia nach�dza na sklade
	 */
	
	public boolean zistiHmotnosID(int hmotnost, int id){								//over� v�skyt chemik�lie v dostato�nom mno�stve
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


