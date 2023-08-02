package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Projekty {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "LONGTEXT")
	private String tytul;
	private String beneficjent;
	@Column(columnDefinition = "LONGTEXT")
	private String dzialanie;
	private float wartosc;
	@Column(columnDefinition = "LONGTEXT")
	private String miejsce;
	private String start;
	private String koniec;
	@Column(columnDefinition = "LONGTEXT")
	private String dziedzina;
	@Column(columnDefinition = "LONGTEXT")
	private String  obszar;
	private String zakonczone;
	
	
	
	public Projekty() {
		super();
	}

	

	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getDzialanie() {
		return dzialanie;
	}
	public void setDzialanie(String dzialanie) {
		this.dzialanie = dzialanie;
	}
	public float getWartosc() {
		return wartosc;
	}
	public void setWartosc(float wartosc) {
		this.wartosc = wartosc;
	}
	public String getMiejsce() {
		return miejsce;
	}
	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getKoniec() {
		return koniec;
	}
	public void setKoniec(String koniec) {
		this.koniec = koniec;
	}
	public String getDziedzina() {
		return dziedzina;
	}
	public void setDziedzina(String dziedzina) {
		this.dziedzina = dziedzina;
	}
	public String getObszar() {
		return obszar;
	}
	public void setObszar(String obszar) {
		this.obszar = obszar;
	}
	public String getZakonczone() {
		return zakonczone;
	}
	public void setZakonczone(String zakonczone) {
		this.zakonczone = zakonczone;
	}



	public String getBeneficjent() {
		return beneficjent;
	}



	public void setBeneficjent(String beneficjent) {
		this.beneficjent = beneficjent;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
