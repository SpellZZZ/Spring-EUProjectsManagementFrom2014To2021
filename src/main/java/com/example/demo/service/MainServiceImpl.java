package com.example.demo.service;

import com.example.demo.dao.OgolneWynikiMaturRepo;
import com.example.demo.dao.ProjektyRepo;
import com.example.demo.dao.WojWynikiMaturRepo;
import com.example.demo.model.OgolneWynikiMatur;
import com.example.demo.model.Projekty;
import com.example.demo.model.WojWynikiMatur;
import Other.RokWartosc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    private final OgolneWynikiMaturRepo ogolneRepo;
    private final WojWynikiMaturRepo wojRepo;
    private final ProjektyRepo projektRepo;

    @Autowired
    MainServiceImpl(OgolneWynikiMaturRepo ogolneRepo, WojWynikiMaturRepo wojRepo, ProjektyRepo projektRepo) {
        this.ogolneRepo = ogolneRepo;
        this.wojRepo = wojRepo;
        this.projektRepo = projektRepo;
    }

    @Override
    public List<OgolneWynikiMatur> findByLesson(String przedmiot) {
        return ogolneRepo.findByPrzedmiot(przedmiot);
    }

    @Override
    public List<OgolneWynikiMatur> getAll() {
        return ogolneRepo.findAll();
    }

    @Override
    public List<WojWynikiMatur> findByLessonAndLevel(String przedmiot, String poziom) {
        List<WojWynikiMatur> tab = wojRepo.findByPrzedmiot(przedmiot);
        List<WojWynikiMatur> res = new ArrayList<>();

        for (WojWynikiMatur item : tab) {
            if (item.getPoziom().equals(poziom)) {
                res.add(item);
            }
        }

        return res;
    }

    @Override
    public List<WojWynikiMatur> findByWojewodztwo(String woj) {
        return wojRepo.findByWojewodztwo(woj);
    }

    @Override
    public List<WojWynikiMatur> findByWojewodztwoAndPoziom(String woj, String poziom) {
        List<WojWynikiMatur> tab = wojRepo.findByWojewodztwo(woj);
        List<WojWynikiMatur> res = new ArrayList<>();

        for (WojWynikiMatur item : tab) {
            if (item.getPoziom().equals(poziom)) {
                res.add(item);
            }
        }

        return res;
    }

    @Override
    public List<WojWynikiMatur> findByWojewodztwoPoziomPrzedmiot(String woj, String poziom, String przedmiot) {
        List<WojWynikiMatur> tab = wojRepo.findByWojewodztwo(woj);
        List<WojWynikiMatur> res = new ArrayList<>();
        List<WojWynikiMatur> res2 = new ArrayList<>();

        for (WojWynikiMatur item : tab) {
            if (item.getPrzedmiot().equals(przedmiot)) {
                res.add(item);
            }
        }

        for (WojWynikiMatur item : res) {
            if (item.getPoziom().equals(poziom)) {
                res2.add(item);
            }
        }

        return res2;
    }

    @Override
    public List<Projekty> findProjektyByWoj(String woj) {
        List<Projekty> tab = projektRepo.findAll();
        List<Projekty> res = new ArrayList<>();

        for (Projekty item : tab) {
            if (item.getMiejsce().toLowerCase().contains(woj.toLowerCase())) {
                res.add(item);
            }
        }

        return res;
    }

    @Override
    public float calculateProjektyDotacje(String woj) {
        List<Projekty> tab = projektRepo.findAll();
        float wynik = 0;

        for (Projekty item : tab) {
            if (item.getMiejsce().toLowerCase().contains(woj.toLowerCase())) {
                wynik += item.getWartosc();
            }
        }

        return wynik;
    }

    @Override
    public List<RokWartosc> calculateProjektyDotacjeLata(String woj, int start, int koniec) {
        List<Projekty> tabProjekty = projektRepo.findAll();
        List<RokWartosc> res = new ArrayList<>();

        for (int i = start; i <= koniec; i++) {
            res.add(new RokWartosc(i));
        }

        for (RokWartosc rw : res) {
            for (Projekty item : tabProjekty) {
                if (item.getMiejsce().toLowerCase().contains(woj.toLowerCase())) {
                    if (item.getStart().contains(Integer.toString(rw.getRok()))) {
                        rw.setWartosc(rw.getWartosc() + item.getWartosc());
                        rw.setCnt(rw.getCnt() + 1);
                    }
                }
            }
        }

        return res;
    }
}
