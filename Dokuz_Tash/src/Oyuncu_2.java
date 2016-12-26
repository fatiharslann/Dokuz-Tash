
public class Oyuncu_2 {

	private int x, y, hamlesayisi, cap,konumindexi,index;
	private boolean durum;

	public Oyuncu_2(int x, int y, int hamlesayisi, int cap, boolean durum,int konumindexi,int index) {
		this.durum = durum;
                this.index=index;
		this.konumindexi=konumindexi;
		this.cap = cap;
		this.x = x;
		this.y = y;
	}


    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
	public int getKonumindexi() {
		return konumindexi;
	}

	public void setKonumindexi(int konumindexi) {
		this.konumindexi = konumindexi;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHamlesayisi() {
		return hamlesayisi;
	}

	public void setHamlesayisi(int hamlesayisi) {
		this.hamlesayisi = hamlesayisi;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public boolean getDurum() {
		return durum;
	}

	public void setDurum(boolean durum) {
		this.durum = durum;
	}

}
