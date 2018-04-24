package testovaci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Hlavna {

	static int velkostGeneracie = 100;
	static int pocetGenov = 30;
	static int pocetNaj = 10; // v percentach
	static int pocetMut = 20; // v percentach
	static int pocetGeneracii= 15000;

	static int pocetKriz = 100 - pocetMut-pocetNaj; // v percentach

	public static int smer = 0;
	static int maxy = 10;
	static int maxx = 12;
	static int skaly = 6;
	static int zacx = 0;
	static int zacy = 0;
	public static int pole[][] = new int[maxy][maxx];
	public static int obnova[][] = new int[maxy][maxx];
	static Random rand = new Random();

	public static ArrayList<Jedinec> generacia = new ArrayList<Jedinec>();
	public static ArrayList<Jedinec> nova = new ArrayList<Jedinec>();

	public static Gen pom;

	public static int rotacia1(int x, int y) {
		
		if (smer == 0 || smer == 2) {
			
			if (y != 0 && pole[y - 1][x] == 0) {
				zacy=y-1;
				return 1;
			}
			if (y != maxy-1 && pole[y + 1][x] == 0) {
				zacy=y+1;
				return 3;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
			
			
			return 4;

		}

		if (smer == 1 || smer == 3) {
		
			if (x != maxx-1 && pole[y][x + 1] == 0) {
				zacx=x+1;
				return 0;
			}
			if (x != 0 && pole[y][x - 1] == 0) {
				zacx=x-1;
				return 2;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
			
			return 4;
		}

		return 4;

	}

	public static int rotacia2(int x, int y) {

		if (smer == 0 || smer == 2) {
			
			

			if (y != maxy-1 && pole[y + 1][x] == 0) {
				zacy=y+1;
				return 3;
			}
			if (y != 0 && pole[y - 1][x] == 0) {
				zacy=y-1;
				return 1;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
			
			return 4;

		}

		if (smer == 1 || smer == 3) {
		
			if (x != 0 && pole[y][x - 1] == 0) {
				zacx=x-1;
				return 2;
			}
			if (x != maxx-1 && pole[y][x + 1] == 0) {
				zacx=x+1;
				return 0;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
			
			return 4;
		}

		return 4;

	}

	public static int rotacia3(int x, int y) {

		if (smer == 0 || smer == 2) {
		
			if (y != 0 && pole[y - 1][x] == 0) {
				zacy=y-1;
				return 1;
			}

			if (y != maxy-1 && pole[y + 1][x] == 0) {
				zacy=y+1;
				return 3;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
			
			return 4;

		}

		if (smer == 1 || smer == 3) {
		
			if (x != 0 && pole[y][x - 1] == 0) {
				zacx=x-1;
				return 2;
			}
			if (x != maxx-1 && pole[y][x + 1] == 0) {
				zacx=x+1;
				return 0;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
			
			return 4;
		}

		return 4;

	}

	public static int rotacia4(int x, int y) {

		if (smer == 0 || smer == 2) {
		

			if (y != maxy-1 && pole[y + 1][x] == 0) {
				zacy=y+1;
				return 3;
			}
			if (y != 0 && pole[y - 1][x] == 0) {
				zacy=y-1;
				return 1;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}
		
			return 4;

		}

		if (smer == 1 || smer == 3) {

		
			if (x != maxx-1 && pole[y][x + 1] == 0) {
				zacx =x+1;
				return 0;
			}
			if (x != 0 && pole[y][x - 1] == 0) {
				zacx = x-1;
				return 2;
			}
			if(y==maxy-1 || x == maxx-1 || y==0 ||x==0) {
				return 5;
			}

			return 4;
		}

		return 4;

	}

	public static void suradnice(int a) {

		if (a < 11) {
			zacx = 0;
			zacy = 10 - a;
			smer = 0;
			return;
		}
		if (a < 23) {
			zacx = a - 11;
			zacy = 0;
			smer = 3;
			return;
		}
		if (a < 33) {
			zacx = maxx - 1;
			zacy = a - 23;
			smer = 2;
			return;
		}
		if (a < 45) {
			zacx = 44 - a;
			zacy = maxy - 1;
			smer = 1;
			return;
		}

	}

	public static int trasa(Gen tmp,int index ) {

	    int pocPolicok = 0;
		int pom = 0;
		int roz = tmp.vratRoz();
		
		suradnice(tmp.vratZac());
			
		if(pole[zacy][zacx] != 0 ) {
			return 0;
		}

		while (pom != 1) {

			// System.out.println(smer);

			if (smer == 0) {

				while (pole[zacy][zacx] == 0 ) {
					pole[zacy][zacx]=index;
					
					pocPolicok++;
					// System.out.println(pocPolicok);
					if (zacx == maxx - 1) {
						pom = 1;
						return pocPolicok;
					}
					zacx++;
				}
	
				zacx--;
				
			}
			
			if (smer == 1) {

				while (pole[zacy][zacx] == 0 ) {				
					pole[zacy][zacx]=index;
					
					pocPolicok++;
					// System.out.println(zacy);
					if (zacy == 0) {
						pom = 1;
						return pocPolicok;
					}
					zacy--;
				}
				
				zacy++;
				
			}

			if (smer == 2) {

				while (pole[zacy][zacx] == 0) {
					pole[zacy][zacx]=index;
					pocPolicok++;
					// System.out.println(zacx);
					if (zacx == 0) {
						pom = 1;
						return pocPolicok;
					}
					zacx--;
				}
				zacx++;
				
			}

			if (smer == 3) {

				while (pole[zacy][zacx] == 0 ) {
					pole[zacy][zacx]=index;
					
					pocPolicok++;
					// System.out.println(zacy);
					if (zacy == maxy - 1) {
						pom = 1;
						return pocPolicok;
					}
					zacy++;
				}
				zacy--;
				
			}
			
			

			if (pom == 1) {
				return pocPolicok;
			}			
			if (roz == 1) {
				smer = rotacia1(zacx, zacy);
			}
			if (roz == 2) {
				smer = rotacia2(zacx, zacy);
			}
			if (roz == 3) {
				smer = rotacia3(zacx, zacy);
			}
			if (roz == 4) {
				smer = rotacia4(zacx, zacy);
			}
			if (smer == 4) {
				return 0;
			}
			if(smer == 5 && pocPolicok == 1 ) {
				return 0;
			}

			if(smer == 5 ) {
				return pocPolicok;
			}

		}

		return pocPolicok;
	}

	public static void vypis() {
		for (int i = 0; i < maxy; i++) {
			for (int j = 0; j < maxx; j++) {
				System.out.print(pole[maxy - i - 1][j]);
				if(pole[maxy - i - 1][j]<10) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
			System.out.println("");
		}

	}

	public static void vypisGenetiky(int poradieJedinca) {

		for (int b = 0; b < pocetGenov; b++) {
			pom = generacia.get(poradieJedinca).geny.get(b);

			System.out.println(pom.rozhodnutie);
			System.out.println(pom.zaciatok);
			// System.out.println(b);
		}
	}

	public static void generujGeny(int poradieJedinca) {

		for (int a = 0; a < pocetGenov; a++) {
			generacia.get(poradieJedinca).geny.add(a, new Gen(rand.nextInt(4) + 1, rand.nextInt(44) + 1));

		}

	}

	public static void generujJedincov(int pocet) {

		for (int a = 0; a < pocet; a++) {
			generacia.add(a, new Jedinec());
			generujGeny(a);

		}

	}

	public static void prazdnaMatica() {

		for (int i = 0; i < maxy; i++) {
			for (int j = 0; j < maxx; j++) {
				pole[i][j] = 0;
			}
		}

		pole[7][1] = 1;
		pole[5][2] = 1;
		pole[6][4] = 1;
		pole[8][5] = 1;
		pole[3][9] = 1;
		pole[3][8] = 1;

	}

	public static void mutacie(int poradie) {
		

		int pocetMutagenov = rand.nextInt(pocetGenov-1) + 1;
		int poziciaGenu = rand.nextInt(pocetGenov-1) + 1;
		int druhM = rand.nextInt(2) + 1;

		for (int c = 0; c < pocetMutagenov; c++) {
			
			nova.get(poradie).geny.get(poziciaGenu).rozhodnutie = rand.nextInt(4) + 1;

			if (druhM == 1) {
				nova.get(poradie).geny.get(poziciaGenu).zaciatok = rand.nextInt(44) + 1;
			}

			druhM = rand.nextInt(2) + 1;
			poziciaGenu = rand.nextInt(pocetGenov-1) + 1;

		}

	}

	public static Jedinec krizenie(int poradie1, int poradie2) {

		Jedinec tmp = new Jedinec();

		int pocetZmien = rand.nextInt(pocetGenov-1) + 1;
		int poziciaGenu = rand.nextInt(pocetGenov-1) + 1;
		int ktory = rand.nextInt(2) + 1;

		if (ktory == 1) {
			tmp = generacia.get(poradie1);
		}else {
			tmp = generacia.get(poradie2);

		}

		for (int c = 0; c < pocetZmien; c++) {

			if (ktory == 1) {
				tmp.geny.get(poziciaGenu).zaciatok = generacia.get(poradie2).geny.get(poziciaGenu).zaciatok;
			} else {

				tmp.geny.get(poziciaGenu).zaciatok = generacia.get(poradie1).geny.get(poziciaGenu).zaciatok;

			}

			ktory = rand.nextInt(2) + 1;
			poziciaGenu = rand.nextInt(pocetGenov-1) + 1;

		}

		return tmp;
	}

	public static int maticovePrechody(int poradie) {
		
		prazdnaMatica();
		
		int pocetP=0;
		int pom = 0;
		int index =2;
		
		
		for(int a=0; a < pocetGenov ;a++) {
			
			
			for (int i = 0; i < maxy; i++) {
				for (int j = 0; j < maxx; j++) {
					obnova[i][j] = pole[i][j];
				}
			}
			
			pom=trasa(generacia.get(poradie).geny.get(a),index);
			
			if(pom == 0) {
				//System.out.println("Pole bolo obnovene");
				
				for (int i = 0; i < maxy; i++) {
					for (int j = 0; j < maxx; j++) {
						pole[i][j] = obnova[i][j];
					}
				}
				
				
				index--;
			}
			
			
			pocetP = pocetP+pom;
			index++;
			
		}
		
		return pocetP;
	}
	
	public static int priradPocetPolicok(int pocet) {
		
		for (int a = 0; a < pocet; a++) {
			 generacia.get(a).pocetPolicok = maticovePrechody(a);
			
			 if( generacia.get(a).pocetPolicok == (maxy * maxx) - skaly) {
				 vypis();
				 System.out.println("\n");
				 return 0;
			 }

		}
		return 1;
		
	}

	
	public static void novaGeneracia() {
		
		
		int max;
		int pom=0;
		int nahodna=0;
		int por1;
		int por2;
		
		
		int tmpMut = (velkostGeneracie/100) * pocetMut;
		for(int i=0;i<tmpMut;i++) {
			nahodna = rand.nextInt(velkostGeneracie-1) + 1;
			
			nova.add(i,generacia.get(nahodna));
		
			
			mutacie(i);
			
		}
		
		int tmpKriz = (velkostGeneracie/100) * pocetKriz;
		
		for(int i=0;i<tmpKriz;i++) {
			
			por1=rand.nextInt(velkostGeneracie-1) + 1;
			por2=rand.nextInt(velkostGeneracie-1) + 1;

			nova.add(i+tmpMut,krizenie(por1,por2));
		
			
			
			
		}
		
		for(int a=0;a<pocetNaj;a++) {
			max=0;
			for(int b = 0;b+a < velkostGeneracie ;b++) {
				
				if(max <= generacia.get(b).pocetPolicok ) {
					max =  generacia.get(b).pocetPolicok;
					pom = b;
				}	
			}
			
			
			nova.add(a+tmpMut+tmpKriz,generacia.get(pom));
			generacia.remove(pom);
		//	System.out.println(nova.get(a).pocetPolicok);
		}
		
		for(int a=0;a<velkostGeneracie-pocetNaj;a++) {
			
			generacia.remove(0);
		}
		
		
		for(int e=0;e<velkostGeneracie;e++) {
			
			generacia.add(e,nova.get(e));
		}
	  for(int a=0;a<velkostGeneracie;a++) {
			
			nova.remove(0);
		}
	  
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hladam cestu");
		int ukoncovacia=1;
		
		prazdnaMatica();
		
		
		generujJedincov(velkostGeneracie);
			
		ukoncovacia = priradPocetPolicok(velkostGeneracie);
		
		if(ukoncovacia == 0) {
			System.out.println("Postup bol najdeny");
			return ;
		}
		
		for(int i=0;i<pocetGeneracii;i++) {
					
			novaGeneracia();
			ukoncovacia = priradPocetPolicok(velkostGeneracie);
			
			if(ukoncovacia == 0) {
				System.out.println("Postup bol najdeny");
				return ;
				
			}
			
		}
		
		System.out.println("koniec hladania");
		
		

	

	}

}
