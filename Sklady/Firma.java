package Sklady;

import java.util.LinkedList;

import Controler.ListCreator;
import Controler.ZoznamCh;
import Model.Chemikalia;

/**
 * 
 *@author Vladimír Veèerek
 *@version 1.3
 *@since   2017-04-17
 *Trieda Firma  dedí vlastnosti triedy sklad  a obsahuje LinkedList s objednanımi chemikáliami
 */
public class Firma extends Sklad{
	
	/**
	 * Konštruktor
	 * 
	 */
	
	
	public Firma() {
		this.zabezpecenie=null; 											// nema zabezpeèenie
		this.Chemlist=ListCreator.createList();
		
	}
	/**
	 * Funkcia ,slúi na pridanie chemikálie do Chemlistu 	
	 * @param id int id chemikálie
	 * @param hmotnost int hmotnos chemikálie ,
	 */
		
	public void pridajDoListu(int id, int hmotnost){						// pridanie do Chemlistu
		this.Chemlist.add(new Chemikalia(id, hmotnost));
	}
	

 	
																			//prehladavanie suboru
	/**
	 * Funkcia zistujúca informácie o Chemliste
	 * 
	 * @return String chemikálie v chemliste
	 */
	
	
	public String zistiInfo(){												// zisti aktualne objednané chemikálie na firme 
		String pom="";
		int num=0;
		
		Chemikalia chemikalia;
		
		for(int i=0;i<Chemlist.size();i++){
			chemikalia=Chemlist.get(i);
			num++;
			pom +="*******\n" + Integer.toString(num) + ":ID " +chemikalia.getID() + " Hmotnos " + chemikalia.getHmot() + "\n";
			
		}
		return pom;
	}
	
	
	/**
	 * Funkcia vracajúca hmotnos skupensta 
	 * @param skupenstvo String skupenstvo chemikálie
	 * @return hmotnos chemikálií daného skupenstva
	 */
	
	public int vratHmotnost(String skupenstvo){									// zisti hmotnos skupenstva na firme
		
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
