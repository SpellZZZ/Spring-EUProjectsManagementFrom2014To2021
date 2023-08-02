package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.WojWynikiMatur;

public interface WojWynikiMaturRepo extends JpaRepository<WojWynikiMatur, Integer>{
		public List<WojWynikiMatur> findByPrzedmiot(String przedmiot);
		public List<WojWynikiMatur> findByWojewodztwo(String wojewodztwo);
}
