
public class Oyuncu_1 {

	private int x, y, hamlesayisi, cap,konumindexi,index;
	private boolean durum;

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
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

	public boolean getDurum() {
		return durum;
	}

	public void setDurum(boolean durum) {
		this.durum = durum;
	}

	public Oyuncu_1(int x, int y, int hamlesayisi, int cap, boolean durum,int konumindexi,int index) {
		this.x = x;
		this.index=index;
		this.konumindexi=konumindexi;
		this.durum = durum;
		this.cap = cap;
		this.hamlesayisi = hamlesayisi;
		this.y = y;

	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getKonumindexi() {
		return konumindexi;
	}

	public void setKonumindexi(int konumindexi) {
		this.konumindexi = konumindexi;
	}

	public int getHamlesayisi() {
		return hamlesayisi;
	}

	public void setHamlesayisi(int hamlesayisi) {
		this.hamlesayisi = hamlesayisi;
	}

}
