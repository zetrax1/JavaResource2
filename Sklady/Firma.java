package Sklady;

import java.util.LinkedList;

import Controler.ListCreator;
import Controler.ZoznamCh;
import Model.Chemikalia;

/**
 * 
 *@author Vladim�r Ve�erek
 *@version 1.3
 *@since   2017-04-17
 *Trieda Firma  ded� vlastnosti triedy sklad  a obsahuje LinkedList s objednan�mi chemik�liami
 */
public class Firma extends Sklad{
	
	/**
	 * Kon�truktor
	 * 
	 */
	
	
	public Firma() {
		this.zabezpecenie=null; 											// nema zabezpe�enie
		this.Chemlist=ListCreator.createList();
		
	}
	/**
	 * Funkcia ,sl��i na pridanie chemik�lie do Chemlistu 	
	 * @param id int id chemik�lie
	 * @param hmotnost int hmotnos� chemik�lie ,
	 */
		
	public void pridajDoListu(int id, int hmotnost){						// pridanie do Chemlistu
		this.Chemlist.add(new Chemikalia(id, hmotnost));
	}
	

 	
																			//prehladavanie suboru
	/**
	 * Funkcia zistuj�ca inform�cie o Chemliste
	 * 
	 * @return String chemik�lie v chemliste
	 */
	
	
	public String zistiInfo(){												// zisti aktualne objednan� chemik�lie na firme 
		String pom="";
		int num=0;
		
		Chemikalia chemikalia;
		
		for(int i=0;i<Chemlist.size();i++){
			chemikalia=Chemlist.get(i);
			num++;
			pom +="*******\n" + Integer.toString(num) + ":ID " +chemikalia.getID() + " Hmotnos� " + chemikalia.getHmot() + "\n";
			
		}
		return pom;
	}
	
	
	/**
	 * Funkcia vracaj�ca hmotnos� skupensta 
	 * @param skupenstvo String skupenstvo chemik�lie
	 * @return hmotnos� chemik�li� dan�ho skupenstva
	 */
	
	public int vratHmotnost(String skupenstvo){									// zisti hmotnos� skupenstva na firme
		
		int hmotnost=0;
		Chemikalia chemikalia;
		ZoznamCh zoznamCh = new ZoznamCh();
		
		for(int i=0;i<Chemlist.size();i++){
			chemikalia=Chemlist.get(i);
			if(zoznamCh.citajSuborPreSkupenstvo(Integer.toString(chemikalia.getID())).equals(skupenstvo)){
				hmotnost +=chemikalia.getHmot();
				
			}
			
				
		}
		return hmotnost;
		
	}
	



}
