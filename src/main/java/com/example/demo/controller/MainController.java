package com.example.demo.controller;



import java.security.Key;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.aot.hint.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dao.OgolneWynikiMaturRepo;
import com.example.demo.dao.ProjektyRepo;
import com.example.demo.dao.WojWynikiMaturRepo;
import com.example.demo.model.OgolneWynikiMatur;
import com.example.demo.model.Projekty;
import com.example.demo.model.WojWynikiMatur;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Other.AuthRequest;
import Other.RokWartosc;
import Other.ZlozonyRes;



@RestController
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class MainController {
	
	@Autowired
	OgolneWynikiMaturRepo ogolneRepo;
	
	@Autowired
	WojWynikiMaturRepo wojRepo;
	
	@Autowired
	ProjektyRepo projektRepo;





	@GetMapping("/ogolneWynikiMatur/{przedmiot}")
	public List<OgolneWynikiMatur> ogolneSzukajPoPrzedmiocie(@PathVariable("przedmiot") String przedmiot) {
		
		return ogolneRepo.findByPrzedmiot(przedmiot);
	}
	
	@GetMapping("/ogolneWynikiMatur/all")
	public List<OgolneWynikiMatur> ogolneWszystko(){
		return ogolneRepo.findAll();
	}
	
	@GetMapping("/wojewodztwoWyniki/{przedmiot}/{poziom}")
	public List<WojWynikiMatur> WynikiWojewodztwPrzedmiot(@PathVariable("przedmiot") String przedmiot, @PathVariable("poziom") String poziom){

		List<WojWynikiMatur> tab = wojRepo.findByPrzedmiot(przedmiot);
		List<WojWynikiMatur> res = new ArrayList<>();
		
		
		
		
		for(int i = 0 ;i < tab.size(); i++) {
			
			if(  tab.get(i).getPoziom().equals(poziom) ) {
				res.add(tab.get(i));
			}
			
		}
	
		return res;
	}
	
	
	@GetMapping("/wojewodztwoWyniki/woj/{woj}")
	public List<WojWynikiMatur> WynikiDanegoWojewodztw(@PathVariable("woj") String woj){


	
		return wojRepo.findByWojewodztwo(woj);
	}
	
	
	
	
	
	@GetMapping("/wojewodztwoWyniki/woj/{woj}/{poziom}")
	public List<WojWynikiMatur> WynikiDanegoWojewodztwPoziom(@PathVariable("woj") String woj,  @PathVariable("poziom") String poziom){


		
		
		List<WojWynikiMatur> tab = wojRepo.findByWojewodztwo(woj);
		
		
		
		List<WojWynikiMatur> res = new ArrayList<>();
		
		
		
		
		for(int i = 0 ;i < tab.size(); i++) {
			
			if(  tab.get(i).getPoziom().equals(poziom) ) {
				res.add(tab.get(i));
			}
			
		}
	
		return res;
	
	}
	

	
	@GetMapping("/wojewodztwoWyniki/woj/{woj}/{poziom}/{przedmiot}")
	public List<WojWynikiMatur> WynikiDanegoWojewodztwPoziomPrzedmiot(@PathVariable("woj") String woj,  @PathVariable("poziom") String poziom, @PathVariable("przedmiot") String przedmiot){


		
		
		List<WojWynikiMatur> tab = wojRepo.findByWojewodztwo(woj);
		
		
		
		List<WojWynikiMatur> res = new ArrayList<>();
		List<WojWynikiMatur> res2 = new ArrayList<>();
		
		
		
		for(int i = 0 ;i < tab.size(); i++) {
			
			if(  tab.get(i).getPrzedmiot().equals(przedmiot) ) {
				res.add(tab.get(i));
			}
			
		}
		
		
		for(int i = 0 ;i < res.size(); i++) {
			
			if(  res.get(i).getPoziom().equals(poziom) ) {
				res2.add(res.get(i));
			}
			
		}
		
		
		
		
	
		return res2;
	
	}
	
	
	
	
	
	
	@GetMapping("/projekty/woj/{woj}")
	public List<Projekty> projekty(@PathVariable("woj") String woj){


		
		
		List<Projekty> tab = projektRepo.findAll();
		

		List<Projekty> res = new ArrayList<>();
		
		
		
		for(int i = 0 ;i < tab.size(); i++) {
			
			if(  tab.get(i).getMiejsce().toLowerCase().contains(woj.toLowerCase()) ) {
				res.add(tab.get(i));
			}
			
		}
		
		
		

		return res;
	
	}
	
	
	
	
	@GetMapping("/projekty/woj/{woj}/dotacje")
	public float projektyDotacje(@PathVariable("woj") String woj){


		
		
		List<Projekty> tab = projektRepo.findAll();
		

		float wynik = 0;
		
		
		
		for(int i = 0 ;i < tab.size(); i++) {
			
			if(  tab.get(i).getMiejsce().toLowerCase().contains(woj.toLowerCase()) ) {
				wynik += tab.get(i).getWartosc();
			}
			
		}
		
		

		return wynik;
	
	}
	

	@GetMapping("/projekty/woj/{woj}/dotacje/{start}/{koniec}")
	public List<RokWartosc> projektyDotacjeLata(@PathVariable("woj") String woj, @PathVariable("start") int start, @PathVariable("koniec") int koniec){




		List<Projekty> tabProjekty = projektRepo.findAll();
		List<RokWartosc> res = new ArrayList<>();



		for(int i = start; i<= koniec ; i++) {
			res.add(new RokWartosc(i));
		}



		for(RokWartosc rw : res) {

			for(int i = 0 ;i < tabProjekty.size(); i++) {

				if(  tabProjekty.get(i).getMiejsce().toLowerCase().contains(woj) ) {




						if(tabProjekty.get(i).getStart().contains(Integer.toString(rw.getRok()))) {
							rw.setWartosc( rw.getWartosc() + tabProjekty.get(i).getWartosc());

							rw.setCnt(rw.getCnt()+1);
						}








				}

			}


		}




		return res;

	}




	
	
	
	

	
	


	
	
	
}
