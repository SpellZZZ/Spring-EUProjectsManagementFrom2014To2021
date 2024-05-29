package com.example.demo.controller;

import com.example.demo.service.MainService;
import com.example.demo.model.OgolneWynikiMatur;
import com.example.demo.model.Projekty;
import com.example.demo.model.WojWynikiMatur;
import Other.RokWartosc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional(isolation = Isolation.REPEATABLE_READ)
public class MainController {

	private final MainService mainService;

	@Autowired
	MainController(MainService mainService) {
		this.mainService = mainService;
	}

	@GetMapping("/ogolneWynikiMatur/{przedmiot}")
	public List<OgolneWynikiMatur> ogolneSzukajPoPrzedmiocie(@PathVariable("przedmiot") String przedmiot) {
		return mainService.findByLesson(przedmiot);
	}

	@GetMapping("/ogolneWynikiMatur/all")
	public List<OgolneWynikiMatur> ogolneWszystko() {
		return mainService.getAll();
	}

	@GetMapping("/wojewodztwoWyniki/{przedmiot}/{poziom}")
	public List<WojWynikiMatur> WynikiWojewodztwPrzedmiot(@PathVariable("przedmiot") String przedmiot, @PathVariable("poziom") String poziom) {
		return mainService.findByLessonAndLevel(przedmiot, poziom);
	}

	@GetMapping("/wojewodztwoWyniki/woj/{woj}")
	public List<WojWynikiMatur> WynikiDanegoWojewodztw(@PathVariable("woj") String woj) {
		return mainService.findByWojewodztwo(woj);
	}

	@GetMapping("/wojewodztwoWyniki/woj/{woj}/{poziom}")
	public List<WojWynikiMatur> WynikiDanegoWojewodztwPoziom(@PathVariable("woj") String woj, @PathVariable("poziom") String poziom) {
		return mainService.findByWojewodztwoAndPoziom(woj, poziom);
	}

	@GetMapping("/wojewodztwoWyniki/woj/{woj}/{poziom}/{przedmiot}")
	public List<WojWynikiMatur> WynikiDanegoWojewodztwPoziomPrzedmiot(@PathVariable("woj") String woj, @PathVariable("poziom") String poziom, @PathVariable("przedmiot") String przedmiot) {
		return mainService.findByWojewodztwoPoziomPrzedmiot(woj, poziom, przedmiot);
	}

	@GetMapping("/projekty/woj/{woj}")
	public List<Projekty> projekty(@PathVariable("woj") String woj) {
		return mainService.findProjektyByWoj(woj);
	}

	@GetMapping("/projekty/woj/{woj}/dotacje")
	public float projektyDotacje(@PathVariable("woj") String woj) {
		return mainService.calculateProjektyDotacje(woj);
	}

	@GetMapping("/projekty/woj/{woj}/dotacje/{start}/{koniec}")
	public List<RokWartosc> projektyDotacjeLata(@PathVariable("woj") String woj, @PathVariable("start") int start, @PathVariable("koniec") int koniec) {
		return mainService.calculateProjektyDotacjeLata(woj, start, koniec);
	}
}
