package testovaci;

public class Gen {

	int rozhodnutie;
	public int zaciatok;
	

	public Gen(int num ,int zac) {
		this.rozhodnutie = num;
		this.zaciatok = zac;
	}

	public int vratZac() {

		return zaciatok;
	}

	public int vratRoz() {

		return rozhodnutie;
	}
}
