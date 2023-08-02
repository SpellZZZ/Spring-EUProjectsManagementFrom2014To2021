package Other;

public class RokWartosc {
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getRok() {
		return rok;
	}
	public void setRok(int rok) {
		this.rok = rok;
	}
	public float getWartosc() {
		return wartosc;
	}
	public void setWartosc(float wartosc) {
		this.wartosc = wartosc;
	}
	
	
	public RokWartosc(int rok2) {
		super();
		
		rok = rok2;
		wartosc = 0;
		cnt = 0;
	}

	
	public RokWartosc(int rok2, float war) {
		super();
		
		rok = rok2;
		wartosc = war;
		cnt = 1;
	}

	
	
	
	private int rok;
	private float wartosc;
	private int cnt;
	
	
	
	

}
