package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class WojWynikiMatur {
	

	public String getPrzedmiot() {
		return przedmiot;
	}




	public void setPrzedmiot(String przedmiot) {
		this.przedmiot = przedmiot;
	}




	public String getPoziom() {
		return poziom;
	}




	public void setPoziom(String poziom) {
		this.poziom = poziom;
	}




	public String getZdajacych() {
		return zdajacych;
	}




	public void setZdajacych(String zdajacych) {
		this.zdajacych = zdajacych;
	}




	public String getMinS() {
		return minS;
	}




	public void setMinS(String minS) {
		this.minS = minS;
	}




	public String getMaxS() {
		return maxS;
	}




	public void setMaxS(String maxS) {
		this.maxS = maxS;
	}




	public String getMediana() {
		return mediana;
	}




	public void setMediana(String mediana) {
		this.mediana = mediana;
	}




	public String getSrednia() {
		return srednia;
	}




	public void setSrednia(String srednia) {
		this.srednia = srednia;
	}




	public String getOdchylenie() {
		return odchylenie;
	}




	public void setOdchylenie(String odchylenie) {
		this.odchylenie = odchylenie;
	}




	public String getOdsetek() {
		return odsetek;
	}




	public void setOdsetek(String odsetek) {
		this.odsetek = odsetek;
	}




	public String getWojewodztwo() {
		return wojewodztwo;
	}




	public void setWojewodztwo(String wojewodztwo) {
		this.wojewodztwo = wojewodztwo;
	}




	public int getRok() {
		return rok;
	}




	public void setRok(int rok) {
		this.rok = rok;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String przedmiot;
	private String poziom;
	private String zdajacych;
	private String minS;
	private String maxS;
	private String mediana;
	private String srednia;
	private String odchylenie;
	private String odsetek;
	private String wojewodztwo;
	private int rok;
	
	
	





	public WojWynikiMatur() {
		super();
		this.zdajacych = "1";
		this.srednia = "1";
		this.rok = 2014;
	}
	
	
	

	
	
	
	
	
	
	

}
