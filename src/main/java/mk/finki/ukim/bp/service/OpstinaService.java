package mk.finki.ukim.bp.service;

import mk.finki.ukim.bp.model.Opstina;

import java.util.List;
import java.util.Optional;

public interface OpstinaService {
    List<Opstina> listAll();

    Optional<Opstina> findById(int id_opstina);


}
