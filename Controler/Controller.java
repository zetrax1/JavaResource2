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
 *@author Vladim�r Ve�erek
 *@version 1.4
 *@since   2017-05-08
 *Trieda vykon�vaj�ca v��inu v�po�tov , je v nej zahrnut� logitika prepravy a pr�stup k skladom
 */

public class Controller implements SledovatelObjednavky{
	
	/**
	 * 
	 * Atrib�ty triedy 
	 */

	private ArrayList<Sklad> storeList = new ArrayList<Sklad>();								//vytvorenie ArrayListov 
	//private LinkedList<Chemikalia> objedChem = new LinkedList<Chemikalia>();
	private ArrayList<Vozidlo> VozidloList = new ArrayList<Vozidlo>();
	private ArrayList<SledovatelObjednavky> Aktualizacia = new ArrayList<SledovatelObjednavky>();
	private int pocet = 0;
	
	/**
	 * Agreg�cia Firma
	 */
	
	private Firma firma;
	
	/**
	 * Kon�truktor na vytvorenie skladov a firmy
	 */
	
	public Controller() {																// kon�truktor - vytvorenie skladov 
		storeList.add(new SkladStupenZabezpeceniaJedna());//0
		storeList.add(new SkladStupenZabezpeceniaDva());
		storeList.add(new SkladStupenZabezpeceniaTri());
		storeList.add(new SkladStupenZabezpeceniaStyri());
		storeList.add(new SkladStupenZabezpeceniaPat());
		 
		 this.firma = new Firma();
	}
	
	/**
	 * Funkcia ktor� n�jde sklad podla stupna zabezpe�enia
	 * @param zabezpecenie String stupen zabezpe�enia
	 * @return i Int pozicia v storeList
	 * @return 0 ak neexistuje
	 */
	public int najdiSklad(String zabezpecenie) {							// najdenie indexu skladu podla zabezpe�enia
		
		Sklad sklad;
		for (int i = 0; i < storeList.size(); i++) {
			sklad = storeList.get(i);
			if(sklad.zabezpecenie().equals(zabezpecenie)){
				return i;
			}
		}
		//prejde v�dy
		return 0;
	}
	
	/**
	 * Funkcia ktor� pou�ije funkciu k najdeniu skladu a vyp�e hmotnos� skupenstva 
	 * @param  skupenstvo String skupenstvo
	 * @param  zabezpecenie String stupen zabezpe�enia 
	 * @return Int hmotnost hladaneho skupenstva v sklade ur�enom zabezpe�en�m
	 */
	public int zistiHmotnost(String skupenstvo, String zabezpecenie){					// najdenie hmotnosti chemik�lie v sklade
		
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
	 * Funkcia r�ta po�et objedn�vok a vol� funkciu pridaj
	 * @param id int id chemik�lie 
	 * @param hmotnost Int hmotnos�
	 * @param firma objekt typu firma
	 */
	
	public void objednajdoFirmy(int id, int hmotnost, Firma firma){						// pridanie objedn�vky do listu objedn�vok
		firma.pridajDoListu(id, hmotnost);
		pocet++;
		upovedom();
		
	}
	
	/**
	 * Funkcia volaj�ca funkciu na zv��enie po�tu objedn�vok
	 * 
	 * @return Firma firma
	 */
	
	
	public Firma getFirma(){
		zmenPocet(1);
		upovedom();
		return this.firma;
	}
	
	/**
	 * Funkcia prehlad� sklady a zist� �i sa tam zadan� chemik�lia vyskituje v aspo� zadanom mno�stve
	 * @param zabezpecenie String zabezpe�enie  
	 * @param id int id chemik�lie 
	 * @param hmotnost Int hmotnos�
	 * @return Boolean true ak sa chemik�lie nach�dza v sklade v dostato�nom mno�stve
	 */
	
	public boolean prehladajSklad(int id, int hmotnost, String zabezpecenie){				// zistenie �i sa v sklade chemik�lia nach�dza v adekv�tnom mno�stve
		
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
	 * Funkcia zma�e objedn�vku  
	 * 
	 */
	
	public void zmazObjednavku(){
		firma.getlist().clear();
		//zmaze vsetky polozky vo firme
	}
	
	/**
	 * Funkcia zist� hmotnos� skupenstva na firme
	 * @param skupenstvo String skupenstvo
	 * @return Int hmotnost hladaneho skupenstva 
	 */
	
	public int zistiHmotnostFirma(String skupenstvo){
		int hmotnost;
		hmotnost =firma.vratHmotnost(skupenstvo);
		return hmotnost;
		
	}
	
	/**
	 * Funkcia - prehlad�va list objedn�vok a navrhuje adekv�tny sp�sob prepravy  
	 * 
	 * @return String pou�it� vozidl� 
	 */
	
	public String pouziteVozidla(){									// hlavn� logistika prepravy
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
		
		
		for(int i=0;i<ChemikList.size();i++){			// prejdenie zoznamu hladan�ch chemik�li�
			chemikalia=ChemikList.get(i);
			boolean reaktivita = zoznamCh.citajSuborPreReaktivitu(Integer.toString(chemikalia.getID()));
			
		if(reaktivita){								//navrh prepravy pre reaktivne l�tky 
			int mreaktivnych;
			int pocetVozidiel;
			switch (zoznamCh.citajSuborPreSkupenstvo(Integer.toString( chemikalia.getID()))) {
			case "kvapalne":						//pridelenie pre kvapaln� chcemik�lie
				
				mreaktivnych = chemikalia.getHmot();
				pocetVozidiel =mreaktivnych/5;
				for(int j=0;j<pocetVozidiel;j++){
					VozidloList.add(new Cisterna()); 
				cist++;
				}
				VozidloList.trimToSize();
				break;
			case "tuhe": 							//pridelenie pre tuh� chcemik�lie
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
				
			case "plynne":								//pridelenie pre plynn� chcemik�lie
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
			
			
			
		}else{				// stabiln� chemik�lie je mozn� prev�a� spolu preto maj� r�znu logistiku prepravy ako reakt�vne
			
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
		
	
		
		textNaVypis = "********** \n"+" Po�et Kamionov pou�it�ch na prepravu : "+Integer.toString(kam)+ "\n"+" Po�et Liazok pou�it�ch na prepravu : "+Integer.toString(liaz)+"\n"+" Po�et Cisterien pou�it�ch na prepravu : "+Integer.toString(cist);
				
		return textNaVypis;
	}


	
	public void upovedom() {
		for(SledovatelObjednavky tmp : Aktualizacia){
			tmp.upovedom();
		}
		
	}
	
	/**
	 * Funkcia pr�d� sledovatel do triedy Aktualiz�cia
	 * @param sledovatelObjednavky SledovatelObjednavky sledovatelObjednavky
	 *  
	 */
	
	
	public void addSledovatel(SledovatelObjednavky sledovatelObjednavky){
		
		Aktualizacia.add(sledovatelObjednavky);
	}

	/**
	 * Funkcia pre zistenie po�tu objedn�vok
	 * @return pocet objedn�vok
	 *  
	 */
	
	public int zistiPocetObjednavok(){
		return this.pocet;
	}
	
	/**
	 * Funkcia nav��i po�et objedn�vok
	 * @param pocet int pocet o ktor� sa zv��i po�et objedn�vok
	 *  
	 */
	
	public void zmenPocet(int pocet){
		this.pocet+=pocet;
	}
	
	
}
