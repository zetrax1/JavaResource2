package Controler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.omg.CORBA.PRIVATE_MEMBER;
import Sklady.Sklad;
import Sklady.SkladStupenZabezpeceniaDva;
import Sklady.SkladStupenZabezpeceniaJedna;
import Sklady.SkladStupenZabezpeceniaPat;
import Sklady.SkladStupenZabezpeceniaStyri;
import Sklady.SkladStupenZabezpeceniaTri;

/**
 * 
 *@author Vladimír Veèerek
 *Trieda pracujúca zo súborom zo zoznamom Chemikálií
 */
public class ZoznamCh {

	private Scanner subor;
	private String pole = null;
	
	/**
	 * Funkcia na otvorenie súboru
	 * 
	 */

	public void otvorSubor() {								// otvorenie súboru
		try {
			subor = new Scanner(new File("D:\\2.semester\\oop\\eclipse\\Projekt\\src\\Chemikalie.txt"));
		} catch (Exception e) {
			System.out.println("subor sa nepodarilo otvorit");

		}

	}
	/**
	 * Funkcia na resetnutie súboru na zaèiatok
	 * 
	 */

	public void resetniSubor() {					//resetnutie súboru
		subor.reset();
		otvorSubor();
	}
	
	/**
	 * Funkcia pridelí názvu chemikálie jej id
	 * @param hladanyNazov String názov chemikálie
	 * @return id chemikálie , ak sa chemikálie nenachádza v zozname vráti String "Chemikalia nieje v zozname"
	 */

	public String citajSuborPoSlovach(String hladanyNazov) {			// prejdnie súbor po slovách
		while (subor.hasNext()) {
			String identicikacneCislo = subor.next();
			String nazov = subor.next();
			String chemickaSkratka = subor.next();
			String reaktivita = subor.next();
			String skupenstvo = subor.next();
			int zabezpecenie = subor.nextInt();

			if (hladanyNazov.equals(nazov)) {
				return identicikacneCislo;
			}
		}
		return "Chemikalia nieje v zozname";
	}
	
	
	/**
	 * Funkcia zistí ,èi id chemikálie existuje v zozname
	 * @param kodProduktu String id 
	 * @return boolean true ak sa chemikália nachádza v zozname
	 */

	
	public  boolean zistiIdZoznam(String kodProduktu) throws VlastnaVynimka {			// overenie chemikálie v zozname
		otvorSubor();
		while (subor.hasNext()) {
			String identicikacneCislo = subor.next();
			String nazov = subor.next();
			String chemickaSkratka = subor.next();
			String reaktivita = subor.next();
			String skupenstvo = subor.next();
			int zabezbecenie = subor.nextInt();

			if (kodProduktu.equals(identicikacneCislo) ) {
				zavriSubor();
				return true;
				
			}
		}
		zavriSubor();
		throw new VlastnaVynimka();
	}
	
	/**
	 * Funkcia pridelí k id chemikálie jej reaktivitu
	 * @param kodProduktu String id chemikálie
	 * @return boolean true ak je chemikália reaktívna
	 */
	
	public  boolean citajSuborPreReaktivitu(String kodProduktu) {				// pridelenie reaktivity pre id
		otvorSubor();
		while (subor.hasNext()) {
			String identicikacneCislo = subor.next();
			String nazov = subor.next();
			String chemickaSkratka = subor.next();
			String reaktivita = subor.next();
			String skupenstvo = subor.next();
			int zabezbecenie = subor.nextInt();

			if (kodProduktu.equals(identicikacneCislo) && reaktivita.equals("reaktivny")) {
				zavriSubor();
				return true;
			}
		}
		zavriSubor();
		return false;
		
	}
	
	/**
	 * Funkcia pridelí pre zadané id chemikálie jej skupenstvo
	 * @param kodProduktu String id chemikálie
	 * @return String skupenstvo chemikálie
	 */

	public String citajSuborPreSkupenstvo(String kodProduktu) {				// pridelenie skupenstva pre id
		otvorSubor();
		while (subor.hasNext()) {
			String identicikacneCislo = subor.next();
			String nazov = subor.next();
			String chemickaSkratka = subor.next();
			String reaktivita = subor.next();
			String skupenstvo = subor.next();
			int zabezbecenie = subor.nextInt();

			if (kodProduktu.equals(identicikacneCislo)) {
				zavriSubor();
				return skupenstvo;
			}
		}
		zavriSubor();
		return kodProduktu;

	}
	
	/**
	 * Funkcia pridelí pre zadané id chemikálie jej stupen zabezpeèenia
	 * @param kodProduktu String id chemikálie
	 * @return zabezbecenie Int stupen zabezpeèenia chemikálie
	 */

	public int citajSuborPreStupen(String kodProduktu) {			// pridelenie stupna zabezpeèenia pre id
		while (subor.hasNext()) {
			String identicikacneCislo = subor.next();
			String nazov = subor.next();
			String chemickaSkratka = subor.next();
			String reaktivita = subor.next();
			String skupenstvo = subor.next();
			int zabezbecenie = subor.nextInt();

			if (kodProduktu.equals(identicikacneCislo)) {
				return zabezbecenie;
			}
		}

		return 0;

	}
	
	/**
	 * Preèíta v súbore jeden riadok
	 * @return riadok
	 */

	public String citajSuborJedenRiadok() {				//preèítanie jedného riadku
		String riadok;
		riadok = subor.nextLine();

		return riadok;

	}
	
	/**
	 * preèíta celý súbor
	 * @return pole String celý súbor
	 */

	public String citajSuborCely() {						// preèítanie celého súboru

		subor.reset();
		pole = subor.nextLine();

		while (subor.hasNext()) {
			pole = pole + "\n" + subor.nextLine();

		}

		return pole;
	}

	/**
	 * Funkcia zavrie súbor
	 * 
	 */

	public void zavriSubor() {
		subor.close();
	}

}
