package mk.finki.ukim.bp.service;

import mk.finki.ukim.bp.model.mileniche;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MilenicheService {
    List<mileniche> listAll();

    Optional<mileniche> findById(int id_mileniche);

    Optional<mileniche> addMileniche(int id_mileniche,
                                     String ime,
                                     String vid,
                                     String rasa,
                                     String pol,
                                     String boja,
                                     int id_centar_vdomuvanje,
                                     Date datum_smestuvanje,
                                     int id_opstina,
                                     Date datum_naogjanje,
                                     String opis_lokacija);
}