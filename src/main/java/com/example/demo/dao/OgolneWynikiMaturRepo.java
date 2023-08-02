package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OgolneWynikiMatur;

public interface OgolneWynikiMaturRepo extends JpaRepository<OgolneWynikiMatur, Integer>{
	
	public OgolneWynikiMatur findByRok(int rok);
	public List<OgolneWynikiMatur> findByPrzedmiot(String przedmior);

}


