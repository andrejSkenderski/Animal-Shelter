package mk.finki.ukim.bp.service;

import mk.finki.ukim.bp.model.opstina;

import java.util.List;
import java.util.Optional;

public interface OpstinaService {
    List<opstina> listAll();

    Optional<opstina> findById(int id_opstina);


}
