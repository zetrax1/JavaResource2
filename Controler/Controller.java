package Controler;


import java.util.ArrayList;
import java.util.LinkedList;
import Model.Chemikalia;
import Sklady.Firma;
import Sklady.Sklad;
import Sklady.SkladStupenZabezpeceniaDva;
import Sklady.SkladStupenZabezpeceniaJedna;
import Sklady.SkladStupenZabezpeceniaPat;
import Sklady.SkladStupenZabezpeceniaStyri;
import Sklady.SkladStupenZabezpeceniaTri;
import transport.Cisterna;
import transport.Kamion;
import transport.Liaz;
import transport.Vozidlo;
/**
 * 
 *@author Vladimír Veèerek
 *@version 1.4
 *@since   2017-05-08
 *Trieda vykonávajúca väèšinu výpoètov , je v nej zahrnutá logitika prepravy a prístup k skladom
 */

public class Controller implements SledovatelObjednavky{
	
	/**
	 * 
	 * Atribúty triedy 
	 */

	private ArrayList<Sklad> storeList = new ArrayList<Sklad>();								//vytvorenie ArrayListov 
	//private LinkedList<Chemikalia> objedChem = new LinkedList<Chemikalia>();
	private ArrayList<Vozidlo> VozidloList = new ArrayList<Vozidlo>();
	private ArrayList<SledovatelObjednavky> Aktualizacia = new ArrayList<SledovatelObjednavky>();
	private int pocet = 0;
	
	/**
	 * Agregácia Firma
	 */
	
	private Firma firma;
	
	/**
	 * Konštruktor na vytvorenie skladov a firmy
	 */
	
	public Controller() {																// konštruktor - vytvorenie skladov 
		storeList.add(new SkladStupenZabezpeceniaJedna());//0
		storeList.add(new SkladStupenZabezpeceniaDva());
		storeList.add(new SkladStupenZabezpeceniaTri());
		storeList.add(new SkladStupenZabezpeceniaStyri());
		storeList.add(new SkladStupenZabezpeceniaPat());
		 
		 this.firma = new Firma();
	}
	
	/**
	 * Funkcia ktorá nájde sklad podla stupna zabezpeèenia
	 * @param zabezpecenie String stupen zabezpeèenia
	 * @return i Int pozicia v storeList
	 * @return 0 ak neexistuje
	 */
	public int najdiSklad(String zabezpecenie) {							// najdenie indexu skladu podla zabezpeèenia
		
		Sklad sklad;
		for (int i = 0; i < storeList.size(); i++) {
			sklad = storeList.get(i);
			if(sklad.zabezpecenie().equals(zabezpecenie)){
				return i;
			}
		}
		//prejde vždy
		return 0;
	}
	
	/**
	 * Funkcia ktorá použije funkciu k najdeniu skladu a vypíše hmotnos skupenstva 
	 * @param  skupenstvo String skupenstvo
	 * @param  zabezpecenie String stupen zabezpeèenia 
	 * @return Int hmotnost hladaneho skupenstva v sklade urèenom zabezpeèením
	 */
	public int zistiHmotnost(String skupenstvo, String zabezpecenie){					// najdenie hmotnosti chemikálie v sklade
		
		int hmotnost=0;;
		Sklad sklad;
		Chemikalia chemikalia;
		
		int pozicia;
		LinkedList<Chemikalia> pom;
		
		pozicia = najdiSklad(zabezpecenie);
		
		for (int i = 0; i < storeList.size(); i++) {
			if(i==pozicia){
				sklad=storeList.get(i);
				pom=sklad.getlist();
				
				for(int j =0; j<pom.size(); j++){
					chemikalia=pom.get(j);
					if(chemikalia.getSkupenstov().equals(skupenstvo)){
						hmotnost+=chemikalia.getHmot();
					}
				}
				return hmotnost;
			}
		}
		return 0;
	}
	
	/**
	 * Funkcia ráta poèet objednávok a volá funkciu pridaj
	 * @param id int id chemikálie 
	 * @param hmotnost Int hmotnos
	 * @param firma objekt typu firma
	 */
	
	public void objednajdoFirmy(int id, int hmotnost, Firma firma){						// pridanie objednávky do listu objednávok
		firma.pridajDoListu(id, hmotnost);
		pocet++;
		upovedom();
		
	}
	
	/**
	 * Funkcia volajúca funkciu na zvýšenie poètu objednávok
	 * 
	 * @return Firma firma
	 */
	
	
	public Firma getFirma(){
		zmenPocet(1);
		upovedom();
		return this.firma;
	}
	
	/**
	 * Funkcia prehladá sklady a zistí èi sa tam zadaná chemikália vyskituje v aspoò zadanom množstve
	 * @param zabezpecenie String zabezpeèenie  
	 * @param id int id chemikálie 
	 * @param hmotnost Int hmotnos
	 * @return Boolean true ak sa chemikálie nachádza v sklade v dostatoènom množstve
	 */
	
	public boolean prehladajSklad(int id, int hmotnost, String zabezpecenie){				// zistenie èi sa v sklade chemikália nachádza v adekvátnom množstve
		
		int pom;
		pom = najdiSklad(zabezpecenie);
		Sklad sklad ;
		sklad =  storeList.get(pom);
		if(sklad.zistiId(id) && sklad.zistiHmotnosID(hmotnost, id)){
			return true;
		}
		return false;
	}
	
	/**
	 * Funkcia zmaže objednávku  
	 * 
	 */
	
	public void zmazObjednavku(){
		firma.getlist().clear();
		//zmaze vsetky polozky vo firme
	}
	
	/**
	 * Funkcia zistí hmotnos skupenstva na firme
	 * @param skupenstvo String skupenstvo
	 * @return Int hmotnost hladaneho skupenstva 
	 */
	
	public int zistiHmotnostFirma(String skupenstvo){
		int hmotnost;
		hmotnost =firma.vratHmotnost(skupenstvo);
		return hmotnost;
		
	}
	
	/**
	 * Funkcia - prehladáva list objednávok a navrhuje adekvátny spôsob prepravy  
	 * 
	 * @return String použité vozidlá 
	 */
	
	public String pouziteVozidla(){									// hlavná logistika prepravy
		int kam=0;
		int liaz=0;
		int cist=0;
		int tmp=0;
		int hmot=0;
		String textNaVypis;
		
		Vozidlo vozidlo = new Vozidlo();
		LinkedList<Chemikalia> ChemikList;
		
		ChemikList= firma.getlist();
		Chemikalia chemikalia;
		ZoznamCh zoznamCh =new ZoznamCh();
		
		
		for(int i=0;i<ChemikList.size();i++){			// prejdenie zoznamu hladaných chemikálií
			chemikalia=ChemikList.get(i);
			boolean reaktivita = zoznamCh.citajSuborPreReaktivitu(Integer.toString(chemikalia.getID()));
			
		if(reaktivita){								//navrh prepravy pre reaktivne látky 
			int mreaktivnych;
			int pocetVozidiel;
			switch (zoznamCh.citajSuborPreSkupenstvo(Integer.toString( chemikalia.getID()))) {
			case "kvapalne":						//pridelenie pre kvapalná chcemikálie
				
				mreaktivnych = chemikalia.getHmot();
				pocetVozidiel =mreaktivnych/5;
				for(int j=0;j<pocetVozidiel;j++){
					VozidloList.add(new Cisterna()); 
				cist++;
				}
				VozidloList.trimToSize();
				break;
			case "tuhe": 							//pridelenie pre tuhé chcemikálie
				mreaktivnych = chemikalia.getHmot();
				pocetVozidiel=mreaktivnych/10;
				if(mreaktivnych%10>5){
					pocetVozidiel++;
				}
				for(int j=0;j<pocetVozidiel;j++){
					VozidloList.add(new Kamion()); 
					kam++;
				}
				
				if(mreaktivnych%10<5){
					VozidloList.add(new Liaz()); 
					liaz++;
				}
				
				VozidloList.trimToSize();
				break;
				
			case "plynne":								//pridelenie pre plynné chcemikálie
				mreaktivnych = chemikalia.getHmot();
				pocetVozidiel=mreaktivnych/10;
				if(mreaktivnych%10>5){
					pocetVozidiel++;
				}
				for(int j=0;j<pocetVozidiel;j++){
					VozidloList.add(new Kamion());
					kam++;
				}
				
				if(mreaktivnych%10<5){
					VozidloList.add(new Liaz()); 
					liaz++;
				}
				VozidloList.trimToSize();
				break;
			}
			
			
			
		}else{				// stabilné chemikálie je mozné preváža spolu preto majú rôznu logistiku prepravy ako reaktívne
			
			int pom=0;
			int zvysok;
			
			if (zoznamCh.citajSuborPreSkupenstvo(Integer.toString( chemikalia.getID())).equals("tuhe") ||zoznamCh.citajSuborPreSkupenstvo(Integer.toString( chemikalia.getID())).equals("plynne")) {
				
				hmot+=chemikalia.getHmot();
				
			} else {
				if (chemikalia.getHmot()>3) {
					pom=chemikalia.getHmot()/5;
					if (chemikalia.getHmot()%5>3) {
						pom++;
						
					}
					else {
						zvysok=chemikalia.getHmot()%5;
						hmot+=zvysok;
					}
					for(int j=0;j<pom;j++){
						VozidloList.add(new Cisterna());
						cist++;
					}
				}
			}
		}
			
			
			
		}
		
		tmp = hmot /10;
		if(hmot%10>5){
			tmp++;
		}else{
			VozidloList.add(new Liaz());
			liaz++;
		}
		
		for(int j=0;j<tmp;j++){
			VozidloList.add(new Kamion());
			kam++;
		}
		
	
		
		textNaVypis = "********** \n"+" Poèet Kamionov použitých na prepravu : "+Integer.toString(kam)+ "\n"+" Poèet Liazok použitých na prepravu : "+Integer.toString(liaz)+"\n"+" Poèet Cisterien použitých na prepravu : "+Integer.toString(cist);
				
		return textNaVypis;
	}


	
	public void upovedom() {
		for(SledovatelObjednavky tmp : Aktualizacia){
			tmp.upovedom();
		}
		
	}
	
	/**
	 * Funkcia prídá sledovatel do triedy Aktualizácia
	 * @param sledovatelObjednavky SledovatelObjednavky sledovatelObjednavky
	 *  
	 */
	
	
	public void addSledovatel(SledovatelObjednavky sledovatelObjednavky){
		
		Aktualizacia.add(sledovatelObjednavky);
	}

	/**
	 * Funkcia pre zistenie poètu objednávok
	 * @return pocet objednávok
	 *  
	 */
	
	public int zistiPocetObjednavok(){
		return this.pocet;
	}
	
	/**
	 * Funkcia navýši poèet objednávok
	 * @param pocet int pocet o ktorý sa zvýši poèet objednávok
	 *  
	 */
	
	public void zmenPocet(int pocet){
		this.pocet+=pocet;
	}
	
	
}
