package Other;

import java.util.List;

public class ZlozonyRes {
	
	
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public List<Integer> getTablicaLata() {
		return tablicaLata;
	}
	public void setTablicaLata(List<Integer> tablicaLata) {
		this.tablicaLata = tablicaLata;
	}
	public List<Float> getWynikiWKolejnychLatach() {
		return wynikiWKolejnychLatach;
	}
	public void setWynikiWKolejnychLatach(List<Float> wynikiWKolejnychLatach) {
		this.wynikiWKolejnychLatach = wynikiWKolejnychLatach;
	}
	public List<Float> getDotacjeWKolejnychLatach() {
		return dotacjeWKolejnychLatach;
	}
	public void setDotacjeWKolejnychLatach(List<Float> dotacjeWKolejnychLatach) {
		this.dotacjeWKolejnychLatach = dotacjeWKolejnychLatach;
	}
	String nazwa;
	List<Integer> tablicaLata;
	List<Float> wynikiWKolejnychLatach;
	List<Float> dotacjeWKolejnychLatach;
	
	
	public ZlozonyRes() {
		super();
	}

	
	
	
	
}
