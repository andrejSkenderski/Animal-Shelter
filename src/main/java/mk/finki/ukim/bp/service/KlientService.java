package mk.finki.ukim.bp.service;

import mk.finki.ukim.bp.model.Klient;

import java.util.List;
import java.util.Optional;

public interface KlientService {
    List<Klient> listAll();
    Optional<Klient> findByEmbg(String embg);
    Optional<Klient> addKlient (String embg, String ime, String prezime, String adresa, Integer opstina);
    void deleteById (String embg);
}
