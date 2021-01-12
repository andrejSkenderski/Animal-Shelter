package mk.finki.ukim.bp.service;

import mk.finki.ukim.bp.model.klient;
import mk.finki.ukim.bp.model.opstina;

import java.util.List;
import java.util.Optional;

public interface KlientService {
    List<klient> listAll();
    Optional<klient> findByEmbg(String embg);
    Optional<klient> addKlient (String embg, String ime, String prezime, String adresa, Integer opstina);
    void deleteByEmbg (String embg);
}
