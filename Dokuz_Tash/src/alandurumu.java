
public class alandurumu {
    int x,y,index,a,oyuncu_indexi;
    boolean durum;
   
    alandurumu sag,sol,yukari,asagi;
    
    public alandurumu(int x,int y,boolean durum,int index,int a,int oyuncu_indexi){
        this.oyuncu_indexi=oyuncu_indexi;
        this.index=index;
        this.a=a;
        this.x=x;
        this.y=y;
        this.durum=durum;
        sag=null;
        sol=null;
        asagi=null;
        yukari=null;
    }
    

    public void setOyuncu_indexi(int oyuncu_indexi) {
        this.oyuncu_indexi = oyuncu_indexi;
    }

    public int getOyuncu_indexi() {
        return oyuncu_indexi;
    }
    

    

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
        public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
   
}
