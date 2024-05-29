package com.example.demo.service;

import com.example.demo.model.OgolneWynikiMatur;
import com.example.demo.model.Projekty;
import com.example.demo.model.WojWynikiMatur;
import Other.RokWartosc;

import java.util.List;

public interface MainService {
    List<OgolneWynikiMatur> findByLesson(String przedmiot);
    List<OgolneWynikiMatur> getAll();
    List<WojWynikiMatur> findByLessonAndLevel(String przedmiot, String poziom);
    List<WojWynikiMatur> findByWojewodztwo(String woj);
    List<WojWynikiMatur> findByWojewodztwoAndPoziom(String woj, String poziom);
    List<WojWynikiMatur> findByWojewodztwoPoziomPrzedmiot(String woj, String poziom, String przedmiot);
    List<Projekty> findProjektyByWoj(String woj);
    float calculateProjektyDotacje(String woj);
    List<RokWartosc> calculateProjektyDotacjeLata(String woj, int start, int koniec);
}
