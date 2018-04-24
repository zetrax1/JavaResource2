package Model;
/**
 * 
 *@author Vladim�r Ve�erek
 *Objekt Chemik�lia ur�uj�ci jej vlastnosti
 */

public class Chemikalia {
	/**
	 * 
	 *Vlasnosti chemik�lie
	 *
	 */
													// vlasnosti chemik�lie
	private int ID;
	private int hmotnost;
	private String nazov;
	private String vzorec;
	private boolean reaktivita;
	private int zabezpecenie;
	private String skupenstvo;
	
	/**
	 * 
	 *Kon�truktor
	 *@param id int id chemik�lie
	 *@param weight int hmotnos� chemik�lie
	 *@param name String meno chemik�lie
	 *@param model String Chemick� vzorec
	 *@param reactivity Boolean reaktivita chemik�lie - true reakt�vna
	 *@param security zabezpe�enie chemik�lie
	 *@param state skupenstvo chemik�lie
	 */
													//kon�truktor prideluj�ci vlasnosti
	
	public Chemikalia(int id, int weight, String name, String model, boolean reactivity, int security, String state){
		this.ID=id;
		this.hmotnost=weight;
		this.nazov=name;
		this.vzorec=model;
		this.reaktivita=reactivity;
		this.zabezpecenie= security;
		this.skupenstvo= state;
		
	}
														//overloading "overriding" preta�enie
	public Chemikalia(int id, int mnozstvo) {
		this.ID=id;
		this.hmotnost=mnozstvo;
	}
															// pratenie aktualnej hodnoty pre premenn�
	public int getID(){
		return this.ID;
	}
	
	public int getHmot(){
		return this.hmotnost;
	}
	public String getNazov(){
		return this.nazov;
	}
	public String getVzorec(){
		return this.vzorec;
	}
	public boolean getReaktivita(){
		return this.reaktivita;
	}
	public int getZabezpecenie(){
		return this.zabezpecenie;
	}
	
	public String getSkupenstov(){
		return this.skupenstvo;
	}
	
	
	
	
}
